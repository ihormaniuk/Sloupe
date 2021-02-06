package com.groot.sloupe.tetse;

import com.groot.sloupe.Net.Jsoup.Teste.JsoupTeste;

import java.io.IOException;

public class Teste  {

    int getInt;
    String valueString;



    public void generedUrl(String valueString, int inte,JsoupTeste js) throws IOException {

        js.setValue(inte);
        for (int i = 0 ; i<inte;i++){
            js.setValueString(valueString);
            js.getUrl();
        }

    }
}
