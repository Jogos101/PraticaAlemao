package org.simon.service.german;

import org.simon.entity.German;
import org.simon.entity.Language;
import org.simon.repository.GermanRepository;
import org.json.simple.JSONObject;
import org.simon.service.JsonService;
import org.simon.service.LanguageService;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.Random;

public class GermanPortugueseService extends LanguageService {
    GermanRepository germanRepository = new GermanRepository();
    JsonService jsonService = new JsonService();
    German ultimoRandom;

    public GermanPortugueseService() {
        this.ultimoRandom = null;
    }

    @Override
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

    @Override
    public void addCoffe() {

    }

    @Override
    public void addFamily() {

    }

    @Override
    public ArrayList<Language> getAllFromRepository() {
        return germanRepository.getAll();
    }
}
