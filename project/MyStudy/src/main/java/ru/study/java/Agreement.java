package ru.study.java;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Agreement{
    private int numbAgree;
    private int nextNumberAgr= 1;
    private String client;
    private String contractor;
    private int deadLineDays = 0;
    private List<ConstructionProject> listProjects = new ArrayList<>();
    private LocalDate dateCreatedAgree;
    private int priceAgree = 0;

    public Agreement(){}

    public Agreement(String client, String contractor, int deadLineDays, int createdDay,int createdMonth,int createdYear){
        this.client = client;
        this.contractor = contractor;
        this.deadLineDays = deadLineDays;
        setNumberAgree();
        setCreatedDate(createdDay,createdMonth,createdYear);
    }

    private void setNumberAgree(){
        this.numbAgree = nextNumberAgr;
        nextNumberAgr++;
    }

    private void setCreatedDate(int createdDay, int createdMonth, int createdYear) {
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
}

