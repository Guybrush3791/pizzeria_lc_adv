package org.pizzahat.com.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.pizzahat.com.demo.pojo.Ingrediente;
import org.pizzahat.com.demo.pojo.Pizza;
import org.pizzahat.com.demo.service.IngredienteService;
import org.pizzahat.com.demo.service.PizzaServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPizzaAdvApplication implements CommandLineRunner {

	@Autowired
	private PizzaServ pizzaServ;
	
	@Autowired
	private IngredienteService ingredienteService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringPizzaAdvApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Ingrediente ing1 = new Ingrediente("pomodoro");
		Ingrediente ing2 = new Ingrediente("mozzarella");
		Ingrediente ing3 = new Ingrediente("acciughe");
		Ingrediente ing4 = new Ingrediente("capperi");
		
		ingredienteService.save(ing1);
		ingredienteService.save(ing2);
		ingredienteService.save(ing3);
		ingredienteService.save(ing4);
		
		List<Ingrediente> ingP1 = Arrays.asList(new Ingrediente[] {
				ing1, ing1, ing2
		});		
		Pizza p1 = new Pizza("Margherita", null, 1000, new HashSet<>(ingP1));
		
		List<Ingrediente> ingP2 = Arrays.asList(new Ingrediente[] {
				ing2, ing4
		});
		Pizza p2 = new Pizza("Margherita piccante", "my p2 desc", 2200, new HashSet<>(ingP2));
		
		List<Ingrediente> ingP3 = Arrays.asList(new Ingrediente[] {
				ing3, ing4
		});
		Pizza p3 = new Pizza("Diavola", "my p3 desc", 400, new HashSet<>(ingP3));
		
		Pizza p4 = new Pizza("Diavola light", null, 1200);
	
		pizzaServ.save(p1);
		pizzaServ.save(p2);
		pizzaServ.save(p3);
		pizzaServ.save(p4);
	}
}
