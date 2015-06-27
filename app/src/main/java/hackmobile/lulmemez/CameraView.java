package hackmobile.lulmemez;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;

import java.io.IOException;

public class CameraView extends Activity implements SurfaceHolder.Callback {

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

        setContentView(R.layout.camera_surface);

        mSurfaceView = (SurfaceView) findViewById(R.id.surface_camera);


        mSurfaceHolder = mSurfaceView.getHolder();

        mSurfaceHolder.addCallback(this);

        mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

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
        mCamera.setParameters(p);

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

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        mCamera.stopPreview();
        mPreviewRunning = false;
        mCamera.release();

    }
}