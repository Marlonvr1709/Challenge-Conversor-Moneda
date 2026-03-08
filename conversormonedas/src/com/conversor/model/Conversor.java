package com.conversor.model;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Conversor
{
    public double convertir(String json, String monedaDestino, double cantidad){

        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        JsonObject tasas = jsonObject.getAsJsonObject("conversion_rates");

        double tasa = tasas.get(monedaDestino).getAsDouble();

        return cantidad * tasa;
    }
}
