package com.example.gearo.streetawarev1.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gearo.streetawarev1.Activity.MainActivity;
import com.example.gearo.streetawarev1.R;

public class RateMyFitFragment extends Fragment {

    public RateMyFitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Setting the title to be given the value Rate My Fit upon being selected
        ((MainActivity)getActivity()).setActionBarTitle("Rate My Fit");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rmf, container, false);
    }
}
