package com.example.myproject2022.common;

import com.example.myproject2022.exception.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

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
