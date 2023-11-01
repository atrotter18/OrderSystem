package menu.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import menu.bean.Order;

@Configuration
public class BeanConfiguration {
	
	@Bean(name = "order")
	public Order order() {
		Order bean = new Order();
		bean.setCustomerName("Jenny Pillsbury");
		bean.setItemName("Purple Cabbage Sushi Rolls");
		bean.setItemPrice(19.99);
		return bean;
	}
}

