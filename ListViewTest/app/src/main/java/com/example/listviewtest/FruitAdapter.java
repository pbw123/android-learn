package com.example.listviewtest;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;

    public FruitAdapter(@NonNull Context context, int resource, @NonNull List<Fruit> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }

    /**
     * 每个子项滚动到屏幕内的时候getView()都会被调用
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        获取当前项的Fruit实例
        Fruit fruit = getItem(position);
//        加载我们传入的布局
        View view;
        ViewHolder viewHolder;
//        convertView是将我们加载好的布局进行缓存
        if (convertView==null)
        {
             view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
             viewHolder=new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.fruit_image);
            viewHolder.textView = view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);
        }else {
            view=convertView;
             viewHolder =(ViewHolder) view.getTag();
        }
        viewHolder.imageView.setImageResource(fruit.getImageId());
        viewHolder.textView.setText(fruit.getName());
//        获取ImageView实例
//        ImageView fruitImage = view.findViewById(R.id.fruit_image);
////        获取TextView实例
//        TextView fruitName = view.findViewById(R.id.fruit_name);
////        为ImageView设置要显示的图片
//        fruitImage.setImageResource(fruit.getImageId());
////        为TextView设置要显示的名字
//        fruitName.setText(fruit.getName());
//        将布局返回
        return view;
    }
//    定义内部类
    class  ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
