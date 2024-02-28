package com.agencyamazon.task.model.dto.user;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
public class CreateUserAccountDto {

    @NotNull
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "username is required")
    @Size(min = 2, max = 50, message
            = "user name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Confirmation is required")
    private String confirmPassword;

    @AssertTrue(message = "Password must be at least 8 characters long, less than 50 characters "
            + "and contain at least one letter and one digit, and match the confirmation.")
    public boolean isPasswordValid() {
        if (password == null || confirmPassword == null) {
            return false;
        }
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d#?!@$%^&~*(){}:;_+|<>/.,'=№`\\-\"\\[\\]]{8,49}")
                && password.equals(confirmPassword);
    }

}
