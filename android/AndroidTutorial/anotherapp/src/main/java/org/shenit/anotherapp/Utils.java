package org.shenit.anotherapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by 江老师 on 5/25/16.
 */
public final class Utils {
    private static final Gson GSON;
    static{
        GSON = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
    }

    public static void bind(final Activity act,int rid, final Class<?> actClass) {
        Button btn = (Button) act.findViewById(rid);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                act.startActivity(new Intent(act, actClass));
            }
        });
    }

    /**
     * Get gson instance
     * @return
     */
    public static Gson gson(){
        return GSON;
    }

    /* Checks if external storage is available for read and write */
    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public static boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    /**
     * Save url resource to file.
     * @param urlStr URL string
     * @param dir Dir to save the file
     * @param bw Bandwidth to use.
     */
    public static File saveToFile(String urlStr, File dir, int bw){
        FileOutputStream fos = null;
        URL url = null;
        URLConnection conn = null;
        File file = null;
        try {
            url = new URL(urlStr);
            //get the last part as file name in url path
            String fileName = url.getPath();
            fileName = fileName.substring(fileName.lastIndexOf("/"));

            file = new File(dir,fileName);
            fos =  new FileOutputStream(file);
            conn = url.openConnection();
            InputStream is = conn.getInputStream();
            byte[] buff = new byte[bw];
            int read;
            while(is.available()> 0){
                read = is.read(buff);
                fos.write(buff,0,read);
                fos.flush();
            }
        } catch (IOException e) {
            Log.e(Utils.class.getSimpleName(),"Error saving resources["+urlStr+"] to file["+file+"]",e);
        }finally{
            IOUtils.close(conn);
            IOUtils.closeQuietly(fos);
        }
        return file;
    }

}
