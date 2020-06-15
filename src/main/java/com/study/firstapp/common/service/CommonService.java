package com.study.firstapp.common.service;

import com.study.firstapp.common.exception.StudyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by josescalia on 11/03/15.
 */
public interface CommonService<T, Z> {

    Long getNum();

    T save(T wrapper) throws StudyException;

    T getById(Z pk) throws StudyException;

    Boolean delete(Z pk) throws StudyException;

    List<T> getAll() throws StudyException;

    void deleteAll() throws StudyException;

    //pageable
    Page<T> getPageableList(String sSearch, int startPage, int pageSize, Sort sort) throws StudyException;
}
