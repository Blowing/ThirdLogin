package com.wujie.thirdlogin;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;

/**
 * Created by wujie on 2016/8/19.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }

}
