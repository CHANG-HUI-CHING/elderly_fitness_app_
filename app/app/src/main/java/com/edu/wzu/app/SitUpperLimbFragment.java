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

import com.edu.wzu.app.databinding.FragmentSitMyocardialGroupBinding;
import com.edu.wzu.app.databinding.FragmentSitUpperLimbBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SitUpperLimbFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SitUpperLimbFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SitUpperLimbFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SitUpperLimbFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SitUpperLimbFragment newInstance(String param1, String param2) {
        SitUpperLimbFragment fragment = new SitUpperLimbFragment();
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
        FragmentSitUpperLimbBinding binding;//改databinding
        //databinding的頁面fragment_sit_upper_limb
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_sit_upper_limb,container,false);
        binding.setData(urlViewModel);
        binding.setLifecycleOwner(getActivity());
        //肩胛下壓
        binding.scapularDepressionULsitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                //頁面切換到videoFragment
                controller.navigate(R.id.action_sitUpperLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.sitting_name)+getString(R.string.scapular_depression));
                urlViewModel.setSuggestion(getString(R.string.scapular_depressionSuggestion));
                //寬高設定100%
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/NaeqxGgWvaA?si=zfiYmYe3hnlIEQvi\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/YqpvOlcNZ_A?si=CTv4qkoEXYnbmGEw\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
            }
        });
        //肩胛轉圈
        binding.shoulderBladeCirclesULsitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_sitUpperLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.sitting_name)+getString(R.string.shoulder_blade_circles));
                urlViewModel.setSuggestion(getString(R.string.shoulder_blade_circlesSuggestion));
                //寬高設定100%
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/4x7GBw_oN1M?si=MtRCdVos-ybW8loG\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/eAO-p9J1LuE?si=XFajWSH6Um8618vt\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");

            }
        });
        //二頭肌彎舉
        binding.BicepsCurlULsitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_sitUpperLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.sitting_name)+getString(R.string.BicepsCurl));
                urlViewModel.setSuggestion(getString(R.string.BicepsCurlSuggestion));
                //寬高設定100%
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/tHgaJZuG-kw?si=V2um-XdvJlUL836N\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/dPAXkbXtNj4?si=4tvv9kAlXbCecom6\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
            }
        });
        //三頭肌伸展-1
        binding.OverheadTricepsExtensions1ULsitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_sitUpperLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.sitting_name)+getString(R.string.OverheadTricepsExtensions_1));
                urlViewModel.setSuggestion(getString(R.string.Nodata));
                //寬高設定100%
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/IocMPT3i9BA?si=gGSiSjUMX6Gs1o_V\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/WAsMa5xAiuo?si=t7YS4VJJ36Sr3-M-\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
            }
        });
        //三頭肌伸展-2
        binding.OverheadTricepsExtensions2ULsitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_sitUpperLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.sitting_name)+getString(R.string.OverheadTricepsExtensions_2));
                urlViewModel.setSuggestion(getString(R.string.Nodata));
                //寬高設定100%
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/6xjnP3Cvs1g?si=eM2jMQ4ZQ1micZau\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/yudbrO-6jJg?si=9RHNY-IE2mgNB7H1\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
            }
        });
        //啞鈴側擺
        binding.DumbbellSideSwingsULsitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_sitUpperLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.sitting_name)+getString(R.string.DumbbellSideSwings));
                urlViewModel.setSuggestion(getString(R.string.DumbbellSideSwingsSuggestion));
                //寬高設定100%
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/JBQH7kNFiCg?si=wJJB__Fr-wZ-iSnC\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/dGVmkZ6QTEg?si=j7SZLe7OtKkPZliv\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
            }
        });
        //雙手肩部推壓
        binding.TwoHandedOverheadPressULsitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_sitUpperLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.sitting_name)+getString(R.string.TwoHandedOverheadPress));
                urlViewModel.setSuggestion(getString(R.string.TwoHandedOverheadPressSuggestion));
                //寬高設定100%
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/kp6ugIq03nQ?si=fcTBTvlWj8lqFNsc\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/ytb_bJbbLs0?si=63_5NVtPU9wVBmKQ\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
            }
        });
        //俯身划船
        binding.BentOverRowULsitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_sitUpperLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.sitting_name)+getString(R.string.BentOverRow));
                urlViewModel.setSuggestion(getString(R.string.BentOverRowSuggestion));
                //寬高設定100%
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/pDv-3RAXvrk?si=adIirYtnaSjIWri1\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/-rpMhaEZVPQ?si=ZH7YOT91laEE6_Gl\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
            }
        });
        //肩推
        binding.ShoulderPressULsitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_sitUpperLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.sitting_name)+getString(R.string.ShoulderPress));
                urlViewModel.setSuggestion(getString(R.string.ShoulderPressSuggestion));
                //寬高設定100%
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/yPrzGPniH1g?si=8iTCh5YacJmS7OGg\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/XsB7mVpOffU?si=nl2K-tNNgDm7izc1\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
            }
        });
        //雙手推磨
        binding.TwoHandGrindingULsitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_sitUpperLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.sitting_name)+getString(R.string.TwoHandGrinding));
                urlViewModel.setSuggestion(getString(R.string.TwoHandGrindingSuggestion));
                //寬高設定100%
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/F2AB2aPoAmg?si=601QXhObCxWoF3Ny\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/PjGUHhuXMlM?si=iS0z0o-WmCwjMK-U\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
            }
        });
        //反向飛鳥
        binding.ReverseFlyULsitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_sitUpperLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.sitting_name)+getString(R.string.ReverseFly));
                urlViewModel.setSuggestion(getString(R.string.ReverseFlySuggestion));
                //寬高設定100%
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/uwUfaMVdOOA?si=nWpc-k0yYJGd9NrW\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/jbDlCvpTZYc?si=p1XWrpuRZUIKq79M\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
            }
        });
        return binding.getRoot();
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_sit_upper_limb, container, false);
    }
}