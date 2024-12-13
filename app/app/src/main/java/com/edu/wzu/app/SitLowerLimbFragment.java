package com.edu.wzu.app;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edu.wzu.app.databinding.FragmentSitLowerLimbBinding;
import com.edu.wzu.app.databinding.FragmentSitMyocardialGroupBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SitLowerLimbFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SitLowerLimbFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SitLowerLimbFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SitLowerLimbFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SitLowerLimbFragment newInstance(String param1, String param2) {
        SitLowerLimbFragment fragment = new SitLowerLimbFragment();
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
        UrlViewModel urlViewModel;
        urlViewModel = new ViewModelProvider(getActivity()).get(UrlViewModel.class);
        FragmentSitLowerLimbBinding binding;
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_sit_lower_limb,container,false);
        binding.setData(urlViewModel);
        binding.setLifecycleOwner(getActivity());
        //深蹲
        binding.SquatLLsitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_sitLowerLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.sitting_name)+getString(R.string.Squat));
                urlViewModel.setSuggestion(getString(R.string.SquatSuggestion));
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/DlLo-ARwZFU?si=KYTf2T3Xzi21EMU0\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/pMdrWSETDYM?si=wAqz5y4q3_isZXRP\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
            }
        });
        //腳踝背屈下做膝伸直
        binding.DorsiflexTheAnkleAndExtendTheKneeLLsitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_sitLowerLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.sitting_name)+getString(R.string.DorsiflexKnee));
                urlViewModel.setSuggestion(getString(R.string.DorsiflexKneeSuggestion));
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/yk6x1DGUvvc?si=7Cw9KU7hA2HfrLr9\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/qBwQITsOIMU?si=C7l3psUMYvfqZiq0\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
            }
        });
        //抬腿
        binding.LegRaisesLLsitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_sitLowerLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.sitting_name)+getString(R.string.LegRaises));
                urlViewModel.setSuggestion(getString(R.string.LegRaisesSuggestion));
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/ulfV0SxsZP0?si=vM_S9Gn-tXCKwNBQ\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/dYKoIPavowY?si=QTsNj9WJCCZcvQUn\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
            }
        });
        //側舉腿
        binding.SideLegLiftLLsitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_sitLowerLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.sitting_name)+getString(R.string.SideLegLift));
                urlViewModel.setSuggestion(getString(R.string.SideLegLiftSuggestion));
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/9nPYDBYj-R8?si=MNulyRDZ7kZ-4WK-\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/pbjOzcJb5JI?si=RDQURaYrB1tseixl\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
            }
        });
        //踮腳
        binding.TiptoeLLsitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_sitLowerLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.sitting_name)+getString(R.string.Tiptoe));
                urlViewModel.setSuggestion(getString(R.string.TiptoeSuggestion));
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/FUVsNrVRct8?si=he_1WgU_gtD9DIi4\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/3ADes169XhQ?si=Nr2hq8T7Dx7BslH9\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
            }
        });
        //小腿拉伸
        binding.CalfStretchLLsitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_sitLowerLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.sitting_name)+getString(R.string.CalfStretch));
                urlViewModel.setSuggestion(getString(R.string.CalfStretchSuggestion));
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/JJf2KzU6e78?si=Gqux9vdLke_Tsg9B\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/bDECmqKVRn8?si=gNwQsB7QVITVgunt\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
            }
        });

        return binding.getRoot();
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_sit_lower_limb, container, false);
    }
}