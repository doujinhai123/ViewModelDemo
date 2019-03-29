package com.example.myfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class TestFragment extends Fragment {

    private static final String TAG = "TestFragment";

    private View view;
    private MViewModel mMViewModel;
    private Button mBtn;
    private TextView mDesc;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_test, container, false);
        mBtn = view.findViewById(R.id.btn);
        mDesc = view.findViewById(R.id.desc);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //这里传入了getActivity(),返回的是跟Activity同一个ViewModel.
        mMViewModel = ViewModelProviders.of(getActivity()).get(MViewModel.class);
        mMViewModel.getString().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mDesc.setText(s);
            }
        });

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMViewModel.getMsgString().setValue("Fragment1 发送的数据");
            }
        });
    }

}
