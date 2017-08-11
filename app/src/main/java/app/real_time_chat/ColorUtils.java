package app.real_time_chat;

/**
 * Created by david on 28.07.17.
 */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v7.graphics.Palette;
import android.graphics.Color;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.io.File;



public class ColorUtils {

    public String imageName;



    public  static int[] getColor(String filePath, String imageName) {
        getSDcardPath();
        File sd = Environment.getExternalStorageDirectory();
        File image = new File("/storage/extSdCard/"+filePath, imageName);
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(),bmOptions);
        return getDominantColor1(bitmap);
    }
    public static void getSDcardPath() {
        String sdpath,sd1path,usbdiskpath,sd0path;

        if(new File("/storage/extSdCard/DCIM/Camera/raspberries.jpg").exists())
        {
            sdpath="/storage/extSdCard/";
            Log.i("Sd Cardext Path",sdpath);
        }
        if(new File("/storage/sdcard1/").exists())
        {
            sd1path="/storage/sdcard1/";
            Log.i("Sd Card1 Path",sd1path);
        }
        if(new File("/storage/usbcard1/").exists())
        {
            usbdiskpath="/storage/usbcard1/";
            Log.i("USB Path",usbdiskpath);
        }
        if(new File("/storage/sdcard0/").exists())
        {
            sd0path="/storage/sdcard0/";
            Log.i("Sd Card0 Path",sd0path);
        }
    }

    protected final static String TAG = "ColorUtils";
    /**
     * Calculates the dominat color of a bitmap
     * WARNING: Slow
     *
     * @param bitmap
     * @return
     */
    public static int[] getDominantColor1(Bitmap bitmap) {
        int[] derivedColor = new int[3];
        if (bitmap == null)
            throw new NullPointerException();
        // Synchronous
        Palette p = Palette.from(bitmap).generate();
        int intColor = p.getMutedColor(0);
        derivedColor[0] = Color.red(intColor);
        derivedColor[1] = Color.green(intColor);
        derivedColor[2] = Color.blue(intColor);
        return derivedColor;
    }

}
