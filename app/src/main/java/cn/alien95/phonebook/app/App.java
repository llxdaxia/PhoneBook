package cn.alien95.phonebook.app;

import android.app.Application;

import cn.alien95.phonebook.utils.Util;

/**
 * Created by llxal on 2015/12/9.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Util.init(this);
        Util.setDebugLog("fuck");
    }
}
