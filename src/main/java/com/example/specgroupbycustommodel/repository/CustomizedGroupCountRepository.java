package com.example.specgroupbycustommodel.repository;

import com.example.specgroupbycustommodel.repository.model.DocGroupStatus;
import com.example.specgroupbycustommodel.entity.Document;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface CustomizedGroupCountRepository{

    List<DocGroupStatus> groupAndCount(Specification<Document> specification);
}
