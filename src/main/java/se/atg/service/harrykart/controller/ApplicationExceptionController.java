package se.atg.service.harrykart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionController {
   @ExceptionHandler(value = ParticipantNotFoundException.class)
   public ResponseEntity<Object> exception(ParticipantNotFoundException exception) {
      return new ResponseEntity<>("Lanes and participants not matched", HttpStatus.NOT_FOUND);
   }
}