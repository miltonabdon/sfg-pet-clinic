package springframework.sfgpetclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity{
	
	private String name;
	
	private PetType petType;
	
	private Owner owner;	
	
	private LocalDate birthDate;
	
	public Pet() {
	}
	
	public Pet(PetType petType, Owner owner, LocalDate birthDate, String name) {
		this.petType = petType;
		this.owner = owner;
		this.birthDate = birthDate;
		this.name = name;
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
