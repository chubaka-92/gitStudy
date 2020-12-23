package ru.study.java;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class StageProject implements InfoShort{

    private static int nextNumbStg = 1;
    private int numberStage = 0;
    private String name = null;
    private String status = null;
    private LocalDate startDate = null;
    private LocalDate endDate = null;
    private int priceStage = 0;

    public StageProject (){}

    public StageProject (String name, String status,
                         int startDay,int starMonth,int starYear,int endDay,int endMonth,int endYear, int priceStage){
        setNumberStage();
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
    public String getStatus() {
        return status;
    }

    //возвращаем Дату начала Этапа
    public LocalDate getStartDate() {
        return startDate;
    }

    //возвращаем Дату завершения Этапа
    public LocalDate getEndDate() {
        return endDate;
    }

    //установка номера Этапа
    private void setNumberStage(){
        this.numberStage = nextNumbStg;
        this.nextNumbStg++;
    }

    //установка Даты начала Этапа
    public void setStartDate(int startDay,int starMonth,int starYear){
        this.startDate = LocalDate.of(starYear,starMonth,startDay);
    }

    //установка Даты завершения Этапа
    public void setEndDate(int endDay,int endMonth,int endYear){
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
    public void setNameStage(String newName){
        if(!(newName.equals(""))){
            this.name = newName;
        } else {
            System.out.println("Название не может быть пустым");
        }
    }
    //Изменяем статус
    public void setStatusStage(String newStatus){
        if(!(newStatus.equals(""))){
            this.status = newStatus;
        } else {
            System.out.println("Статус не может быть пустым");
        }
    }

    public String toString(){
        return "Этап: №" + numberStage + ". " + name + "\nСтатус этапа: " + status + "\nДата начала: " + startDate +
                "\nДата завершения: " + endDate;
    }


    @Override
    public void infoShort() {
        System.out.println("Этап: №" + numberStage + ". " + name + ". Статус: " + status);
    }
}

