package io.github.pengrad.uw_ussd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View mViewHome;
    private View mViewSettings;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewHome = findViewById(R.id.layoutHome);
        mViewSettings = findViewById(R.id.layoutSettings);

        mEditText = (EditText) findViewById(R.id.editTextLog);

        findViewById(R.id.buttonHome).setOnClickListener(this);
        findViewById(R.id.buttonSettings).setOnClickListener(this);
        findViewById(R.id.buttonStartApp).setOnClickListener(this);
        findViewById(R.id.buttonStopApp).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonHome) {
            mViewSettings.setVisibility(View.GONE);
            mViewHome.setVisibility(View.VISIBLE);
        } else if (v.getId() == R.id.buttonSettings) {
            mViewHome.setVisibility(View.GONE);
            mViewSettings.setVisibility(View.VISIBLE);
        } else if (v.getId() == R.id.buttonStartApp) {
            addString("Start application...");
        } else if (v.getId() == R.id.buttonStopApp) {
            addString("Stop application...");
        }
    }


    private List<String> text = new ArrayList<>(4);

    private void addString(String s) {
        if (mEditText.getLineCount() >= 4) {
            text.remove(0);
            String res = "";
            for (String string : text) {
                res += string + "\n";
            }
            mEditText.setText(res + s);
        } else {
            mEditText.setText(mEditText.getText() + "\n" + s);
        }
        text.add(s);
    }
}
