package com.example.springrestapi.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.springrestapi.configurations.RabbitMQConfig;
import com.example.springrestapi.delegateService.interfaces.DelegateService;
import com.example.springrestapi.messages.QueueMessage;

@Component
public class Consumer {

    @Autowired
    @Qualifier("userDelegateService")
    DelegateService userDelegateService;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void listen(QueueMessage message) {

        try {
            String routingKey = message.getRoutingKey();
            String[] splitStrings = routingKey.split("\\.");
            switch (splitStrings[1]) {
                case "user":
                    userDelegateService.receiveAction(splitStrings[0], splitStrings[2], message);
                    break;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
