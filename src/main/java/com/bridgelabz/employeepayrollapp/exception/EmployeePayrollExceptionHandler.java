package com.bridgelabz.employeepayrollapp.exception;

import com.bridgelabz.employeepayrollapp.DTO.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;
@ControllerAdvice
public class EmployeePayrollExceptionHandler {

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
            List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
            List<String> errorMessage = errorList.stream().map(objectError -> objectError.getDefaultMessage())
                    .collect(Collectors.toList());
            ResponseDto responseDTO = new ResponseDto("Exception found : ",errorMessage);
            return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(EmployeePayrollException.class)
        public ResponseEntity<ResponseDto> handleEmployeePayrollException(EmployeePayrollException exception) {
            ResponseDto responseDTO = new ResponseDto("Exception found : ", exception.getMessage());
            return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
        }

    }
