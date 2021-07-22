package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.management.MalformedObjectNameException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student alfon = new Student("Alfon", "alfongalindo@hotmail.com", LocalDate.of(2000, Month.JANUARY, 5));
            Student gael = new Student("Gael", "alfongalindo@hotmail.com", LocalDate.of(2000, Month.JANUARY, 5));

            repository.saveAll(Arrays.asList(alfon,gael));
        };


    }
}
