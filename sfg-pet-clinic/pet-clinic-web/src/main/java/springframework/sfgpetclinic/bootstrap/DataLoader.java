package springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import springframework.sfgpetclinic.model.Owner;
import springframework.sfgpetclinic.model.Pet;
import springframework.sfgpetclinic.model.PetType;
import springframework.sfgpetclinic.model.Vet;
import springframework.sfgpetclinic.services.OwnerService;
import springframework.sfgpetclinic.services.PetTypeService;
import springframework.sfgpetclinic.services.VetService;
import sun.util.resources.LocaleData;

@Component
public class DataLoader implements CommandLineRunner{
	
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Owner owner = new Owner();
		owner.setFirstName("Michael");
		owner.setLastName("Weston");
		owner.setAdress("123 Brickerel");
		owner.setCity("Miami");
		owner.setTelephone("123132132");
		
		Pet mikesPet = new Pet();
		mikesPet.setPetType(savedDogPetType);
		mikesPet.setOwner(owner);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setName("Rosco");
		
		owner.getPets().add(mikesPet);
		
		ownerService.save(owner);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAdress("123 Brickerel");
		owner2.setCity("Miami");
		owner2.setTelephone("123132132");
		
		Pet fionasPet = new Pet();
		fionasPet.setPetType(savedCatPetType);
		fionasPet.setOwner(owner2);
		fionasPet.setName("Just Cat");
		fionasPet.setBirthDate(LocalDate.now());
		owner2.getPets().add(fionasPet);
		
		ownerService.save(owner2);
		
		System.out.println("Loaded Owners ... ");
		
		Vet vet = new Vet();
		vet.setFirstName("Sam");
		vet.setLastName("Axe");
		
		vetService.save(vet);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		
		vetService.save(vet2);
		
		System.out.println("Loaded Vets ... ");
		
		
		
	}

}
