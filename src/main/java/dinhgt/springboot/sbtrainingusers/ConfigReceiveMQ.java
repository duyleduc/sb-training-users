package dinhgt.springboot.sbtrainingusers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigReceiveMQ {
//	public final static String QUEUE_NAME = "request_account_queue";
//
//	public final static String EXCHANGE_NAME = "account";
//
//	public final static String ROUTING_KEY = "rabbitmq.*";
//
//	@Bean
//	Queue queue() {
//		return new Queue(QUEUE_NAME, false);
//	}
//
//	@Bean
//	TopicExchange exchange() {
//		return new TopicExchange(EXCHANGE_NAME);
//	}
//
//	@Bean
//	Binding binding(Queue queue, TopicExchange exchange) {
//		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
//	} 
//	
    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
	
	
}
