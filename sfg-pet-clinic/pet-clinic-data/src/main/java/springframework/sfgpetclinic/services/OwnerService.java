package springframework.sfgpetclinic.services;

import java.security.acl.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
	
	public Owner findByLastName();

}
