package com.sth.vc.service;

import com.sth.vc.model.LoginReqModel;
import com.sth.vc.model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LoginService {

    @POST("/VoiceCodeService.asmx/Login")
    Call<ResponseModel> login(@Body LoginReqModel loginReqModel);

}
