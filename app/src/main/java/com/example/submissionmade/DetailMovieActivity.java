package com.example.submissionmade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailMovieActivity extends AppCompatActivity {

    private TextView tvTitle, tvScore, tvRelease, tvDescription, tvCrew;
    private ImageView imgPoster;
    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        tvTitle = findViewById(R.id.txt_title);
        tvScore = findViewById(R.id.txt_score);
        tvRelease = findViewById(R.id.txt_release);
        tvCrew = findViewById(R.id.text_crew);
        tvDescription = findViewById(R.id.txt_description);
        imgPoster = findViewById(R.id.img_poster);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        String txtTitle = movie.getTitle();
        String txtRelease = movie.getReleaase();
        String txtScore = movie.getScore();
        String txtDescription = movie.getDescription();
        String txtCrew = movie.getCrew();
        int poster = movie.getPoster();

        tvTitle.setText(txtTitle);
        tvRelease.setText(txtRelease);
        tvScore.setText(txtScore);
        tvCrew.setText(txtCrew);
        tvDescription.setText(txtDescription);
        imgPoster.setImageResource(poster);
    }
}
