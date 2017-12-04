package component;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import dao.EventDAO;
import factory.DAOFactory;
import factory.constants.DAOConstants;
import model.Event;
import model.Permission;

public class IFCalendarBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            String response = "";
            String receivedMessage = update.getMessage().getText();
            String[] arrayReceivedMessage = receivedMessage.split(" ");

            if (arrayReceivedMessage.length != 2 || !arrayReceivedMessage[0].equals("/events")) {
                response = "Please, type /events <user_email>";
            } else {
                response = "Events list:";
                EventDAO eventDAO = (EventDAO) DAOFactory.getDAO(DAOConstants.EVENT_CLASS);
                List<Event> listEvents = eventDAO.all();
                if (listEvents != null && listEvents.size() > 0) {
                    for (Event event : listEvents) {
                        long timeToStart = event.getStart().getTime() - new Date().getTime();
                        if (TimeUnit.MILLISECONDS.toMinutes(timeToStart) > 0) {
                            List<Permission> permissionList = event.getCalendar().getPermissions();
                            if (event.getCalendar().getOwner().getEmail().equals(arrayReceivedMessage[1])) {
                                response += "\n-Event name:\n" + event.getName() + "\nStarting at: " + event.getStart().toLocaleString() + "\n";
                                System.out.println("\n--------------------------------- \n" + "ENTROOOOU" + "\n----------------------------------");
                            }
                            for (Permission p : permissionList) {
                                if (p.getId().getUser().getEmail().equals(arrayReceivedMessage[1])) {
                                    response += "\n-Event name:\n" + event.getName() + "\nStarting at: " + event.getStart().toLocaleString() + "\n";
                                }
                            }
                        }
                    }
                }
            }

            if (response.equals("Events list:")) {
                response = "There are no events for this email!";
            }
            SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId()).setText(response);
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {}
        }
    }

    @Override
    public String getBotUsername() {
        return "IFCalendarBot";
    }

    @Override
    public String getBotToken() {
        return "416248213:AAFr51e1lX6fDb31xPu9fPtOL2lCi3p6vrY";
    }
}
