import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.DisconnectEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.user.UserTypingEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.EmoteManager;
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;

import javax.security.auth.login.LoginException;
import java.util.List;
import java.util.Random;

public class respond {

    static public void main(String[] args) {
        try {
            JDABuilder builder = new JDABuilder(AccountType.BOT);
            String token = "token";
            builder.setToken(token);
            builder.addEventListeners(new botListner());
            builder.build();
        } catch (LoginException le) {


        }
    }
}

class botListner extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getContentRaw().equals("ping")) {
            sendMessage(event);
        }
        if(event.getMessage().getContentRaw().equals("test")) {
            Guild guild = event.getGuild();
            event.getMessage().addReaction(guild.getEmoteById(542308723176112148L)).queue();
            event.getMessage().addReaction("\uD83E\uDD14").queue();
        }


    }

    @Override
    public void onUserTyping(UserTypingEvent event) {

        if (event.getUser().getAsTag().equals("grfcMDA#5863")) {
            try {
                event.getChannel().sendMessage("MDA is typing").queue();
                event.getChannel().sendMessage(":rage: :rage: :rage: ").queue();

            } catch (Exception ex) {


            }
        }


    }


    private void sendMessage(MessageReceivedEvent event) {

        String[] str = messageArr();
        for (int i = 0; i < str.length; ++i) {
            try {

                event.getChannel().sendMessage(str[i]).queue();

            } catch (Exception ex) {

            }

        }



    }


    private String createMessage() {

        Random rand = new Random();
        int amount = rand.nextInt(2) + 3;
        String message = "";
        for (int i = 0; i < amount; ++i)
            message += ":thinking:";

        return message;

    }

    private String[] messageArr() {
        Random rand = new Random();
        //String[] strArr = new String [rand.nextInt(4) + 3];
        String[] strArr = new String[5];
        for (int i = 0; i < strArr.length; ++i) {

            strArr[i] = createMessage();

        }

        return strArr;
    }


}
