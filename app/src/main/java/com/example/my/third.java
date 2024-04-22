package com.example.my;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.net.URISyntaxException;

public class third extends AppCompatActivity {

    private WebView webView;
    private ProgressBar progressBar1;
    private TextView urlTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Ánh xạ WebView
        webView = findViewById(R.id.web_search_2);

        // Ánh xạ TextView
        urlTextView = findViewById(R.id.url_out);
        progressBar1 = findViewById(R.id.progress_bar_4);

        webView.setWebViewClient(new MyWebViewClient());

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                progressBar1.setProgress(newProgress);
            }
        });

        // Lấy URL từ Intent và cập nhật lên TextView
        String url = getIntent().getStringExtra("URL");
        if (url != null) {
            urlTextView.setText(url);
            webView.loadUrl(url);
        }
    }

    class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            String url = request.getUrl().toString();
            if (url.startsWith("intent://")) {
                try {
                    Intent intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
                    if (intent != null) {
                        startActivity(intent);
                        return true; // Đã xử lý URL, không cần WebView xử lý nữa
                    }
                } catch (URISyntaxException | ActivityNotFoundException e) {
                    e.printStackTrace();
                }
            }
            return false; // Để WebView xử lý URL bình thường
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar1.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar1.setVisibility(View.INVISIBLE);
        }
    }
    public void imageClicked_3(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        String url = "https://example.com";
        intent.putExtra("URL", url);
        startActivity(intent);
    }
}
