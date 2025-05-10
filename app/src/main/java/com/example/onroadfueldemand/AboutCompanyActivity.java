package com.example.onroadfueldemand;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AboutCompanyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_company);

        // إعداد زر العودة
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("عن الشركة");
        }

        // تعريف العناصر
        TextView facebook = findViewById(R.id.tv_facebook);
        TextView twitter = findViewById(R.id.tv_twitter);
        TextView youtube = findViewById(R.id.tv_youtube);
        Button btnCall = findViewById(R.id.btn_call);
        Button btnDownload = findViewById(R.id.tv_download);

        // أحداث النقر
        facebook.setOnClickListener(v -> openUrl("https://www.facebook.com/profile.php?id=61561480315484"));
        twitter.setOnClickListener(v -> openUrl("https://twitter.com/YourTwitterLink"));
        youtube.setOnClickListener(v -> openUrl("https://youtube.com/YourYouTubeChannel"));
        btnCall.setOnClickListener(v -> dialPhoneNumber());
        btnDownload.setOnClickListener(v -> openUrl("https://example.com/download-brochure"));
    }

    private void dialPhoneNumber() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:734953951"));
        startActivity(intent);
    }

    private void openUrl(String url) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "التطبيق المطلوب غير مثبت!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
