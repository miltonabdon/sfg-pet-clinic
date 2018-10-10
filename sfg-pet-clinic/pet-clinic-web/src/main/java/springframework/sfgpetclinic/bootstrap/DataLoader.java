package springframework.sfgpetclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import springframework.sfgpetclinic.model.Owner;
import springframework.sfgpetclinic.model.Vet;
import springframework.sfgpetclinic.services.OwnerService;
import springframework.sfgpetclinic.services.VetService;
import springframework.sfgpetclinic.services.map.OwnerServiceMap;
import springframework.sfgpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner{
	
	private final OwnerService ownerService;
	private final VetService vetService;
	
	public DataLoader(OwnerService ownerService, VetService vetService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Owner owner = new Owner();
		owner.setId(1L);
		owner.setFirstName("Michael");
		owner.setLastName("Weston");
		
		ownerService.save(owner);
		
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		
		ownerService.save(owner2);
		
		System.out.println("Loaded Owners ... ");
		
		Vet vet = new Vet();
		vet.setId(1L);
		vet.setFirstName("Sam");
		vet.setLastName("Axe");
		
		vetService.save(vet);
		
		Vet vet2 = new Vet();
		vet.setId(2L);
		vet.setFirstName("Jessie");
		vet.setLastName("Porter");
		
		vetService.save(vet2);
		
		System.out.println("Loaded Vets ... ");
		
		
		
	}

}
