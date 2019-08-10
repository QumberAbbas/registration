package rc.bootsecurity.service;

import rc.bootsecurity.model.BooleanResponse;
import rc.bootsecurity.model.registration.LoginRequest;

public interface ILoginService {
    BooleanResponse login(LoginRequest loginRequest);
}
