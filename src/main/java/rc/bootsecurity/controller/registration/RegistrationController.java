package rc.bootsecurity.controller.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rc.bootsecurity.model.registration.UserRegistration;
import rc.bootsecurity.service.RegistrationService;

import javax.validation.Valid;

@RestController
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public String registerUser(@RequestBody @Valid UserRegistration request) {
        return "Success";
    }
}
