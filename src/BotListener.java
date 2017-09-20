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
                        "\t!cours : donne le lien vers les supports de cours" +
                        "TODO").queue();
                break;
            case "!git" :
                channel.sendMessage("Mes sources : https://github.com/JJandot/ImaginaBot").queue();
                break;
            case "!planning" :
                channel.sendMessage("Le planning : http://julienjandot.alwaysdata.net/planning/").queue();
                break;
            case "!cours" :
                channel.sendMessage("Voilà les différents liens pour retrouver les cours en ligne : \n" +
                        "\tIntelligence artificielle : https://moodle.umontpellier.fr/course/view.php?id=1195\n" +
                        "\tIngénierie logicielle : http://www.lirmm.fr/~dony/enseig/IL/index.html\n" +
                        "\tRéseaux et communication : https://moodle.umontpellier.fr/course/view.php?id=675\n" +
                        "\tIHM : http://www.lirmm.fr/~mountaz/Ens/Ihm/\n" +
                        "\tProgrammation orientée agents : http://www.lirmm.fr/~ferber/ProgAgent/index.html\n" +
                        "\tTraitement du signal : https://www.lirmm.fr/~wpuech/enseignement/master_informatique/Traitement_Transmission_Signal/").queue();
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
