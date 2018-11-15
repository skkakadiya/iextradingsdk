package com.sanjay.iextrading;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sanjay.iextradingsdk.IEXTrading;
import com.sanjay.iextradingsdk.Response;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IEXTrading iexTrading = new IEXTrading(new Response() {
            @Override
            public void onResponseObtained(JSONObject jsonObject) {
                getPrice(jsonObject);
            }

            @Override
            public void onErrorObatained(String error) {

            }
        });
        iexTrading.requestCompanyDetail("GOOGL");
    }

    private void getPrice(JSONObject jsonObject) {
        IEXTrading iexTrading = new IEXTrading(new Response() {
            @Override
            public void onResponseObtained(JSONObject jsonObject) {

            }

            @Override
            public void onErrorObatained(String error) {

            }
        });
        iexTrading.requestPriceDetail("GOOGL");
    }
}
