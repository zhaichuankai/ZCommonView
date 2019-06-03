package com.xhkjedu.zcommonview;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {
    private LoadingView loadingView;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    loadingView.remove();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        loadingView = new LoadingView(this).init();
        loadingView.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Message msg = mHandler.obtainMessage();
                msg.what = 0;
                mHandler.sendMessageDelayed(msg, 3000);
            }
        }).start();
    }

}
