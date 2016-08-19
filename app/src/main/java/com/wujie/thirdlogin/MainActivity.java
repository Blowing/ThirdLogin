package com.wujie.thirdlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private UMShareAPI umShareAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        umShareAPI = UMShareAPI.get(this);
    }

    public void initView() {
        findViewById(R.id.btn_qq).setOnClickListener(this);
        findViewById(R.id.btn_qq_exit).setOnClickListener(this);
        findViewById(R.id.btn_weibo).setOnClickListener(this);
        findViewById(R.id.btn_weibo_exit).setOnClickListener(this);
        findViewById(R.id.btn_weixing).setOnClickListener(this);
        findViewById(R.id.btn_weixing_exit).setOnClickListener(this);
    }

    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
            Toast.makeText(getApplicationContext(),"认证成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
            Toast.makeText(getApplicationContext(),"认证失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {
            Toast.makeText(getApplicationContext(),"认证取消", Toast.LENGTH_SHORT).show();
        }
    };

    private UMAuthListener umdelAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
            Toast.makeText(getApplicationContext(),"取消认证成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
            Toast.makeText(getApplicationContext(),"取消认证成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {
            Toast.makeText(getApplicationContext(),"取消认证成功", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_qq:
                umShareAPI.doOauthVerify(MainActivity.this, SHARE_MEDIA.QQ, umAuthListener);
                break;
            case R.id.btn_qq_exit:
                umShareAPI.deleteOauth(MainActivity.this, SHARE_MEDIA.QQ, umdelAuthListener);
                break;
            case R.id.btn_weibo:
                umShareAPI.doOauthVerify(MainActivity.this, SHARE_MEDIA.SINA, umAuthListener);
                break;
            case R.id.btn_weibo_exit:
                umShareAPI.deleteOauth(MainActivity.this, SHARE_MEDIA.SINA, umdelAuthListener);
                break;
            case R.id.btn_weixing:
                umShareAPI.doOauthVerify(MainActivity.this, SHARE_MEDIA.WEIXIN, umAuthListener);
                break;
            case R.id.btn_weixing_exit:
                umShareAPI.deleteOauth(MainActivity.this, SHARE_MEDIA.WEIXIN, umdelAuthListener);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        umShareAPI.onActivityResult(requestCode, requestCode, data);
    }
}
