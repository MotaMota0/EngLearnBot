package com.ara.EnglishBot.data;

import com.ara.EnglishBot.model.Words;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Repository
public interface DataRepository extends JpaRepository<Words,Long> {


   //@Query(value = "SELECT * FROM words WHERE text LIKE :word LIMIT 1", nativeQuery = true)
    //String findByWord(@Param("word") String s);
}
