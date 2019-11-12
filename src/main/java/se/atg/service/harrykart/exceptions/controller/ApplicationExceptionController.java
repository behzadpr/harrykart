package se.atg.service.harrykart.exceptions.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import se.atg.service.harrykart.exceptions.InvalidValueException;
import se.atg.service.harrykart.exceptions.ParticipantNotFoundException;

@ControllerAdvice
public class ApplicationExceptionController {
   @ExceptionHandler(value = ParticipantNotFoundException.class)
   public ResponseEntity<Object> exception(ParticipantNotFoundException exception) {
      return new ResponseEntity<>("Lanes and participants not matched", HttpStatus.NOT_FOUND);
   }

   @ExceptionHandler(value = InvalidValueException.class)
   public ResponseEntity<Object> exception(InvalidValueException exception) {
      return new ResponseEntity<>("Invalid value detected in input xml", HttpStatus.NOT_ACCEPTABLE);
   }
}