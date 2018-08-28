package com.vdishub.roomapiexample.room.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.os.AsyncTask;

import com.vdishub.roomapiexample.room.dao.EmployeeDao;
import com.vdishub.roomapiexample.room.db.AppDatabase;
import com.vdishub.roomapiexample.room.entity.Employee;

import java.util.List;

/**
 * Created by vdishub.
 * Date: 28/8/18
 * Time: 10:33 AM
 *
 * @author Manish rawat
 */
public class EmployeeRepository {
    private EmployeeDao employeeDao;
    private LiveData<List<Employee>> mAllEmployees;
    public EmployeeRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        employeeDao = db.employeeDao();
        mAllEmployees = employeeDao.getAllEmployees();

    }
    public LiveData<List<Employee>> getAllEmployees() {
        return mAllEmployees;
    }
    public void insert (Employee employee) {
        new insertAsyncTask(employeeDao).execute(employee);
    }

    private static class insertAsyncTask extends AsyncTask<Employee, Void, Void> {

        private EmployeeDao mAsyncTaskDao;

        insertAsyncTask(EmployeeDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Employee... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
