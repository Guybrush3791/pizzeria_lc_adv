package org.pizzahat.com.demo.controller;

import java.util.List;

import org.pizzahat.com.demo.pojo.Ingrediente;
import org.pizzahat.com.demo.pojo.Pizza;
import org.pizzahat.com.demo.service.IngredienteService;
import org.pizzahat.com.demo.service.PizzaServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/ing")
public class IngredienteController {

	@Autowired
	private IngredienteService ingredienteService;
	
	@Autowired
	private PizzaServ pizzaServ;
	
	@GetMapping
	public String getIngredienti(Model model) {
		
		List<Ingrediente> ingredienti = ingredienteService.findAll();
		model.addAttribute("ingredienti", ingredienti);
		
		return "ingredienti";
	}
	
	@GetMapping("/update/{id}")
	public String updateIngrediente(
			@PathVariable("id") int id,
			Model model
		) {
		
		Ingrediente ingrediente = ingredienteService.findById(id);
		model.addAttribute("ingrediente", ingrediente);
		
		List<Pizza> pizze = pizzaServ.findAll();
		model.addAttribute("pizze", pizze);
		
		return "ingrediente-update";
	}
	
	@PostMapping("/update/{id}")
	public String storeIngrediente(
			@PathVariable("id") int id,
			@Valid Ingrediente ingrediente
		) {
		
//		// -- LOG ----------------------------------
//		System.err.println("id: " + id);
//		System.err.println("ingrediente: " + ingrediente);
//		for (Pizza p : ingrediente.getPizze())
//			System.err.println("\t" + p);
//		// -----------------------------------------
//		
//		System.err.println("-----------------------");
//		
//		// -- LOG ----------------------------------
//		Ingrediente oldIng = ingredienteService.findById(id);
//		System.err.println("ingrediente: " + oldIng);
//		for (Pizza p : oldIng.getPizze())
//			System.err.println("\t" + p);
//		// -----------------------------------------
//		
//		System.err.println("-----------------------");
//		
//		Ingrediente oldIng = ingredienteService.findById(id);
//		
//		for (Pizza p : oldIng.getPizze()) 
//			p.getIngredienti().remove(ingrediente);
//		
//		for (Pizza p : ingrediente.getPizze())			
//			p.getIngredienti().add(ingrediente);
		
		ingredienteService.save(ingrediente);
		
		return "redirect:/ing";
	}
}









