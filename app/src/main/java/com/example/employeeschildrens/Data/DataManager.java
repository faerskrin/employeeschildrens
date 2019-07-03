package com.example.employeeschildrens.Data;


import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private List<Employees> mEmployees = new ArrayList<>();
    private List<Childrens> mChild = new ArrayList<>();

    public List<Employees> getmEmployees() {
        return mEmployees;
    }

    public void addEmployees(Employees employees) {
        mEmployees.add(employees);
    }

    public void setChild(int position, List<Childrens> child) {
        Employees employees = mEmployees.get(position);
        if (employees.getChildrens() == null) {
            employees.setChildrens(child);
        } else {
            mChild.addAll(employees.getChildrens());
            mChild.addAll(child);
            employees.setChildrens(mChild);

        }

    }
}
