package com.example.powersale;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class reviewpage extends AppCompatActivity {

    Button rate_btn;
    RatingBar ratingStars;
    float rateResult =0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviewpage);

        rate_btn = findViewById(R.id.ratingbutton);
        ratingStars = findViewById(R.id.ratingbar);

        ratingStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                int rating = (int) v;
                String msg = null;
                rateResult = ratingBar.getRating();

                switch (rating) {
                    case 1:
                        msg = "Sorry to hear that! :(";
                        break;
                    case 2:
                        msg = "You always accept suggestions.";
                        break;
                    case 3:
                        msg = "Good enough!";
                        break;
                    case 4:
                        msg = "Great! Thank You!";
                        break;
                    case 5:
                        msg = "Awesome! you're the best! ;)";
                        break;
                }
                Toast.makeText(reviewpage.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
        rate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(reviewpage.this, String.valueOf(rateResult), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
