package com.sth.vc.service;

import com.sth.vc.model.ResponseModel;
import com.sth.vc.model.UserInfoReqModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserInfoService {

    @POST("/VoiceCodeService.asmx/GetUserInfo")
    Call<ResponseBody> getUserInfo(@Body UserInfoReqModel model);

    @FormUrlEncoded
    @POST("/VoiceCodeService.asmx/GetUserInfo/")
    Call<ResponseModel> getUserInfo2(@Field("machineCode") String machineCode, @Field("phone") String phone);
}
