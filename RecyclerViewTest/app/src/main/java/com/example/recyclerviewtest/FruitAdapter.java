package com.example.recyclerviewtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
        View fruitView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            分别获取到布局中的ImageView和TextView实例
            fruitView=itemView;
            fruitImage = itemView.findViewById(R.id.fruit_image);
            fruitName = itemView.findViewById(R.id.fruit_name);
        }
    }

    public FruitAdapter(List<Fruit> mFruitList) {
        this.mFruitList = mFruitList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        把fruit_item布局加载进来
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
//        创建ViewHolder实例，并把加载进来的fruit_item传到构造函数
       final ViewHolder holder = new ViewHolder(view);

       holder.fruitView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               int position = holder.getAdapterPosition();
               Fruit fruit = mFruitList.get(position);
               Toast.makeText(view.getContext(),"You clicked view"+fruit.getName(),Toast.LENGTH_SHORT).show();
           }
       });

       holder.fruitImage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               int position = holder.getAdapterPosition();
               Fruit fruit = mFruitList.get(position);
               Toast.makeText(view.getContext(),"You clicked Image"+fruit.getName(),Toast.LENGTH_SHORT).show();
           }
       });
//        返回ViewHolder实例
        return holder;
    }

    /**
     * onBindViewHolder()会给RecyclerView的子项数据赋值，在每一个子项滚到屏幕内会被执行
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        通过position参数得到当前项的Fruit实例
        Fruit fruit = mFruitList.get(position);
//        将fruit数据设置到ViewHolder的ImageView和TextView当中
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
//        返回数据源的长度，告诉RecyclerView共有多少子项
        return mFruitList.size();
    }
}
