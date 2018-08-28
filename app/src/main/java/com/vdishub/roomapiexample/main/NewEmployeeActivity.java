package com.vdishub.roomapiexample.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.vdishub.roomapiexample.R;
import com.vdishub.roomapiexample.room.entity.Employee;

public class NewEmployeeActivity extends AppCompatActivity {
    public static final String EXTRA_EMP_NAME = "emp_name";
    public static final String EXTRA_EMP_ID = "emp_id";
    public static final String EXTRA_EMP_AGE = "emp_age";

    private EditText mEditIdView,empNameView,empAgeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_employee);
        mEditIdView = findViewById(R.id.edit_id);
        empNameView = findViewById(R.id.edit_name);
        empAgeView = findViewById(R.id.edit_age);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditIdView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    int age=Integer.parseInt(empAgeView.getText().toString());
                    replyIntent.putExtra(EXTRA_EMP_ID, mEditIdView.getText().toString());
                    replyIntent.putExtra(EXTRA_EMP_NAME, empNameView.getText().toString());
                    replyIntent.putExtra(EXTRA_EMP_AGE, empAgeView.getText().toString());
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });

    }
}
