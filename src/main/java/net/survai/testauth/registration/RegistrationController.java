package net.survai.testauth.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController
{
	private final RegistrationService registrationService;
	
	@PostMapping
	public String register(@RequestBody RegistrationRequest req)
	{
		return registrationService.register(req);
	}
	
	@GetMapping(path = "confirm")
	public String confirm(@RequestParam("token") String token)
	{
		return registrationService.confirmToken(token);
	}
}
