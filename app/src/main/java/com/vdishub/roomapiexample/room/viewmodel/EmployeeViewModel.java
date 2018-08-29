package com.vdishub.roomapiexample.room.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.vdishub.roomapiexample.room.entity.Employee;
import com.vdishub.roomapiexample.room.repository.EmployeeRepository;

import java.util.List;

/**
 * Created by vdishub.
 * Date: 28/8/18
 * Time: 10:45 AM
 *
 * @author Manish rawat
 */
public class EmployeeViewModel extends AndroidViewModel{
    private EmployeeRepository mRepository;
    private LiveData<List<Employee>> mAllEmployees;

    /**
     * Instantiates a new Employee view model.
     *
     * @param application the application
     */
    public EmployeeViewModel(@NonNull Application application) {
        super(application);
        mRepository = new EmployeeRepository(application);
        mAllEmployees = mRepository.getAllEmployees();
    }

    /**
     * Gets all employees.
     *
     * @return the all employees
     */
    public LiveData<List<Employee>> getmAllEmployees() { return mAllEmployees; }

    /**
     * Insert.
     *
     * @param employee the employee
     */
    public void insert(Employee employee) {
        mRepository.insert(employee);
    }
}
