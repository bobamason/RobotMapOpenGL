package org.masonapps.robotmap;

import android.os.Bundle;

import org.masonapps.robotmap.bluetooth.BluetoothActivity;


public class MainActivity extends BluetoothActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new MapFragment()).commit();
        }
    }

    @Override
    public void onConnected() {

    }

    @Override
    public void connecting() {

    }

    @Override
    public void onDisconnected() {

    }
    
    /*
    private ProgressBar progressBar;
    private FloatingActionButton fab;
    private Drawable disconnectedDrawable;
    private Drawable connectedDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        progressBar = (ProgressBar) findViewById(R.id.progressIndicator);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new PlotMapFragment(), COMPASS_PLOT_FRAG).commit();
        }

        disconnectedDrawable = DrawableCompat.wrap(getResources().getDrawable(R.drawable.ic_bluetooth_disabled));
        DrawableCompat.setTint(disconnectedDrawable, Color.LTGRAY);
        connectedDrawable = getResources().getDrawable(R.drawable.ic_bluetooth);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageDrawable(disconnectedDrawable);
        fab.setBackgroundTintList(ColorStateList.valueOf(FAB_COLOR_DISCONNECTED));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isConnected()) {

                } else {
                    if (BluetoothAdapter.getDefaultAdapter().isEnabled()) {
                        displayDeviceListDialog();
                    } else {
                        requestEnableBluetooth();
                    }
                }
            }
        });
    }

    @Override
    protected void onPause() {
        write("disable\n");
        super.onPause();
    }

    @Override
    public void onConnected() {
        fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
        fab.setImageDrawable(connectedDrawable);
        for (OnBluetoothEventListener listener : listeners) {
            listener.onConnected();
        }
        setProgressVisibility(false);
        write("enable\n");
    }

    @Override
    public void connecting() {
        setProgressVisibility(true);
        fab.setBackgroundTintList(ColorStateList.valueOf(FAB_COLOR_DISCONNECTED));
        fab.setImageDrawable(disconnectedDrawable);
    }

    @Override
    public void onDisconnected() {
        setProgressVisibility(true);
        fab.setBackgroundTintList(ColorStateList.valueOf(FAB_COLOR_DISCONNECTED));
        fab.setImageDrawable(disconnectedDrawable);
        attemptToConnect();
        for (OnBluetoothEventListener listener : listeners) {
            listener.onDisconnected();
        }
    }
    
    public void setProgressVisibility(boolean visible) {
        progressBar.setVisibility(visible ? View.VISIBLE : View.GONE);
    }
     */
}
