package com.study.firstapp.controller;

import com.study.firstapp.common.controller.BaseController;
import com.study.firstapp.common.exception.StudyException;
import com.study.firstapp.common.response.CommonResponses;
import com.study.firstapp.common.response.CustomReturn;
import com.study.firstapp.service.AuthorService;
import com.study.firstapp.wrapper.AuthorWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/study/author")
public class AuthorController extends BaseController {
    private static Logger logger = LogManager.getLogger(AuthorController.class.getName());

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = "/list")
    public CustomReturn<Page<AuthorWrapper>> getListAuthor(String search, Integer pageSize, Integer startPage, String sortBy, String sortOrder) throws StudyException {
        CommonResponses<Page<AuthorWrapper>> commonResponses = new CommonResponses<>();
        Sort sort = new Sort(Sort.Direction.fromString(sortOrder), sortBy);
        Page<AuthorWrapper> pageable = authorService.getPageableList(search, startPage, pageSize, sort);
        if (pageable != null) {
            logger.info(STR_SUCCESS);
            return commonResponses.commonSuccessResponse(pageable);
        } else {
            logger.info(STR_FAILED);
            return commonResponses.commonFailedResponse();
        }
    }
    @GetMapping(value = "/id/{id}")
    public CustomReturn<AuthorWrapper> getById(@PathVariable Long id) throws StudyException {
        CommonResponses<AuthorWrapper> commonResponses = new CommonResponses<>();
        try {
            AuthorWrapper wrapper = authorService.getById(id);
            if (wrapper != null){
                return commonResponses.commonSuccessResponse(wrapper);
            } else {
                return commonResponses.commonFailedResponse();
            }
        } catch (Exception e){
            logger.error(e);
            return commonResponses.commonFailedError(e);
        }
    }
    @PostMapping(value = "/save")
    public CustomReturn<AuthorWrapper> save(@RequestBody AuthorWrapper authorWrapper){
        CommonResponses<AuthorWrapper> commonResponses = new CommonResponses<>();
        try {
            AuthorWrapper wrapper = authorService.save(authorWrapper);
            if (wrapper != null){
                wrapper.setDeleted(false);
                wrapper.setVersion(1);
                return commonResponses.commonSuccessResponse(wrapper);
            } else {
                return commonResponses.commonFailedResponse();
            }
        }catch (Exception e){
            logger.error(e);
            return commonResponses.commonFailedError(e);
        }
    }
    @DeleteMapping(value = "/delete/{id}")
    public CustomReturn<AuthorWrapper> delete(@PathVariable Long id) {
        CommonResponses<AuthorWrapper> commonResponses = new CommonResponses<>();
        try {
            return commonResponses.commonDeleteSuccess();
        } catch (Exception e){
            logger.error(e);
            return commonResponses.commonFailedError(e);
        }

    }
    @PutMapping(value = "/update/{id}")
    public CustomReturn<AuthorWrapper> update(@PathVariable Long id, @RequestBody AuthorWrapper wrapper){
        CommonResponses<AuthorWrapper> commonResponses = new CommonResponses<>();
        try {
            AuthorWrapper oldData = authorService.getById(id);
            if (oldData != null){
                oldData.setDeleted(false);
                oldData.setVersion(1);
                oldData.setName(wrapper.getName());
                oldData.setAddress(wrapper.getAddress());
                oldData.setGender(wrapper.getGender());
                AuthorWrapper newData = authorService.save(oldData);
                return commonResponses.commonSuccessResponse(newData);
            }else {
                return commonResponses.commonFailedResponse();
            }

        }catch (Exception e){
            logger.error(e);
            return commonResponses.commonFailedError(e);
        }
    }
}
