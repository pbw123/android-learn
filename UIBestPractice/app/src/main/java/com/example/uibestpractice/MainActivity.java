package com.example.uibestpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg>msgList=new ArrayList<>();
    private EditText inputText;
    private Button button;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;

    private void initMsgs()
    {
        Msg msg1 = new Msg("How are you", Msg.TYPE_RECIEVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("I am fine, thank you!", Msg.TYPE_SEND);
        msgList.add(msg2);
        Msg msg3 = new Msg("See you tomorrow.", Msg.TYPE_RECIEVED);
        msgList.add(msg3);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        初始化消息数据
        initMsgs();
//        获取输入框
        inputText=findViewById(R.id.input_text);
//        获取按钮
        button = findViewById(R.id.button);
//        获取消息界面
        msgRecyclerView=findViewById(R.id.msg_recycler_view);
//         创建适配器
        final MsgAdapter adapter = new MsgAdapter(msgList);
//        创建线性布局管理器
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
//        给RecyclerView设置布局
        msgRecyclerView.setLayoutManager(linearLayout);
//        给RecyclerView设置适配器
        msgRecyclerView.setAdapter(adapter);
//        给按钮添加点击事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputText.getText().toString();
                if(!"".equals(content))
                {
                    Msg msg = new Msg(content, Msg.TYPE_SEND);
                    msgList.add(msg);
//                    有新消息时，刷新给RecyclerView中的显示
                    adapter.notifyItemInserted(msgList.size()-1);
//                    将给RecyclerView定位到最后一行
                    msgRecyclerView.scrollToPosition(msgList.size()-1);
//                    清空输入框的内容
                    inputText.setText("");
                }
            }
        });
    }
}
