package ru.study.java;

public enum Status {
    NEW("Новый"),
    PLANNING("Планирование"),
    PENDING_APPROVAL("На согласовании"),
    AGREED("Cогласован"),
    NOT_APPROVAL("Не согласован"),
    PENDING_START_WORK("Ожидает начала работ"),
    IN_PROGRESS("В работе"),
    SUSPENDED("Приостановлен"),
    COMPLETED("Завершен");

    private String translation;

    Status(String translation){
        this.translation = translation;
    }

    public static boolean contains (Status stat){
        for (Status status : Status.values()){
            if(status.equals(stat)){
                return true;
            }
        }
        return false;
    }

    public String toString(){
        return translation;
    }
}
