package hackmobile.lulmemez;


import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
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

    public Bitmap blunt, guy, doritos, glasses, hat, loominati, SnoopDogg, swag, weed, yolo, image;

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

            istr1 = assetManager.open("DO_NOT_WANT_GUY.png");
            guy = BitmapFactory.decodeStream(istr1);

            istr2 = assetManager.open("doritos.png");
            doritos = BitmapFactory.decodeStream(istr2);

            istr3 = assetManager.open("glasses.png");
            glasses = BitmapFactory.decodeStream(istr3);

            istr4 = assetManager.open("hat.png");
            hat = BitmapFactory.decodeStream(istr4);

            istr5 = assetManager.open("loominati.png");
            loominati = BitmapFactory.decodeStream(istr5);

            istr6 = assetManager.open("SnoopDogg.png");
            SnoopDogg = BitmapFactory.decodeStream(istr6);

            istr7 = assetManager.open("swag.png");
            swag = BitmapFactory.decodeStream(istr7);

            istr8 = assetManager.open("weed.png");
            weed = BitmapFactory.decodeStream(istr8);

            istr9 = assetManager.open("yolo.png");
            yolo = BitmapFactory.decodeStream(istr9);

            istr10 = assetManager.open("BillNye.png");
            image = BitmapFactory.decodeStream(istr10);

            int EYEDISTANCE = image.getWidth()/3;
            Bitmap resizedWeed = Bitmap.createScaledBitmap(weed, EYEDISTANCE, image.getHeight()*EYEDISTANCE/weed.getHeight(), true);

            Bitmap mutableImage = image.copy(Bitmap.Config.ARGB_8888, true);

            Canvas canvas = new Canvas(mutableImage);
            Paint paint = new Paint(Paint.FILTER_BITMAP_FLAG);
            canvas.drawBitmap(resizedWeed, 0, 0, paint);


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

//        }
//        catch (IOException e){
//        }
        // Hide loading message
        hideLoading();
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
