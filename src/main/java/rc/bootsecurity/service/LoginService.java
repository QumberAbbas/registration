package rc.bootsecurity.service;

import org.springframework.stereotype.Service;
import rc.bootsecurity.model.BooleanResponse;
import rc.bootsecurity.model.User;
import rc.bootsecurity.model.registration.LoginRequest;
import rc.bootsecurity.model.registration.UserRegistrationRequest;
import rc.bootsecurity.repository.IRegisterationRepository;

@Service
public class LoginService implements ILoginService {

    private IRegisterationRepository iRegisterationRepository;

    public LoginService(IRegisterationRepository iRegisterationRepository){
        this.iRegisterationRepository = iRegisterationRepository;
    }

    @Override
    public BooleanResponse login(LoginRequest loginRequest) {
        return null;
    }
}
