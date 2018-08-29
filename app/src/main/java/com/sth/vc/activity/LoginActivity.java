package com.sth.vc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.sth.vc.R;
import com.sth.vc.model.LoginReqModel;
import com.sth.vc.model.ResponseModel;
import com.sth.vc.service.LoginService;
import com.sth.vc.util.Contains;

import java.io.IOException;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.userNameEdit)
    EditText userNameEdit;
    @BindView(R.id.passwordEdit)
    EditText passwordEdit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        // Logger Init
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    @OnClick(R.id.loginBtn)
    void loginAction() {
        if (!checkInput())
            return;

        requestLogin();
    }

    @OnClick(R.id.userInfoBtn)
    void showUserInfoView() {
        startActivity(new Intent(LoginActivity.this, UserInfoActivity.class));
    }

    private boolean checkInput() {
        if (this.userNameEdit.getText().toString().isEmpty()) {
            Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return false;
        } else if (this.passwordEdit.getText().toString().isEmpty()) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void requestLogin() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Contains.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LoginService loginService = retrofit.create(LoginService.class);

        LoginReqModel loginReq = new LoginReqModel("22222222e22222", "18500972879", "123456");
        Call<ResponseModel> call = loginService.login(loginReq);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                try {
                    Logger.e(new Gson().toJson(response.body().getD()));
                    Logger.e(response.body().getD().getRespMsg());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

}
