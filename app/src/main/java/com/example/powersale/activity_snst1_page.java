package com.example.powersale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class activity_snst1_page extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snst1_page);

        Button sharebtn = findViewById(R.id.sharebtn);
        Button location_btn = findViewById(R.id.location_btn);
        Button more_details_btn = findViewById(R.id.more_details_btn);
        Button bid_btn = findViewById(R.id.bid_btn);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("bid_place","bid place notification",
                    NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        bid_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(findViewById(android.R.id.content), "Place Bid on this product?",Snackbar.LENGTH_INDEFINITE)
                        .setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE)
                        .setBackgroundTint(Color.BLACK)
                        .setAction("Confirm", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(activity_snst1_page.this, "Bid has been Placed!", Toast.LENGTH_SHORT).show();

                                NotificationCompat.Builder builder = new NotificationCompat.Builder(activity_snst1_page.this,"bid_place");
                                builder.setContentTitle("Bid Placed!");
                                builder.setContentText("Hurrah a new Bid has been Placed. Congrats and Good Luck!");
                                builder.setSmallIcon(R.drawable.iconimage);
                                builder.setAutoCancel(true);

                                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(activity_snst1_page.this);
                                managerCompat.notify(2, builder.build());

                            }
                        })
                        .setActionTextColor(Color.WHITE)
                        .show();
            }
        });
        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"+"johns.baby@mca.christuniversity.in"));
                i.putExtra(Intent.EXTRA_SUBJECT, "Contact");
                i.putExtra(Intent.EXTRA_TEXT, "Hello");
                try{
                    startActivity(i);
                }
                catch(ActivityNotFoundException e){

                }
            }
        });

        location_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/d/viewer?hl=en&ie=UTF8&msa=0&ll=53.463066%2C-2.291336000000004&spn=0.035773%2C0.072956&z=13&source=embed&mid=118mI_eAQvlFruldjAAmVT2aw0f8"));
                try{
                    startActivity(i);
                }
                catch(ActivityNotFoundException e){
                }
            }
        });

        more_details_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity_snst1_page.this, moredetails_webview.class);
                try{
                    startActivity(i);
                }
                catch(ActivityNotFoundException e){
                }
            }
        });
    }

    //********************************* Menus *****************************
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.snst1_menu,menu);
        return true;
    }
}
