package io.turntabl.userservice.frontend.request;

import lombok.Data;

@Data
public class UserRequest {
    private String id;
    private String email;
    private String fullName;
}
