package com.example.movieapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {
    private Context mContext;
    private List<Film> mFilmList;

    public FilmAdapter(Context context, List<Film> filmList) {
        mContext = context;
        mFilmList = filmList;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler, parent, false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        Film film = mFilmList.get(position);
        holder.bind(film);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(),DetailsActivity.class);
            intent.putExtra("title", film.getTitle());
            intent.putExtra("image", film.getImage());
            intent.putExtra("description", film.getDescription());
            intent.putExtra("price", film.getPrice());
            intent.putExtra("rating", film.getRating());
            intent.putExtra("time", film.getTime());
            intent.putExtra("genre", film.getGenre());
            v.getContext().startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return mFilmList.size();
    }

    public class FilmViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageView;
        private TextView title;

        public FilmViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.title);
            itemView.setOnClickListener(this);
        }

        public void bind(Film film) {
            Picasso.get().load(film.getImage()).into(imageView);
            title.setText(film.getTitle());
        }

        @Override
        public void onClick(View v) {
            // обробник кліку на елемент RecyclerView
        }
    }
}

