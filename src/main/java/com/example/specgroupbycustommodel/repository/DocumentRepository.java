package com.example.specgroupbycustommodel.repository;

import com.example.specgroupbycustommodel.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface DocumentRepository extends JpaRepository<Document, UUID>, JpaSpecificationExecutor<Document>, CustomizedGroupCountRepository {
}
