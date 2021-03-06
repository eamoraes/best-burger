package br.com.eam.bestburger.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="guests")
public class Guest implements Serializable {
	
	private static final long serialVersionUID = 810869730976832078L;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	private String name;
	
	private Integer companionAmount;

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

	public Integer getCompanionAmount() {
		return companionAmount;
	}

	public void setCompanionAmount(Integer companionAmount) {
		this.companionAmount = companionAmount;
	}

}
