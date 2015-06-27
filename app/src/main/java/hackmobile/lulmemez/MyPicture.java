package hackmobile.lulmemez;

/**
 * Authors: Casey and John
 * Singleton for passsing the current image between activities.
 */
public class MyPicture {
    // Singleton instance
    static MyPicture obj = null;

    // Picture from camera
    public Object my_picture = null;
    public Coordinates coords = null;

    // Get reference to singleton instance
    public static MyPicture get() {
        if (obj == null) {
            return new MyPicture();
        }
        return obj;
    }
}
