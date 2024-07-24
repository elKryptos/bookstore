package com.hans.bookstoreapi.model.dto;

import com.hans.bookstoreapi.model.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserFormDTO {

    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private User.Role role;

    public String getFullname(){
        return firstname + " " + lastname;
    }
}
