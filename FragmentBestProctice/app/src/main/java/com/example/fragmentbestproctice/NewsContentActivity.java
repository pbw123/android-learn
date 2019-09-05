package com.example.fragmentbestproctice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class NewsContentActivity extends AppCompatActivity {

    public static void actionStart(Context context, String newsTitle,String newsContent)
    {
        Intent intent = new Intent(context,NewsContentActivity.class);
        intent.putExtra("news_item", newsTitle);
        intent.putExtra("news_content", newsContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);
        String newsTitle = getIntent().getStringExtra("news_item");
        String newsContent = getIntent().getStringExtra("news_content");
        NewsContentFragment newsContentFragment=(NewsContentFragment)getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
//        刷新NewsContentFragment的界面
        newsContentFragment.refresh(newsTitle,newsContent);

    }
}
