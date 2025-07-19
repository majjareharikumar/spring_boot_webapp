package com.javaguide.Spring_boot_restful_webservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "User DTO module"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @Schema(
            description = "User id"
    )
    private Long id;
    @Schema(
            description = "User first name"
    )
    private String firstname;
    @Schema(
            description = "User last name"
    )
    private String lastname;
    @Schema(
            description = "User email"
    )
    private String email;
}
