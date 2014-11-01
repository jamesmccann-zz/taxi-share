package nz.co.hackmiramar.taxi_share.utils;

import android.graphics.Bitmap;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import nz.co.hackmiramar.taxi_share.Application;

public class ImageUtils {

    public static File defaultImagesDir() {
        File defaultImagesDir = new File(Application.getAppContext().getFilesDir(), "/images/");
        defaultImagesDir.mkdirs();
        return defaultImagesDir;
    }

    /**
     * A helper method to save a given Bitmap as a JPEG file.
     *
     * @param image    The bitmap image to convert to JPEG and save
     * @param path     A file representing the directory where the image should be stored
     * @param baseName A string to use as the file basename for this image, leave null for a random UUID
     * @param quality  The JPEG quality to use
     * @return The File that the image was saved to
     * @throws java.io.IOException if there are problems opening or saving the file
     */
    public static File saveImageAsJpeg(Bitmap image, File path, String baseName, int quality) throws IOException {
        if (baseName == null) {
            baseName = UUID.randomUUID().toString();
        }

        File outFile = new File(path, baseName + ".jpg");
        FileOutputStream out = new FileOutputStream(outFile);
        image.compress(Bitmap.CompressFormat.JPEG, quality, out);
        out.close();

        Log.d("ImageUtils", "JPEG image stored at: " + outFile.getPath());

        return outFile;
    }

}
