package com.project.template.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotNull(message = "email cannot be null")
    @Email
    private String email;
    @NotNull(message = "password cannot be null")
    private String password;
}
