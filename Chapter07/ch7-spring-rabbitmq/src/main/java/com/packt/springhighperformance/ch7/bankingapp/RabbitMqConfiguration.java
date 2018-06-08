package com.packt.springhighperformance.ch7.bankingapp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.packt.springhighperformance.ch7.bankingapp")
@EnableRabbit
public class RabbitMqConfiguration {

	public static final String RABBIT_MESSAGE_QUEUE = "rabbit.queue.name";
	private static final String RABBIT_MESSAGE_EXCHANGE = "rabbit.exchange.name";
	private static final String ROUTING_KEY = "messages.key";

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("127.0.0.1");
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		return connectionFactory;
	}

	@Bean
	public Queue queue() {
		return new Queue(RABBIT_MESSAGE_QUEUE, true);
	}

	@Bean
	public DirectExchange exchange() {
		return new DirectExchange(RABBIT_MESSAGE_EXCHANGE);
	}

	@Bean
	Binding exchangeBinding(DirectExchange directExchange, Queue queue) {
		return BindingBuilder.bind(queue).to(directExchange).with(ROUTING_KEY);
	}

	@Bean
	public RabbitAdmin rabbitAdmin() {
		RabbitAdmin admin = new RabbitAdmin(connectionFactory());
		admin.declareQueue(queue());
		admin.declareExchange(exchange());
		admin.declareBinding(exchangeBinding(exchange(), queue()));
		return admin;
	}

	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		template.setRoutingKey(ROUTING_KEY);
		template.setExchange(RABBIT_MESSAGE_EXCHANGE);
		template.setMessageConverter(messageConverter());
		return template;
	}

	@Bean
	public SimpleRabbitListenerContainerFactory listenerContainer() {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		factory.setMaxConcurrentConsumers(5);
		return factory;
	}

}
