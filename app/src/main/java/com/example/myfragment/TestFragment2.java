package com.example.myfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class TestFragment2 extends Fragment {

    private View view;
    private MViewModel mMViewModel;
    private TextView mDesc;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_test2, container, false);
        mDesc = view.findViewById(R.id.desc);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMViewModel = ViewModelProviders.of(getActivity()).get(MViewModel.class);
        mMViewModel.getString().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mDesc.setText(s);
            }
        });

        mMViewModel.getMsgString().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mDesc.setText(s);
            }
        });
    }
}
