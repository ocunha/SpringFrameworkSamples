/*
 * TCC Facet 2012 - Djulles IKEDA e Osnir F CUNHA.
 *
 * Copyright (c) 2012
 * All rights reserved.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system, nor translated in any human or computer
 * language in any way for any purposes whatsoever without the prior written
 * 
 * 
 * (Code Template Version: 1.0)
 */
package br.osnir.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Osnir F CUNHA
 * 
 */
@Component("alunoProcessor")
public class AlunoProcessor implements ItemProcessor<Object, Object> {

    /**
     * usado para integrar o batch e o spring integration pipeline.
     */
    private final MessagingTemplate messagingGateway;

    /**
     * primeiro canal do spring integration pipeline.
     */
    private MessageChannel integrationInputChannel;

    public AlunoProcessor(MessagingTemplate gateway) {
        this.messagingGateway = gateway;
    }

    public Object process(Object item) {
        Message<?> inputMessage = MessageBuilder.withPayload(item).build();

        Message<?> outputMessage = this.messagingGateway.sendAndReceive(
                this.integrationInputChannel, inputMessage);

        return outputMessage;
    }

    public void setIntegrationInputChannel(
            MessageChannel integrationInputChannel) {
        this.integrationInputChannel = integrationInputChannel;
    }

}
