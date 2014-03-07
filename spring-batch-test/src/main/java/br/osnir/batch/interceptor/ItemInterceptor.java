/**
 * 
 */
package br.osnir.batch.interceptor;

import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.channel.ChannelInterceptor;
import org.springframework.stereotype.Component;

/**
 * @author osnir
 *
 */
@Component("itemInterceptor")
public class ItemInterceptor implements ChannelInterceptor{

	public Message<?> postReceive(Message<?> arg0, MessageChannel arg1) {
		System.out.println("postReceive");
		System.out.println(arg0.getPayload());
		return arg0;
	}

	public void postSend(Message<?> arg0, MessageChannel arg1, boolean arg2) {
		// TODO Auto-generated method stub
		
	}

	public boolean preReceive(MessageChannel arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	public Message<?> preSend(Message<?> arg0, MessageChannel arg1) {
		System.out.println("preSend");
		System.out.println(arg0.getPayload());
		return arg0;
	}
	
}
