package com.example.movieapp;

import static android.content.ContentValues.TAG;

import static com.example.movieapp.R.id.recyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private List<String> mData = new ArrayList<>();

    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recyclerView);
        imageButton = findViewById(R.id.imageButton);

        if(FirebaseAuth.getInstance().getCurrentUser() == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });


        // Отримання посилання на Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference filmsRef = database.getReference("data");

        // Створення адаптера та призначення його RecyclerView
        List<Film> filmList = new ArrayList<>();
        FilmAdapter adapter = new FilmAdapter(this, filmList);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);

        // Додавання слухача для отримання даних з Firebase
        filmsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                filmList.clear();
                for (DataSnapshot filmSnapshot : dataSnapshot.getChildren()) {
                    Film film = filmSnapshot.getValue(Film.class);
                    filmList.add(film);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Обробка помилок
            }
        });




    }
}