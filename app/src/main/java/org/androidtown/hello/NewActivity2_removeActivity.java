package org.androidtown.hello;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class NewActivity2_removeActivity extends Activity {

    private Intent intent;
    private PendingIntent ServicePending;
    private AlarmManager alarmManager;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new2_remove_alarm);

        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.song);
        mediaPlayer.start();

        Button.OnClickListener bClickListener = new View.OnClickListener(){
            public void onClick(View v){
                switch (v.getId()){
                    case R.id.changeSet:
                        Toast.makeText(getBaseContext(),"미구현",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.removeAlarm:
                        mediaPlayer.stop();
                        removeAlarm();
                        break;
                }
            }
        };
        findViewById(R.id.changeSet).setOnClickListener(bClickListener);
        findViewById(R.id.removeAlarm).setOnClickListener(bClickListener);
    }

    void removeAlarm(){
        intent = new Intent("AlarmReceiver");
        ServicePending = PendingIntent.getBroadcast(NewActivity2_removeActivity.this,111,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        Log.d("ServicePending : ",""+ServicePending.toString());
        Toast.makeText(getBaseContext(),"알람 해제",Toast.LENGTH_SHORT).show();
        alarmManager.cancel(ServicePending);
    }



    public void onBackButtonClicked(View v) {
        Toast.makeText(getApplicationContext(), "돌아가기 버튼이 눌렸어요.", Toast.LENGTH_LONG).show();
        finish();
    }
}