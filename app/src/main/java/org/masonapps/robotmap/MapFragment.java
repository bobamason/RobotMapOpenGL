package org.masonapps.robotmap;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


public class MapFragment extends Fragment{


    private FrameLayout layout;

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layout = (FrameLayout) inflater.inflate(R.layout.fragment_map, container, false);
        return layout;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        if(layout != null) layout.removeView();
    }
}
