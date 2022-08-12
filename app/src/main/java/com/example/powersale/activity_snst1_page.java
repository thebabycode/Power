package com.example.powersale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_snst1_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snst1_page);

        Button sharebtn = findViewById(R.id.sharebtn);
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
        Button location_btn = findViewById(R.id.location_btn);
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
    }
}
