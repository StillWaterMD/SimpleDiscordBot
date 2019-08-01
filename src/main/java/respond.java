import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.user.UserTypingEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import javax.security.auth.login.LoginException;
import java.util.*;


public class respond {

    static public void main(String[] args) {
        try {
            JDABuilder builder = new JDABuilder(AccountType.BOT);
            String token = "";
            builder.setToken(token);
            builder.addEventListeners(new botListener());
            builder.build();
        } catch (LoginException le) {
        }
    }
}

class botListener extends ListenerAdapter {

    HashMap<String, UserStats> map;
    Random rand;
    Timer timer;

    @Override
    public void onReady(ReadyEvent event) {
        super.onReady(event);
        /*String channelId = "535460087276240903";
        MessageChannel channel = event.getJDA().getTextChannelById(channelId);
        Date date = new Date();
        DailyEvent dailyEvent = new DailyEvent(channel, timer);

        date = DateProcessing.getExecutionDate(date);
        channel.sendMessage("Hello there! We are expecting daily event at "
                + MessageGenerator.formatNumber((date.getHours() + 3) % 24) //timeshift to moscow
                + ":" + MessageGenerator.formatNumber(date.getMinutes())).queue();
        timer.schedule(dailyEvent, date);*/
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message message = event.getMessage();
        String text = message.getContentRaw().toLowerCase();

        if (text.equals("ping")) {
            sendMessage(event);
        }
        if ("emb".equals(text)) {

            List<MessageEmbed.Field> fields = new ArrayList();
            fields.add(new MessageEmbed.Field("testname1", ":frowning:", true, true));
            fields.add(new MessageEmbed.Field("testname2", ":thinking:", true, true));
            fields.add(new MessageEmbed.Field("testname3", "<:test:542308723176112148>", true, true));

            event.getChannel().sendMessage(new MessageEmbed(null, "Emb message",
                    "description", EmbedType.RICH, null, 0,
                    null, null, null, null, null, null, fields)).queue();

        }
        if (text.equals("test")) {
            Guild guild = event.getGuild();
            event.getMessage().addReaction(guild.getEmoteById(542308723176112148L)).queue();
            event.getMessage().addReaction("\uD83E\uDD14").queue();
        }
        if (text.equals("count")) {
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
        for (int i = 0; i < amount; ++i) {
            message += ":thinking:";
        }
        return message;

    }


    botListener() {
        super();
        this.rand = new Random();
        this.map = new HashMap<>();
        this.timer = new Timer();
    }

}
