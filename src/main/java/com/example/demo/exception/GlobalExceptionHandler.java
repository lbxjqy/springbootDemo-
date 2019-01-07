package com.example.demo.exception;

import com.example.demo.entity.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonHandler(HttpServletRequest req, Exception e) {
        System.out.println("MyException");
        ErrorInfo<String> r = new ErrorInfo<String>();
        r.setCode(-1);
        r.setMessage("系统繁忙");
        r.setUrl(req.getRequestURL().toString());
        r.setData("some data");
        return r;
    }
}
