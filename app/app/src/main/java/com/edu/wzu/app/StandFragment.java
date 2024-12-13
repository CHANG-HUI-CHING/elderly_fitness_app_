package com.edu.wzu.app;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StandFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StandFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StandFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StandFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StandFragment newInstance(String param1, String param2) {
        StandFragment fragment = new StandFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stand, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //    核心肌群
        //getView().findViewById(R.id.myocardial_group_stand_button).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_standFragment_to_standMyocardialGroupFragment));
        //   上肢肌群
        getView().findViewById(R.id.Upper_limb_stand_button).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_standFragment_to_standUpperLimbFragment));
        // 下肢肌群
        getView().findViewById(R.id.Lower_limb_stand_button).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_standFragment_to_standLowerLimbFragment));
    }
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        getView().findViewById(R.id.button).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_standFragment_to_homeFragment));
//    }
}