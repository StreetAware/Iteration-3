package com.example.gearo.streetawarev1.util;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gearo.streetawarev1.R;

public class CtfSearchFragment extends Fragment {

    private static final String TAG = "CtfSeachFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_ctf_search, container,false);

        return view;
    }
}
