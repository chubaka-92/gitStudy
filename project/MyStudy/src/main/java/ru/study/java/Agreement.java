package ru.study.java;


import java.time.LocalDate;
import java.util.Random;

public class Agreement implements InfoShort{
    private int numbAgree;
    private String nameAgree;
    private int nextNumberAgr= 1;
    private String client;
    private String contractor;
    private int deadLineDays = 0;
    private int massProjLengh = 0;
    private ConstructionProject [] massProjects = new ConstructionProject[massProjLengh];
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
        this.massProjLengh++;
        this.massProjects[massProjLengh-1] = project;
    }

    //Колличество проектов под договором
    public int countProjects(){ return massProjLengh; }

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

    public int getPriceAgree() {
        return priceAgree;
    }

    @Override
    public void infoShort() {
        System.out.println("№ договора: " + numbAgree + ". Сроки договора(в днях): " + deadLineDays);
    }


}

