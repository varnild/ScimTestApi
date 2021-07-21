package com.ibm.teamserver.scimApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

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
	
	@GetMapping(path="/Groups", produces="application/scim+json")
	@ResponseBody
	public String scimGroup(@RequestParam String filter) {
		if(filter.equals("displayName co \"music\"")) {
			return service.parseJsonFile("groups");
		} else {
			throw new ResponseStatusException(
			          HttpStatus.NOT_FOUND, "Wrong filter", null);
		}
		
	}
	
	@GetMapping(path="/Groups/cn=queen", produces="application/scim+json")
	@ResponseBody
	public String scimQueen() {
		return service.parseJsonFile("queen");
	}
	@GetMapping(path="/Groups/cn=ledZepplin", produces="application/scim+json")
	@ResponseBody
	public String scimLedZep() {
		return service.parseJsonFile("ledZepplin");
	}
	@GetMapping(path="/Groups/cn=guitarist", produces="application/scim+json")
	@ResponseBody
	public String scimGuitarist() {
		return service.parseJsonFile("guitarist");
	}
	@GetMapping(path="/Groups/cn=singer", produces="application/scim+json")
	@ResponseBody
	public String scimSinger() {
		return service.parseJsonFile("singer");
	}
	
	@GetMapping(path="/Users/cn=jimiHendrix", produces="application/scim+json")
	@ResponseBody
	public String scimJimi() {
		return service.parseJsonFile("jimiHendrix");
	}
	@GetMapping(path="/Users/cn=kurtCobain", produces="application/scim+json")
	@ResponseBody
	public String scimKurt() {
		return service.parseJsonFile("kurtCobain");
	}
	@GetMapping(path="/Users/cn=freddieMercury", produces="application/scim+json")
	@ResponseBody
	public String scimFreddie() {
		return service.parseJsonFile("freddieMercury");
	}
	@GetMapping(path="/Users/cn=robertPlant", produces="application/scim+json")
	@ResponseBody
	public String scimBob() {
		return service.parseJsonFile("robertPlant");
	}
	@GetMapping(path="/Users/cn=jimmyPage", produces="application/scim+json")
	@ResponseBody
	public String scimPage() {
		return service.parseJsonFile("jimmyPage");
	}
	@GetMapping(path="/Users/cn=brianMay", produces="application/scim+json")
	@ResponseBody
	public String scimBrian() {
		return service.parseJsonFile("brianMay");
	}
	
}
