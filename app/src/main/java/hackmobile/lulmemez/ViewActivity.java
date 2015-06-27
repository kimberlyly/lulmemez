package hackmobile.lulmemez;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;
import java.io.InputStream;


public class ViewActivity extends ActionBarActivity {

    public Bitmap blunt, guy, doritos, glasses, hat, loominati, SnoopDogg, swag, weed, yolo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
    }

    //Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.image);

    public void loadImages()
    {
        InputStream istr0, istr1, istr2, istr3, istr4, istr5, istr6, istr7, istr8, istr9;
        Bitmap bitmap = null;
        AssetManager assetManager;


        assetManager = getAssets();
        try {
            istr0 = assetManager.open("assets/blunt.png");
            blunt = BitmapFactory.decodeStream(istr0);

            istr1 = assetManager.open("assets/DO_NOT_WANT_GUY.png");
            guy = BitmapFactory.decodeStream(istr1);

            istr2 = assetManager.open("assets/doritos.png");
            doritos = BitmapFactory.decodeStream(istr2);

            istr3 = assetManager.open("assets/glasses.png");
            glasses = BitmapFactory.decodeStream(istr3);

            istr4 = assetManager.open("assets/hat.png");
            hat = BitmapFactory.decodeStream(istr4);

            istr5 = assetManager.open("assets/loominati.png");
            loominati = BitmapFactory.decodeStream(istr5);

            istr6 = assetManager.open("assets/SnoopDog.png");
            SnoopDogg = BitmapFactory.decodeStream(istr6);

            istr7 = assetManager.open("assets/swag.png");
            swag = BitmapFactory.decodeStream(istr7);

            istr8 = assetManager.open("assets/weed.png");
            weed = BitmapFactory.decodeStream(istr8);

            istr9 = assetManager.open("assets/yolo.png");
            yolo = BitmapFactory.decodeStream(istr9);



        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
