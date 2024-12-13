package com.edu.wzu.app;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;

import com.edu.wzu.app.databinding.FragmentSitMyocardialGroupBinding;
import com.edu.wzu.app.databinding.FragmentVideoBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SitMyocardialGroupFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SitMyocardialGroupFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SitMyocardialGroupFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SitMyocardialGroupFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SitMyocardialGroupFragment newInstance(String param1, String param2) {
        SitMyocardialGroupFragment fragment = new SitMyocardialGroupFragment();
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
        /*
        UrlViewModel urlViewModel;
        urlViewModel = new ViewModelProvider(getActivity()).get(UrlViewModel.class);
        FragmentSitMyocardialGroupBinding binding;
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_sit_myocardial_group,container,false);
        binding.setData(urlViewModel);
        binding.setLifecycleOwner(getActivity());
        binding.scapulardepressionMGsitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_sitMyocardialGroupFragment_to_videoFragment);
                //urlViewModel.setUrl("https://drive.google.com/file/d/1qghddHss-5VMWu_9fIotxlgVKXIM9z3D/view?usp=drive_link");
            }
        });
        //肩胛轉圈
        binding.shoulderbladecirclesMGsitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                Log.d("NavController", "Controller is null: " + (controller == null));
                controller.navigate(R.id.action_sitMyocardialGroupFragment_to_videoFragment);
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/cglODBjsufk?si=BUT5diWZH2eDdsfZ\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe><iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/cglODBjsufk?si=BUT5diWZH2eDdsfZ\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
            }
        });
        return binding.getRoot();

         */
        //Inflate the layout for this fragment
       return inflater.inflate(R.layout.fragment_sit_myocardial_group, container, false);
    }
}