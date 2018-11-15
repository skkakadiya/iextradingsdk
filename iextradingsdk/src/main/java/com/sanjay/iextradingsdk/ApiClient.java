package com.sanjay.iextradingsdk;


import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class ApiClient {

    List<String> list;


    private Response mResponse = null;


    public ApiClient(Response response){
        if(response != null){
            this.mResponse = response;
        } else {
            throw new IllegalStateException("Activity must implement com.sanjay.iextradingsdk.Response");
        }
    }

    public void requestSymbol(String url){

        new GetSymbol().execute(url);
    }

    private class GetSymbol extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder sb = new StringBuilder();
            try {
                URL url = new URL(strings[0]);

                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                String str = null;
                while ((str = in.readLine()) != null ) {
                    sb.append(str + "\n");
                }
                in.close();
            } catch (Exception e){
                e.printStackTrace();
            }

            return sb.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if(!TextUtils.isEmpty(s)) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    mResponse.onResponseObtained(jsonObject);
                } catch (JSONException e) {
                    mResponse.onErrorObatained("Invalid JSON!");
                }
            } else {
                mResponse.onErrorObatained("Please try again later!");
            }
        }
    }

}
