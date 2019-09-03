package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
//        可以通过getIntent()获取到用于启动SecondActivity活动的Intent
//        Intent intent = getIntent();
//        String extra_data = intent.getStringExtra("extra_data");
//        Log.d("SecondActivity","++++++"+extra_data);
        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("data_result", "Hello FirstActivity");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
