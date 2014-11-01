package nz.co.hackmiramar.taxi_share.model;

import android.content.SharedPreferences;
import android.graphics.Bitmap;

import java.io.File;
import java.io.IOException;

import nz.co.hackmiramar.taxi_share.Application;
import nz.co.hackmiramar.taxi_share.Constants;
import nz.co.hackmiramar.taxi_share.utils.ImageUtils;

public class Profile {

    private static final int SCALED_PICTURE_SIZE = 240;

    public static void saveAppProfile(String name, String description, Bitmap image) {
        SharedPreferences prefs = Application.getAppContext().getSharedPreferences(Constants.APP_PREFERENCES, 1);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString(Constants.PREFS_PROFILE_NAME, name);
        edit.putString(Constants.PREFS_PROFILE_DESCRIPTION, description);

        File imageFile = null;
        if (image != null) {
            Bitmap scaledPicture = Bitmap.createScaledBitmap(image, SCALED_PICTURE_SIZE, SCALED_PICTURE_SIZE, false);
            try {
                imageFile = ImageUtils.saveImageAsJpeg(scaledPicture, ImageUtils.defaultImagesDir(), null, 100);
            } catch (IOException e) { e.printStackTrace(); }
        }

        edit.putString(Constants.PREFS_PROFILE_IMAGE, imageFile.getPath());
        edit.apply();
    }
}
