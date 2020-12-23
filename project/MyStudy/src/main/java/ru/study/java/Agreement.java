package ru.study.java;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Agreement implements InfoShort{
    private int numbAgree;
    private String nameAgree;
    private int nextNumberAgr= 1;
    private String client;
    private String contractor;
    private int deadLineDays = 0;
    private List<ConstructionProject> listProjects = new ArrayList<>();
    private LocalDate dateCreatedAgree;
    private int priceAgree = 0;

    {
        this.dateCreatedAgree = LocalDate.now();
    }

    public Agreement(){
    }

    public Agreement(String client, String contractor, int deadLineDays){

        this.client = client;
        this.contractor = contractor;
        this.deadLineDays = deadLineDays;
        setNumberAgree();
    }

    private void setNumberAgree(){
        this.numbAgree = nextNumberAgr;
        nextNumberAgr++;
    }

    public String toString(){
        return "№ договора: " + numbAgree + "\nКлиент: " + client +
                "\nИсполнитель: " + contractor + "\nСроки договора(в днях): " + deadLineDays +
                "\nДата создания: " + dateCreatedAgree;
    }

    //добавление проекта под договор
    public void addProject(ConstructionProject project){
        this.listProjects.add(project);
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

    //получаем стоимость проекта
    public int getPriceAgree() {
        if(listProjects.size() >= 0)
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

    @Override
    public void infoShort() {
        System.out.println("№ договора: " + numbAgree + ". Сроки договора(в днях): " + deadLineDays);
    }


}

