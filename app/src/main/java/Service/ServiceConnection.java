package Service;

import android.content.ComponentName;
import android.os.IBinder;

import henrik.mau.assignment4.MainActivity;
import henrik.mau.assignment4.StepsHistoryActivity;

public class ServiceConnection implements android.content.ServiceConnection {
    private final StepsHistoryActivity stepsActivity;

    public ServiceConnection(StepsHistoryActivity stepsActivity){
        this.stepsActivity = stepsActivity;
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        StepsService.LocalBinder binder = (StepsService.LocalBinder) service;
        stepsActivity.stepsService = binder.getService();
        stepsActivity.mBound = true;
        
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }

    @Override
    public void onBindingDied(ComponentName name) {

    }

    @Override
    public void onNullBinding(ComponentName name) {

    }
}
