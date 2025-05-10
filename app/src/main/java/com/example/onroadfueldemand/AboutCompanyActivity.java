package com.example.onroadfueldemand;
public class AboutCompanyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_company);

        // إعداد زر العودة
        setupActionBar();

        // تهيئة الروابط والأزرار
        setupSocialLinks();
        setupCallButton();
        setupDownloadButton();
    }

    private void setupActionBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("عن الشركة");
        }
    }

    private void setupSocialLinks() {
        // الفيسبوك
        TextView facebook = findViewById(R.id.tv_facebook);
        facebook.setOnClickListener(v -> openUrl("https://www.facebook.com/profile.php?id=61561480315484"));

        // تويتر (تحديد الرابط عند إضافته)
        TextView twitter = findViewById(R.id.tv_twitter);
        twitter.setOnClickListener(v -> openUrl("https://twitter.com/YourTwitterLink"));

        // يوتيوب (تحديد الرابط عند إضافته)
        TextView youtube = findViewById(R.id.tv_youtube);
        youtube.setOnClickListener(v -> openUrl("https://youtube.com/YourYouTubeChannel"));
    }

    private void setupCallButton() {
        Button callButton = findViewById(R.id.btn_call);
        callButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:734953951"));
            startActivity(intent);
        });
    }

    private void setupDownloadButton() {
        Button downloadButton = findViewById(R.id.tv_download);
        downloadButton.setOnClickListener(v -> openUrl("https://example.com/download-brochure"));
    }

    private void openUrl(String url) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "التطبيق المطلوب غير مثبت!", Toast.LENGTH_SHORT).show();
        }
    }

    // التعامل مع زر العودة
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // إضافة انتقالات عند العودة
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
