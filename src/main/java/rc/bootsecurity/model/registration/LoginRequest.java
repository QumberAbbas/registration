package rc.bootsecurity.model.registration;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LoginRequest {

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;

    public String getName() {
        return username;
    }
    public String getPassword() {
        return password;
    }

}
