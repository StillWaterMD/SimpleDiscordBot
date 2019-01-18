import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.user.UserTypingEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.util.Random;

public class respond {

    static public void main(String[] args) throws LoginException, InterruptedException {

        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = "NTM1NDYyMjE4NTMyMTI2NzMx.DyMCog.79vb9KtBFKv7yJXkKqP9osjiM-I";
        //JDA api = new JDABuilder(AccountType.BOT).setToken(token).build();
        builder.setToken(token);
        builder.addEventListeners(new botListner());
        builder.build();
        //api.addEventListener(new botListner());

    }
}

class botListner extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        super.onMessageReceived(event);

        if ( event.getMessage().getContentRaw().equals("ping") ) {
            sendMessage(event);
        }
    }

    @Override
    public void onUserTyping(UserTypingEvent event){
        System.out.println(event.getUser().getAsTag());
        if(event.getUser().getAsTag().equals("grfcMDA#5863")) {
            event.getChannel().sendMessage("MDA is typing").queue();
            event.getChannel().sendMessage(":rage: :rage: :rage: ").queue();
        }


    }


    private void sendMessage(MessageReceivedEvent event){

        String[] str = messageArr();
        for (int i = 0; i < str.length ; ++i){

            event.getChannel().sendMessage(str[i]).queue();

        }


    }


    private String createMessage(){

        Random rand = new Random();
        int amount = rand.nextInt(2) + 3;
        String message = "";
        for(int i = 0; i < amount; ++i)
            message +=":thinking:";

       return message;

    }

    private String [] messageArr(){
        Random rand = new Random();
        String[] strArr = new String [rand.nextInt(4) + 3];

        for(int i = 0; i < strArr.length ; ++i){

            strArr[i] = createMessage();

        }

        return strArr;
    }



}
