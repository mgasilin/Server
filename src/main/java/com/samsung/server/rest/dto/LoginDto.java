package com.samsung.server.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class LoginDto{
    private int result;
    private int id;

    public LoginDto(int result, int id){
        this.result=result;
        this.id=id;
    }
}