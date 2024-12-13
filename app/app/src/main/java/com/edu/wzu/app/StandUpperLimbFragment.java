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

import com.edu.wzu.app.databinding.FragmentStandUpperLimbBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StandUpperLimbFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StandUpperLimbFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StandUpperLimbFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StandUpperLimbFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StandUpperLimbFragment newInstance(String param1, String param2) {
        StandUpperLimbFragment fragment = new StandUpperLimbFragment();
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
        FragmentStandUpperLimbBinding binding;
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_stand_upper_limb,container,false);
        binding.setData(urlViewModel);
        binding.setLifecycleOwner(getActivity());
        //肩胛轉圈
        binding.shoulderBladeCirclesULstandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_standUpperLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.stand_name)+getString(R.string.shoulder_blade_circles));
                urlViewModel.setSuggestion(getString(R.string.Nodata));
                //寬高設定100%
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/tNEhocYFSA4?si=I8T_sMVijgpqRJ5q\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/16zOnQFoA0w?si=gWpbIfJLPyF8JDIu\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");

            }
        });
        //肩胛下壓
        binding.scapularDepressionULstandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_standUpperLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.stand_name)+getString(R.string.scapular_depression));
                urlViewModel.setSuggestion(getString(R.string.scapular_depressionSuggestion));
                //寬高設定100%
                //側
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/6vDVZr0RMxc?si=Eyb4XjJy2I0VfAvZ\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
                //正
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/KF8ctZIuuxE?si=mXKeMQU-i-2QJKn3\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
            }
        });

        //二頭肌彎舉
        binding.BicepsCurlULstandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_standUpperLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.stand_name)+getString(R.string.BicepsCurl));
                urlViewModel.setSuggestion(getString(R.string.BicepsCurlSuggestion));
                //寬高設定100%
                //側
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/2nwK-V0IUz8?si=nv2LE-WhGEOT4GCl\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
                //正
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/2h2XE9ziUSw?si=CKI_KPOzI43hTsBE\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
            }
        });

        //三頭肌伸展-1
        binding.OverheadTricepsExtensions1ULstandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_standUpperLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.stand_name)+getString(R.string.OverheadTricepsExtensions_1));
                urlViewModel.setSuggestion(getString(R.string.Nodata));
                //寬高設定100%
                //側
                urlViewModel.setUrl("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/Y8uXdj3hM9s?si=7BvrPYBDGsgrOuax\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
                //正
                urlViewModel.setUrl2("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/0WGxn5BZDpo?si=YZFH1yzOGZ0cm1yV\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
            }
        });

        //啞鈴側擺
        binding.DumbbellSideSwingsULstandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_standUpperLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.stand_name)+getString(R.string.DumbbellSideSwings));
                urlViewModel.setSuggestion(getString(R.string.DumbbellSideSwingsSuggestion));
                //寬高設定100%
                //側
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/6MkvUISomxA?si=UPGr-Xsv4ruCHg47\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
                //正
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/vpCrBBbvmSI?si=MoCgCoa5Vsp28AV0\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
            }
        });

        //雙手肩部推壓
        binding.TwoHandedOverheadPressULstandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_standUpperLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.stand_name)+getString(R.string.TwoHandedOverheadPress));
                urlViewModel.setSuggestion(getString(R.string.TwoHandedOverheadPressSuggestion));
                //寬高設定100%
                //側
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/mtbeaWXCLbo?si=p5s4SLoOCS9B7h0d\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
                //正
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/x6M-5bNlvRI?si=wUVioVJQaoUpAlsR\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
            }
        });

        //肩推
        binding.ShoulderPressULstandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_standUpperLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.stand_name)+getString(R.string.ShoulderPress));
                urlViewModel.setSuggestion(getString(R.string.ShoulderPressSuggestion));
                //寬高設定100%
                //側
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/ieG0X5XGVzM?si=-trPNxhSIvOR7hjY\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
                //正
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/F7ocwK6Hx2g?si=wk41PYrrSP0w9hmm\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
            }
        });

        //雙手推磨
        binding.TwoHandGrindingULstandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_standUpperLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.stand_name)+getString(R.string.TwoHandGrinding));
                urlViewModel.setSuggestion(getString(R.string.TwoHandGrindingSuggestion));
                //寬高設定100%
                //側
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Awg-hs4njrg?si=EjbmbTt-uGK4cRDS\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
                //正
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/RUM_5rrkhlI?si=eFL3EaC4mcna1G57\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
            }
        });

        //反向飛鳥
        binding.ReverseFlyULstandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_standUpperLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.stand_name)+getString(R.string.ReverseFly));
                urlViewModel.setSuggestion(getString(R.string.ReverseFlySuggestion));
                //寬高設定100%
                //側
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/KmBZJLXl4zg?si=QlEsZxl2einBNaEo\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
                //正
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/svC7NR2NDWU?si=nAbuIZRVuGAo66EN\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
            }
        });
        return binding.getRoot();




        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_stand_upper_limb, container, false);
    }
}