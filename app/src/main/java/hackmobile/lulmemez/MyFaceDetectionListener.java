package hackmobile.lulmemez;

import android.hardware.Camera;

/**
 * Created by kimberlyly on 6/27/15.
 */

class MyFaceDetectionListener implements Camera.FaceDetectionListener {
    Coordinates coord;
    @Override
    public void onFaceDetection(Camera.Face[] faces, Camera camera) {
        Camera.Face face = faces[0];

        coord.leftEye[0] = face.leftEye.x;
        coord.leftEye[1] = face.leftEye.y;

        coord.rightEye[0] = face.rightEye.x;
        coord.rightEye[1] = face.rightEye.y;

        coord.mouth[0] = face.mouth.x;
        coord.mouth[1] = face.mouth.y;

        coord.upperLeft[0] = face.rect.left;
        coord.upperLeft[1] = face.rect.top;

        coord.lowerRight[0] = face.rect.right;
        coord.lowerRight[1] = face.rect.bottom;
    }
}