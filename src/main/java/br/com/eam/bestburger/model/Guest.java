package br.com.eam.bestburger.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="guests")
public class Guest extends Auditable<Long> {

	private static final long serialVersionUID = 5760674102646966777L;

	private String name;
	
	private Integer companionAmount;
	
	public Guest() {
		
	}

	public Guest(String name, Integer companionAmount) {
		super();
		this.name = name;
		this.companionAmount = companionAmount;
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

	@Override
	public String toString() {
		return "Guest [getId()=" + getId() + ", name=" + name + ", companionAmount=" + companionAmount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((companionAmount == null) ? 0 : companionAmount.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Guest other = (Guest) obj;
		if (companionAmount == null) {
			if (other.companionAmount != null)
				return false;
		} else if (!companionAmount.equals(other.companionAmount))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
