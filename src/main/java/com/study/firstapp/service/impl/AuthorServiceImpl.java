package com.study.firstapp.service.impl;

import com.study.firstapp.common.exception.ErrorCode;
import com.study.firstapp.common.exception.StudyException;
import com.study.firstapp.common.messages.DataTableObject;
import com.study.firstapp.model.Author;
import com.study.firstapp.repository.AuthorRepository;
import com.study.firstapp.service.AuthorService;
import com.study.firstapp.wrapper.AuthorWrapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    private AuthorWrapper toWrapper(Author entity){
        AuthorWrapper wrapper = new AuthorWrapper();
        if (entity != null) {
            wrapper.setId(entity.getId());
            wrapper.setDeleted(entity.getDeleted());
            wrapper.setDescription(entity.getDescription());
            wrapper.setVersion(entity.getVersion());

            wrapper.setName(entity.getName());
            wrapper.setAddress(entity.getAddress());
            wrapper.setGender(entity.getGender());
        }

        return wrapper;
    }

    private Author toEntity(AuthorWrapper wrapper){
        Author entity = new Author();
        if (wrapper.getId() != null){
            Optional<Author> optional = authorRepository.findById(wrapper.getId());
            if (optional.isPresent()){
                entity = optional.get();
            }
        }
        entity.setDescription(wrapper.getDescription());
        entity.setDeleted(wrapper.getDeleted());
        entity.setVersion(wrapper.getVersion());

        entity.setName(wrapper.getName());
        entity.setAddress(wrapper.getAddress());
        entity.setGender(wrapper.getGender());

        return entity;
    }

    private List<AuthorWrapper> toWrapperList(List<Author> modelList){
        List<AuthorWrapper> rList = new ArrayList<>();
        if (modelList != null && !modelList.isEmpty()){
            for (Author model : modelList){
                rList.add(toWrapper(model));
            }
        }
        return rList;
    }
    @Override
    public Long getNum() {
        return authorRepository.count();
    }

    @Override
    public AuthorWrapper save(AuthorWrapper wrapper) throws StudyException {
        return toWrapper(authorRepository.save(toEntity(wrapper)));
    }

    @Override
    public AuthorWrapper getById(Long pk) throws StudyException {
        Optional<Author> optionalAuthor = authorRepository.findById(pk);
        return optionalAuthor.map(this::toWrapper).orElse(null);
    }

    @Override
    public Boolean delete(Long pk) throws StudyException {
        try {
            authorRepository.deleteById(pk);
            return true;
        } catch (Exception e){
            throw new StudyException(e, ErrorCode.GENERIC_FAILURE);
        }
    }

    @Override
    public List<AuthorWrapper> getAll() throws StudyException {
        return toWrapperList((List<Author>) authorRepository.findAll());
    }

    @Override
    public void deleteAll() throws StudyException {
        // Do nothing
    }

    @Override
    public Page<AuthorWrapper> getPageableList(String sSearch, int startPage, int pageSize, Sort sort) throws StudyException {
        int page = DataTableObject.getPageFromStartAndLength(startPage, pageSize);
        if (authorRepository.count() == 0){
            return new PageImpl<>(new ArrayList<>(), PageRequest.of(page, pageSize, sort), 0);
        } else {
            Page<Author> authorPage = authorRepository.getPageable(sSearch,PageRequest.of(page, pageSize, sort));
            List<AuthorWrapper>wrapperList =toWrapperList(authorPage.getContent());
            return new PageImpl<>(wrapperList, PageRequest.of(page, pageSize, sort), authorPage.getTotalElements());
        }
    }
}
