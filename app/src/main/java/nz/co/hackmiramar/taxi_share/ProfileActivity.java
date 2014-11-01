package nz.co.hackmiramar.taxi_share;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.soundcloud.android.crop.Crop;

import java.io.File;
import java.io.IOException;

import nz.co.hackmiramar.taxi_share.model.Profile;


public class ProfileActivity extends Activity {

    private static final int REQUEST_GET_PICTURE = 1;

    private Bitmap mProfileImageBitmap;

    private ImageView mIvProfileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mIvProfileImage = (ImageView) findViewById(R.id.profile_image);
    }


    public void onAddPicturePressed(View view) {
        requestPictureIntent();
    }

    public void requestPictureIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, REQUEST_GET_PICTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_GET_PICTURE:
                if (resultCode == Activity.RESULT_OK) {
                    requestPictureCrop(data);
                }
                break;
            case Crop.REQUEST_CROP:
                onImageCropResult(resultCode, data);
                break;
        }
    }

    private String tmpFilePath;

    public void requestPictureCrop(Intent data) {
        try {
            File tmpFile = File.createTempFile("image", null, this.getCacheDir());
            tmpFilePath = tmpFile.getPath();
            Uri selectedImage = data.getData();
            new Crop(selectedImage)
                    .output(Uri.fromFile(tmpFile))
                    .asSquare()
                    .start(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onImageCropResult(int resultCode, Intent data) {
        Bitmap croppedBitmap = BitmapFactory.decodeFile(tmpFilePath);
        mProfileImageBitmap = croppedBitmap;
        mIvProfileImage.setImageBitmap(croppedBitmap);
        findViewById(R.id.add_picture).setVisibility(View.GONE);
    }

    public void onSignUpPressed(View v) {
        TextView tvName = (TextView) findViewById(R.id.profile_name);
        TextView tvDescription = (TextView) findViewById(R.id.profile_description);
        Profile.saveAppProfile(tvName.getText().toString(),
                tvDescription.getText().toString(), mProfileImageBitmap);
    }
}
