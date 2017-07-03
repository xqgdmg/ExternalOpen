package externalopen.libin.com.externalopen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView tv_second_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv_second_info = (TextView) findViewById(R.id.tv_second_info);

        tv_second_info.setText(getIntent().getStringExtra(ProcessActivity.INFOMATION));
    }
}
