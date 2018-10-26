package springframework.sfgpetclinic.services;

import org.springframework.stereotype.Service;

import springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
	
	public Owner findByLastName(String lastName);

}
