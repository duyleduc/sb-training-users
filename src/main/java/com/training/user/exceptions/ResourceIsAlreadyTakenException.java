package com.training.user.exceptions;

import com.training.user.payload.ApiResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
@Getter
public class ResourceIsAlreadyTakenException extends RuntimeException{
    private ApiResponse apiResponse;

    public ResourceIsAlreadyTakenException(String resourceName, String fieldName, Object fieldValue) {
        super();
        String message = String.format("%s  with %s: '%s' is already taken", resourceName, fieldName, fieldValue);

        this.apiResponse = new ApiResponse(Boolean.FALSE, message);
    }
}
