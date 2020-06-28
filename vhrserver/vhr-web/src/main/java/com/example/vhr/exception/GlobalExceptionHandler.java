package com.example.vhr.exception;

import com.example.vhr.model.RespBean;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MySQLIntegrityConstraintViolationException.class)
    public RespBean mySQLIntegrityConstraintViolationException(MySQLIntegrityConstraintViolationException e){
        if(e instanceof MySQLIntegrityConstraintViolationException){
            return RespBean.error("该数据有关联数据，操作失败");
        }
        return RespBean.error("数据库异常，操作失败");
    }
}
