package app.materialsignup;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import top.wefor.circularanim.CircularAnim;

public class LoadinActivity extends AppCompatActivity {



    private TextView _status;
    private TextView _success;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadin);
        getSupportActionBar().hide();


        _status = (TextView) findViewById(R.id.status);
        _success = (TextView) findViewById(R.id.success);
        loadingTask task = new loadingTask();
        task.execute();


    }


    private class loadingTask extends AsyncTask<String, String, String> {


        ObjectAnimator animator;
        @Override
        protected void onPreExecute() {

            animator = ObjectAnimator.ofFloat(_status, View.ALPHA, 0.0f,1f);
            animator.setDuration(800);
            animator.setRepeatMode(ValueAnimator.REVERSE);
            animator.setRepeatCount(ValueAnimator.INFINITE);
            animator.setInterpolator(new LinearInterpolator());
            animator.start();
        }

        @Override
        protected String doInBackground(String... strings) {


            //You can use your on code logic here...
            for(int i = 0; i < 5; i++) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Success";
        }

        @Override
        protected void onPostExecute(String s) {



            animator.cancel();
            AnimatorSet set  = new AnimatorSet();


            ObjectAnimator status_text_end = ObjectAnimator.ofFloat(_status, View.TRANSLATION_X, 0,-50);
            status_text_end.setDuration(600);
           /* status_text.setRepeatMode(ValueAnimator.REVERSE);
            status_text.setRepeatCount(ValueAnimator.INFINITE);*/
            status_text_end.setInterpolator(new LinearInterpolator());


            ObjectAnimator status_text_fade = ObjectAnimator.ofFloat(_status, View.ALPHA, 1f,0.0f);
            status_text_fade.setDuration(600);
           /* status_text.setRepeatMode(ValueAnimator.REVERSE);
            status_text.setRepeatCount(ValueAnimator.INFINITE);*/
            status_text_fade.setInterpolator(new LinearInterpolator());

            set.playTogether(status_text_end,status_text_fade);
            set.start();



            ObjectAnimator success_animator;
            success_animator = ObjectAnimator.ofFloat(_success, View.ALPHA, 0.0f,1f);
            success_animator.setStartDelay(800);
            success_animator.setDuration(800);
            success_animator.setRepeatMode(ValueAnimator.REVERSE);
            success_animator.setRepeatCount(ValueAnimator.INFINITE);
            success_animator.setInterpolator(new LinearInterpolator());
            success_animator.start();


            new CountDownTimer(2800, 1000) {

                public void onTick(long millisUntilFinished) {

                }

                public void onFinish() {

                    CircularAnim.fullActivity(LoadinActivity.this, _success)
                            .colorOrImageRes(android.R.color.white)
                            .go(new CircularAnim.OnAnimationEndListener() {
                                @Override
                                public void onAnimationEnd() {

                                    Intent intent = new Intent(LoadinActivity.this, DashboardActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                }
            }.start();




        }
    }




}
