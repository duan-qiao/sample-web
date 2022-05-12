package cn.edu.seu.sky.advice;

import cn.edu.seu.sky.model.common.BaseResult;
import cn.edu.seu.sky.model.enums.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * @author xiaotian on 2022/5/11
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 无@RequestBody时报错
     * @param e BindException
     * @return BaseResult
     */
    @ExceptionHandler(BindException.class)
    public BaseResult<Void> bindExceptionHandler(BindException e) {
        String message = e.getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining("；"));
        return BaseResult.failure(message);
    }

    /**
     * 有@RequestBody时报错
     * @param e MethodArgumentNotValidException
     * @return BaseResult
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResult<Void> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining("；"));
        return BaseResult.failure(message);
    }

    /**
     * 有@RequestParam时报错
     * @param e ConstraintViolationException
     * @return BaseResult
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public BaseResult<Void> constraintViolationExceptionHandler(ConstraintViolationException e) {
        String message = e.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("；"));
        return BaseResult.failure(message);
    }

    @ExceptionHandler(Exception.class)
    public BaseResult<Void> exceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        return BaseResult.failure(ResultCode.FAIL);
    }
}
