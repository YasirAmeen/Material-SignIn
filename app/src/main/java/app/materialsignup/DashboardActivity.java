package app.materialsignup;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.siyamed.shapeimageview.CircularImageView;

import static android.R.attr.visible;
import static android.R.attr.y;

public class DashboardActivity extends AppCompatActivity {

    private LinearLayout _layoutOne;
    private LinearLayout _layoutTwo;
    private ImageView _dashboardImage;
    private View _view;
    TextView notification;
     CircularImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        getSupportActionBar().hide();


        _layoutTwo = (LinearLayout) findViewById(R.id.linearLayout2);
        _layoutOne = (LinearLayout) findViewById(R.id.weekda);
        _dashboardImage = (ImageView) findViewById(R.id.imageView);
        iv = (CircularImageView) findViewById(R.id.iv_dp);
        iv.setScaleY(0);
        iv.setScaleX(0);

         notification = (TextView) findViewById(R.id.textView7);
        notification.setScaleX(0);
        notification.setScaleY(0);

        _view = findViewById(R.id.view);

        Glide.with(this).load(R.drawable.dp_round).crossFade().into(iv);
        final ListView lv = (ListView) findViewById(R.id.my_list);
        lv.setAdapter(new ListAdapter(this));




        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                AnimatorSet animationSet = new AnimatorSet();

                //Translating Details_Card in Y Scale
                ObjectAnimator  _x = ObjectAnimator.ofFloat(iv, View.SCALE_X, 0,1);
                _x.setDuration(1000);
                _x.setInterpolator(new AccelerateInterpolator());


                ObjectAnimator _y = ObjectAnimator.ofFloat(iv, View.SCALE_Y, 0,1);
                _y.setDuration(1000);
                _y.setInterpolator(new AccelerateInterpolator());





                animationSet.playTogether(_x,_y);
                animationSet.start();


            }
        });

     //   AnimateToDown();



        new CountDownTimer(1000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {


                TextView notification = (TextView) findViewById(R.id.textView7);

                AnimatorSet xy = new AnimatorSet();

                ObjectAnimator x = ObjectAnimator.ofFloat(notification, View.SCALE_X, 0,1);
                x.setDuration(300);
                x.setInterpolator(new AccelerateInterpolator());


                ObjectAnimator y = ObjectAnimator.ofFloat(notification, View.SCALE_Y, 0,1);
                y.setDuration(300);
                y.setInterpolator(new AccelerateInterpolator());


                xy.play(x).with(y).after(100);
                xy.start();

            }
        }.start();











    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


    private void AnimateToDown() {


    runOnUiThread(new Runnable() {
    @Override
    public void run() {


        AnimatorSet animationSet = new AnimatorSet();

        //Translating Details_Card in Y Scale
        ObjectAnimator linearOne = ObjectAnimator.ofFloat(_layoutOne, View.TRANSLATION_Y, -100,1);
        linearOne.setDuration(1200);
        linearOne.setInterpolator(new AccelerateInterpolator());


        //Translating Movie_Cover in Y Scale
        ObjectAnimator linearTwo = ObjectAnimator.ofFloat(_layoutTwo, View.TRANSLATION_Y, -50,1);
        linearTwo.setDuration(900);
        linearTwo.setInterpolator(new AccelerateInterpolator());

        ObjectAnimator imageView = ObjectAnimator.ofFloat(_dashboardImage, View.TRANSLATION_Y, -50,1);
        imageView.setDuration(900);
        imageView.setInterpolator(new AccelerateInterpolator());


        ObjectAnimator v = ObjectAnimator.ofFloat(_view, View.TRANSLATION_Y, -50,1);
        v.setDuration(900);
        v.setInterpolator(new AccelerateInterpolator());




        animationSet.playTogether(linearOne,linearTwo,imageView,v);
        animationSet.start();
    }
});


    }
}
