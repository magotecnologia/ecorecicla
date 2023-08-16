package edu.unal.todosalau.ecorecicla.exception;

public class NotFoundUser extends Exception {
    public NotFoundUser() {
        super("No se han encontrado un usuario con el nombre dado");
    }
}
