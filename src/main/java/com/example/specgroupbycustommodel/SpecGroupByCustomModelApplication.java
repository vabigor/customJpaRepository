package com.example.specgroupbycustommodel;

import com.example.specgroupbycustommodel.entity.Document;
import com.example.specgroupbycustommodel.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class SpecGroupByCustomModelApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpecGroupByCustomModelApplication.class, args);
    }

    @Autowired
    private DocumentRepository rep;

    @Bean
    public CommandLineRunner CommandLineRunnerBean() {
        return (args) -> {
            if (rep.findAll().isEmpty()){
                List<String> statuses = List.of("DRAFT", "NEW", "NEW");
                List<Document> documents = new ArrayList<>();
                statuses.forEach(s->documents.add(new Document().setStatus(s)
                        .setShortSummary(UUID.randomUUID().toString())
                        .setOrgId(UUID.randomUUID().toString())));
                rep.saveAll(documents);
            }
        };
    }

}
