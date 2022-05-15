package adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cleandia.InformationDetail;
import com.example.cleandia.R;
import java.util.ArrayList;
import models.InformationModel;

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.viewHolder> {
    ArrayList<InformationModel> list ;
    Context context;

    public InformationAdapter(ArrayList<InformationModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.sample_information, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final InformationModel model = list.get(position);
        holder.wasteName.setText(model.getWasteName());
        holder.wasteImage.setImageResource(model.getImageId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, InformationDetail.class);
                intent.putExtra("waste type", model.getWasteName());
                intent.putExtra("image",model.getImageId());
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
        TextView wasteName;
        ImageView wasteImage;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            wasteName = itemView.findViewById(R.id.waste_name);
            wasteImage = itemView.findViewById(R.id.waste_image);
        }
    }
}


