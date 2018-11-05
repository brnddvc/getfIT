package ba.unsa.pmf.berinadedovic.getfit;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ba.unsa.pmf.berinadedovic.getfit.Adapter.RecyclerViewAdapter;
import ba.unsa.pmf.berinadedovic.getfit.Model.Exercise;

public class ExercisesActivity extends AppCompatActivity {

    List<Exercise> mExerciseList = new ArrayList<>();
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView mRecyclerView;
    RecyclerViewAdapter mRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.listExercies);
        mRecyclerViewAdapter = new RecyclerViewAdapter(mExerciseList, getBaseContext());
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

    private void initData(){
        mExerciseList.add(new Exercise(R.drawable.osma, this.getString(R.string.running)));
        mExerciseList.add(new Exercise(R.drawable.cetvrta, this.getString(R.string.skipping_rope)));
        mExerciseList.add(new Exercise(R.drawable.petnaesta, this.getString(R.string.cardio_step)));
        mExerciseList.add(new Exercise(R.drawable.deseta, this.getString(R.string.squat)));
        mExerciseList.add(new Exercise(R.drawable.dvadesetjedan, this.getString(R.string.squat_with_kettlebell)));
        mExerciseList.add(new Exercise(R.drawable.druga, this.getString(R.string.squat_with_weights)));
        mExerciseList.add(new Exercise(R.drawable.jedanaesta, this.getString(R.string.weightlifting)));
        mExerciseList.add(new Exercise(R.drawable.dvadeset, this.getString(R.string.forward_lunge)));
        mExerciseList.add(new Exercise(R.drawable.peta, this.getString(R.string.forward_lunge_with_dumbbell)));
        mExerciseList.add(new Exercise(R.drawable.dvanaesta, this.getString(R.string.forward_lunge_with_dumbbell_press)));
        mExerciseList.add(new Exercise(R.drawable.deveta, this.getString(R.string.pushing_tire)));
        mExerciseList.add(new Exercise(R.drawable.treca, this.getString(R.string.push_up)));
        mExerciseList.add(new Exercise(R.drawable.sesnaesta, this.getString(R.string.sit_up)));
        mExerciseList.add(new Exercise(R.drawable.sedma, this.getString(R.string.crunches)));
        mExerciseList.add(new Exercise(R.drawable.sesta, this.getString(R.string.plank)));
        mExerciseList.add(new Exercise(R.drawable.osamnaest, this.getString(R.string.side_plank)));
        mExerciseList.add(new Exercise(R.drawable.devetnaest, this.getString(R.string.donkey_kick)));
        mExerciseList.add(new Exercise(R.drawable.sedamnaesta, this.getString(R.string.mountain_climbers)));
        mExerciseList.add(new Exercise(R.drawable.cetrnaesta, this.getString(R.string.bird_dog_on_gym_ball)));
        mExerciseList.add(new Exercise(R.drawable.trinaesta, this.getString(R.string.chest_press_on_gym_ball)));
    }
}