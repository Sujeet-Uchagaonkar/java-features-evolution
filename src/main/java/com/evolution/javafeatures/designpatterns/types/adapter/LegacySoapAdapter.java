package com.evolution.javafeatures.designpatterns.types.adapter;


// Will act as a adapter
public class LegacySoapAdapter implements BaseApi {
    LegacySoapApi legacySoapApi = new LegacySoapApi();


    @Override
    public String callExternalApi() {
        return legacySoapApi.executeSoapLogic();
    }
}
