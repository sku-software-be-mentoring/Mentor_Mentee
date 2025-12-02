package com.example.mentor_mentee.global.exception;

import com.example.mentor_mentee.global.base.BaseResponse;
import com.example.mentor_mentee.global.exception.model.BaseErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
// 전역 예외 처리를 해주는 어노테이션
// 모든 @RestController에서 발생한 예외를 잡아서 처리해줌
@RestControllerAdvice
public class GlobalExceptionHandler {
  // CustomException 예외 처리
  @ExceptionHandler(CustomException.class)
  public ResponseEntity<BaseResponse<?>> handleCustomException(CustomException e){
    BaseErrorCode baseErrorCode = e.getErrorCode();
    log.error("Custom 오류 발생: {}", e.getErrorCode());
    return ResponseEntity
        .status(baseErrorCode.getStatus()) // ResponseEntity에 Http status 설정
        .body(BaseResponse.error(baseErrorCode.getCode(), baseErrorCode.getMessage()));
  }

  // Exception 최후의 보루 예외 처리
  @ExceptionHandler(Exception.class)
  public ResponseEntity<BaseResponse<?>> handleException(Exception e){
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(BaseResponse.error("500", e.getMessage()));
  }
}