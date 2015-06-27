package hackmobile.lulmemez;

/**
 * Authors: Casey and John
 * Singleton for passsing the current image between activities.
 */
public class MyPicture {
    // Singleton instance
    static MyPicture obj = null;

    // Picture from camera
    Object my_picture = null;

    // Get reference to singleton instance
    static MyPicture get() {
        if (obj == null) {
            return new MyPicture();
        }
        return obj;
    }
}
