package com.example.specgroupbycustommodel.specification;

import com.example.specgroupbycustommodel.controller.request.BasicSearchRequest;
import com.example.specgroupbycustommodel.entity.Document;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class DocumentSpecification {

    public Specification<Document> getFilter(BasicSearchRequest request) {
        return (root, query, cb) -> Specification.where(byShortSummary(request.getSearch()))
                .and(byActive(request.getActive())).toPredicate(root, query, cb);
    }

    public Specification<Document> byActive(boolean value) {
        return (root, query, cb) -> cb.equal(root.get("active"), value);
    }

    public Specification<Document> byShortSummary(String value) {
        return (root, query, cb) -> {
            if (value == null) {
                return null;
            }
            return cb.like(
                    cb.lower(root.get("shortSummary")),
                    containsLowerCase(value)
            );
        };
    }

    protected String containsLowerCase(String searchField) {
        return "%" + searchField.toLowerCase() + "%";
    }
}
