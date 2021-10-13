package net.survai.testauth.registration;

import lombok.AllArgsConstructor;
import net.survai.testauth.appuser.AppUser;
import net.survai.testauth.appuser.AppUserRole;
import net.survai.testauth.appuser.AppUserService;
import net.survai.testauth.validation.EmailValidator;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService
{
	private final AppUserService appUserService;
	private EmailValidator emailValidator;
	
	public String register(RegistrationRequest request)
	{
		boolean isValidEmail = emailValidator.test(request.getEmail());
		
		if (!isValidEmail)
		{
			throw new IllegalStateException("email not vaild");
		}
		
		return appUserService.signUpUser(new AppUser(request.getFirstName(), request.getLastName(),
				request.getEmail(), request.getPassword(), AppUserRole.USER));
	}
}
