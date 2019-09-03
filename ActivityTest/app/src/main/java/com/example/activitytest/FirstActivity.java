package com.example.activitytest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        调用setContentView()来给当前活动加载一个布局，方法中一般会传入一个布局文件的id
        setContentView(R.layout.activity_first);
//        通过findViewById()获取到布局文件中定义的元素，返回View对象；
//        这里要向下转型成Button对象，得到按钮实例
        Button button1 = (Button) findViewById(R.id.button_1);
//        为按钮注册一个监听器
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                在活动中使用Toast
//                通过静态方法makeText创建出一个Toast对象，然后调用show()方法将Toast显示出来
//                makeText()有三个参数，第一个参数是Context(上下文,这里活动本身就是一个Context对象，所以传入FirstActivity.this)
//                第二个参数是Toast显示的文本内容，
//                第三个参数是Toast显示的时长，有两个内置常量可以选择Toast.LENGTH_SHORT和 Toast.LENGTH_LONG
//                Toast.makeText(FirstActivity.this, "You clicked Button", Toast.LENGTH_SHORT).show();

//                销毁一个活动
//                finish();

//                使用显式Intent在活动之间穿梭
//                Intent的这个构造函数接收两个参数，
//                第一个参数：要求提供一个启动活动的上下文
//                第二个参数：指定想要启动的目标活动
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);

//                使用隐式Intent
//                使用另一个Intent构造函数，直接将actionf的字符串传入
//                表明我们们想要启动能够响应com.example.activitytest.ACTION_START这个ation的活动
//                Intent intent = new Intent("com.example.activitytest.ACTION_START");
//                每个Intent只能指定一个action,但却可以指定多个category,现在来指定第二个(第一个是默认category)
//                intent.addCategory("com.example.activitytest.MY_CATEGORY");
//                startActivity()专门用于启动活动的，它接收一个Intent参数

//                更多隐式Intent的用法
//                调用系统的浏览器打开网页
//                这里指定了Intent的action是Intent.ACTION_VIEW,这是Android系统的内置动作
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));
//                调用系统的拨号界面
//                Intent.ACTION_DIAL也是Android系统的内置动作
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));

//               向下一个活动传递数据
//                String data="Hello SecondActivity";
//                putExtra()方法有两个参数，第一参数是键，第二参数是值
//                intent.putExtra("extra_data",data);
//                startActivity(intent);
                startActivityForResult(intent,1);
            }
        });
    }

    /**
     * 在活动中使用Menu，重写onCreateOptionsMenu（)方法
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        通过getMenuInflater()方法来得到MenuInflater对象，再调用该对象中的inflate()方法就可以给该活动创建菜单了
//        inflate接收两个参数，第一个参数指定我们通过哪一个资源文件来创建菜单
//        第二个参数用于指定我们的菜单项添加到哪一个Menu对象当中，这里直接使用传入的menu参数
        getMenuInflater().inflate(R.menu.main, menu);
//        参加true,表示允许创建的菜单显示出来，若为false则无法显示
        return true;
    }

    /**
     *定义菜单的响应事件，重写 onOptionsItemSelected()方法
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode)
        {
            case  1:
                if(resultCode== RESULT_OK)
                {
                    String returnedData = data.getStringExtra("data_result");
                    Log.i("FirstActivity", returnedData);
                }
                break;
                default:
        }
    }
}
