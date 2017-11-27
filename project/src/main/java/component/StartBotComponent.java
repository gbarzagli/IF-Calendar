package component;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.servlet.ServletContext;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

@ApplicationScoped
public class StartBotComponent {
	
	public void init(@Observes ServletContext context) {
		System.out.println("[TelegramBot] Starting IFCalendar Telegram Bot...!");
		ApiContextInitializer.init();
		
		TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new IFCalendarBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        System.out.println("[TelegramBot] IFCalendar Telegram Bot started!");
	}
}
