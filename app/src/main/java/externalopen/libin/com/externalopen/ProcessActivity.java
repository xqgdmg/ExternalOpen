package externalopen.libin.com.externalopen;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * 负责分发跳转的activity
 */
public class ProcessActivity extends AppCompatActivity {
    private static final String TAG = ProcessActivity.class.getSimpleName().toString();
    public static final String FIRST = "/first";
    public static final String SECOND = "/second";
    public static final String THIRD = "/third";
    public static final String HOME = "/home";
    public static final String URI = "uri";
    public static final String ISSHOWSPLASH = "isShowSplash";
    public static final String INFOMATION = "infomation";

    private ImageView iv_bg;

    String path;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);

        iv_bg = (ImageView) findViewById(R.id.iv_bg);

        try {
            distribute();
        } catch (Exception e) {
            Log.e(TAG, "分发异常");
        }

    }

    private void distribute() {
        uri = getIntent().getData();
        if (uri != null) {

            //url部分
            Log.e(TAG, "uri -----> " + uri);

            // scheme部分
            String scheme = uri.getScheme();
            Log.e(TAG, "scheme -----> " + scheme);

            // host部分
            String host = uri.getHost();
            Log.e(TAG, "host -----> " + host);

            // 访问路劲
            path = uri.getPath();
            Log.e(TAG, "path -----> " + path);

            // Query部分
            String query = uri.getQuery();
            Log.e(TAG, "query -----> " + query);

            //获取指定参数值
            String isShowSplash = uri.getQueryParameter(ISSHOWSPLASH);
            Log.e(TAG, "isShowSplash -----> " + isShowSplash);

            String infomation = uri.getQueryParameter(INFOMATION);
            Log.e(TAG, "infomation -----> " + infomation);

            //===============================以上为log信息方便理解==============================>


            if (path != null && !path.isEmpty()) {

                /**
                 *  是否展示欢迎页面
                 *  很多情况下从外部开启APP需要展示广告或者欢迎页面，这里模拟下一欢迎页
                 */
                if (isShowSplash.equals("true")) {
                    iv_bg.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            iv_bg.setVisibility(View.INVISIBLE);
                            controlActivity(path, uri);
                            finish();
                        }
                    },2000);
                }else {
                    controlActivity(path, uri);
                    finish();
                }

            }

        } else {
            finish();
        }
    }

    /**
     * 根据Path确定开启哪个Activity
     * @param path
     * @param uri
     */
    private void controlActivity(String path, Uri uri) {

        if (path.equals(FIRST)) {
            Intent intent = new Intent(this, FirstActivity.class);
            intent.putExtra(INFOMATION, uri.getQueryParameter(INFOMATION));
            startActivity(intent);
        } else if (path.equals(SECOND)) {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(INFOMATION, uri.getQueryParameter(INFOMATION));
            intent.putExtra(URI, uri);
            startActivity(intent);
        } else if (path.equals(THIRD)) {
            Intent intent = new Intent(this, ThirdActivity.class);
            intent.putExtra(INFOMATION, uri.getQueryParameter(INFOMATION));
            intent.putExtra(URI, uri);
            startActivity(intent);
        }else if (path.equals(HOME)) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(INFOMATION, uri.getQueryParameter(INFOMATION));
            intent.putExtra(URI, uri);
            startActivity(intent);
        }

    }

}
