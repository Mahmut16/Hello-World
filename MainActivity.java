package com.google.android.helloworld;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.ic_launcher);

        TextView textView = new TextView(this);
        textView.setText("Hello, World!");
        textView.setTextSize(24);

        TextView assetTextView = new TextView(this);
        assetTextView.setText(loadAssetFile("sample.txt"));
        assetTextView.setTextSize(18);

        layout.addView(imageView);
        layout.addView(textView);
        layout.addView(assetTextView);

        setContentView(layout);
    }

    private String loadAssetFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try {
            AssetManager assetManager = getAssets();
            InputStream is = assetManager.open(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to load asset file.";
        }
        return content.toString();
    }

    static {
        System.loadLibrary("native-lib");
    }

    public native String stringFromJNI();
}