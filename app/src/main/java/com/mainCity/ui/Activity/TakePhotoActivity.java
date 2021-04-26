package com.mainCity.ui.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mainCity.R;

import java.io.FileNotFoundException;

/**
 * Let users take photo so that we can get the location information from the picture.
 */
public class TakePhotoActivity extends AppCompatActivity {

    private Uri photoUri;
//    private final ImageView showImage = (ImageView)findViewById(R.id.photo);
    public Bitmap bitmap;
//    final TextView address = (TextView) findViewById(R.id.Address);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_photo);

        Button takePhoto = (Button) findViewById(R.id.photoButton);

        takePhoto.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT,photoUri);
                startActivityForResult(intent,1);
            }
        });

        Button next = (Button) findViewById(R.id.NextButton);
    }

    /**
     * Get the Uri of the photo and get the location information.
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == 0 && resultCode == RESULT_OK){
            if(data != null){
                photoUri = data.getData();
                if(photoUri != null){
                    Cursor query = getContentResolver().query(photoUri, new String[]{"_data"}, null, null, null);
                    if (query.moveToFirst()){
                        query.moveToNext();
                        String path = query.getString(0);
                    }
                    query.close();
                    try {
                        bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(photoUri));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
//                    showImage.setImageBitmap(bitmap);
                }
                else{
                    Bitmap bitmap = (Bitmap) data.getParcelableExtra("data");
//                    showImage.setImageBitmap(bitmap);
                }

                // Code to get the location information from the picture.
//                ExifInterface exifInterface = new ExifInterface(path);
//                String altitude = exifInterface.getAttribute(ExifInterface.TAG_GPS_ALTITUDE);
//                String latitude = exifInterface.getAttribute(ExifInterface.TAG_GPS_LATITUDE);
//                String longitude = exifInterface.getAttribute(ExifInterface.TAG_GPS_LONGITUDE);
//
//                double lat = score2dimensionality(latitude);
//                double lon = score2dimensionality(longitude);
//
//                address.setText("Your latitude is: " + lat + ", your longitude is: " + lon);
            }
        }
    }

    /**
     * Change the format of the latitude and longitude to double so that
     * this information is readable and easier to use.
     * @param string
     * @return dimensionality
     */
    private double score2dimensionality(String string) {
        double dimensionality = 0.0;
        if (null==string){
            return dimensionality;
        }

        String[] split = string.split(",");
        for (int i = 0; i < split.length; i++) {

            String[] s = split[i].split("/");
            double v = Double.parseDouble(s[0]) / Double.parseDouble(s[1]);
            dimensionality=dimensionality+v/Math.pow(60,i);
        }
        return dimensionality;
    }
}