package com.example.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    private TextView title,genre_tv,time_tv,rating_tv,desc_tv,price_tv;

    private ImageView imageView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);

        title = findViewById(R.id.title);
        genre_tv = findViewById(R.id.genre_tv);
        time_tv = findViewById(R.id.time_tv);
        rating_tv = findViewById(R.id.rating_tv);
        desc_tv = findViewById(R.id.desc_tv);
        price_tv = findViewById(R.id.price_tv);
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);


        Intent intent = getIntent();
        String titleText = intent.getStringExtra("title");
        String img = intent.getStringExtra("image");
        String descriptionText = intent.getStringExtra("description");
        String priceText = intent.getStringExtra("price");
        String ratingText = intent.getStringExtra("rating");
        String timeText = intent.getStringExtra("time");
        String genreText = intent.getStringExtra("genre");

        title.setText(titleText);
        desc_tv.setText(descriptionText);
        price_tv.setText(priceText+"$");
        rating_tv.setText(ratingText);
        time_tv.setText(timeText);
        genre_tv.setText(genreText);

        Picasso.get().load(img).into(imageView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailsActivity.this, "An invitation has been sent to your email", Toast.LENGTH_SHORT).show();
            }
        });




    }
}