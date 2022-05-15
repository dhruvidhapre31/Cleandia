package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cleandia.R;
import java.util.ArrayList;
import models.PostModel;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.viewHolder> {
    ArrayList<PostModel> list ;
    Context context;

    public PostAdapter(ArrayList<PostModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.sample_post, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final PostModel model = list.get(position);
        holder.post_image.setImageResource(model.getPostImage());
        holder.user_name.setText(model.getUserName());
        holder.time.setText(model.getTime());
        holder.address.setText(model.getAddress());
        holder.cases.setText(model.getCases());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView post_image;
        TextView user_name , time , address, cases ;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            post_image = itemView.findViewById(R.id.postImage);
            user_name = itemView.findViewById(R.id.userName);
            time = itemView.findViewById(R.id.time);
            address = itemView.findViewById(R.id.address);
            cases = itemView.findViewById(R.id.cases);
        }
    }
}

