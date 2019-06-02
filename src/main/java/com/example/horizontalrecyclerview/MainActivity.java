package com.example.horizontalrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity";

    //vars
    private ArrayList<String> mnames= new ArrayList<>();
    private ArrayList<String> mage=new ArrayList<>();
    private ArrayList<String> mImageUrls=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getImages();
    }

    private void getImages() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://static-ssl.businessinsider.com/image/589dbb873149a101788b4c85-2400/undefined");
        mnames.add("Jasmine");
        mage.add("18");

        mImageUrls.add("https://femina.wwmindia.com/content/2018/jan/lead_shutterstock_140977318_in_1516880591.jpg");
        mnames.add("Kale");
        mage.add("20");

        mImageUrls.add("https://cdn.psychologytoday.com/sites/default/files/styles/article-inline-half/public/field_blog_entry_images/shutterstock_144672743.jpg?itok=SVxtA4Gd");
        mnames.add("Panama");
        mage.add("25");

        mImageUrls.add("https://ewedit.files.wordpress.com/2019/03/cagleheadshot.jpg");
        mnames.add("Roger");
        mage.add("30");


        mImageUrls.add("http://sydney.edu.au/images/content/news/2011/jul/roger_stancliffe.jpg");
        mnames.add("Mecoles");
        mage.add("50");

        mImageUrls.add("https://i2.wp.com/metro.co.uk/wp-content/uploads/2019/03/GettyImages-911518004.jpg?quality=90&strip=all&zoom=1&resize=644%2C429&ssl=1");
        mnames.add("Zain Malik");
        mage.add("20");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/8/8c/Cristiano_Ronaldo_2018.jpg");
        mnames.add("Ronalado");
        mage.add("30");

        mImageUrls.add("https://www.remove.bg/images/samples/combined/s4.jpg");
        mnames.add("Ramaez");
        mage.add("25");

        mImageUrls.add("https://images.pexels.com/photos/415829/pexels-photo-415829.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");
        mnames.add("Stewart");
        mage.add("19");

        initRecyclerView();
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView= findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(this,mnames,mage,mImageUrls);           // this the class that we have created as adapter
        recyclerView.setAdapter(adapter);
    }
}
