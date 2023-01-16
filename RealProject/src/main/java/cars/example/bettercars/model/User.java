package cars.example.bettercars.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

public class User {

    @JsonProperty("id")
    private Long id;

    @NotBlank
    @JsonProperty("username")
    private String username;

    @NotBlank
    @JsonProperty("password")
    private String password;

    private int enabled;

    @NotBlank
    @JsonProperty("email")
    private String email;
    @NotBlank
    @JsonProperty("mobilePhone")
    private String mobilePhone;

    public User(String username, String password, int enabled, String email, String mobilePhone) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.email = email;
        this.mobilePhone = mobilePhone;
    }

    public User(Long id, String username, String password, int enabled, String email, String mobilePhone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.email = email;
        this.mobilePhone = mobilePhone;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", email='" + email + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;

    }
    public String getEmail() {
        return email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getUsername() {
        return username;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

}
