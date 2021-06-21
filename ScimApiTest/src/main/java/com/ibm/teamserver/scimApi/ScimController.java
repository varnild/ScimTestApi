package com.ibm.teamserver.scimApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/scim")
public class ScimController {
	
	@Autowired
	ScimService service;
	
	@GetMapping(path="/user", produces="application/scim+json")
	@ResponseBody
	public String scimUser() {
		return service.parseJsonFile("user");
	}
	
	@GetMapping(path="/users", produces="application/scim+json")
	@ResponseBody
	public String scimUsers() {
		return service.parseJsonFile("users");
	}
	
	@GetMapping(path="/group", produces="application/scim+json")
	@ResponseBody
	public String scimGroup() {
		return service.parseJsonFile("group");
	}
	
	@GetMapping(path="/groups", produces="application/scim+json")
	@ResponseBody
	public String scimGroups() {
		return service.parseJsonFile("groups");
	}
	
}
