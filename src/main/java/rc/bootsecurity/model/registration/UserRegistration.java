package rc.bootsecurity.model.registration;

import rc.bootsecurity.annotations.PasswordMatches;
import rc.bootsecurity.annotations.ValidEmail;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@PasswordMatches
public class UserRegistration {

	@NotNull
	@NotEmpty
	@ValidEmail
	private String email;

	@NotNull
	@NotEmpty
	private String firstName;

	@NotNull
	@NotEmpty
	private String lastName;

	@NotNull
	@NotEmpty
	private String password;

	@NotNull
	@NotEmpty
	private String matchingPassword;

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}
}
