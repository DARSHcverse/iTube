package com.example.itube;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class WebviewAct extends AppCompatActivity {

    WebView web_View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        web_View=findViewById(R.id.webView);

        Intent getintent=getIntent();
        String Url=getintent.getStringExtra("URLID");

        web_View.getSettings().setJavaScriptEnabled(true);

        web_View.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                view.loadUrl("javascript:player.playerVideo();");
            }
        });

        web_View.loadData(
                "<html>" +
                        "<body>" +
                        "<iframe width=\"100%\" height=\"100%\" src=\""+Url
                        + "?enablejsapi=1\" frameborder=\"0\" allowfullscreen>" +
                        "</iframe>" +
                        "</body>" +
                        "</html>",
                "text/html",
                "utf-8");
    }
}

//https://www.youtube.com/embed/Hw0Jeq42FNU
//https://www.youtube.com/embed/2rtLdF9UFqg
//https://www.youtube.com/embed/HgSStRRA0D0
//https://www.youtube.com/embed/41VZhwrXAKI?list=RDCMUCVHFbqXqoYvEWM1Ddxl0QDg