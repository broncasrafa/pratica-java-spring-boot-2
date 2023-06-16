package com.rsfrancisco.springbootmongodb.resources.models.response;

public class ApiResponse<T> {
    private T data;
    private boolean status;
    private Object error;

    /**
     * Instancia um objeto de resultado SUCESSO
     * @param data objeto para retornar
     */
    public ApiResponse(T data) {
        this.data = data;
        this.status = true;
        this.error = null;
    }

    public ApiResponse(T data, boolean status, Object error) {
        this.data = data;
        this.status = status;
        this.error = error;
    }
}
