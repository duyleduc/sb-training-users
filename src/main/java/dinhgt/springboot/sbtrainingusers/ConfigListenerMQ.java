//package dinhgt.springboot.sbtrainingusers;
//
//import org.springframework.amqp.core.MessageListener;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
//import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class ConfigListenerMQ {
//	
//	public final static String QUEUE_NAME = "request_update_account";
//
//	public final static String EXCHANGE_NAME = "account";
//
//	public final static String ROUTING_KEY = "rabbitmq.update.account";
//	
//	
//	@Bean
//	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
//			MessageListenerAdapter listenerAdapter) {
//		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//		container.setConnectionFactory(connectionFactory);
//		container.setQueueNames(QUEUE_NAME);
//		container.setMessageListener(listenerAdapter);
//		return container;
//	}
//
//	@Bean
//	MessageListenerAdapter listenerAdapter(MessageListener receiver) {
//		return new MessageListenerAdapter(receiver, "updateAccount");
//	}
//	
//
//	
//}
