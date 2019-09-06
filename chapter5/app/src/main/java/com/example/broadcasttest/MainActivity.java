package com.example.broadcasttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentFilter = new IntentFilter();
//        广播接收器要监听什么广播，就在这里添加相应的action
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver= new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        动态注册的广播接收器一定要取消注册才行
        unregisterReceiver(networkChangeReceiver);
    }

    class NetworkChangeReceiver extends BroadcastReceiver {
//        每当网络状态发生变化时，onReceive都会得到执行
        @Override
        public void onReceive(Context context, Intent intent) {
//         Toast.makeText(context,"network is change",Toast.LENGTH_SHORT).show();
//            ConnectivityManager是一个系统服务类，专门用于管理网络连接
            ConnectivityManager connectivityManager=
                    (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo!=null&&networkInfo.isAvailable())
            {
                Toast.makeText(context,"有网络",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context,"没网络",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
