package component;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class IFCalendarBot extends TelegramLongPollingBot {
	@Override
	public void onUpdateReceived(Update update) {
	    // We check if the update has a message and the message has text
	    if (update.hasMessage() && update.getMessage().hasText()) {
	        SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
	                .setChatId(update.getMessage().getChatId())
	                .setText("Aqui aparecerão os eventos");
	        try {
	            execute(message); // Call method to send the message
	        } catch (TelegramApiException e) {}
	    }
	}

    @Override
    public String getBotUsername() {
        // TODO
    	return "IFCalendarBot";
    }

    @Override
    public String getBotToken() {
        // TODO
    	return "416248213:AAFr51e1lX6fDb31xPu9fPtOL2lCi3p6vrY";
    }
}
