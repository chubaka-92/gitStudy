package ru.study.java;


import ru.study.java.Validate.ValidNegativeValue;
import ru.study.java.Validate.ValidationException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Agreement{
    private int numbAgree;
    private static int nextNumberAgr= 1;
    private String client;
    private String contractor;
    private int deadLineDays = 0;
    private List<ConstructionProject> listProjects = new ArrayList<>();
    private LocalDate dateCreatedAgree;
    private int priceAgree = 0;

    public Agreement(String client, String contractor, int deadLineDays,
                     int createdDay,int createdMonth,int createdYear) throws DateTimeException, ValidationException {
        this.client = client;
        this.contractor = contractor;
        setDeadLineDays(deadLineDays);
        setNumberAgree();
        setCreatedDate(createdDay,createdMonth,createdYear);
    }

    //Установка номера договора
    private void setNumberAgree(){
        this.numbAgree = nextNumberAgr;
        nextNumberAgr++;
    }

    //Установка Колличества запланированных дней на договор
    public void setDeadLineDays(int deadLineDays) throws ValidNegativeValue{
        if (deadLineDays < 0) {
            throw new ValidNegativeValue("Колличество запланированных дней не может быть отрицательным");
        } else {
            this.deadLineDays = deadLineDays;
        }
    }

    //Установка даты создания договора
    private void setCreatedDate(int createdDay, int createdMonth, int createdYear) throws DateTimeException {
        this.dateCreatedAgree = LocalDate.of(createdYear,createdMonth,createdDay);
    }

    //добавление проекта под договор
    public void addProject(ConstructionProject project){
        this.listProjects.add(project);
    }

    public String toString(){
        return "№ договора: " + numbAgree + "\nКлиент: " + client +
                "\nИсполнитель: " + contractor + "\nСроки договора(в днях): " + deadLineDays +
                "\nДата создания: " + dateCreatedAgree;
    }

    //Колличество проектов под договором
    public int countProjects(){ return listProjects.size(); }

    public int getNumbAgree() {
        return numbAgree;
    }

    public String getClient() {
        return client;
    }

    public String getContractor() {
        return contractor;
    }

    public int getDeadLineDays() {
        return deadLineDays;
    }

    public String getDateCreatedAgree(){ return this.dateCreatedAgree.toString(); }

    //получаем стоимость проекта
    public int getPriceAgree() {
        if(listProjects.size() > 0)
            this.priceAgree = sumPriceStageAll(listProjects);
        return priceAgree;
    }

    //подсчет стоимости всех этапов
    private int sumPriceStageAll(List<ConstructionProject> listProjects){
        int sumPrice = 0;
        for (ConstructionProject proj : listProjects){
            sumPrice += proj.getPriceProject();
        }
        return sumPrice;
    }

    public boolean isEmptyListProjects() {
        return listProjects.size() == 0;
    }
}

