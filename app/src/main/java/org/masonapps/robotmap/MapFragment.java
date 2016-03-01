package org.masonapps.robotmap;


import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;

import org.rajawali3d.debug.GridFloor;
import org.rajawali3d.lights.DirectionalLight;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.methods.DiffuseMethod;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.primitives.Plane;
import org.rajawali3d.renderer.ISurfaceRenderer;


public class MapFragment extends Base3DFragment {
    @Override
    public ISurfaceRenderer createRenderer(Context context) {
        return new MapPlotRenderer(context);
    }

    private final class MapPlotRenderer extends BaseRenderer {


        public MapPlotRenderer(Context context) {
            super(context);
        }

        @Override
        protected void initScene() {
            getCurrentScene().addLight(new DirectionalLight(0.2f, -1f, -0.2f));

            //LOAD ROBOT FBX

            getCurrentScene().addChild(new GridFloor(1000, Color.WHITE, 4, 100));
            final Plane groundPlane = new Plane(1000, 1000, 1, 1, Vector3.Axis.Y);
            final Material groundMaterial = new Material();
            groundMaterial.enableLighting(true);
            groundMaterial.setDiffuseMethod(new DiffuseMethod.Lambert());
            groundMaterial.setColor(Color.GRAY);
            groundPlane.setMaterial(groundMaterial);
            groundPlane.setPosition(0, -0.01, 0);
            getCurrentScene().addChild(groundPlane);
        }

        @Override
        protected void render(long ellapsedRealtime, double deltaTime) {
            super.render(ellapsedRealtime, deltaTime);
        }

        @Override
        public void onOffsetsChanged(float xOffset, float yOffset, float xOffsetStep, float yOffsetStep, int xPixelOffset, int yPixelOffset) {

        }

        @Override
        public void onTouchEvent(MotionEvent event) {

        }
    }
}
