package io.turntabl.userservice.entities;

import io.turntabl.userservice.dto.UserDto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "user")
public class UserEntity {
    @Id
    private String id;
    private String email;
    private String fullName;
    private String status;
}
