package com.edu.wzu.app;

import android.Manifest;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.edu.wzu.app.databinding.FragmentGradeSystemBinding;

import java.util.List;

public class GradeSystemFragment extends Fragment {
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 100;
    private static final int STORAGE_PERMISSION_REQUEST_CODE = 101;
    private static final int CAMERA_REQUEST_CODE = 102;
    private static final String TAG = "GradeSystemFragment";
    private Uri imageUri;
    private UrlViewModel urlViewModel;
    private FragmentGradeSystemBinding binding;

    public GradeSystemFragment() {
        // Required empty public constructor
    }

    public static GradeSystemFragment newInstance(String param1, String param2) {
        GradeSystemFragment fragment = new GradeSystemFragment();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String mParam1 = getArguments().getString("param1");
            String mParam2 = getArguments().getString("param2");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        urlViewModel = new ViewModelProvider(this).get(UrlViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_grade_system, container, false);
        binding.setData(urlViewModel);
        binding.setLifecycleOwner(this);

        View view = binding.getRoot();

        ImageButton imageButton = view.findViewById(R.id.CameraButton);
        Button deleteAllBtn = view.findViewById(R.id.DeleteAllButton);
        ImageView imageView = view.findViewById(R.id.imageView);
        // 點擊拍照按鈕時檢查權限並打開相機
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermissionsAndOpenCamera();
            }
        });
        // 點擊刪除所有圖片按鈕時彈出確認對話框
        deleteAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAllImagesFromDatabase();
            }
        });
        // 觀察 imageUris 的變化，更新 UI 上的圖片顯示
        urlViewModel.getImageUris().observe(getViewLifecycleOwner(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> uris) {
                if (!uris.isEmpty()) {
                    String lastUri = uris.get(uris.size() - 1);
                    imageView.setImageURI(Uri.parse(lastUri));
                } else {
                    imageView.setImageURI(null);
                }
            }
        });

        return view;
    }
    // 檢查權限並打開相機
    private void checkPermissionsAndOpenCamera() {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.CAMERA},
                    CAMERA_PERMISSION_REQUEST_CODE);
        } else if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    STORAGE_PERMISSION_REQUEST_CODE);
        } else {
            openCamera();
        }
    }

    private void openCamera() {
        try {
            ContentValues values = new ContentValues();
            values.put(MediaStore.Images.Media.TITLE, "My Picture");
            values.put(MediaStore.Images.Media.DESCRIPTION, "Taken with my camera");
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
            // 將圖片 URI 插入到系統媒體庫
            imageUri = getContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            Log.d(TAG, "Image URI: " + imageUri);
            // 啟動相機應用，拍照並將結果保存到指定 UR
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, CAMERA_REQUEST_CODE);
            } else {
                Log.e(TAG, "No camera app available");
            }
        } catch (Exception e) {
            Log.e(TAG, "Error opening camera", e);
        }
    }
    // 相機拍照完成後的處理，將 URI 存儲到 SQLite 數據庫
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult called with requestCode: " + requestCode + " and resultCode: " + resultCode);
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == getActivity().RESULT_OK) {
            try {
                if (imageUri != null) {
                    urlViewModel.insertUri(imageUri.toString(), "image");
                    urlViewModel.setMessage("照片已存儲，URI：" + imageUri.toString());
                } else {
                    Log.e(TAG, "Image URI is null");
                }
            } catch (Exception e) {
                Log.e(TAG, "Error storing image", e);
            }
        } else {
            if (imageUri != null) {
                getContext().getContentResolver().delete(imageUri, null, null);
                Log.d(TAG, "Image capture cancelled, deleted URI: " + imageUri);
            }
        }
    }
    // 處理權限請求的結果
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d(TAG, "onRequestPermissionsResult called with requestCode: " + requestCode);
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "Camera permission granted");
                checkPermissionsAndOpenCamera();
            } else {
                Log.e(TAG, "Camera permission denied");
            }
        } else if (requestCode == STORAGE_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "Storage permission granted");
                checkPermissionsAndOpenCamera();
            } else {
                Log.e(TAG, "Storage permission denied");
            }
        }
    }
    // 彈出確認對話框並刪除所有圖片
    private void deleteAllImagesFromDatabase() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("確認刪除");
        builder.setMessage("確定要刪除所有圖片嗎？");
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                urlViewModel.deleteAllUris();
                urlViewModel.setMessage("All images deleted");
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
