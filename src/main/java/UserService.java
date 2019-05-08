import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.HashMap;

public class UserService {

    public static void reactToCount(HashMap<String, UserStats> map, MessageReceivedEvent event) {

        String id = event.getMessage().getAuthor().getId();
        UserStats userS = map.get(id);

        if (userS == null) {
            UserStats newUser = new UserStats();
            newUser.counter = 1;
            map.put(id, newUser);
            event.getChannel().sendMessage("1").queue();

        } else {

            int counter = ++userS.counter;
            event.getChannel().sendMessage(counter + "").queue();

        }

    }

}
