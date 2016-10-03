package app.materialsignup;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import top.wefor.circularanim.CircularAnim;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        getSupportActionBar().hide();


        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                CircularAnim.fullActivity(MainActivity.this, view)
                        .colorOrImageRes(R.color.colorPrimary)
                        .go(new CircularAnim.OnAnimationEndListener() {
                            @Override
                            public void onAnimationEnd() {
                                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this)
                                        .toBundle();

                                Intent intent = new Intent(MainActivity.this, LoadinActivity.class);
                                startActivity(intent);
                            }
                        });
            }
        });
    }
}
