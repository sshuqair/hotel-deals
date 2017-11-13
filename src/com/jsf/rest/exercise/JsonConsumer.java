package com.jsf.rest.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Json Consumer to consume an external service
 *  Ahmad.alsanie92@gmail.com 20-02-2017
 * **/
public class JsonConsumer {

  private static String readAll(Reader reader) throws IOException {
    StringBuilder sb = new StringBuilder();
    int c;
    //read to the end
    while ((c = reader.read()) != -1) {
      sb.append((char) c);
    }
    return sb.toString();
  }

  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    //try-with resources to ensures that the resource is closed
    try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")))) {
      
      String jsonStr = readAll(bufferedReader);
      JSONObject json = new JSONObject(jsonStr);
      return json;
    } 
  }

  
}
