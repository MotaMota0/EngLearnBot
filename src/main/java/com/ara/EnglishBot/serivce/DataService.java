package com.ara.EnglishBot.serivce;


import com.ara.EnglishBot.data.DataRepository;
import com.ara.EnglishBot.model.Words;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DataService {

    private final DataRepository dataRepository;

    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }


    public String getRandomWords(){
        List<Words> words = dataRepository.findAll();
        if(words.isEmpty()){
            return "⚠️ В базе нет слов! Добавьте их вручную.";
        }
        int index = new Random().nextInt(words.size());
        Words word = words.get(index);

        return word.getEngl()+" - "+word.getKazakh();
    }
}
