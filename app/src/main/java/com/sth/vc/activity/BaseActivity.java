package com.sth.vc.activity;

import android.support.v7.app.AppCompatActivity;

import com.kaopiz.kprogresshud.KProgressHUD;

public class BaseActivity extends AppCompatActivity {

    private static KProgressHUD hud;

    protected void showLoading(String msg) {
        if (null == hud) {
            hud = KProgressHUD.create(this)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setLabel(msg)
                    .setCancellable(true)
                    .show();
        } else {
            hud.setLabel(msg);
            if (!hud.isShowing())
                hud.show();
        }
    }

    protected void hideLoading() {
        hud.dismiss();
    }
}
