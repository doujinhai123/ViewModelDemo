package com.example.myfragment;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

public class MApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Log.e(activity.getLocalClassName(),"onActivityCreated");
            }

            @Override
            public void onActivityStarted(Activity activity) {
                Log.e(activity.getLocalClassName(),"onActivityStarted");
            }

            @Override
            public void onActivityResumed(Activity activity) {
                Log.e(activity.getLocalClassName(),"onActivityResumed");
            }

            @Override
            public void onActivityPaused(Activity activity) {
                Log.e(activity.getLocalClassName(),"onActivityPaused");
            }

            @Override
            public void onActivityStopped(Activity activity) {
                Log.e(activity.getLocalClassName(),"onActivityStopped");
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                Log.e(activity.getLocalClassName(),"onActivitySaveInstanceState");
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                Log.e(activity.getLocalClassName(),"onActivityDestroyed");
            }
        });
    }
}
