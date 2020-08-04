package com.example.submissionmade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MovieAdapter adapter;
    private String[] dataTitle, dataRelease, dataScore, dataDescription, dataCrew;
    private TypedArray dataPoster;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_list_movie);
        adapter = new MovieAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Movie movie = new Movie();
                movie.setPoster(dataPoster.getResourceId(i, -1));
                movie.setTitle(dataTitle[i]);
                movie.setReleaase(dataRelease[i]);
                movie.setScore(dataScore[i]);
                movie.setCrew(dataCrew[i]);
                movie.setDescription(dataDescription[i]);

                Intent detailMovieIntent = new Intent(MainActivity.this, DetailMovieActivity.class);
                detailMovieIntent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie);
                startActivity(detailMovieIntent);
            }
        });
    }

    private void prepare(){
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
        dataTitle = getResources().getStringArray(R.array.data_title_movie);
        dataRelease = getResources().getStringArray(R.array.data_release_movie);
        dataScore = getResources().getStringArray(R.array.data_score_movie);
        dataDescription = getResources().getStringArray(R.array.data_description_movie);
        dataCrew = getResources().getStringArray(R.array.data_crew_movie);
    }

    private void addItem(){
        movies = new ArrayList<>();

        for (int i = 0; i < dataTitle.length; i++){
            Movie movie = new Movie();
            movie.setPoster(dataPoster.getResourceId(i, -1));
            movie.setTitle(dataTitle[i]);
            movie.setReleaase(dataRelease[i]);
            movie.setScore("Score : "+dataScore[i]);
            movie.setDescription(dataDescription[i]);
            movie.setCrew(dataCrew[i]);
            movies.add(movie);
        }

        adapter.setMovies(movies);
    }
}
