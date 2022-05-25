package com.censos.api.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserDTO {
    private String name;
    private String username;
    private String email;
}
