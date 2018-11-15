package com.sanjay.iextradingsdk;


import org.json.JSONObject;

public interface Response {

    void onResponseObtained(JSONObject jsonObject);

    void onErrorObatained(String error);

}
