package ru.study.java;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class StageProject implements InfoShort{

    private static int nextNumbStg = 1;
    private int numberStage;
    private String name;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;

    public StageProject (){}

    public StageProject (String name, String status, int startDay,int starMonth,int starYear,
                         int endDay,int endMonth,int endYear){
        setNumberStage();
        this.name = name;
        this.status = status;
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

    //Изменяем Название Этапа
    public void editNameStage(String newName){
        if(!(newName.equals(""))){
            this.name = newName;
        } else {
            System.out.println("Название не может быть пустым");
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

