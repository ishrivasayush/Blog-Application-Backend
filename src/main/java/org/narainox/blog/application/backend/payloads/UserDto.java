package org.narainox.blog.application.backend.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    @NotEmpty
    @Size(min = 4,message = "Username must be min of 4 characters.")
    private String name;
    @Email(message = "Email Address is not valid !!")
    @NotNull
    private String email;
    private String about;
    @NotEmpty
    @Size(max = 8,min = 6)
    private String password;
}
