package springframework.sfgpetclinic.services;

import java.util.Set;

import springframework.sfgpetclinic.model.Pet;

public interface PetService {
	
	public Pet findById();

	public Pet save(Pet pet);

	public Set<Pet> findAll();

}
