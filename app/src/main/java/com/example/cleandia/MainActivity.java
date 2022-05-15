package com.example.cleandia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        fAuth = FirebaseAuth.getInstance();
        if (item.getItemId() == R.id.signOut) {
            fAuth.signOut();
            startActivity(new Intent(MainActivity.this, Login.class));
        }
        return super.onOptionsItemSelected(item);
    }

    Home homeFragment = new Home();
    Complaint complaintFragment = new Complaint();
    Notification notificationFragment = new Notification();
    Information informationFragment = new Information();

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                return true;
            case R.id.complaint:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, complaintFragment).commit();
                return true;
            case R.id.notification:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, notificationFragment).commit();
                return true;
            case R.id.information:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, informationFragment).commit();
                return true;
        }
        return false;
    }
}