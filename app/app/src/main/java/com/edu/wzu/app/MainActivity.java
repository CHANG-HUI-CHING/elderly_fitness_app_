package com.edu.wzu.app;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import android.util.Log;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.fragment.app.FragmentTransaction;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button homeButton = findViewById(R.id.HomeButton);
        Button standButton = findViewById(R.id.StandButton);
        Button sitButton = findViewById(R.id.SitButton);
        Button gradeButton = findViewById(R.id.grading_system_button);
//        Button SitMyocardialGroupBtn=findViewById(R.id.shoulder_blade_circles_MGsit_button);//坐姿-心肌-肩胛轉圈
//        SitMyocardialGroupBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Bundle bundle = new Bundle();
//                bundle.putString("video_url", "YOUR_VIDEO_URL_HERE");
//                bundle.putString("description", "YOUR_DESCRIPTION_HERE");
//                VideoFragment videoFragment = new VideoFragment();
//                videoFragment.setArguments(bundle);
//
//
//            }
//        });
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 導航到首頁分頁
                Log.d("ViewInfo", "View: " + view.toString());
                // 获取NavController
                NavController navController = Navigation.findNavController(MainActivity.this, R.id.fragmentContainerView);

                // 导航到首页分页
                navController.navigate(R.id.homeFragment);
            }
        });

        standButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 導航到站姿分頁
                NavController navController = Navigation.findNavController(MainActivity.this, R.id.fragmentContainerView);
                navController.navigate(R.id.standFragment);
            }
        });

        sitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 導航到坐姿分頁
                NavController navController = Navigation.findNavController(MainActivity.this, R.id.fragmentContainerView);
                navController.navigate(R.id.sitFragment);
            }
        });

        gradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(MainActivity.this, R.id.fragmentContainerView);

                //頁面切換
                navController.navigate(R.id.gradeSystemFragment);
            }
        });
    }


}