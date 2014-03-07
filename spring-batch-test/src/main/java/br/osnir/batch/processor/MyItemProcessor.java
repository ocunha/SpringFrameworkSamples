package br.osnir.batch.processor;

import java.util.Date;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

import br.osnir.batch.object.Person;
import br.osnir.batch.object.PersonTax;

/**
 * @author Osnir F CUNHA
 * 
 */
@Component("itemProcessor")
public class MyItemProcessor implements ItemProcessor<Person, PersonTax> {

    /**
     * usado para integrar o batch e o spring integration pipeline.
     */
    private final MessagingTemplate messagingGateway;

    /**
     * primeiro canal do spring integration pipeline.
     */
    private MessageChannel integrationInputChannel;

    public MyItemProcessor(MessagingTemplate gateway) {
        this.messagingGateway = gateway;
    }

    public PersonTax process(Person item) {
    	
        Message<?> inputMessage = MessageBuilder.withPayload(item).build();
//
        Message<?> outputMessage = this.messagingGateway.sendAndReceive(this.integrationInputChannel, inputMessage);

//        return outputMessage;
        
        PersonTax personTax = (PersonTax) outputMessage.getPayload();
        
        if (item.getDependents() > 0) {
			personTax.setFree(true);
		}else{
			personTax.setFree(false);
		}
        
        personTax.setDate(new Date(System.currentTimeMillis()));
		personTax.setTax(item.getSalary()*1.05);
        
    	return personTax;
    }

    public void setIntegrationInputChannel(MessageChannel integrationInputChannel) {
        this.integrationInputChannel = integrationInputChannel;
    }

}
