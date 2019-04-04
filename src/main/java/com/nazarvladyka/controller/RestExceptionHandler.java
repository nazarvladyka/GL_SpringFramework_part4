package com.nazarvladyka.controller;

//@ControllerAdvice
//public class RestExceptionHandler extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler({ HeroNotFoundException.class })
//    protected ResponseEntity<Object> handleNotFound(
//            Exception ex, WebRequest request) {
//        return handleExceptionInternal(ex, "Book not found",
//                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
//    }
//
//    @ExceptionHandler({ HeroIdMismatchException.class,
//            ConstraintViolationException.class,
//            DataIntegrityViolationException.class })
//    public ResponseEntity<Object> handleBadRequest(
//            Exception ex, WebRequest request) {
//        return handleExceptionInternal(ex, ex.getLocalizedMessage(),
//                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
//    }
//}
