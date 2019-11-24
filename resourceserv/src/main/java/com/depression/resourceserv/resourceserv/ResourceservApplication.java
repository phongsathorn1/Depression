package com.depression.resourceserv.resourceserv;

import com.depression.resourceserv.resourceserv.model.UserInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
