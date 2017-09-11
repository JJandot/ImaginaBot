import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class BotListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.getAuthor().isBot()) return;

        Message message = event.getMessage();
        String content = message.getRawContent();
        if (content.equals("!info"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Bonjour, je suis ImagiBot, je comprends plusieurs commandes qui sont les suivantes : \n TODO").queue();
        }
    }
}
