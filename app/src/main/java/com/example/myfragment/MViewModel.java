package com.example.myfragment;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MViewModel extends ViewModel {

    MutableLiveData<String> mString;
    MutableLiveData<String> msgString;


    public MutableLiveData<String> getString(){
        if(mString==null){
            mString=new MutableLiveData<>();
        }
        return mString;
    }

    public MutableLiveData<String> getMsgString(){
        if(msgString==null){
            msgString=new MutableLiveData<>();
        }
        return msgString;
    }

    public void startTask(){
        new Thread(){
            @Override
            public void run() {
                //请求网络数据、数据库、加载大图等。
                //如果在Activity转屏的时候取消这些任务，那恢复的时候就要重新加载，势必浪费资源
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mString.postValue("我是来自3秒后的数据");
                super.run();
            }
        }.start();
    }


    @SuppressWarnings("WeakerAccess")
    protected void onCleared() {
        //做一些数据清理工作
        Log.e("MViewModel","onCleared");
    }

}
