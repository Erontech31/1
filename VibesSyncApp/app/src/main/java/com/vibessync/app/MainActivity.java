package com.vibessync.app;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        
        // Configurações essenciais para rodar aplicações web modernas
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        webSettings.setAllowFileAccess(true);

        webView.setWebViewClient(new WebViewClient());
        
        // Opção A: Carregar o arquivo HTML local salvo na pasta assets
        webView.loadUrl("file:///android_asset/index.html");
        
        // Opção B: Se preferir carregar direto de um link hospedado (ex: Vercel/Netlify)
        // webView.loadUrl("https://seu-link-hospedado.com");
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}