package org.masonapps.robotmap;

import android.os.Bundle;

import org.masonapps.robotmap.bluetooth.BluetoothActivity;

public class MainActivity extends BluetoothActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void connected() {
        
    }

    @Override
    public void connecting() {

    }

    @Override
    public void disconnected() {

    }

    @Override
    public void onRead(String line) {

    }
}
