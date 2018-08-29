package com.sth.vc.service;

import com.sth.vc.model.UserInfoReqModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserInfoService {

    @POST("/VoiceCodeService.asmx/GetUserInfo")
    Call<ResponseBody> getUserInfo(@Body UserInfoReqModel model);
}
