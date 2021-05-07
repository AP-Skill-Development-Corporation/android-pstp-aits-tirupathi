package com.example.prohelpr.workers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prohelpr.R;
import com.example.prohelpr.users.UserHomeFragment;

import java.util.ArrayList;
import java.util.List;

public class WorkerDetailsViewAdaper extends RecyclerView.Adapter<WorkerDetailsViewAdaper.WorkerDetailsViewHolder> {
    List<WorkersPojoModel> models;
    Context ctx;

    public WorkerDetailsViewAdaper(List<WorkersPojoModel> models, Context ctx) {
        this.models = models;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public WorkerDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WorkerDetailsViewHolder(LayoutInflater.from(ctx).inflate(R.layout.workers_details_view_row, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull WorkerDetailsViewHolder holder, int position) {
        holder.obj_tv_workeraddress.setText(models.get(position).getWorker_address());
        holder.obj_tv_workerName.setText(models.get(position).getWorker_name());
        holder.obj_tv_workerNumber.setText(models.get(position).getWorker_number());
        holder.obj_tv_workerNumberPincode.setText(models.get(position).getWorker_postalCode());
        holder.obj_tv_availbility.setText(models.get(position).getWorker_avalbiltyStatus());
        holder.obj_tv_workerMail.setText(models.get(position).getWorker_mail());
        holder.obj_tv_worker_place.setText(models.get(position).getWorker_plase());
        holder.obj_tv_workerChatogory.setText(models.get(position).getWorker_chargeOfWork());
        holder.obj_tv_Charge.setText(models.get(position).getWorker_chargeOfWork());
        holder.obj_tv_workerRole.setText(models.get(position).getWorker_role());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    /*<!--  String worker_role;
        String worker_name;
        String worker_number;
        String worker_mail;
        String worker_address;
        String worker_plase;
        String worker_catergory;
        String worker_postalCode;
        String worker_chargeOfWork;
        String worker_avalbiltyStatus;-->*/
    public class WorkerDetailsViewHolder extends RecyclerView.ViewHolder {
        TextView obj_tv_workerName, obj_tv_workerNumber, obj_tv_availbility,
                obj_tv_workerChatogory,
                obj_tv_Charge, obj_tv_workerNumberPincode, obj_tv_workerRole,
                obj_tv_worker_place, obj_tv_workerMail, obj_tv_workeraddress;

        public WorkerDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            obj_tv_availbility = itemView.findViewById(R.id.tv_avilablity);
            obj_tv_workerName = itemView.findViewById(R.id.tv_workerName);
            obj_tv_workerNumber = itemView.findViewById(R.id.tv_workerNumber);
            obj_tv_workerChatogory = itemView.findViewById(R.id.tv_category);
            obj_tv_Charge = itemView.findViewById(R.id.tv_chargeOfWork);
            obj_tv_workerNumberPincode = itemView.findViewById(R.id.tv_workerPostalCode);
            obj_tv_worker_place = itemView.findViewById(R.id.tv_place);
            obj_tv_workerMail = itemView.findViewById(R.id.tv_workerMail);
            obj_tv_workerRole = itemView.findViewById(R.id.tv_workerRole);
            obj_tv_workeraddress = itemView.findViewById(R.id.tv_address);
        }
    }
}
