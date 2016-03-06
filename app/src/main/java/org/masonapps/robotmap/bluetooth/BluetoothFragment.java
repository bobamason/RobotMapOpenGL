package org.masonapps.robotmap.bluetooth;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Bob on 1/3/2016.
 */
public abstract class BluetoothFragment extends Fragment implements BluetoothActivity.OnBluetoothEventListener {

    public boolean write(String s) {
        return ((BluetoothActivity) getActivity()).write(s);
    }

    public boolean writeln(String s) {
        return ((BluetoothActivity) getActivity()).write(s + "\n");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!(getActivity() instanceof BluetoothActivity))
            throw new RuntimeException("the Activity must extend BluetoothActivity");
    }

    @Override
    public void onResume() {
        super.onResume();
        ((BluetoothActivity) getActivity()).addOnBluetoothEventListener(this);
    }

    @Override
    public void onPause() {
        ((BluetoothActivity) getActivity()).removeOnBluetoothEventListener(this);
        super.onPause();
    }
}
