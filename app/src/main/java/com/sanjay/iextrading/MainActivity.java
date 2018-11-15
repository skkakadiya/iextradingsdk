package com.sanjay.iextrading;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.sanjay.iextradingsdk.IEXTrading;
import com.sanjay.iextradingsdk.Response;

public class MainActivity extends AppCompatActivity {

    TextView tvText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvText = findViewById(R.id.tv_text);

        IEXTrading iexTrading = new IEXTrading(new Response() {
            @Override
            public void onResponseObtained(String jsonObject) {
                getPrice(jsonObject);
            }

            @Override
            public void onErrorObatained(String error) {

            }
        });
        iexTrading.requestCompanyDetail("GOOGL");
    }

    private void getPrice(final String jsonObject) {
        IEXTrading iexTrading = new IEXTrading(new Response() {
            @Override
            public void onResponseObtained(String json) {
                tvText.setText(jsonObject + " " + json);
            }

            @Override
            public void onErrorObatained(String error) {

            }
        });
        iexTrading.requestPriceDetail("GOOGL");
    }
}
