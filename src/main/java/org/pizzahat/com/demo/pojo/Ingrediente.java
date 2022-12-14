package org.pizzahat.com.demo.pojo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Ingrediente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@ManyToMany
	@JoinTable(
		name = "pizza_ingrediente_errore",
		joinColumns = @JoinColumn(name = "ingrediente_id"),
		inverseJoinColumns = @JoinColumn(name = "pizza_id")		
	)
	private List<Pizza> pizze;
	
	public Ingrediente() { }
	public Ingrediente(String name) {
		
		setName(name);
	}
	public Ingrediente(String name, List<Pizza> pizze) {
		
		this(name);
		
		setPizze(pizze);
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
	public List<Pizza> getPizze() {
		return pizze;
	}
	public void setPizze(List<Pizza> pizze) {
		this.pizze = pizze;
	}
	
	@Override
	public String toString() {
		
		return "(" + getId() + ") " + getName();
	}
	@Override
	public int hashCode() {
		
		return getId();
	}
	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof Ingrediente)) return false;
		
		return obj.hashCode() == hashCode();
	}
}
