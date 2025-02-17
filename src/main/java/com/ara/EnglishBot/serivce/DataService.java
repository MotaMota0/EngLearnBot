package com.ara.EnglishBot.serivce;


import com.ara.EnglishBot.data.DataRepository;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    private final DataRepository dataRepository;

    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }


    public String findByWords(String word){
        return dataRepository.findByWord(word);
    }
}
