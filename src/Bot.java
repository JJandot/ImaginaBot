import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

public class Bot {

    private JDA jda;

    public Bot(String token) {
        try{
            jda = new JDABuilder(AccountType.BOT).setToken(token).setBulkDeleteSplittingEnabled(false).addEventListener(new BotListener()).buildBlocking();
        } catch (InterruptedException | RateLimitedException | LoginException e) {
            e.printStackTrace();
            System.out.println("Erreur token");
            return;
        }
        System.out.println("Connecté avec : " + jda.getSelfUser().getName());
    }
}
