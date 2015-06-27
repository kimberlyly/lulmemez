package hackmobile.lulmemez.util;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

import hackmobile.lulmemez.R;


/**
 * Created by Kevin on 6/26/2015.
 */
public class Modify_Img extends Activity{
    //Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.image);

    InputStream istr;
    Bitmap bitmap = null;
    AssetManager assetManager;

    public Bitmap makeImage()
    {
        assetManager = getAssets();
        try {
            istr = assetManager.open("assets/blunt.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(istr);
        return bitmap;
    }
}
