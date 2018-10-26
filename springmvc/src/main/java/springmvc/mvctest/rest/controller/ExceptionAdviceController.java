package springmvc.mvctest.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import springmvc.mvctest.rest.exception.BookNotFoundException;
import springmvc.mvctest.rest.exception.Error;
/**
 * controller增强处理
 * @author WZM
 *
 * 2018年10月8日
 */
@ControllerAdvice
public class ExceptionAdviceController {

	/**
	 * 自定义异常处理 返回给客户端
	 * @param e
	 * @return 
	 */
	@ExceptionHandler(BookNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody springmvc.mvctest.rest.exception.Error bookNotFound(BookNotFoundException e) {
		Integer bno = e.getBno();
		return new Error(4, "book [" + bno + "] not found");
	}
}
