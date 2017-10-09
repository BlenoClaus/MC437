package com.mc437.produshow.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="product")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(Include.NON_EMPTY)
public class Product {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="amount")
	private Long amount;
	
	@Column(name="category")
	private String category;
	
	@Column(name="price")
	private Long price;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="product_id")
	private List<Attribute> attributes;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="product_id")
	private List<Image> images;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Long getAmount() {
		return amount;
	}
	
	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public Long getPrice() {
		return price;
	}
	
	public void setPrice(Long price) {
		this.price = price;
	}
	
	public List<Attribute> getAttributes() {
		return attributes;
	}
	
	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
	
	public List<Image> getImages() {
		return images;
	}
	
	public void setImages(List<Image> images) {
		this.images = images;
	}
	
}
