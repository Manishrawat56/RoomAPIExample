package com.vdishub.roomapiexample.room.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.vdishub.roomapiexample.room.entity.Employee;

import java.util.List;

/**
 * Created by vdishub.
 * Date: 28/8/18
 * Time: 10:20 AM
 *
 * @author Manish rawat
 */
@Dao
public interface EmployeeDao {
    /**
     * Insert.
     *
     * @param employee the employee
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Employee employee);

    /**
     * Delete all.
     */
    @Query("DELETE FROM emp_table")
    void deleteAll();

    /**
     * Gets all employees.
     *
     * @return the all employees
     */
    @Query("SELECT * from emp_table ORDER BY id ASC")
    LiveData<List<Employee>> getAllEmployees();
}
