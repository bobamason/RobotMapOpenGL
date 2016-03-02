package org.masonapps.robotmap;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import org.rajawali3d.renderer.ISurfaceRenderer;
import org.rajawali3d.renderer.Renderer;
import org.rajawali3d.view.TextureView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


public abstract class Base3DFragment extends Fragment {

    private FrameLayout layout;
    private TextureView textureView;
    private ProgressBar progressBar;
    private BaseRenderer renderer;

    public Base3DFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layout = (FrameLayout) inflater.inflate(R.layout.fragment_base3d, container, false);
        textureView = (TextureView) layout.findViewById(R.id.textureView);
        progressBar = (ProgressBar) layout.findViewById(R.id.progressBar);
        onBeforeApplyRenderer();
        renderer = (BaseRenderer) createRenderer(getActivity());
        textureView.setSurfaceRenderer(renderer);
        return layout;
    }

    public void onBeforeApplyRenderer() {

    }

    public abstract ISurfaceRenderer createRenderer(Context context);

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (layout != null) layout.removeView(textureView);
    }

    private void showProgressBar() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    private void hideProgressBar() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    protected abstract class BaseRenderer extends Renderer {

        public BaseRenderer(Context context) {
            super(context);
        }

        @Override
        public void onRenderSurfaceCreated(EGLConfig config, GL10 gl, int width, int height) {
            showProgressBar();
            super.onRenderSurfaceCreated(config, gl, width, height);
            hideProgressBar();
        }
    }
}
