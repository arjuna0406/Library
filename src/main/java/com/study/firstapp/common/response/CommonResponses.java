package com.study.firstapp.common.response;

import com.study.firstapp.common.controller.BaseController;

public class CommonResponses<T> extends BaseController {

	public CustomReturn<T> commonSuccessResponse(T wrapper) {
		CustomReturn<T> customReturn = new CustomReturn<>();
		customReturn.setMessage(STR_SUCCESS);
		customReturn.setStatus("200");
		customReturn.setDatas(wrapper);
		return customReturn;
	}

	public CustomReturn<T> commonFailedResponse() {
		CustomReturn<T> customReturn = new CustomReturn<>();
		customReturn.setMessage(STR_FAILED);
		customReturn.setStatus("200");
		return customReturn;
	}

	public CustomReturn<T> commonDeleteSuccess(){
		CustomReturn<T> customReturn = new CustomReturn<>();
		customReturn.setMessage(STR_SUCCESS);
		customReturn.setStatus("200");
		return customReturn;
	}



	public CustomReturn<T> commonFailedError(Exception exception) {
		CustomReturn<T> customReturn = new CustomReturn<>();
		customReturn.setMessage(STR_ERROR);
		customReturn.setStatus("500");
		customReturn.setDetail(exception);
		return customReturn;
	}

}
