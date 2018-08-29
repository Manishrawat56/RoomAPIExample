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
    /**
     * The Id.
     */
    @PrimaryKey
    @NonNull
    public int id;
    /**
     * The Name.
     */
    @ColumnInfo(name = "emp_name")
    public String name;
    /**
     * The Age.
     */
    @ColumnInfo(name = "emp_age")
    public int age;

    /**
     * Instantiates a new Employee.
     *
     * @param id   the id
     * @param name the name
     * @param age  the age
     */
    public Employee(int id,String name, int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    @NonNull
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(@NonNull int id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(int age) {
        this.age = age;
    }
}
