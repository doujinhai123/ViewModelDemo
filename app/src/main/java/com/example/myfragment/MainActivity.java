package com.example.myfragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {

    private MViewModel mViewModel;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView=findViewById(R.id.desc);
        mViewModel = ViewModelProviders.of(this).get(MViewModel.class);

        mViewModel.getString().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e("MainActivity", "耗时任务结束返回数据");
                mTextView.setText(s);
            }
        });

        mViewModel.getMsgString().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e("MainActivity", "Fragment1发过来的数据");
                mTextView.setText(s);
            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new TestFragment(),
                TestFragment.class.getName()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.container2, new TestFragment2(),
                TestFragment.class.getName()).commit();

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("MainActivity", "开始耗时任务");
                mViewModel.startTask();
                new Thread(){
                    @Override
                    public void run() {
                        int count = 0;
                        while (true) {
                            //请求网络数据、数据库、加载大图等。
                            //如果在Activity转屏的时候取消这些任务，那恢复的时候就要重新加载，势必浪费资源
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            count = count +1;
                            Log.w("doujinhaiyu", "run: 1111111"+count );

                        }

                    }
                }.start();
            }
        });


    }
}
