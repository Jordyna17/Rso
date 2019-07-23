/*
package com.example.rsofinder;

import com.google.gson.Gson;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

import java.net.URL;
import java.net.MalformedURLException;

public class PullAPI {

    private static final int STATUS_OK = 200;


    private static Adventure adventure;

    public static Adventure takeURL(String url) {
        try {
            makeApiRequest(url);
        } catch (UnirestException e) {
            System.out.println("Network not responding");
        } catch (MalformedURLException e) {
            System.out.println("Bad URL: " + url);
            return null;
        }
        return adventure;
    }

    static void makeApiRequest(String url) throws UnirestException, MalformedURLException {
        final HttpResponse<String> stringHttpResponse;

// This will throw MalformedURLException if the url is malformed.
        new URL(url);

        stringHttpResponse = Unirest.get(url).asString();
// Check to see if the request was successful; if so, convert the payload JSON into Java objects
        if (stringHttpResponse.getStatus() == STATUS_OK) {
            String json = stringHttpResponse.getBody();
            Gson gson = new Gson();
            adventure = gson.fromJson(json, Adventure.class);
        }
    }
}*/
