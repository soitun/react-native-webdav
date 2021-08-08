// RNWebdavModule.java

package com.koodo.webdav;

import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

import com.thegrizzlylabs.sardineandroid.impl.OkHttpSardine;
import com.thegrizzlylabs.sardineandroid.DavResource;
import com.thegrizzlylabs.sardineandroid.Sardine;
import com.thegrizzlylabs.sardineandroid.impl.SardineException;

import java.io.File;
import java.util.List;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;


public class RNWebdavModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public RNWebdavModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNWebdav";
    }

    @ReactMethod
    public void sampleMethod(String stringArgument, int numberArgument, Callback callback) {
        // TODO: Implement some actually useful functionality
        callback.invoke("Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
    }

    @ReactMethod
    public void list(String username, String password, String url, Promise promise) {
        Sardine sardine = new OkHttpSardine();
        sardine.setCredentials(username, password);
        try {
            List<DavResource> resources = sardine.list(url);
            promise.resolve(resources.toString());

        } catch (IOException e) {
            e.printStackTrace();
            promise.reject(e);
        }
    }
    @ReactMethod
    public void createDirectory(String username, String password, String url, Promise promise) {
        Sardine sardine = new OkHttpSardine();
        sardine.setCredentials(username, password);
        try {
            sardine.createDirectory(url);
            promise.resolve(sardine.exists(url));

        } catch (IOException e) {
            e.printStackTrace();
            promise.reject(e);
        }
    }

    @ReactMethod
    public void delete(String username, String password, String url, Promise promise) {
        Sardine sardine = new OkHttpSardine();
        sardine.setCredentials(username, password);
        try {
            sardine.delete(url);
            promise.resolve(sardine.exists(url));

        } catch (IOException e) {
            e.printStackTrace();
            promise.reject(e);
        }
    }

    @ReactMethod
    public void exsits(String username, String password, String url, Promise promise) {
        Sardine sardine = new OkHttpSardine();
        sardine.setCredentials(username, password);
        try {
            promise.resolve(sardine.exists(url));

        } catch (IOException e) {
            e.printStackTrace();
            promise.reject(e);
        }
    }

    @ReactMethod
    public void move(String username, String password, String sourceUrl, String destUrl, Promise promise) {
        Sardine sardine = new OkHttpSardine();
        sardine.setCredentials(username, password);
        try {
            sardine.move(sourceUrl, destUrl);
            promise.resolve(sardine.exists(destUrl));

        } catch (IOException e) {
            e.printStackTrace();
            promise.reject(e);
        }
    }

    @ReactMethod
    public void copy(String username, String password, String sourceUrl, String destUrl, Boolean isOverwrite, Promise promise) {
        Sardine sardine = new OkHttpSardine();
        sardine.setCredentials(username, password);
        try {
            sardine.copy(sourceUrl, destUrl, isOverwrite);
            promise.resolve(sardine.exists(destUrl));

        } catch (IOException e) {
            e.printStackTrace();
            promise.reject(e);
        }
    }

    @ReactMethod
    public void download(String username, String password, String url, String dest,Promise promise) {
        InputStream input = null;
        OutputStream output = null;
        Sardine sardine = new OkHttpSardine();
        sardine.setCredentials("2237026218@qq.com", "a8g8ca6su5n2u86v");
        try {
            final InputStream in = sardine.get(url);
            input = new BufferedInputStream(in, 8 * 1024);
            output = new FileOutputStream(dest);
            byte data[] = new byte[8 * 1024];
            long total = 0;
            int count;
            double lastProgressValue = 0;
            long lastProgressEmitTimestamp = 0;

            while ((count = input.read(data)) != -1) {
                total += count;
                output.write(data, 0, count);
            }
            output.flush();

            promise.resolve(true);

        } catch (IOException e) {
            e.printStackTrace();
            promise.reject(e);
        }
    }
    @ReactMethod
    public void upload(String username, String password, String url, String source,String contentType, Promise promise) {
        Sardine sardine = new OkHttpSardine();
        sardine.setCredentials("2237026218@qq.com", "a8g8ca6su5n2u86v");
        try {
            File file = new File(source);
            sardine.put(url, file, contentType, false);
            promise.resolve(sardine.exists(url));

        } catch (IOException e) {
            e.printStackTrace();
            promise.reject(e);
        }
    }

    
}
