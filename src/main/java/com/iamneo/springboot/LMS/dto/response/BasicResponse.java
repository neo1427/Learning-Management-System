package com.iamneo.springboot.LMS.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasicResponse<T> {
    private String message;
    private T data;
}
