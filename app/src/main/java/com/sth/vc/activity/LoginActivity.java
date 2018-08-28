package com.sth.vc.activity;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.sth.vc.R;
import com.sth.vc.util.Contains;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText userNameEdit = null;
    private EditText passwordEdit = null;
    private Button loginBtn = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Logger.e("=========");

        setContentView(R.layout.activity_login);

        // Logger Init
        Logger.addLogAdapter(new AndroidLogAdapter());

        initView();
    }

    private void initView() {
        this.userNameEdit = this.findViewById(R.id.userNameEdit);
        this.passwordEdit = this.findViewById(R.id.passwordEdit);
        this.loginBtn = this.findViewById(R.id.loginBtn);
        this.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAction();
            }
        });
    }

    private void loginAction() {
        if (!checkInput())
            return;

        requestLogin();
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
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder formBody = new FormBody.Builder();
        formBody.add("machineCode", "000000")
                .add("phone", "18500972879")
                .add("code", "1234");
        Request request = new Request.Builder()
                .url(Contains.HOST + "/VoiceCodeService.asmx/Login")
                .post(formBody.build())
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Logger.e("====Failure", e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Logger.e("====Response", response.toString());

            }
        });


    }

}
