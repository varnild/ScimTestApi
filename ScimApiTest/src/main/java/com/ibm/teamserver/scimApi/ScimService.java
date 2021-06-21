package com.ibm.teamserver.scimApi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;

@Component
public class ScimService {
	
	public boolean SERVER_ON_ERROR = false;
	public boolean REPO_UPDATED = false;
	
	public String parseJsonFile(String fileName) {
		if(REPO_UPDATED) fileName = fileName + "Updated";
		if(SERVER_ON_ERROR) fileName = "error";
		
		String file = "src/main/resources/" + fileName +".json";
        String json = "";
		try {
			json = new String(Files.readAllBytes(Paths.get(file)));
		} catch (IOException e) {
			e.printStackTrace();
			return "Something is wrong with the JSON files";
		}
		return json;
	}
	
	public void toggleServerInError() {
		SERVER_ON_ERROR = !SERVER_ON_ERROR;
	}
	
	public void updateRepo() {
		REPO_UPDATED = !REPO_UPDATED;
	}
}
