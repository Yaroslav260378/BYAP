package com.KimYunho.bookyourapartment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ApartmentInfo extends AppCompatActivity {

    ImageView ap_image;
    TextView tv_ap_title;

    String title, status;
    int myImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment_info);

        ap_image = findViewById(R.id.ap_image);
        tv_ap_title = findViewById(R.id.tv_ap_title);

        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("title") && getIntent().hasExtra("status") &&
        getIntent().hasExtra("ap_image")){
            title = getIntent().getStringExtra("title");
            myImage = getIntent().getIntExtra("ap_image", 1);
        } else {
            Toast.makeText(this, "There is not data.", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        ap_image.setImageResource(myImage);
        tv_ap_title.setText(title);
    }
}