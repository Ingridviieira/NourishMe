package br.com.NourishMe.exception;

public record RestValidationError(String field, String message) {}
