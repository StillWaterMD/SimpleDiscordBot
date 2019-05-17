import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.user.UserTypingEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.Random;

public class respond {

    static public void main(String[] args) {
        try {
            JDABuilder builder = new JDABuilder(AccountType.BOT);
            String token = "";
            builder.setToken(token);
            builder.addEventListeners(new botListner());
            builder.build();
        } catch (LoginException le) {


        }
    }
}

class botListner extends ListenerAdapter {

    HashMap<String, UserStats> map;
    Random rand;

    @Override
    public void onReady(ReadyEvent event) {
        super.onReady(event);
        event.getJDA().getTextChannels().forEach(chanel -> {chanel.sendMessage("Hello there").queue();});
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {


        Message message = event.getMessage();

        if (event.getMessage().getContentRaw().toLowerCase().equals("ping")) {
            sendMessage(event);
        }
        if (event.getMessage().getContentRaw().toLowerCase().equals("test")) {
            Guild guild = event.getGuild();
            event.getMessage().addReaction(guild.getEmoteById(542308723176112148L)).queue();
            event.getMessage().addReaction("\uD83E\uDD14").queue();
        }
        if (event.getMessage().getContentRaw().trim().toLowerCase().equals("count")) {

            UserService.reactToCount(map, event);
        }

        if (event.getAuthor().getId().equals("74817348367814656")) {
            event.getMessage().addReaction("\uD83E\uDD14").queue();

        }


    }


    @Override
    public void onUserTyping(UserTypingEvent event) {
        if (event.getUser().getId().equals("532923085872168961") || event.getUser().getId().equals("159769254705627137")) {
            try {
                // event.getChannel().sendMessage("MDA is typing").queue();
                //event.getChannel().sendMessage(":rage: :rage: :rage: ").queue();

            } catch (Exception ex) {


            }
        }


    }


    private void sendMessage(MessageReceivedEvent event) {

        try {
            event.getChannel().sendMessage(createMessage()).queue();

        } catch (Exception ex) {

        }


    }


    private String createMessage() {
        int amount = rand.nextInt(5) + 1;
        String message = "";
        for (int i = 0; i < amount; ++i)
            message += ":thinking:";

        return message;

    }


    botListner() {

        super();
        this.rand = new Random();
        this.map = new HashMap<>();
    }

}
