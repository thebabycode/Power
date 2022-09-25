package com.example.powersale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class reviewpage extends AppCompatActivity {

    Button rate_btn;
    Button submit_btn;
    RatingBar ratingStars;
    float rateResult =0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviewpage);

        rate_btn = findViewById(R.id.ratingbutton);
        ratingStars = findViewById(R.id.ratingbar);
        submit_btn = findViewById(R.id.submitbutton);

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

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("review notification","review notification",
                    NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(reviewpage.this,"review notification");
                builder.setContentTitle("Review Submitted");
                builder.setContentText("Thank you for the response, we have recieved your Review!");
                builder.setSmallIcon(R.drawable.iconimage);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(reviewpage.this);
                managerCompat.notify(1, builder.build());
            }
        });
    }
}
