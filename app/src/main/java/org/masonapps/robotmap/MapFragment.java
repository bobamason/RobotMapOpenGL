package org.masonapps.robotmap;


import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.view.MotionEvent;

import org.rajawali3d.Object3D;
import org.rajawali3d.cameras.ArcballCamera;
import org.rajawali3d.debug.GridFloor;
import org.rajawali3d.lights.DirectionalLight;
import org.rajawali3d.loader.LoaderOBJ;
import org.rajawali3d.loader.ParsingException;
import org.rajawali3d.loader.fbx.LoaderFBX;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.methods.DiffuseMethod;
import org.rajawali3d.renderer.ISurfaceRenderer;


public class MapFragment extends Base3DFragment {
    @Override
    public ISurfaceRenderer createRenderer(Context context) {
        return new MapPlotRenderer(context);
    }

    private final class MapPlotRenderer extends BaseRenderer {


        private
        @Nullable
        Object3D robotMain = null;
        private
        @Nullable
        Object3D robotHead = null;

        public MapPlotRenderer(Context context) {
            super(context);
        }

        @Override
        protected void initScene() {
            getCurrentScene().addLight(new DirectionalLight(0.2f, -1f, -0.2f));

//            final Animation3D robotAnim = new RotateOnAxisAnimation(Vector3.Axis.Y, 360);
//            robotAnim.setRepeatMode(Animation.RepeatMode.INFINITE);
//            robotAnim.setDurationMilliseconds(10000);
//            getCurrentScene().registerAnimation(robotAnim);
//            final Animation3D headAnim = new RotateOnAxisAnimation(Vector3.Axis.Y, 180);
//            headAnim.setRepeatMode(Animation.RepeatMode.REVERSE_INFINITE);
//            headAnim.setDurationMilliseconds(4000);
//            getCurrentScene().registerAnimation(headAnim);

            Material robotMaterial = new Material();
            robotMaterial.enableLighting(true);
            robotMaterial.setDiffuseMethod(new DiffuseMethod.Lambert());
            robotMaterial.setColor(Color.YELLOW);

//            try {
//                robotMain = loadFBX(R.raw.robot_main);
//                robotMain.setMaterial(robotMaterial);
//                getCurrentScene().addChild(robotMain);
////                robotAnim.setTransformable3D(robotMain);
////                robotAnim.play();
//            } catch (ParsingException e) {
//                e.printStackTrace();
//            }
//            try {
//                robotHead = loadFBX(R.raw.robot_main);
//                robotHead.setMaterial(robotMaterial);
//                if(robotMain != null){
//                    robotMain.addChild(robotHead);
//                } else{
//                    getCurrentScene().addChild(robotHead);
//                }
//                robotHead.setRotation(Vector3.Axis.Y, -90);
//                robotHead.setPosition(0, 5.5, -5.5);
////                headAnim.setTransformable3D(robotHead);
////                headAnim.play();
//            } catch (ParsingException e) {
//                e.printStackTrace();
//            }

            final GridFloor gridFloor = new GridFloor(200);
            getCurrentScene().addChild(gridFloor);
//            final Plane groundPlane = new Plane(1000, 1000, 1, 1, Vector3.Axis.Y);
//            final Material groundMaterial = new Material();
//            groundMaterial.enableLighting(true);
//            groundMaterial.setDiffuseMethod(new DiffuseMethod.Lambert());
//            groundMaterial.setColor(Color.GRAY);
//            groundPlane.setMaterial(groundMaterial);
//            groundPlane.setPosition(0, -0.01, 0);
//            getCurrentScene().addChild(groundPlane);
            ArcballCamera camera = new ArcballCamera(getActivity(), getView());
            getCurrentScene().replaceAndSwitchCamera(getCurrentCamera(), camera);
            camera.setPosition(0, 10, 30);
            camera.setTarget(gridFloor);
        }

        private Object3D loadFBX(int res) throws ParsingException {
            LoaderFBX parser = new LoaderFBX(this, res);
            parser.parse();
            return parser.getParsedObject();
        }

        private Object3D loadOBJ(int res) throws ParsingException {
            LoaderOBJ parser = new LoaderOBJ(this, res);
            parser.parse();
            return parser.getParsedObject();
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
