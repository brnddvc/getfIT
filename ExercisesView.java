package ba.unsa.pmf.berinadedovic.getfit;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ExercisesView extends AppCompatActivity {

    int mImageId;
    String mName;
    TextView mTimer, mTitle;
    ImageView mDetailImage;
    Button mStartButton;
    boolean isRunning = false;
    public static int time = 30000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_view);

        mTimer = (TextView) findViewById(R.id.timer);
        mTitle = (TextView) findViewById(R.id.title);
        mDetailImage = (ImageView) findViewById(R.id.detailImage);

        mStartButton = (Button) findViewById(R.id.startExerciseButton);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isRunning) {
                    mStartButton.setText("Done");
                    new CountDownTimer(time, 1000) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            mTimer.setText("" + millisUntilFinished / 1000);
                        }

                        @Override
                        public void onFinish() {
                            Toast.makeText(ExercisesView.this, R.string.toast, Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }.start();
                } else {
                    Toast.makeText(ExercisesView.this, R.string.toast, Toast.LENGTH_SHORT).show();
                    finish();
                }
                isRunning = !isRunning;
            }
        });


        mTimer.setText("");

        if (getIntent() != null) {
            mImageId = getIntent().getIntExtra("image_id", -1);
            mName = getIntent().getStringExtra("name");

            mDetailImage.setImageResource(mImageId);
            mTitle.setText(mName);

        }
    }
}
