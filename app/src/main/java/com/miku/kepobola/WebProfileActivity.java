package com.miku.kepobola;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebProfileActivity extends AppCompatActivity {

    WebView myBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_profile);

        initWebview();
    }

    private void initWebview() {
        myBrowser = findViewById(R.id.mybrowser);
        myBrowser.getSettings().setJavaScriptEnabled(true);
        myBrowser.getSettings().setBuiltInZoomControls(true);
        myBrowser.getSettings().setDisplayZoomControls(false);

        String htmlFile = getIntent().getStringExtra("htmlFile");
        myBrowser.loadUrl("file:///android_asset/" + htmlFile + ".html");
    }
}
