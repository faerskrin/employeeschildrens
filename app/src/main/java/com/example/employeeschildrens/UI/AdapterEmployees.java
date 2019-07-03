package com.example.employeeschildrens.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeeschildrens.Data.Employees;
import com.example.employeeschildrens.R;

import java.util.List;

public class AdapterEmployees extends RecyclerView.Adapter<AdapterEmployees.GroupViewHolder> {
    private List<Employees> mEmployees;
    private OnitemClick onitemClick;

    public void setmEmployees(List<Employees> mEmployees) {
        this.mEmployees = mEmployees;
        notifyDataSetChanged();
    }

    public void setOnitemClick(OnitemClick onitemClick) {
        this.onitemClick = onitemClick;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_empl, parent, false);
        return new GroupViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull GroupViewHolder holder, int position) {
        holder.mName.setText(mEmployees.get(position).getName());
        holder.mLastName.setText(mEmployees.get(position).getLastname());
        holder.mMidlleName.setText(mEmployees.get(position).getMiddlename());
        holder.mBirthday.setText(mEmployees.get(position).getBirthday());
        holder.mPosition.setText(mEmployees.get(position).getPosition());
        if (mEmployees.get(position).getChildrens()!=null) {
            holder.mChildrensName.setVisibility(View.VISIBLE);
            holder.mChildrens.setVisibility(View.VISIBLE);
            holder.mChildrens.setText(" " + mEmployees.get(position).getChildrens().size());
        }
        else {
            holder.mChildrens.setVisibility(View.GONE);
            holder.mChildrensName.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mEmployees.size();
    }

    public void refresh() {
        notifyDataSetChanged();
    }

    public class GroupViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mName = itemView.findViewById(R.id.rv_name_emp);
        TextView mLastName = itemView.findViewById(R.id.rv_lastname_emp);
        TextView mMidlleName = itemView.findViewById(R.id.rv_middlename_emp);
        TextView mBirthday = itemView.findViewById(R.id.rv_birthday_emp);
        TextView mPosition = itemView.findViewById(R.id.rv_position_emp);
        TextView mChildrens = itemView.findViewById(R.id.rv_childrens);
        TextView mChildrensName = itemView.findViewById(R.id.rv_childrens_name);


        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onitemClick.addChild(getAdapterPosition());
        }
    }

    interface OnitemClick{
        void addChild (int position);
    }
}
