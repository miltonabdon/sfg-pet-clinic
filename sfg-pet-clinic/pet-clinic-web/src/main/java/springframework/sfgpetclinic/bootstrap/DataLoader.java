package springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import springframework.sfgpetclinic.model.Owner;
import springframework.sfgpetclinic.model.Pet;
import springframework.sfgpetclinic.model.PetType;
import springframework.sfgpetclinic.model.Specialty;
import springframework.sfgpetclinic.model.Vet;
import springframework.sfgpetclinic.services.OwnerService;
import springframework.sfgpetclinic.services.PetTypeService;
import springframework.sfgpetclinic.services.SpecialityService;
import springframework.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner{
	
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		//caso não esteja utilizando banco em memória, não vai dar problema.
		int count = petTypeService.findAll().size();
		
		if(count == 0) {
			loadData();
		}
		
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Specialty radiology = new Specialty();
		radiology.setDescription("Radiology");
		Specialty savedRadiology = specialityService.save(radiology);
		
		Specialty surgery = new Specialty();
		surgery.setDescription("Surgery");
		Specialty savedSurgery = specialityService.save(surgery);
		
		Specialty dentistry = new Specialty();
		dentistry.setDescription("Dentistry");
		Specialty savedDentistry = specialityService.save(dentistry);
		
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
		vet.getSpecialities().add(savedRadiology);
		
		vetService.save(vet);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vet2.getSpecialities().add(savedSurgery);
		
		vetService.save(vet2);
		
		System.out.println("Loaded Vets ... ");
	}

}
