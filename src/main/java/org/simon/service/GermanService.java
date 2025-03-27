package org.simon.service;

import org.simon.entity.German;
import org.simon.repository.GermanRepository;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.Random;

public class GermanService {
    GermanRepository germanRepository = new GermanRepository();
    JsonService jsonService = new JsonService();
    Random rand = new Random();
    German ultimoRandom;

    public GermanService() {
        this.ultimoRandom = null;
    }

    public void addNumbers() {
        Iterator<JSONObject> iterator = jsonService
                .getIterator("src/main/resources/library/numbers.json");
        while (iterator.hasNext()) {
            JSONObject numero = iterator.next();
            String portuguese = (String) numero.get("portugues");
            String alemao = (String) numero.get("alemao");
            germanRepository.addGerman(new German(portuguese, alemao));
        }
    }

    public German getRandomGerman(){
        int repoSeize = germanRepository.getSize();
        German g = germanRepository.getGerman(rand
                .nextInt(repoSeize));
        if(ultimoRandom == null){
            this.ultimoRandom = g;
            return g;
        }else{
            while(g.equals(ultimoRandom)){
                g = germanRepository.getGerman(rand
                        .nextInt(repoSeize));
            }
            this.ultimoRandom = g;
            return g;
        }
    }

    public void showAll(){
        ArrayList<German> gAll = germanRepository.getAll();
        for(German g : gAll){
            System.out.printf("%s: %s\n", g.portugues, g.alemao);
        }
    }

    public void showRandom(){
        System.out.println(getRandomGerman().alemao);
    }

    public boolean testeResposta(String resposta,German g){
        return g.portugues.equals(resposta);
    }
}
