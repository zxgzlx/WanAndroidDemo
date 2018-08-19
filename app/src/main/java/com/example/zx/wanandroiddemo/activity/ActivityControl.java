package com.example.zx.wanandroiddemo.activity;

import android.app.Activity;

import java.util.HashSet;
import java.util.Set;

public class ActivityControl {

    private static ActivityControl sActivityControl;
    private Set<Activity> mActivities = new HashSet<>();

    public static ActivityControl getActivityControl() {
        if (sActivityControl == null) {
            synchronized (ActivityControl.class) {
                if (sActivityControl == null) {
                    sActivityControl = new ActivityControl();
                }
            }
        }
        return sActivityControl;
    }

    public void addActivity(Activity activity) {
        mActivities.add(activity);
    }

    public void removeActivity(Activity activity) {
        mActivities.remove(activity);
    }

    public void exitApp() {
        if (sActivityControl != null) {
            for (Activity activity : mActivities){
                activity.finish();
            }
        }
        // 注意这两个退出方法的区别
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
