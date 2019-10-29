package com.example.projectfinden.com.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.projectfinden.R;
import com.example.projectfinden.com.fragment.FragmentChoiceEducate;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuFragment extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private BottomNavigationView bottomNavigationView;
    private int mMenuId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        FragmentManager fragmentManager = getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentChoiceEducate fragmentChoiceEducate= new FragmentChoiceEducate();
        fragmentTransaction.add(R.id.frameLayoutMenu, fragmentChoiceEducate);
        fragmentTransaction.commit();
        bottomNavigationView.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) this);
        bottomNavigationView.getMenu().findItem(R.id.action_study).setChecked(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mMenuId = item.getItemId();
        for (int i = 0; i < bottomNavigationView.getMenu().size(); i++) {
            MenuItem menuItem = bottomNavigationView.getMenu().getItem(i);
            boolean isChecked = menuItem.getItemId() == item.getItemId();
            menuItem.setChecked(isChecked);
        }

        switch (item.getItemId()) {
            case R.id.action_guide: {
            }
            break;
            case R.id.action_study: {
                FragmentManager fragmentManager = getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentChoiceEducate fragmentChoiceEducate= new FragmentChoiceEducate();
                fragmentTransaction.add(R.id.frameLayoutMenu, fragmentChoiceEducate);
                fragmentTransaction.commit();
            }
            break;
            case R.id.action_115: {
            }
            break;
            case R.id.action_person: {
            }
            break;
            case R.id.action_about: {
            }
            break;
        }
        return true;
    }
}
