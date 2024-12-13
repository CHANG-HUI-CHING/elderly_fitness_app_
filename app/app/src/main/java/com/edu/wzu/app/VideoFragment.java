package com.edu.wzu.app;

import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.MediaController;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import com.edu.wzu.app.databinding.FragmentVideoBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public VideoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VideoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VideoFragment newInstance(String param1, String param2) {
        VideoFragment fragment = new VideoFragment();
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

        mediaController = new MediaController(getActivity());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        if (getView() != null) {
//            UrlViewModel urlViewModel;
//            urlViewModel = new ViewModelProvider(getActivity()).get(UrlViewModel.class);
//            FragmentVideoBinding binding;
//            binding = DataBindingUtil.inflate(inflater,R.layout.fragment_video,container,false);
//            binding.setData(urlViewModel);
//            binding.setLifecycleOwner(getActivity());
//            VideoView videoView = getView().findViewById(R.id.videoView);
//            videoView.setVideoPath(urlViewModel.getUrl());
//            videoView.start();
//            return binding.getRoot();
//        } else {
//            Log.d("VideoFragment", "onCreateView: getView() is null");
//            return null;
//        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video, container, false);
    }
    private  MediaController mediaController;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        UrlViewModel urlViewModel = new ViewModelProvider(getActivity()).get(UrlViewModel.class);
        FragmentVideoBinding binding = DataBindingUtil.bind(view);
        binding.setData(urlViewModel);
        binding.setLifecycleOwner(getActivity());

        WebView webView = view.findViewById(R.id.webView);
        webView.loadData(urlViewModel.getUrl(),"text/html","utf-8");

        WebView webView2 = view.findViewById(R.id.webView2);
        webView2.loadData(urlViewModel.getUrl2(),"text/html","utf-8");
        //說明
        TextView Suggestion;
        Suggestion = view.findViewById(R.id.suggestion_textView);
        Suggestion.setText(urlViewModel.getSuggestion());
        //標題
        TextView TitleView;
        TitleView = view.findViewById(R.id.titleView);
        TitleView.setText(urlViewModel.getTitle());

        //videoView.setVideoPath(urlViewModel.getUrl());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());


        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.setWebChromeClient(new WebChromeClient());
       // Uri uri = Uri.parse(urlViewModel.getUrl());

        binding.gradingSystemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);

                //頁面切換
                controller.navigate(R.id.action_videoFragment_to_gradeSystemFragment);
            }
        });



    }

}