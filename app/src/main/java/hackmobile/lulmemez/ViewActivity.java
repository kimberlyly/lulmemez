package hackmobile.lulmemez;


import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.content.res.AssetManager;

import android.graphics.PixelFormat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import android.content.Context;

public class ViewActivity extends ActionBarActivity {

    public Bitmap blunt, guy, doritos, glasses, hat, loominati, SnoopDogg, swag, weed, yolo, image, mutableImage;

    ImageView pictureView = null;
    TextView loadText = null;
    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

    LinearLayout rl = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_view);
        loadImages();
    }

    //Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.image);

    public void loadImages()
    {
        InputStream istr0, istr1, istr2, istr3, istr4, istr5, istr6, istr7, istr8, istr9, istr10;

        AssetManager assetManager;

        assetManager = getAssets();
        try {
            istr0 = assetManager.open("blunt.png");
            blunt = BitmapFactory.decodeStream(istr0);
            Matrix matrix = new Matrix();
            matrix.postRotate(-90);
            blunt = Bitmap.createBitmap(blunt, 0, 0, blunt.getWidth(), blunt.getHeight(), matrix, true);
            blunt = Bitmap.createScaledBitmap(blunt, blunt.getWidth() / 2, blunt.getHeight() / 2, true);


            istr1 = assetManager.open("DO_NOT_WANT_GUY.png");
            guy = BitmapFactory.decodeStream(istr1);

            istr2 = assetManager.open("doritos.png");
            doritos = BitmapFactory.decodeStream(istr2);

            istr3 = assetManager.open("glasses.png");
            glasses = BitmapFactory.decodeStream(istr3);
            matrix = new Matrix();
            matrix.postRotate(-90);
            glasses = Bitmap.createBitmap(glasses, 0, 0, glasses.getWidth(), glasses.getHeight(), matrix, true);
            glasses = Bitmap.createScaledBitmap(glasses, glasses.getWidth() / 4, glasses.getHeight() / 4, true);

            istr4 = assetManager.open("hat.png");
            hat = BitmapFactory.decodeStream(istr4);
            matrix = new Matrix();
            matrix.postRotate(-90);
            hat = Bitmap.createBitmap(hat, 0, 0, hat.getWidth(), hat.getHeight(), matrix, true);
            hat = Bitmap.createScaledBitmap(hat, hat.getWidth() / 2, hat.getHeight() / 2, true);

            istr5 = assetManager.open("loominati.png");
            loominati = BitmapFactory.decodeStream(istr5);

            istr6 = assetManager.open("SnoopDogg.png");
            SnoopDogg = BitmapFactory.decodeStream(istr6);
            SnoopDogg = BitmapFactory.decodeStream(istr4);
            matrix = new Matrix();
            matrix.postRotate(-90);
            SnoopDogg = Bitmap.createBitmap(SnoopDogg, 0, 0, SnoopDogg.getWidth(), SnoopDogg.getHeight(), matrix, true);
            SnoopDogg = Bitmap.createScaledBitmap(SnoopDogg, SnoopDogg.getWidth() / 2, SnoopDogg.getHeight() / 2, true);

            istr7 = assetManager.open("swag.png");
            swag = BitmapFactory.decodeStream(istr7);

            istr8 = assetManager.open("weed.png");
            weed = BitmapFactory.decodeStream(istr8);
            weed = BitmapFactory.decodeStream(istr6);
            weed = BitmapFactory.decodeStream(istr4);
            matrix = new Matrix();
            matrix.postRotate(-90);
            weed = Bitmap.createBitmap(weed, 0, 0, weed.getWidth(), weed.getHeight(), matrix, true);
            weed = Bitmap.createScaledBitmap(weed, weed.getWidth() / 2, weed.getHeight() / 2, true);

            istr9 = assetManager.open("yolo.png");
            yolo = BitmapFactory.decodeStream(istr9);

            istr10 = assetManager.open("BillNye.png");
            image = BitmapFactory.decodeStream(istr10);



        } catch (IOException e) {
            e.printStackTrace();
        }

        FileOutputStream out = null;
        try {
            File file = new File(this.getFilesDir(), "test.png");

            out = openFileOutput("test.png", Context.MODE_PRIVATE);

            image.compress(Bitmap.CompressFormat.PNG, 100, out); // bmp is your Bitmap instance
            // PNG is a lossless format, the compression factor (100) is ignored'

            out.close();
            Log.d("DEBUG", "written");
            Log.d("files dir", "" + this.getFilesDir());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }






        // Start our code

        // Instantiate UI
        pictureView  = (ImageView) findViewById(R.id.imageview1); //new ImageView(getApplicationContext());
        loadText = new TextView(getApplicationContext());
        rl = (LinearLayout) findViewById(R.id.relativeLayout1);
        //lp.addRule(LinearLayout.CENTER_IN_PARENT);
        displayLoading("Loading...");
        // Get image
        // Make modify image (kevin)

        Bitmap modifiedImage = null;
//        try {
        MyPicture mine = MyPicture.get();
        modifiedImage = MyPicture.get().my_picture; //BitmapFactory.decodeStream(getAssets().open("blunt.png"));

        Coordinates coords = MyPicture.get().coords;;

        int EYEDISTANCE = coords.rightEye[0] - coords.leftEye[0];

        mutableImage = modifiedImage.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(mutableImage);
        Paint paint = new Paint(Paint.FILTER_BITMAP_FLAG);

        if(EYEDISTANCE != 0 ) {
            Bitmap resizedGlasses = Bitmap.createScaledBitmap(glasses, EYEDISTANCE, image.getHeight() * EYEDISTANCE / glasses.getHeight(), true);
            canvas.drawBitmap(resizedGlasses, coords.rightEye[0], coords.rightEye[1], paint);
        }

        if(coords.mouth[0] == 0)
        {
            Log.d("face detection", "mouth not detected!!!");
            System.out.println("mouth not detected!!!");
        }

        if(coords.mouth[0] !=0 && coords.mouth[1] !=0 ) {
            canvas.drawBitmap(blunt, coords.mouth[0], coords.mouth[1], paint);
        }


        if (coords.upperLeft[0] != 0 || coords.upperLeft[1] != 0) {
            Log.d("face detection", "face detected!!! lowerRight[0] coordinates is: " + coords.lowerRight[0]);
            Log.d("face detection", "face detected!!! lowerRight[1] coordinates is: " + coords.lowerRight[1]);
            Log.d("face detection", "face detected!!! upperLeft[0] coordinates is: " + coords.upperLeft[0]);
            Log.d("face detection", "face detected!!! upperLeft[1] coordinates is: " + coords.upperLeft[1]);
            Log.d("face detection", "face detected!!! mouth[0]] coordinates is: " + coords.mouth[0]);
            Log.d("face detection", "face detected!!! mouth[1] coordinates is: " + coords.mouth[1]);

            canvas.drawBitmap(blunt, -1 * (coords.upperLeft[1] + coords.lowerRight[1]) / 2 + 550 + (coords.upperLeft[1] + coords.lowerRight[1]) / 3, (coords.upperLeft[0] + coords.lowerRight[0]) / 2 + 150, paint);
            canvas.drawBitmap(glasses, -1 * (coords.upperLeft[1] + coords.lowerRight[1]) / 2 + 350 + (coords.upperLeft[1] + coords.lowerRight[1]) / 3, (coords.upperLeft[0] + coords.lowerRight[0]) / 2, paint);
            canvas.drawBitmap(hat, -1 * (coords.upperLeft[1] + coords.lowerRight[1]) / 2 + 100 + (coords.upperLeft[1] + coords.lowerRight[1]) / 3, (coords.upperLeft[0] + coords.lowerRight[0]) / 2, paint);
            canvas.drawBitmap(SnoopDogg, 750, 500, paint);
            canvas.drawBitmap(weed, 0, 0, paint);
        }


        if (coords.lowerRight[0] == 0 || coords.lowerRight[1] == 0)
        {
            Log.d("face detection", "face not detected!!!");
        }



//        }
//        catch (IOException e){
//        }
        // Hide loading message
        hideLoading();

        modifiedImage = mutableImage;
        // Display modified image
        displayImage(modifiedImage);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void displayImage(Bitmap b){
        pictureView.setImageBitmap(b);
        pictureView.setRotation(90);
        //pictureView.setLayoutParams(lp);

        //rl.addView(pictureView, lp);
    }

    void hideImage(){
        //pictureView.setVisibility(View.INVISIBLE);
        rl.removeView(pictureView);
    }

    void displayLoading(String s) {
        loadText.setText(s);
        loadText.setTextColor(Color.BLACK);
        loadText.setTextSize(40);
        loadText.setLayoutParams(lp);
        rl.addView(loadText, lp);
    }

    void hideLoading(){
        rl.removeView(loadText);
    }

}
