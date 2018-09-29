package springframework.sfgpetclinic.services;

import java.security.acl.Owner;
import java.util.Set;

public interface OwnerService {
	
	public Owner findByLastName();
	
	public Owner findById();
	
	public Owner save(Owner owner);
	
	public Set<Owner> findAll();

}
