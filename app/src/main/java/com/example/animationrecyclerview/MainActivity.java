package com.example.animationrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NewsAdapter adapter;
    List<NewsItem> mData;
    ConstraintLayout rootLayout;

    FloatingActionButton fabSwitcher;
    boolean isDarck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        fabSwitcher = findViewById(R.id.fab_switcher);
        rootLayout = findViewById(R.id.root_layout);

        recyclerView = findViewById(R.id.news_rv);
        mData = new ArrayList<>();


        //load theme state
        isDarck = getThemeStatePref();
        if (isDarck) {
            rootLayout.setBackgroundColor(getResources().getColor(R.color.black));
        } else {
            rootLayout.setBackgroundColor(getResources().getColor(R.color.white));
        }

        mData.add(new NewsItem("LOL", "dd", "7/01/2020", R.drawable.ic_launcher_background));
        mData.add(new NewsItem("LOL", "dd", "7/01/2020", R.drawable.ic_launcher_background));
        mData.add(new NewsItem("LOL", "dd", "7/01/2020", R.drawable.ic_launcher_background));
        mData.add(new NewsItem("LOL", "dd", "7/01/2020", R.drawable.ic_launcher_background));
        mData.add(new NewsItem("LOL", "dd", "7/01/2020", R.drawable.ic_launcher_background));
        mData.add(new NewsItem("LOL", "dd", "7/01/2020", R.drawable.ic_launcher_background));
        mData.add(new NewsItem("LOL", "dd", "7/01/2020", R.drawable.ic_launcher_background));
        mData.add(new NewsItem("LOL", "dd", "7/01/2020", R.drawable.ic_launcher_background));
        mData.add(new NewsItem("LOL", "dd", "7/01/2020", R.drawable.ic_launcher_background));
        mData.add(new NewsItem("LOL", "dd", "7/01/2020", R.drawable.ic_launcher_background));
        mData.add(new NewsItem("LOL", "dd", "7/01/2020", R.drawable.ic_launcher_background));
        mData.add(new NewsItem("LOL", "dd", "7/01/2020", R.drawable.ic_launcher_background));
        mData.add(new NewsItem("LOL", "dd", "7/01/2020", R.drawable.ic_launcher_background));
        mData.add(new NewsItem("LOL", "dd", "7/01/2020", R.drawable.ic_launcher_background));
        mData.add(new NewsItem("LOL", "dd", "7/01/2020", R.drawable.ic_launcher_background));
        mData.add(new NewsItem("LOL", "dd", "7/01/2020", R.drawable.ic_launcher_background));
        mData.add(new NewsItem("LOL", "dd", "7/01/2020", R.drawable.ic_launcher_background));
        mData.add(new NewsItem("LOL", "dd", "7/01/2020", R.drawable.ic_launcher_background));

        adapter = new NewsAdapter(this, mData, isDarck);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fabSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isDarck = !isDarck;
                if (isDarck) {
                    rootLayout.setBackgroundColor(getResources().getColor(R.color.black));
                } else {
                    rootLayout.setBackgroundColor(getResources().getColor(R.color.white));
                }
                adapter = new NewsAdapter(MainActivity.this, mData, isDarck);
                recyclerView.setAdapter(adapter);
                saveThemeStatePref(isDarck);
//                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

            }
        });
    }

    private void saveThemeStatePref(boolean isDarck) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isDark", isDarck);
        editor.commit();
    }

    private boolean getThemeStatePref() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref", MODE_PRIVATE);
        boolean isDark = pref.getBoolean("isDark", false);
        return isDark;
    }
}
