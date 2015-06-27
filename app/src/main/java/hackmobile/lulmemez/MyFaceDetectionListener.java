package hackmobile.lulmemez;

import android.hardware.Camera;

/**
 * Created by kimberlyly on 6/27/15.
 */

class MyFaceDetectionListener implements Camera.FaceDetectionListener {
    Coordinates coord = new Coordinates();


    @Override
    public void onFaceDetection(Camera.Face[] faces, Camera camera) {
        if (faces != null && faces.length >= 1) {
            Camera.Face face = faces[0];

            if (face == null) {
                return;
            }
            coord.leftEye[0] = face.leftEye != null ? face.leftEye.x : 0;
            coord.leftEye[1] = face.leftEye != null ? face.leftEye.y : 0;

            coord.rightEye[0] = face.rightEye != null ? face.rightEye.x : 0;
            coord.rightEye[1] = face.rightEye != null ? face.rightEye.y : 0;

            coord.mouth[0] = face.mouth != null ? face.mouth.x : 0;
            coord.mouth[1] = face.mouth != null ? face.mouth.y : 0;

            coord.upperLeft[0] = face.rect.left;
            coord.upperLeft[1] = face.rect.top;

            coord.lowerRight[0] = face.rect.right;
            coord.lowerRight[1] = face.rect.bottom;


            MyPicture.get().coords = coord;
        }
    }
}