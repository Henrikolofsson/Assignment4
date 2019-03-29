package henrik.mau.assignment4;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import Service.ServiceConnection;
import Service.StepsService;

public class StepsHistoryActivity extends AppCompatActivity {
    private ServiceConnection serviceConnection;
    private Intent stepsIntent;
    public StepsService stepsService;
    public boolean mBound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps_history);

        serviceConnection = new ServiceConnection(this);
        stepsIntent = new Intent(this, StepsService.class);
        bindService(stepsIntent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mBound){
            unbindService(serviceConnection);
            mBound = false;
        }
    }
}
