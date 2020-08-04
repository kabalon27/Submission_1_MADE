package com.example.submissionmade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies = new ArrayList<>();

    public MovieAdapter(Context context) {
        this.context = context;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int m) {
        return movies.get(m);
    }

    @Override
    public long getItemId(int m) {
        return m;
    }

    @Override
    public View getView(int m, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        Movie movie = (Movie) getItem(m);
        viewHolder.bind(movie);
        return itemView;
    }

    private class ViewHolder{
        private ImageView imgPoster;
        private TextView txtTitle, txtRelease, txtScore, txtDescription;

        ViewHolder(View view){
            imgPoster = view.findViewById(R.id.img_poster);
            txtTitle = view.findViewById(R.id.txt_title);
            txtRelease = view.findViewById(R.id.txt_release);
            txtScore = view.findViewById(R.id.txt_score);
            txtDescription = view.findViewById(R.id.txt_description);
        }

        void bind(Movie movie){
            imgPoster.setImageResource(movie.getPoster());
            txtTitle.setText(movie.getTitle());
            txtRelease.setText(movie.getReleaase());
            txtScore.setText(movie.getScore());
            txtDescription.setText(movie.getDescription());
        }
    }
}
