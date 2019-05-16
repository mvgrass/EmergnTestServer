package com.mvgrass.Server.Model;

import javax.validation.constraints.NotNull;

public class User {
    public User(@NotNull String login, @NotNull String password, @NotNull String name, @NotNull String email) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    @NotNull
    private String login;

    @NotNull
    private String password;

    @NotNull
    private String name;

    @NotNull
    private String email;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
