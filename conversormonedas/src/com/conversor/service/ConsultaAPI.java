package com.conversor.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI
{
    private final String API_KEY = "709a75e0020a5eb07880a527";

    public String obtenerDatos(String monedaBase) throws IOException, InterruptedException {

        String direccion = "https://v6.exchangerate-api.com/v6/" +
                API_KEY +
                "/latest/" +
                monedaBase;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}

