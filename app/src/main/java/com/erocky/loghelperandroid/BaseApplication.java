package com.erocky.loghelperandroid;

import android.app.Application;

import com.rocky.loghelper.LogHelper;

import java.util.logging.Level;

public class BaseApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        LogHelper.configure(this, "LogHelper-demo", true, Level.FINE);
        LogHelper.setupUncaughtExceptionHandler();
    }

    @Override
    public void onTerminate() {
        LogHelper.flush();
        super.onTerminate();
    }
}
