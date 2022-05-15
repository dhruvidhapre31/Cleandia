package adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cleandia.NotificationDetail;
import com.example.cleandia.R;
import java.util.ArrayList;
import models.NotificationModel;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.viewHolder> {
    ArrayList<NotificationModel> list ;
    Context context;

    public NotificationAdapter(ArrayList<NotificationModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.sample_notification, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final NotificationModel model = list.get(position);
        holder.event_date.setText(model.getEventDate());
        holder.event_month.setText(model.getEventMonth());
        holder.event_name.setText(model.getEventName());
        holder.ngo_name.setText(model.getNgoName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NotificationDetail.class);
                intent.putExtra("ngo name", model.getNgoName());
                intent.putExtra("event name",model.getEventName());
                intent.putExtra("type",1);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView event_date, event_month, event_name, ngo_name ;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            event_date = itemView.findViewById(R.id.event_date);
            event_month = itemView.findViewById(R.id.event_month);
            event_name = itemView.findViewById(R.id.event_name);
            ngo_name = itemView.findViewById(R.id.ngo_name);
        }
    }
}

