package com.samsung.server.rest.dto;

import com.samsung.server.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    private int id;
    private String name;

    public static UserDto toDto(User user){
        return UserDto.builder().id(user.getId()).name(user.getName()).build();
    }

}
