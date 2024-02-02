package com.example.specgroupbycustommodel.controller;

import com.example.specgroupbycustommodel.controller.request.BasicSearchRequest;
import com.example.specgroupbycustommodel.repository.DocumentRepository;
import com.example.specgroupbycustommodel.repository.model.DocGroupStatus;
import com.example.specgroupbycustommodel.specification.DocumentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public class DocumentController {

    private final DocumentRepository repository;
    private final DocumentSpecification spec;

    @Autowired
    public DocumentController(DocumentRepository repository, DocumentSpecification spec) {
        this.repository = repository;
        this.spec = spec;
    }

    @GetMapping
    public List<DocGroupStatus> getAll(BasicSearchRequest request){
        return repository.groupAndCount(spec.getFilter(request));
    }
}
