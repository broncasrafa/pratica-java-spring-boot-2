package com.rsfrancisco.springbootmongodb.resources.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rsfrancisco.springbootmongodb.resources.exception.StandardError;
import lombok.Data;


//@ResponseBody
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
        this.success = true;
        this.message = "ok";
        this.data = data;
    }

    /**
     * Instancia um objeto ApiResponse para FALHA/ERRO
     * @param message mensagem de erro ou falha
     */
//    protected ApiResponse(String message) {
//        this.success = false;
//        this.message = message;
//    }

    /**
     * Instancia um objeto ApiResponse para FALHA/ERRO
     * @param error objeto de erro
     * @param message opcional - mensagem de erro ou falha
     */
    protected ApiResponse(StandardError error, String message) {
        this.success = false;
        this.error = error;
        this.message = message;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<T>(data);
    }

    public static <StandardError> ApiResponse<com.rsfrancisco.springbootmongodb.resources.exception.StandardError> failure(com.rsfrancisco.springbootmongodb.resources.exception.StandardError error) {
        return new ApiResponse<com.rsfrancisco.springbootmongodb.resources.exception.StandardError>(error, null);
    }
}
