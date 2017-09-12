import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.impl.UserImpl;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class BotListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.getAuthor().isBot()) return;

        Message message = event.getMessage();
        String content = message.getRawContent();
        MessageChannel channel = event.getChannel();
        switch (content){
            case "!info" :
                channel.sendMessage("Bonjour, je suis ImagiBot, je comprends plusieurs commandes qui sont les suivantes : \n" +
                        "\t!git : donne accès à mon code pour me modifier \n" +
                        "\t!planning : donne le planning du semestre\n" +
                        "TODO").queue();
                break;
            case "!git" :
                channel.sendMessage("Mes sources : https://github.com/JJandot/ImaginaBot").queue();
                break;
            case "!planning" :
                channel.sendMessage("Le planning : http://julienjandot.alwaysdata.net/planning/").queue();
                break;
        }
    }

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        UserImpl user = (UserImpl) event.getUser();
        if(!user.hasPrivateChannel())
            user.openPrivateChannel().complete();
        user.getPrivateChannel().sendMessage("Merci d'utiliser ton nom et prénom réel sur ce Discord").queue();
    }
}
