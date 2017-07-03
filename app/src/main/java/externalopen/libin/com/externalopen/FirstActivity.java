package externalopen.libin.com.externalopen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {
    private static final String TAG = FirstActivity.class.getSimpleName().toString();
    private TextView tv_first_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        tv_first_info = (TextView) findViewById(R.id.tv_first_info);

        // 显示获取到的信息
        tv_first_info.setText(getIntent().getStringExtra(ProcessActivity.INFOMATION));
    }
}
