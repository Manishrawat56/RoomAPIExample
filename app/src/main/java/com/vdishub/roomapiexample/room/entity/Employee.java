package com.vdishub.roomapiexample.room.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by vdishub.
 * Date: 28/8/18
 * Time: 10:14 AM
 *
 * @author Manish rawat
 */
@Entity(tableName = "emp_table")
public class Employee {
    @PrimaryKey
    @NonNull
    public int id;
    @ColumnInfo(name = "emp_name")
    public String name;
    @ColumnInfo(name = "emp_age")
    public int age;

    public Employee(int id,String name, int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
