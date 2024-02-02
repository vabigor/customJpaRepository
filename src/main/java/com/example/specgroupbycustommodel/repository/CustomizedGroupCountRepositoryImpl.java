package com.example.specgroupbycustommodel.repository;

import com.example.specgroupbycustommodel.entity.Document;
import com.example.specgroupbycustommodel.repository.model.DocGroupStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class CustomizedGroupCountRepositoryImpl implements CustomizedGroupCountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<DocGroupStatus> groupAndCount(Specification<Document> specification) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        final Root<Document> root = query.from(Document.class);
        final Path<String> expression = root.get("status");
        expression.alias("status");
        query.multiselect(expression, criteriaBuilder.count(root));
        query.select(criteriaBuilder.tuple(expression, criteriaBuilder.count(root).alias("sCount")));
        query.where(specification.toPredicate(root, query, criteriaBuilder));
        query.groupBy(expression);
        final List<Tuple> resultList = entityManager.createQuery(query).getResultList();
        return resultList.stream().map(r -> new DocGroupStatus().setStatus(r.get("status").toString()).setCount((Long) r.get("sCount"))).toList();
    }

}
