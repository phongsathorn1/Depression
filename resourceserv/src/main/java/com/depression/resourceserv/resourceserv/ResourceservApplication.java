package com.depression.resourceserv.resourceserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;

@SpringBootApplication
@RestController
public class ResourceservApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceservApplication.class, args);
	}

//	@PreAuthorize("#oauth2.hasScope('read')")
	@Secured({"ROLE_USER", "ROLE_DOCTOR"})
	@GetMapping("/")
	public HashMap<String, Object> index(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		HashMap<String, Object> result = new HashMap<>();

		result.put("username", authentication.getName());
		result.put("authorities", authentication.getAuthorities());
		result.put("details", authentication.getDetails());
		result.put("principle", authentication.getPrincipal());

		return result;
	}

	@GetMapping("/test")
	public HashMap<String, Object> test(Principal principal){
		HashMap<String, Object> result = new HashMap<>();

		result.put("principal", principal);
		return result;
	}

	@Secured({"ROLE_DOCTOR"})
	@GetMapping("/doctor")
	public String doctor(){
		return "Hi! Doctor.";
	}

	@GetMapping("/public")
	public String home(){
		return "Hi! It's work";
	}
}
