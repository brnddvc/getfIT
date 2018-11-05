package ba.unsa.pmf.berinadedovic.getfit;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    RadioGroup mRadioGroup;
    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(R.id.easyButton == checkedId){
                    ExercisesView.time = 30000;
                }
                else if(R.id.mediumButton == checkedId){
                    ExercisesView.time = 45000;
                }
                else{
                    ExercisesView.time = 60000;
                }
            }
        });
    }

    public void play(View view){
        if(mMediaPlayer == null){
            mMediaPlayer = MediaPlayer.create(this, R.raw.song1);
        }
        mMediaPlayer.start();
    }

}
