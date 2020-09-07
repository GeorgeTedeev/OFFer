package com.project.offer.forms;

import javax.validation.constraints.*;

public class UserForm {

    @Pattern(regexp = "[A-Za-z0-9!?./:;]*")
    @NotEmpty
    private String name;
    @NotBlank
    @Email
    private String login;
    @Size(min = 8)
    @Pattern(regexp = "[A-Za-z0-9!?./:;]*")
    @NotEmpty
    private String password;

    public UserForm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
