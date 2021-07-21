package com.ibm.teamserver.scimApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/service")
public class ServiceController {
	
	@Autowired
	ScimService service;
	
	@GetMapping(path= "/toggleServerInError", produces="application/scim+json")
	@ResponseBody
	public String toggelInError() {
		service.toggleServerInError();
		return "{ \"server on error\" : " + Boolean.toString(service.SERVER_ON_ERROR) + " }" ;
	}
	
	@GetMapping(path= "/updateRepo", produces="application/scim+json")
	@ResponseBody
	public String updateRepo() {
		service.updateRepo();
		return "{ \"repo udated\" : " + Boolean.toString(service.REPO_UPDATED) + " }" ;
	}
	
	@GetMapping(path= "/noRef", produces="application/scim+json")
	@ResponseBody
	public String toggleRef() {
		service.toggleRef();
		return "{ \"With ref\" : " + Boolean.toString(!service.TOGGLE_REF) + " }" ;
	}

}
