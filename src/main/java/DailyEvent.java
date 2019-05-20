import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.Timer;
import java.util.TimerTask;

public class DailyEvent extends TimerTask {

    MessageChannel channel;
    Timer timer;

    @Override
    public void run() {

        try {
            channel.sendMessage("ping").queue();
            timer.cancel();
            timer.purge();
        } catch (Exception ex) {


        }

    }

    DailyEvent(MessageChannel channel, Timer timer) {
        this.channel = channel;
        this.timer = timer;

    }
}

