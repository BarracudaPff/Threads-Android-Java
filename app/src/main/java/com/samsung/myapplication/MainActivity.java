package com.samsung.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    Executor executor = Executors.newFixedThreadPool(1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        !NOT THIS ONE!
//        doRequest();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                doRequest();
//            }
//        }).start();

//        new DownloadPageAsyncTask(findViewById(R.id.textView)).execute("https://google.com");

//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                doRequest();
//            }
//        });

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("132456");
//            }
//        }, 1000);
    }

    public void doRequest() {
        TextView textView = findViewById(R.id.textView);
        try {
            String content = downloadPage("https://google.com");
            textView.setText(content);
        } catch (IOException e) {
            Toast.makeText(this, "Can't load page", Toast.LENGTH_SHORT).show();
        }
    }

    // https://google.com
    public String downloadPage(String path) throws IOException {
        URL url = new URL(path);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader stream = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String line;
        StringBuilder content = new StringBuilder();
        line = stream.readLine();
        while (line != null) {
            content.append(line).append("\n");
            line = stream.readLine();
        }
        stream.close();


        return content.toString();
    }
}