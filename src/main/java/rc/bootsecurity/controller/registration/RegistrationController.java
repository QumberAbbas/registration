package rc.bootsecurity.controller.registration;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rc.bootsecurity.model.BooleanResponse;
import rc.bootsecurity.model.registration.UserRegistrationRequest;
import rc.bootsecurity.service.IRegistrationService;
import rc.bootsecurity.service.RegistrationService;

import javax.validation.Valid;

@RestController
public class RegistrationController {

    private IRegistrationService registrationService;


    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping(value = "/user/registration")
    public BooleanResponse registerUser(@RequestBody @Valid UserRegistrationRequest request) {
        return registrationService.register(request);
    }
}
