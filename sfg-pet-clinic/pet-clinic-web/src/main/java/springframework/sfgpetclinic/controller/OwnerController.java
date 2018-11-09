package springframework.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springframework.sfgpetclinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {
	
	//usando final determina que objeto nao tera mudanças e spring injeta depencia
	private final OwnerService ownerService;
	
	//usando construtor, nao preciso utilizar o @autowired, #melhorpratica
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@RequestMapping({"","/", "/index", "/index.html"})
	public String listOwners(Model model) {
		
		model.addAttribute("owners",ownerService.findAll());
		
		return "owners/index";	
		
	}
	
	@RequestMapping("/find")
	public String findOwners(Model model) {
		
		return "notimplemented";
		
	}

}
