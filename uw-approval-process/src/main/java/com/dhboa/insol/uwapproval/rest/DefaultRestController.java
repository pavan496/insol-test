package com.dhboa.insol.uwapproval.rest;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultRestController {

	@RequestMapping("/user")
	public Principal getUser(Principal principal) {
		return principal;
	}
}
