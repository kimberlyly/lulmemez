package hackmobile.lulmemez;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.util.List;

import hackmobile.lulmemez.util.SystemUiHider;

public class CameraActivity extends Activity implements SurfaceHolder.Callback {

    private SurfaceView mSurfaceView;
    private SurfaceHolder mSurfaceHolder;
    private Camera mCamera;
    private boolean mPreviewRunning;
    private Coordinates coord;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        getWindow().setFormat(PixelFormat.TRANSLUCENT);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,

                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_camera);
        mSurfaceView = (SurfaceView) findViewById(R.id.surface_camera);


        mSurfaceHolder = mSurfaceView.getHolder();

        mSurfaceHolder.addCallback(this);

        mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        //mSurfaceView = (SurfaceView) findViewById(R.id.imageView1);
        Button photoButton = (Button) this.findViewById(R.id.button_camera);
        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Camera.PictureCallback callMeMaybe = new Camera.PictureCallback() {
                    @Override
                    public void onPictureTaken(byte[] data, Camera camera) {

                        final BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        //BitmapFactory.decodeByteArray(data, 0, data.length);
//                        options.inSampleSize = calcSize(options, 400, 500);
                        options.inSampleSize = 5;
                        options.inJustDecodeBounds = false;


                        MyPicture.get().my_picture = BitmapFactory.decodeByteArray(data, 0, data.length, options);

                        Intent i = new Intent(getApplicationContext(), ViewActivity.class);
                        startActivity(i);
                    }
                };
                mCamera.takePicture(null, null, callMeMaybe);
            }
        });
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        mCamera = Camera.open();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        if (mPreviewRunning) {

            mCamera.stopPreview();
        }
        Camera.Parameters p = mCamera.getParameters();
        p.setPreviewSize(w, h);
        List<Camera.Size> previewSizes = p.getSupportedPreviewSizes();

        Camera.Size previewSize = previewSizes.get(0);
        p.setPreviewSize(previewSize.width, previewSize.height);


        mCamera.setParameters(p);
        mCamera.setDisplayOrientation(90);
        try {
            mCamera.setPreviewDisplay(holder);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mCamera.startPreview();
        MyFaceDetectionListener faceListener = new MyFaceDetectionListener();
        mCamera.setFaceDetectionListener(faceListener);
        mCamera.startFaceDetection();
        mPreviewRunning = true;
    }

    public static int calcSize(BitmapFactory.Options options, int width, int height) {
        final int uHeight = options.outHeight;
        final int uWidth = options.outWidth;
        int inSampleSize = 1;
        if (uHeight > height || uWidth > width) {
            if (uWidth > uHeight) {
                inSampleSize = Math.round((float) uHeight / (float) height);
            } else {
                inSampleSize = Math.round((float) uWidth / (float) width);
            }
        }
        return inSampleSize;
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        mCamera.stopPreview();
        mPreviewRunning = false;
        mCamera.release();

    }
}