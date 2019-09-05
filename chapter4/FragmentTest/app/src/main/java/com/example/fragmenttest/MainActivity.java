package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        replaceFragment(new RightFragment());
    }

    private void replaceFragment(Fragment fragment) {
//        通过getSupportFragmentManager()获取FragmentManager实例
        FragmentManager fragmentManager = getSupportFragmentManager();
//        开启一个事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        替换碎片
        transaction.replace(R.id.right_layout, fragment);
//        提交事务
        transaction.commit();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                replaceFragment(new AnotherRightFragment());
                break;
            default:
                break;
        }
    }
}
