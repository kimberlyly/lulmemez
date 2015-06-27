package hackmobile.lulmemez;

import android.graphics.Bitmap;

import hackmobile.lulmemez.util.SystemUiHider;

/**
 * Authors: Casey and John
 * Singleton for passsing the current image between activities.
 */
public class MyPicture {
    // Singleton instance
    static MyPicture singleton = null;

    // Picture from camera
    public Bitmap my_picture = null;
    public Coordinates coords = null;

    // Get reference to singleton instance
    public static MyPicture get() {
        if (singleton == null) {
            System.err.println("abcdf: new guy");
            singleton = new MyPicture();
        }
        System.err.println("abcdf: old guy");
        return singleton;
    }
}
