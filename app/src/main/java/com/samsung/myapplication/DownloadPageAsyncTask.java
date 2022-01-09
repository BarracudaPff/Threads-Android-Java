package com.samsung.myapplication;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadPageAsyncTask extends AsyncTask<String, Void, String> {
    TextView view;

    public DownloadPageAsyncTask(TextView view) {
        this.view = view;
    }

    @Override
    protected String doInBackground(String... strings) {
        String path = strings[0];

        try {
            return downloadPage(path);
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String s) {
        view.setText(s);
        super.onPostExecute(s);
    }

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
