package hackmobile.lulmemez;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;


public class ViewActivity extends ActionBarActivity {

    ImageView pictureView = null;
    TextView loadText = null;
    RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

    RelativeLayout rl = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        // Start our code

        // Instantiate UI
        pictureView  = new ImageView(getApplicationContext());
        loadText = new TextView(getApplicationContext());
        rl = (RelativeLayout) findViewById(R.id.relativeLayout1);
        lp.addRule(RelativeLayout.CENTER_IN_PARENT);
        displayLoading("Loading...");
        // Get image
        MyPicture myPicture = MyPicture.get();
        // Make modify image (kevin)

        Bitmap modifiedImage = null;
        try {
            modifiedImage = BitmapFactory.decodeStream(getAssets().open("blunt.png"));
        }
        catch (IOException e){
        }
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
        rl.addView(pictureView, lp);
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
