package ee.cdi.scope.conversation_app;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import java.io.Serializable;

/**
 * Тут вся фишка в чем, что когда мы начинаем         conversation.begin();
 * когда мы делаем name = "Begin" мы работаем с уже другим бином, грубо говоря с Conversation Bean,
 * и этот бин, не имеет ниего общего с бином вне Conversation!
 */
@ConversationScoped
public class Bean implements Serializable {

    String name;

    @Inject
    Conversation conversation;

    public void startConversation() {
        System.out.println("before startConversation " + name);
        conversation.setTimeout(9999999L);
        conversation.begin();
        conversation.setTimeout(9999999L);
        name = "BEGIN!!!!";
        System.out.println("after startConversation " + name);
    }

    public void endConversation() {
        System.out.println("before endConversation " + name);
        conversation.end();
        System.out.println("after endConversation " + name);
    }

}
