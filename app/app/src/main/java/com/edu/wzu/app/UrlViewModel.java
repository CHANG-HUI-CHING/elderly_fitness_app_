package com.edu.wzu.app;

import android.app.Application;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.AndroidViewModel;
import java.util.ArrayList;
import java.util.List;

public class UrlViewModel extends AndroidViewModel {
    private  String Url="";String Url2="";
    private  String Suggestion = "";
    private  String Title="";
    public String getUrl()
    {
        if(Url.equals(""))
        {
            Url = "No data" ;
        }
        return Url;
    }
    public String getUrl2()
    {
        if(Url2.equals(""))
        {
            Url2 = "No data" ;
        }
        return Url2;
    }
    public void setUrl(String newUrl) {
        Url = newUrl;
    }
    public void setUrl2(String newUrl) {
        Url2 = newUrl;
    }
    public String getSuggestion()
    {
        if(Suggestion.equals(""))
        {
            Suggestion = "無" ;
        }
        return Suggestion;
    }
    public  void setSuggestion(String newSuggestion){Suggestion=newSuggestion;}

    public  void setTitle(String newTitle){Title = newTitle;}
    public String getTitle()
    {
        if(Title.equals(""))
        {
            Title = "無" ;
        }
        return Title;
    }
    private MyDatabaseHelper dbHelper;
    private final MutableLiveData<List<String>> imageUris = new MutableLiveData<>(new ArrayList<>());
    private final MutableLiveData<String> message = new MutableLiveData<>();



    public UrlViewModel(@NonNull Application application) {
        super(application);
        dbHelper = new MyDatabaseHelper(application, "MediaStore", null, 2);
    }

    public LiveData<List<String>> getImageUris() {
        return imageUris;
    }

    public void loadStoredUris() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("Media", new String[]{"uri"}, null, null, null, null, null);

        List<String> uris = new ArrayList<>();
        while (cursor.moveToNext()) {
            String uri = cursor.getString(cursor.getColumnIndexOrThrow("uri"));
            uris.add(uri);
        }
        cursor.close();
        imageUris.setValue(uris);
    }

    public void insertUri(String uri, String type) {
        dbHelper.insertMedia(uri, type);
        loadStoredUris();
    }

    public void deleteAllUris() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("Media", null, null);
        db.close();
        imageUris.setValue(new ArrayList<>());
    }

    public LiveData<String> getMessage() {
        return message;
    }

    public void setMessage(String msg) {
        message.setValue(msg);
    }


}
