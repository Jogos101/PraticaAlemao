package org.simon.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;

public class JsonService {
    JSONParser parser = new JSONParser();

    public Iterator<JSONObject> getIterator(String path) {
        try{
            Object obj = parser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray numeros = (JSONArray) jsonObject.get("Numeros");
            return (Iterator<JSONObject>) numeros.iterator();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
