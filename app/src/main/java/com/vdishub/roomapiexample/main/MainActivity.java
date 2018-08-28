package com.vdishub.roomapiexample.main;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.vdishub.roomapiexample.R;
import com.vdishub.roomapiexample.adapter.EmployeeListAdapter;
import com.vdishub.roomapiexample.room.entity.Employee;
import com.vdishub.roomapiexample.room.viewmodel.EmployeeViewModel;

import java.util.List;

/**
 *
 */
public class MainActivity extends AppCompatActivity {
    /**
     * The constant NEW_EMPLOYEE_ACTIVITY_REQUEST_CODE.
     */
    public static final int NEW_EMPLOYEE_ACTIVITY_REQUEST_CODE=1;
    private EmployeeViewModel mEmployeeViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewEmployeeActivity.class);
                startActivityForResult(intent, NEW_EMPLOYEE_ACTIVITY_REQUEST_CODE);
            }
        });

        mEmployeeViewModel = ViewModelProviders.of(this).get(EmployeeViewModel.class);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        final EmployeeListAdapter adapter = new EmployeeListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mEmployeeViewModel.getmAllEmployees().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(@Nullable final List<Employee> employees) {
                // Update the cached copy of the words in the adapter.
                adapter.setEmployees(employees);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_EMPLOYEE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            int id= Integer.parseInt(data.getStringExtra(NewEmployeeActivity.EXTRA_EMP_ID));
            String name=data.getStringExtra(NewEmployeeActivity.EXTRA_EMP_NAME);
            int age= Integer.parseInt(data.getStringExtra(NewEmployeeActivity.EXTRA_EMP_AGE));
            Employee employee =new Employee(id,name,age);

            mEmployeeViewModel.insert(employee);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}
