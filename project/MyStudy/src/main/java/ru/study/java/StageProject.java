package ru.study.java;

import ru.study.java.Validate.ValidEmptyValue;
import ru.study.java.Validate.ValidNegativeValue;
import ru.study.java.Validate.ValidOldValue;
import ru.study.java.Validate.ValidationException;

import java.time.DateTimeException;
import java.time.LocalDate;

public class StageProject{

    private int numberStage = 0;
    private String name = null;
    private Status status = null;
    private LocalDate startDate = null;
    private LocalDate endDate = null;
    private int priceStage = 0;

    public StageProject (){}

    public StageProject (int numbStage, String name, Status status, int priceStage) throws ValidationException {
        setNumberStage(numbStage);
        setNameStage(name);
        setStatusStage(status);
        setPriceStage(priceStage);
    }

    public StageProject (int numbStage, String name, Status status,
                         int startDay,int starMonth,int starYear,int endDay,int endMonth,int endYear,
                         int priceStage) throws DateTimeException, ValidationException {
        setNumberStage(numbStage);
        setNameStage(name);
        setStatusStage(status);
        setPriceStage(priceStage);
        setStartDate(startDay,starMonth,starYear);
        setEndDate(endDay,endMonth,endYear);
    }

    //возвращаем Номер Этапа
    public int getNumberStage() {
        return numberStage;
    }

    //возвращаем Название Этапа
    public String getName() {
        return name;
    }

    //возвращаем Статус Этапа
    public String getStatus() throws NullPointerException{
        return status.toString();
    }

    //возвращаем Дату начала Этапа
    public String getStartDate() throws NullPointerException{
        return startDate.toString();
    }

    //возвращаем Дату завершения Этапа
    public String getEndDate() throws NullPointerException{
        return endDate.toString();
    }

    //установка Даты начала Этапа
    public void setStartDate(int startDay,int starMonth,int starYear) throws DateTimeException{
        this.startDate = LocalDate.of(starYear,starMonth,startDay);
    }

    //установка Даты завершения Этапа
    public void setEndDate(int endDay,int endMonth,int endYear) throws DateTimeException{
        this.endDate = LocalDate.of(endYear,endMonth,endDay);
    }

    //Изменение цены этапа
    public void setPriceStage(int priceStage) {
        this.priceStage = priceStage;
    }

    //Получить стоимость этапа
    public int getPriceStage() {
        return priceStage;
    }

    //Изменяем Название Этапа
    public void setNameStage(String newName) throws ValidEmptyValue {
        if(!(newName.equals(""))){
            this.name = newName;
        } else {
            throw new ValidEmptyValue("Название не может быть пустым");
        }
    }

    //Изменяем статус
    public void setStatusStage(Status newStatus) throws ValidEmptyValue{
        if(newStatus != null){
            this.status = newStatus;
        } else {
            throw new ValidEmptyValue("Статус не может быть пустым");
        }
    }

    //установка номера Этапа
    public void setNumberStage(int numberStage) throws ValidationException {
        int oldNumbStage = this.numberStage;
        if (oldNumbStage == numberStage) {
            throw new ValidOldValue("Номер этапа: " + numberStage + " является текущим номером этапа");
        }
        if (numberStage < 0) {
            throw new ValidNegativeValue("Номер этапа не может быть отрицательным");
        } else {
            this.numberStage = numberStage;
        }
    }

    public String toString(){
        return "Этап: №" + numberStage + ". " + name + "\nСтатус этапа: " + status.toString() + "\nДата начала: " + startDate +
                "\nДата завершения: " + endDate;
    }
}

