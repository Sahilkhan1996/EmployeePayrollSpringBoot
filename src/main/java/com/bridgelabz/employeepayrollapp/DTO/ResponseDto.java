package com.bridgelabz.employeepayrollapp.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDto {

    private String message;
    private Object data;

    public ResponseDto(String message, Object data) {
        this.message = message;
        this.data = data;
    }

}
