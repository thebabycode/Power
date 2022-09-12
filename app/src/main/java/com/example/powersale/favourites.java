package com.example.powersale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class favourites extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        tabLayout.setupWithViewPager(viewPager);

        vpadapter Vpadapter = new vpadapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        Vpadapter.adddfragment(new fragment_oil(), "Oil");
        Vpadapter.adddfragment(new fragment_snst(), "Sunset");
        Vpadapter.adddfragment(new fragment_digital(), "Digital");
        Vpadapter.adddfragment(new fragment_canvas(), "Canvas");
        viewPager.setAdapter(Vpadapter);
    }
}
