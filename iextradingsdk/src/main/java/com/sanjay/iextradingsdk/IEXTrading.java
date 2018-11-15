package com.sanjay.iextradingsdk;

import android.text.TextUtils;

import org.json.JSONObject;

public class IEXTrading {


    public static final String BASE_URL = "https://api.iextrading.com/1.0/stock/";

    private Response mResponse = null;
    private ApiClient apiClient;

    public IEXTrading(Response response){
        if(response != null){
            this.mResponse = response;
        } else {
            throw new IllegalStateException("Activity must implement com.sanjay.iextradingsdk.Response");
        }
        this.apiClient = new ApiClient(mResponse);
    }

    public void requestCompanyDetail(String symbol) {
        if(!TextUtils.isEmpty(symbol)) {
            try{
                this.apiClient.requestSymbol(BASE_URL + symbol + "/company");
            } catch (Exception e) {
                mResponse.onErrorObatained("Please try again later");
            }
        }
    }

    public void requestPriceDetail(String symbol) {
        if(!TextUtils.isEmpty(symbol)) {
            try{
                this.apiClient.requestSymbol(BASE_URL + symbol + "/price");
            } catch (Exception e) {
                mResponse.onErrorObatained("Please try again later");
            }
        }
    }

}
