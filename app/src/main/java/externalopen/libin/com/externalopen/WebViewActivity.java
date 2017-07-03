package externalopen.libin.com.externalopen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {
    String ASSERTS_PATH  ="file:///android_asset/" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        WebView wv_test = (WebView) findViewById(R.id.wv_test);


        wv_test.loadUrl(ASSERTS_PATH+"index.html");
    }
}
