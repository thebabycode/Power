package com.example.powersale;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView t =(TextView) findViewById(R.id.gdmrnname);
        Intent i=getIntent();
        String str=i.getStringExtra("msg");
        t.setText(str);

        addListenerOnButton();
        // for context menu
        registerForContextMenu(findViewById(R.id.snst1_btn));
    }

    public void addListenerOnButton() {
        Button sunsetmainpage_btn = findViewById(R.id.sunsetmainpage_btn);
        ImageButton snst1_btn = findViewById(R.id.snst1_btn);
        FloatingActionButton profile_btn = findViewById(R.id.profile_btn);
        FloatingActionButton reviewpage_btn = findViewById(R.id.reviewpage_btn);

        profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, profilepage.class);
                startActivity(i);
            }
        });

        reviewpage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, reviewpage.class);
                startActivity(i);
            }
        });

        sunsetmainpage_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this, activity_sunset_mainpage.class);
                startActivity(i);
            }
        });

        snst1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, activity_snst1_page.class);
                startActivity(i);
            }
        });
    }

    //********************************* Menus *****************************
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.logout:
                onBackPressed();
                break;

            case R.id.favourites:
                Intent fav = new Intent(MainActivity2.this, favourites.class);
                startActivity(fav);
                break;

            case R.id.about:
                Intent abt = new Intent(MainActivity2.this, about.class);
                startActivity(abt);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //********************************* Context Menus *****************************


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_home_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.addtofavourites:
                return true;

            case R.id.shareviamail:
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"+"johns.baby@mca.christuniversity.in"));
                i.putExtra(Intent.EXTRA_SUBJECT, "Contact");
                i.putExtra(Intent.EXTRA_TEXT, "Hello");
                startActivity(i);
                return true;

            case R.id.shareviawhatsapp:
                return true;
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }

    //********************************* Alert dialog box *****************************
    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this, R.style.AlertDialogStyle);
        builder.setMessage("Do you want to Exit?");

        // Set Alert Title
        builder.setTitle("");
        builder.setCancelable(false);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                finish();
            }
        });

        // Set the Negative button with No name OnClickListener method is use of DialogInterface interface.
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.cancel();
            }
        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
