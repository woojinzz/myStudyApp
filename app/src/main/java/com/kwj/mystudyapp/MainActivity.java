package com.kwj.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ivView1,ivView2,ivView3,ivView4,ivView5,ivView6,ivView7,ivView8,ivView9,ivView10,ivView11,ivView12,ivView13,ivView14,ivView15,ivView16,ivView17,ivView18
            ,ivView19,ivView20,ivView21,ivView22,ivView23,ivView24,ivView25,ivView32;
    Animation ani1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivView1 = (ImageView)findViewById(R.id.ivView1);
        ivView1.setOnClickListener(mClickListener);
        ivView2 = (ImageView)findViewById(R.id.ivView2);
        ivView2.setOnClickListener(mClickListener);
        ivView3 = (ImageView)findViewById(R.id.ivView3);
        ivView3.setOnClickListener(mClickListener);
        ivView4 = (ImageView)findViewById(R.id.ivView4);
        ivView4.setOnClickListener(mClickListener);
        ivView5 = (ImageView)findViewById(R.id.ivView5);
        ivView5.setOnClickListener(mClickListener);
        ivView6 = (ImageView)findViewById(R.id.ivView6);
        ivView6.setOnClickListener(mClickListener);
        ivView7 = (ImageView)findViewById(R.id.ivView7);
        ivView7.setOnClickListener(mClickListener);
        ivView8 = (ImageView)findViewById(R.id.ivView8);
        ivView8.setOnClickListener(mClickListener);
        ivView9 = (ImageView)findViewById(R.id.ivView9);
        ivView9.setOnClickListener(mClickListener);
        ivView10 = (ImageView)findViewById(R.id.ivView10);
        ivView10.setOnClickListener(mClickListener);
        ivView11 = (ImageView)findViewById(R.id.ivView11);
        ivView11.setOnClickListener(mClickListener);
        ivView12 = (ImageView)findViewById(R.id.ivView12);
        ivView12.setOnClickListener(mClickListener);
        ivView13 = (ImageView)findViewById(R.id.ivView13);
        ivView13.setOnClickListener(mClickListener);
        ivView14 = (ImageView)findViewById(R.id.ivView14);
        ivView14.setOnClickListener(mClickListener);
        ivView15 = (ImageView)findViewById(R.id.ivView15);
        ivView15.setOnClickListener(mClickListener);
        ivView16 = (ImageView)findViewById(R.id.ivView16);
        ivView16.setOnClickListener(mClickListener);
        ivView17 = (ImageView)findViewById(R.id.ivView17);
        ivView17.setOnClickListener(mClickListener);
        ivView18 = (ImageView)findViewById(R.id.ivView18);
        ivView18.setOnClickListener(mClickListener);
        ivView19 = (ImageView)findViewById(R.id.ivView19);
        ivView19.setOnClickListener(mClickListener);
        ivView20 = (ImageView)findViewById(R.id.ivView20);
        ivView20.setOnClickListener(mClickListener);
        ivView21 = (ImageView)findViewById(R.id.ivView21);
        ivView21.setOnClickListener(mClickListener);
        ivView22 = (ImageView)findViewById(R.id.ivView22);
        ivView22.setOnClickListener(mClickListener);
        ivView23 = (ImageView)findViewById(R.id.ivView23);
        ivView23.setOnClickListener(mClickListener);
        ivView24 = (ImageView)findViewById(R.id.ivView24);
        ivView24.setOnClickListener(mClickListener);
        ivView25 = (ImageView)findViewById(R.id.ivView25);
        ivView25.setOnClickListener(mClickListener);
        ivView32 = (ImageView)findViewById(R.id.ivView32);
        ivView32.setOnClickListener(mClickListener);
        ani1 = AnimationUtils.loadAnimation(this, R.anim.alpha);


    }


    //버튼이벤트를 감지함...
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.ivView1:
                    Intent intent1 = new Intent(MainActivity.this, Ex1LoginActivity.class);
                    startActivity(intent1);
                    ivView1.startAnimation(ani1);
                    break;

                case R.id.ivView2:
                    Intent intent2 = new Intent(MainActivity.this, Ex2CalcActivity.class);
                    startActivity(intent2);
                    ivView2.startAnimation(ani1);
                    break;
                case R.id.ivView3:
                    Intent intent3 = new Intent(MainActivity.this, EX3AnimationActivity.class);
                    startActivity(intent3);
                    ivView3.startAnimation(ani1);
                    break;
                case R.id.ivView4:
                    Intent intent4 = new Intent(MainActivity.this, Ex4GifActivity.class);
                    startActivity(intent4);
                    ivView4.startAnimation(ani1);
                    break;
                case R.id.ivView5:
                    Intent intent5 = new Intent(MainActivity.this, Ex5DataActivity.class);
                    startActivity(intent5);
                    ivView5.startAnimation(ani1);
                    break;
                case R.id.ivView6:
                    Intent intent6 = new Intent(MainActivity.this, Ex6SpinnerActivity.class);
                    startActivity(intent6);
                    ivView6.startAnimation(ani1);
                    break;
                case R.id.ivView7:
                    Intent intent7 = new Intent(MainActivity.this, Ex7SwitchActivity.class);
                    startActivity(intent7);
                    ivView7.startAnimation(ani1);
                    break;
                case R.id.ivView8:
                    Intent intent8 = new Intent(MainActivity.this, Ex8WebViewActivity.class);
                    startActivity(intent8);
                    ivView8.startAnimation(ani1);
                    break;
                case R.id.ivView9:
                    Intent intent9 = new Intent(MainActivity.this, Ex9VideoMainActivity.class);
                    startActivity(intent9);
                    ivView9.startAnimation(ani1);
                    break;
                case R.id.ivView10:
                    Intent intent10 = new Intent(MainActivity.this, Ex10MediaActivity.class);
                    startActivity(intent10);
                    ivView10.startAnimation(ani1);
                    break;
                case R.id.ivView11:
                    Intent intent11 = new Intent(MainActivity.this, Ex11GalleryViewEx.class);
                    startActivity(intent11);
                    ivView11.startAnimation(ani1);
                    break;
                case R.id.ivView12:
                    Intent intent12 = new Intent(MainActivity.this, Ex12SoccerStartActivity.class);
                    startActivity(intent12);
                    ivView12.startAnimation(ani1);
                    break;
                case R.id.ivView13:
                    Intent intent13 = new Intent(MainActivity.this, Ex13HadlerActivity.class);
                    startActivity(intent13);
                    ivView13.startAnimation(ani1);
                    break;
                case R.id.ivView14:
                    Intent intent14 = new Intent(MainActivity.this, Ex14SharedPreferencesActivity.class);
                    startActivity(intent14);
                    ivView14.startAnimation(ani1);
                    break;
                case R.id.ivView15:
                    Intent intent15 = new Intent(MainActivity.this, Ex15SharedPreferences2Activity.class);
                    startActivity(intent15);
                    ivView15.startAnimation(ani1);
                    break;
                case R.id.ivView16:
                    Intent intent16 = new Intent(MainActivity.this, Ex16FrameLayoutActivity.class);
                    startActivity(intent16);
                    ivView16.startAnimation(ani1);
                    break;
                case R.id.ivView17:
                    Intent intent17 = new Intent(MainActivity.this, Ex17PhoneCreate1Activity.class);
                    startActivity(intent17);
                    ivView16.startAnimation(ani1);
                    break;
                case R.id.ivView18:
                    Intent intent18 = new Intent(MainActivity.this, Ex18ListViewActivity.class);
                    startActivity(intent18);
                    ivView18.startAnimation(ani1);
                    break;
                case R.id.ivView19:
                    Intent intent19 = new Intent(MainActivity.this, Ex19PhoneCreate2ListView.class);
                    startActivity(intent19);
                    ivView19.startAnimation(ani1);
                    break;
                case R.id.ivView20:
                    Intent intent20 = new Intent(MainActivity.this, Ex20FriendsListActivity.class);
                    startActivity(intent20);
                    ivView20.startAnimation(ani1);
                    break;
                case R.id.ivView21:
                    Intent intent21 = new Intent(MainActivity.this, Ex20FriendsListActivity.class);
                    startActivity(intent21);
                    ivView21.startAnimation(ani1);
                    break;
                case R.id.ivView22:
                    Intent intent22 = new Intent(MainActivity.this, Ex20FriendsListActivity.class);
                    startActivity(intent22);
                    ivView22.startAnimation(ani1);
                    break;
                case R.id.ivView23:
                    Intent intent23 = new Intent(MainActivity.this, Ex24MemberListActivity.class);
                    startActivity(intent23);
                    ivView23.startAnimation(ani1);
                    break;
                case R.id.ivView24:
                    Intent intent24 = new Intent(MainActivity.this, Ex24LoginActivity.class);
                    startActivity(intent24);
                    ivView24.startAnimation(ani1);
                    break;
                case R.id.ivView25:
                    Intent intent25 = new Intent(MainActivity.this, Ex24ProfileActivity.class);
                    startActivity(intent25);
                    ivView25.startAnimation(ani1);
                    break;
                case R.id.ivView32:
                    Intent intent32 = new Intent(MainActivity.this, Ex32webPhpLogin.class);
                    startActivity(intent32);
                    ivView32.startAnimation(ani1);
                    break;
            }
        }
    };
}