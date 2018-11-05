package ba.unsa.pmf.berinadedovic.getfit.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

import ba.unsa.pmf.berinadedovic.getfit.ExercisesView;
import ba.unsa.pmf.berinadedovic.getfit.Interface.ItemClickListener;
import ba.unsa.pmf.berinadedovic.getfit.Model.Exercise;
import ba.unsa.pmf.berinadedovic.getfit.R;

class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public ImageView mImageView;
    public TextView mTextView;
    private ItemClickListener mItemClickListener;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        mImageView = (ImageView) itemView.findViewById(R.id.exerciseImage);
        mTextView = (TextView) itemView.findViewById(R.id.exerciseName);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view){
        mItemClickListener.onClick(view, getAdapterPosition());
    }
}

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

    private List<Exercise> mExerciseList;
    private Context mContext;

    public RecyclerViewAdapter(List<Exercise> exerciseList, Context context) {
        mExerciseList = exerciseList;
        mContext = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_exercise, parent, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( RecyclerViewHolder holder, int position) {
        holder.mImageView.setImageResource(mExerciseList.get(position).getImage_id());
        holder.mTextView.setText(mExerciseList.get(position).getName());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {

                //pozivanje nove aktivnosti
                Intent intent = new Intent(mContext, ExercisesView.class);
                intent.putExtra("image_id",mExerciseList.get(position).getImage_id());
                intent.putExtra("name",mExerciseList.get(position).getName());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mExerciseList.size();
    }
}
