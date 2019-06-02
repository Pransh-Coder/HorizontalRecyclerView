package com.example.horizontalrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {            //<Type of adapter>

    private static final String TAG ="RecyclerViewAdapter";

    //vars
    private ArrayList<String> mnames= new ArrayList<>();
    private ArrayList<String> mage=new ArrayList<>();
    private ArrayList<String> mImageUrls=new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context context,ArrayList<String> mnames, ArrayList<String> mage, ArrayList<String> mImageUrls) {
        this.mnames = mnames;
        this.mage = mage;
        this.mImageUrls = mImageUrls;
        this.mContext = context;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{                        // inside it we will put the widgets that are in each individual layout
        ImageView image;
        TextView name ,age;

        public ViewHolder(@NonNull View itemView) {                     //constructor of viewHolder class
            super(itemView);
            image=itemView.findViewById(R.id.image_view);               //inside viewHolder we are going to assign id's
            name=itemView.findViewById(R.id.name);
            age=itemView.findViewById(R.id.age);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);         // This will going to inflate each individual layout
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {                           // bind the data to each of individual listitem
        Log.d(TAG, "onCreateViewHolder:called.");                                              // onBindViewHolder-where all data and widgets are going to be attached to each individual listitem

        Glide.with(mContext).asBitmap().load(mImageUrls.get(position)).into(holder.image);

        holder.name.setText(mnames.get(position));
        holder.age.setText(mage.get(position));
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick:clicked on the image: " + mnames.get(position));

                Toast.makeText(mContext,mnames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mnames.size();
    }

    /*before extending our RecyclerViewAdapter we have to create
     viewHolder class so view holder class inside our adapter
     will hold these widgets in memory.

     Recycler view works by , saves the individual list items
     in memory and will only show the ones which are visible to user
      */


}
