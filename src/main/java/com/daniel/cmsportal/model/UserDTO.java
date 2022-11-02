package com.daniel.cmsportal.model;

import lombok.Data;

@Data
public class UserDTO {

    private User user;

    public UserDTO(User user)
    {
        this.user = user;
    }

    private Role roleToAppend;

}
