package rc.bootsecurity.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
public class User extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user_name", nullable = false)
    @Size(min = 4, max = 50)
    private String userName;

    @NotNull
    @Size(min = 4, max = 100)
    private String password;

    @Column(name = "first_name", nullable = false)
    @Size(min = 4, max = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotNull
    @Size(min = 4, max = 50)
    private String lastName;

    @Column(nullable = false)
    @Size(min = 4, max = 50)
    private String email;

    @Column(nullable = false, name = "phone_number")
    private String phoneNumber;

    private int status = 0;

    @Column(name = "wrong_password_attempts")
    private int wrongPasswordAttempts = 0;

    @Column(name = "is_account_blocked")
    private boolean isAccountBlocked = false;

    @Column(name = "last_password_reset_date")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date lastPasswordResetDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id")})
    private Set<Authority> authorities;


    public User(String email, String password, String firstName, String lastName, String phoneNumber, Set<Authority> authorities) {
        this.userName = firstName + lastName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.authorities = authorities;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getWrongPasswordAttempts() {
        return wrongPasswordAttempts;
    }

    public void setWrongPasswordAttempts(int wrongPasswordAttempts) {
        this.wrongPasswordAttempts = wrongPasswordAttempts;
    }

    public boolean isAccountBlocked() {
        return isAccountBlocked;
    }

    public void setAccountBlocked(boolean accountBlocked) {
        isAccountBlocked = accountBlocked;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public boolean getIsAccountBlocked() {
        return wrongPasswordAttempts >= 3;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }
}
