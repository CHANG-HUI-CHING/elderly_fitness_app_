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

import com.edu.wzu.app.databinding.FragmentStandLowerLimbBinding;
import com.edu.wzu.app.databinding.FragmentStandUpperLimbBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StandLowerLimbFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StandLowerLimbFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StandLowerLimbFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StandLowerLimbFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StandLowerLimbFragment newInstance(String param1, String param2) {
        StandLowerLimbFragment fragment = new StandLowerLimbFragment();
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
        FragmentStandLowerLimbBinding binding;
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_stand_lower_limb,container,false);
        binding.setData(urlViewModel);
        binding.setLifecycleOwner(getActivity());

        //深蹲
        binding.SquatLLstandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_standLowerLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.stand_name)+getString(R.string.Squat));
                urlViewModel.setSuggestion(getString(R.string.SquatSuggestion));
                //寬高設定100%
                //側
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/M9EbhjIPPik?si=MPZiB3PGsJcspTgG\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
                //正
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Ja_RPXGYRf8?si=pzuIfausnI4IwW3U\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");

            }
        });

        //抬腿
        binding.LegRaisesLLstandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_standLowerLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.stand_name)+getString(R.string.LegRaises));
                urlViewModel.setSuggestion(getString(R.string.LegRaisesSuggestion));
                //寬高設定100%
                //側
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/PuCACYF3gXs?si=mmFDl16Kuz6gj0C3\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
                //正
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/E_ERoM01WmQ?si=ndzIiiuFLNdGc0WF\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");

            }
        });

        //側舉腿
        binding.SideLegLiftLLstandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_standLowerLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.stand_name)+getString(R.string.SideLegLift));
                urlViewModel.setSuggestion(getString(R.string.SideLegLiftSuggestion));
                //寬高設定100%
                //側
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/edDj0syl6cA?si=dXPKubQSAgKClk5e\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
                //正
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/T1EJKO2iGqk?si=xuaxbjqIXyAGBUD1\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");

            }
        });

        //踮腳
        binding.TiptoeLLstandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_standLowerLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.stand_name)+getString(R.string.Tiptoe));
                urlViewModel.setSuggestion(getString(R.string.TiptoeSuggestion));
                //寬高設定100%
                //側
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/AHv6I5Er-qQ?si=s1NIOrP8J97tyd_6\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
                //正
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/KnhxKUNSDDI?si=VMwjJcCsH7i5CmLq\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");

            }
        });

        //一腳前一腳後加上肢動作做重心位移
        binding.OnefootforwardOnefootbackLLstandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_standLowerLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.stand_name)+getString(R.string.OnefootforwardOnefootback));
                urlViewModel.setSuggestion(getString(R.string.OnefootforwardOnefootbackSuggestion));
                //寬高設定100%
                //側
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/XQ-BCt0whJk?si=ICry80OeTCjpo0gm\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
                //正
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/vPWsJ7FSxsc?si=0ns3Aia-UY3RBl5i\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");

            }
        });

        //單腳站立
        binding.StandingononelegLLstandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_standLowerLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.stand_name)+getString(R.string.Standingononeleg));
                urlViewModel.setSuggestion(getString(R.string.StandingononelegSuggestion));
                //寬高設定100%
                //側
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/iueNYd3_m0E?si=yRBHA98RlQCKie6U\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
                //正
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/DSj_aDakA0g?si=LxFVQ6-PXxZkgq_G\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");

            }
        });

        //腳跟腳尖直線移動
        binding.HeeltotoemovinginastraightlineLLstandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_standLowerLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.stand_name)+getString(R.string.Heeltotoemovinginastraightline));
                urlViewModel.setSuggestion(getString(R.string.HeeltotoemovinginastraightlineSuggestion));
                //寬高設定100%
                //側
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Tkv8sfQ_UcI?si=HCze9i2zEk7Hgn2Q\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
                //正
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/MlZ6S6hMCk4?si=5hVC96DY4vr23yNH\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");

            }
        });

        //扶椅弓箭步
        binding.ChairLungeLLstandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_standLowerLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.stand_name)+getString(R.string.ChairLunge));
                urlViewModel.setSuggestion(getString(R.string.ChairLungeSuggestion));
                //寬高設定100%
                //側
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/a9OxFPBMqd0?si=6PfBMDFRHZfpOgmA\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
                //正
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/t_qTAi-85tE?si=tzktPZ-xnuAH7YcZ\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");

            }
        });


        //微深蹲
        binding.miniSquatLLstandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_standLowerLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.stand_name)+getString(R.string.mini_Squat));
                urlViewModel.setSuggestion(getString(R.string.mini_SquatSuggestion));
                //寬高設定100%
                //側
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Btv1wzKmqBE?si=lIjficWthRm324OX\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
                //正
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/YeC0CVvdP-Q?si=GFCUYkBAzlu-Nhy-\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");

            }
        });

        //小腿拉伸
        binding.CalfStretchLLstandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_standLowerLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.stand_name)+getString(R.string.CalfStretch));
                urlViewModel.setSuggestion(getString(R.string.CalfStretchSuggestion));
                //寬高設定100%
                //側
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/3U5BKojkWQM?si=pxxCni2ARoq49yA1\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
                //正
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/RnZDVxuVl2M?si=Z4_-xG55JbLh7XqK\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");

            }
        });

        //單腳前後左右點地
        binding.TouchthegroundleftandrightLLstandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);

                //頁面切換到videoFragment
                controller.navigate(R.id.action_standLowerLimbFragment_to_videoFragment);
                //設置說明
                urlViewModel.setTitle(getString(R.string.stand_name)+getString(R.string.Touchthegroundleftandright));
                urlViewModel.setSuggestion(getString(R.string.TouchthegroundleftandrightSuggestion));
                //寬高設定100%
                //側
                urlViewModel.setUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/U8Rq-K5Kq-Q?si=qSrpW5iEDcElteKG\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");
                //正
                urlViewModel.setUrl2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/SwszzHmGUyU?si=dU7nrgWoI5_9Uog5\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");

            }
        });


        return binding.getRoot();
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_stand_lower_limb, container, false);
    }
}