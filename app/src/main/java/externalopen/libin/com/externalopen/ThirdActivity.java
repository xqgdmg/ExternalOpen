package externalopen.libin.com.externalopen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    private TextView tv_third_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tv_third_info = (TextView) findViewById(R.id.tv_third_info);

        tv_third_info.setText(getIntent().getStringExtra(ProcessActivity.INFOMATION));

    }
}
