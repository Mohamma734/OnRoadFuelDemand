package com.example.onroadfueldemand;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button user, admin, bunk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.user);
        admin = findViewById(R.id.admin);
        bunk = findViewById(R.id.bunk);

        user.setOnClickListener(v -> openLogin("user"));
        admin.setOnClickListener(v -> openLogin("admin"));
        bunk.setOnClickListener(v -> openLogin("bunk"));
    }

    private void openLogin(String userType) {
        Intent intent = new Intent(this, Login.class);
        intent.putExtra("key", userType);
        startActivity(intent);
    }

    // إظهار القائمة (الثلاث نقاط)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // التعامل مع النقر على عنصر القائمة
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_about_company) {
            Intent intent = new Intent(this, AboutCompanyActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
