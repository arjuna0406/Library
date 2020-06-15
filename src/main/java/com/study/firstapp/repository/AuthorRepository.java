package com.study.firstapp.repository;

import com.study.firstapp.model.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    @Query(value = "select a from Author a where a.name like %:sSearch% or a.address like %:sSearch% " +
            "or a.gender like %:sSearch% or a.description like %:sSearch% ")
    Page<Author> getPageable(@Param("sSearch") String sSearch, Pageable pageable);
}
