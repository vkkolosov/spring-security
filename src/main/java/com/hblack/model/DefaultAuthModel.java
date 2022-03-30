package com.hblack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DefaultAuthModel {

    String role = "USER";
    String mail = "user";
    String password = "$2a$10$3keVIHBP./5vFB3g8yxabuYNED7rTzoMDdfHOeG/ThVMHc9AtO6yC"; // "user"
    String userName = "";

}
