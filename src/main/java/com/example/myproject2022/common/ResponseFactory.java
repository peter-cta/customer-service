package com.example.myproject2022.common;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ResponseFactory {
    public Response<GeneralResponse<Object>> toSuccess(Object data){
        Response<GeneralResponse<Object>> response = new Response<>();
        response.setStatusCode("200");
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setCode("SUCCESS");
        generalResponse.setMessage("Thành công");
        generalResponse.setData(data);
        response.setBody(generalResponse);
        return response;
    }
}
