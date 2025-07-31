package com.prueba.vehicle.helpers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;

import com.prueba.vehicle.dtos.responses.GeneralResponse;

public class ResponseHelper {

    // Construimos el error bindingresult
    public static Map<String, Object> buildErrorFields(Errors error) {
        Map<String, Object> errors = new HashMap<>();

        error.getFieldErrors().forEach(errorField -> {
            String nameField = errorField.getField();
            String errorMessage = "The field " + nameField + ", " + errorField.getDefaultMessage();
            errors.put(nameField, errorMessage);
        });

        return errors;
    }

    public static ResponseEntity<GeneralResponse> ok(String message, Object data) {
        int code = HttpStatus.OK.value();
        return ResponseEntity.status(code).body(new GeneralResponse("Request accomplished: " + message, code, data));
    }

    public static ResponseEntity<GeneralResponse> badRequest(String message, Object data) {
        int code = HttpStatus.BAD_REQUEST.value();
        return ResponseEntity.status(code).body(new GeneralResponse("Request rejected: " + message, code, data));
    }

}
