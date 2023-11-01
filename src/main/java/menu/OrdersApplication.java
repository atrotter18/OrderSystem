package menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import menu.bean.Order;
import menu.controller.BeanConfiguration;
import menu.repository.MenuRepository;

@SpringBootApplication
public class OrdersApplication implements CommandLineRunner {
	@Autowired
	MenuRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(OrdersApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext appcontext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Order o = appcontext.getBean("order", Order.class);
        o.setCustomerName(" James Buoe");
        o.setItemName(" Italian sausage Ravioli");
        o.setItemPrice(9.99);
        repo.save(o);

        // Creating a new Order and saving it
        Order anotherOrder = new Order(" Sandra Boynton", " Lemon Crusted Salmon with Orzo ", 25.89);
        repo.save(anotherOrder);

        Iterable<Order> allOrders = repo.findAll();
        for (Order a : allOrders) {
            System.out.println(a.toString());
        }

        // Close the context
        ((AbstractApplicationContext) appcontext).close();
    }
}
