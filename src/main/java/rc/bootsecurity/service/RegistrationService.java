package rc.bootsecurity.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rc.bootsecurity.exceptions.EmailExistException;
import rc.bootsecurity.model.Authority;
import rc.bootsecurity.model.BooleanResponse;
import rc.bootsecurity.model.registration.UserRegistrationRequest;
import rc.bootsecurity.repository.IRegisterationRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class RegistrationService implements IRegistrationService {

    private IRegisterationRepository iRegisterationRepository;
    private PasswordEncoder passwordEncoder;

    public RegistrationService(IRegisterationRepository iRegisterationRepository, PasswordEncoder passwordEncoder){
        this.iRegisterationRepository = iRegisterationRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public BooleanResponse register(UserRegistrationRequest userRegistrationRequest) {
        if(iRegisterationRepository.existsByEmail(userRegistrationRequest.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        Set<Authority> authorityTypeSet = new HashSet<>();
        //authorityTypeSet.add(new Authority())

     //   User user = new User(userRegistrationRequest.getEmail(), passwordEncoder.encode(userRegistrationRequest.getPassword()), userRegistrationRequest.getFirstName() , userRegistrationRequest.getLastName(), userRegistrationRequest.getEmail(), userRegistrationRequest.getPhoneNumber());

       // iRegisterationRepository.save(user);
        return BooleanResponse.success();
    }
}
