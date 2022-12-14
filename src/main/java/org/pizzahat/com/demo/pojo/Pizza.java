package org.pizzahat.com.demo.pojo;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "no null name")
	@Column(unique = true)
	private String name;
	
	@Lob
	private String description;
	@NotNull(message = "price can't be null")
	private Integer price;
	
	@ManyToMany
	@JoinTable(
		name = "pizza_ingrediente",
		joinColumns = @JoinColumn(name = "pizza_id"),
		inverseJoinColumns = @JoinColumn(name = "ingrediente_id")		
	)
	private Set<Ingrediente> ingredienti;
	
	public Pizza() { }
	public Pizza(String name, String description, int price) {
		
		setName(name);
		setDescription(description);
		setPrice(price);
	}
	public Pizza(String name, String description, int price, Set<Ingrediente> ingredienti) {
		
		this(name, description, price);
		
		setIngredienti(ingredienti);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Set<Ingrediente> getIngredienti() {
		return ingredienti;
	}
	public void setIngredienti(Set<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}
	
	@Override
	public String toString() {
		
		return "(" + getId() + ") " + getName() + " - " + getPrice()
			+ "\n" + getDescription();
	}
}
