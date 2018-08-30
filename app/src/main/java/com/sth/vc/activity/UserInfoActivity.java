package com.sth.vc.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orhanobut.logger.Logger;
import com.sth.vc.R;
import com.sth.vc.model.ResponseModel;
import com.sth.vc.model.UserInfoReqModel;
import com.sth.vc.service.UserInfoService;
import com.sth.vc.util.Contains;


import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserInfoActivity extends AppCompatActivity {

    @BindView(R.id.userInfoText)
    TextView userInfoText;

    @BindView(R.id.userHeadImageView)
    ImageView userHeadImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.layout_userinfo);

        ButterKnife.bind(this);


    }

    @OnClick(R.id.queryBtn)
    void requestUserInfo() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Contains.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserInfoService service = retrofit.create(UserInfoService.class);

        UserInfoReqModel model = new UserInfoReqModel("000000", "18500972879");
        Call<ResponseBody> call = service.getUserInfo(model);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Logger.e(response.body().string());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    //@OnClick(R.id.queryBtn)
    void requestUserInfo2() {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Contains.HOST)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        UserInfoService service = retrofit.create(UserInfoService.class);

        Call<ResponseModel> call = service.getUserInfo2("000000", "18500972879");
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                Logger.e(response.body().getD().getRespMsg());
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }
}
