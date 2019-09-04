package com.example.uiwidgettest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
//                获取输入框的内容并用Toast显示
//                String text = editText.getText().toString();
//                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();

//                更新图片
//                imageView.setImageResource(R.drawable.image_2);

//                进度条显示和隐藏来回切换
//                if (progressBar.getVisibility()==View.GONE)
//                {
//                    progressBar.setVisibility(View.VISIBLE);
//                }else {
//                    progressBar.setVisibility(View.GONE);
//                }

//                动态更新进度条进度
//                int progress = progressBar.getProgress();
//                progress=progress+10;
//                progressBar.setProgress(progress);

//                AlertDialog的学习
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is Title");
                dialog.setMessage("This is Message");
//                可否用Back键关闭对话框
                dialog.setCancelable(false);
//                设置确定按钮的点击事件
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
//                设置取消按钮的点击事件
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
//                将对话框显示出来
                dialog.show();
                break;
            default:
                break;
        }
    }
}
