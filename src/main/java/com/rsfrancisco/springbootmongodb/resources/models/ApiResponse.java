package com.rsfrancisco.springbootmongodb.resources.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rsfrancisco.springbootmongodb.resources.exception.StandardError;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ApiResponse<T> {
    private T data;
    private boolean success;
    private StandardError error;
    private String message;

    /**
     * Instancia um objeto ApiResponse para SUCESSO
     * @param data objeto para retornar
     */
    protected ApiResponse(T data) {
        if (data instanceof StandardError) {
            this.success = false;
            this.error = (StandardError) data;
        } else {
            this.success = true;
            this.message = "ok";
            this.data = data;
        }
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<T>(data);
    }

    public static <StandardError> ApiResponse<com.rsfrancisco.springbootmongodb.resources.exception.StandardError> failure(com.rsfrancisco.springbootmongodb.resources.exception.StandardError error) {
        return new ApiResponse<com.rsfrancisco.springbootmongodb.resources.exception.StandardError>(error);
    }
}
