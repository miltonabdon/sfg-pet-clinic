package springframework.sfgpetclinic.services;

import springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
	
	public Owner findByLastName(String lastName);

}
