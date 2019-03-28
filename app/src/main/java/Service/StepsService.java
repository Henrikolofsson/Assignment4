package Service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class StepsService extends Service implements SensorEventListener {
    private SensorManager sensorManager;
    private LocalBinder localBinder;
    private Sensor sensor;

    @Override
    public void onCreate() {
        super.onCreate();
        localBinder = new LocalBinder();
        sensorManager = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!= null){
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        return localBinder;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.d("STEPS TAKEN", String.valueOf(event.values[0]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public class LocalBinder extends Binder {
        StepsService getService(){
            return StepsService.this;
        }
    }
}
