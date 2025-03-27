package org.simon.service;

import org.json.simple.JSONObject;
import org.simon.entity.German;
import org.simon.entity.Language;
import org.simon.repository.GermanRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public abstract class LanguageService {
    GermanRepository germanRepository = new GermanRepository();
    JsonService jsonService = new JsonService();
    Random rand = new Random();
    Language ultimoRandom;

    public abstract void addNumbers();
    public abstract void addCoffe();
    public abstract void addFamily();
    public abstract ArrayList<Language> getAllFromRepository();

    public void showAll(){
        ArrayList<Language> gAll = getAllFromRepository();
        for(Language g : gAll){
            System.out.printf("%s: %s\n", g.getTrasnlation(), g.getOriginal());
        }
    }

    public void showRandom(){
        System.out.println(getRandomWord().getOriginal());
    }

    public Language getRandomWord(){
        ArrayList<Language> repository = getAllFromRepository();
        Language g = repository.get(rand.nextInt(repository.size()));
        if (ultimoRandom != null) {
            while (g.equals(ultimoRandom)) {
                g = repository.get(rand.nextInt(repository.size()));
            }
        }
        this.ultimoRandom = g;
        return g;
    }

    public boolean testeResposta(String resposta, Language l){
        return l.getTrasnlation().equals(resposta);
    }
}
