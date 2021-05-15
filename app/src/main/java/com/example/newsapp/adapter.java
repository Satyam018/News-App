package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.viewholder> {
    private static final String TAG ="adapter" ;
    ArrayList<setdata> s1;
    Context context;
    adapter(ArrayList<setdata>s1,Context context){
        this.s1=s1;

        this.context=context;
        Log.e(TAG, "adapter: "+context );
    }


    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final setdata sj=s1.get(position);
        holder.tx1.setText(s1.get(position).getHeading());
        Log.e(TAG, "onBindViewHolder: "+s1.get(position).getHeading() );
        String imgurl=s1.get(position).getIm();
        Glide.with(context).load(imgurl).into(holder.img);

        Log.e(TAG, "onBindViewHolder: "+imgurl );

        String infourl=s1.get(position).getArticlelink();
        holder.tx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(infourl));
                context.startActivity(i);

            }
        });



    }



    @Override
    public int getItemCount() {
        return s1.size();

    }

    class viewholder extends RecyclerView.ViewHolder{
        TextView tx1;
        ImageView img;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            tx1=itemView.findViewById(R.id.textview);
            img=itemView.findViewById(R.id.imageview);
        }
    }
}
