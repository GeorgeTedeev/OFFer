package com.project.offer.forms;

import javax.validation.constraints.*;

public class UserFormForAuthentication {

    @NotBlank
    @Email
    private String login;
    @Size(min = 8)
    @Pattern(regexp = "[A-Za-z0-9!?./:;]*")
    @NotEmpty
    private String password;

    public UserFormForAuthentication() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
