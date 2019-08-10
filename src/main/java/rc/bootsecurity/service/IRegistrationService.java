package rc.bootsecurity.service;

import rc.bootsecurity.model.BooleanResponse;
import rc.bootsecurity.model.registration.UserRegistrationRequest;

public interface IRegistrationService {
    BooleanResponse register(UserRegistrationRequest userRegistrationRequest);
}
