package springframework.sfgpetclinic.services;

import java.util.Set;

import springframework.sfgpetclinic.model.Vet;

public interface VetService {

	public Vet findById();

	public Vet save(Vet vet);

	public Set<Vet> findAll();

}
