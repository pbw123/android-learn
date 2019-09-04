package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] data = {"张三", "李四", "王五", "赵六", "陈浮生", "陈富贵", "竹叶青", "陈龙象", "陈半仙", "王虎胜", "张三千"};

    private List<Fruit>fruitList=new ArrayList<>();

    public void initFruits()
    {
        for (int i=0;i<2;i++)
        {
            Fruit zs = new Fruit("张三", R.drawable.apple_pic);
            fruitList.add(zs);
            Fruit ls = new Fruit("李四", R.drawable.banana_pic);
            fruitList.add(ls);
            Fruit ww = new Fruit("王五", R.drawable.orange_pic);
            fruitList.add(ww);
            Fruit cl = new Fruit("赵六", R.drawable.watermelon_pic);
            fruitList.add(cl);
            Fruit cfs = new Fruit("陈浮生", R.drawable.pear_pic);
            fruitList.add(cfs);
            Fruit clx = new Fruit("陈龙象", R.drawable.grape_pic);
            fruitList.add(clx);
            Fruit cbx = new Fruit("陈半仙", R.drawable.pineapple_pic);
            fruitList.add(cbx);
            Fruit zsq = new Fruit("张三千", R.drawable.strawberry_pic);
            fruitList.add(zsq);
            Fruit cys = new Fruit("陈圆殊", R.drawable.cherry_pic);
            fruitList.add(cys);
            Fruit whs = new Fruit("王虎胜", R.drawable.mango_pic);
            fruitList.add(whs);

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                MainActivity.this, android.R.layout.simple_list_item_1, data);
//        初始化水果数据
        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fruit fruit = fruitList.get(i);
                Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
