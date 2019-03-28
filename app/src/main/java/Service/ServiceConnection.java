package Service;

import android.content.ComponentName;
import android.os.IBinder;

import henrik.mau.assignment4.MainActivity;

public class ServiceConnection implements android.content.ServiceConnection {
    private final MainActivity mainActivity;

    public ServiceConnection(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        StepsService.LocalBinder binder = (StepsService.LocalBinder) service;
        mainActivity.stepsService = binder.getService();
        mainActivity.stepsService
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
