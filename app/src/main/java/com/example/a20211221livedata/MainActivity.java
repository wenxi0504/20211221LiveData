package com.example.a20211221livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ViewModelWithLiveData viewModelWithLiveData;
    TextView textView;
    ImageView imageButtonLike, imageButtonDislike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButtonLike= findViewById(R.id.imageView);
        imageButtonDislike=findViewById(R.id.imageView2);
        // lifecycle owner: this(activity)
        viewModelWithLiveData= new ViewModelProvider(this).get(ViewModelWithLiveData.class);
       viewModelWithLiveData.getLikedNumber().observe(this, new Observer<Integer>() {
           @Override
           public void onChanged(Integer integer) {
               textView.setText(String.valueOf(integer));
           }
       });
       imageButtonLike.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               viewModelWithLiveData.addLikedNumber(1);
           }
       });

        imageButtonDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelWithLiveData.addLikedNumber(-1);
            }
        });
    }
}