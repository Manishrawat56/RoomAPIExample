package com.vdishub.roomapiexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vdishub.roomapiexample.R;
import com.vdishub.roomapiexample.room.entity.Employee;

import java.util.List;

/**
 * Created by vdishub.
 * Date: 28/8/18
 * Time: 11:05 AM
 *
 * @author Manish rawat
 */
public class EmployeeListAdapter  extends RecyclerView.Adapter<EmployeeListAdapter.EmployeeViewHolder> {

    /**
     * The type Employee view holder.
     */
    class EmployeeViewHolder extends RecyclerView.ViewHolder {
        /**
         * The Id view.
         */
        TextView idView;
        /**
         * The Name view.
         */
        TextView nameView;
        /**
         * The Age view.
         */
        TextView ageView;

        private EmployeeViewHolder(View itemView) {
            super(itemView);
            idView = itemView.findViewById(R.id.emp_id);
            nameView = itemView.findViewById(R.id.emp_name);
            ageView = itemView.findViewById(R.id.emp_age);
        }
    }

    private final LayoutInflater mInflater;
    private List<Employee> mEmployees; // Cached copy of Employee

    /**
     * Instantiates a new Employee list adapter.
     *
     * @param context the context
     */
    public EmployeeListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new EmployeeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder holder, int position) {
        if (mEmployees != null) {
            Employee current = mEmployees.get(position);
            holder.idView.setText(""+current.getId());
            holder.nameView.setText(current.getName());
            holder.ageView.setText(""+current.getAge());

        } else {
            // Covers the case of data not being ready yet.
            holder.nameView.setText("No Employee");
        }
    }

    /**
     * Set employees.
     *
     * @param employees the employees
     */
    public void setEmployees(List<Employee> employees){
        mEmployees = employees;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mEmployees != null)
            return mEmployees.size();
        else return 0;
    }
}
