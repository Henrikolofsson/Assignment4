package SensorListener;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;

public class SensorListener implements SensorEventListener {

    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.d("STEPS TAKEN", String.valueOf(event.values[0]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
