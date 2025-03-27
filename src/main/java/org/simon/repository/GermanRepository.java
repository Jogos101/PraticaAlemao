package org.simon.repository;

import org.simon.entity.German;
import org.simon.entity.Language;
import java.util.ArrayList;

public class GermanRepository {
    private final ArrayList<Language> gRepository = new ArrayList<Language>();

    public void addGerman(German g){
        this.gRepository.add(g);
    }

    public ArrayList<Language> getAll(){
        return gRepository;
    }

    public Language getGerman(int index){
        return gRepository.get(index);
    }

    public Integer getSize(){
        return gRepository.size();
    }
}
