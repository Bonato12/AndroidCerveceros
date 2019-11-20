package com.Sebastian.ClubCervezero.view.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.Sebastian.ClubCervezero.MapsActivity;
import com.Sebastian.ClubCervezero.R;

public class PictureDetailActivity extends AppCompatActivity {

    private TextView detalle, likes, icon;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extra1 = getIntent().getExtras();
        String titulo = extra1.getString("titulo");
        String likesCard = extra1.getString("likes");
        final Double latitud = extra1.getDouble("latitud");
        final Double longitud = extra1.getDouble("longitud");


        setContentView(R.layout.activity_picture_detail);
        detalle = (TextView) findViewById(R.id.userNameDetail);
        detalle.setText(titulo);
        likes = (TextView) findViewById(R.id.secondWordDetail);
        likes.setText(likesCard);
        imageView = (ImageView) findViewById(R.id.imageHeader);
        //imageView.setImageResource(R.drawable.image_drakkar);
        imageView.setImageResource(R.drawable.image_7c);


        detalle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(PictureDetailActivity.this, MapsActivity.class);
                intent.putExtra("latitud", latitud);
                intent.putExtra("longitud",longitud);
                startActivity(intent);
            }
        });


    }
}

