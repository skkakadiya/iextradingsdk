package com.sanjay.iextradingsdk;


public interface Response {

    void onResponseObtained(String jsonObject);

    void onErrorObatained(String error);

}
