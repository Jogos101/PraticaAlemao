package org.simon.repository;

import org.simon.entity.German;
import java.util.ArrayList;

public class GermanRepository {
    private final ArrayList<German> gRepository = new ArrayList<German>();

    public void addGerman(German g){
        this.gRepository.add(g);
    }

    public ArrayList<German> getAll(){
        return gRepository;
    }

    public German getGerman(int index){
        return gRepository.get(index);
    }

    public Integer getSize(){
        return gRepository.size();
    }
}
