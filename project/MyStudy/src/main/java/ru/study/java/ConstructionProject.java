package ru.study.java;

import java.util.ArrayList;
import java.util.List;

public class ConstructionProject{

    private String name;
    private Status status;
    private List<StageProject> listStages = new ArrayList<>();
    private int priceProject = 0;

    public ConstructionProject(){}

    public ConstructionProject(String name, Status status){
        editNameProject(name);
        editStatusProject(status);
    }

    public String toString(){
        return "Название проекта: " + name + "\nСтатус: " + status.toString();
    }

    public void editNameProject(String newName) {
        if(!(newName.equals(""))){
            this.name = newName;
        } else {
            System.out.println("Название проекта не может быть пустым");
        }
    }

    public void editStatusProject(Status newStatus) {
        if(newStatus != null){
            this.status = newStatus;
        } else {
            System.out.println("Статус проекта не может быть пустым");
        }
    }

    public String getName() { return name; }

    public String getStatus() { return status.toString(); }

    //Добавление Этапа в проект
    public void addStage(StageProject stage){
        this.listStages.add(stage);
    }

    //получаем количество этапов в проекте
    public int getCountStage(){
        return this.listStages.size();
    }

    //получаем стоимость проекта
    public int getPriceProject() {
        if(listStages.size() >= 0){
            this.priceProject = sumPriceStageAll(listStages);}
        return priceProject;
    }

    //подсчет стоимости всех этапов
    private int sumPriceStageAll(List<StageProject> listStages){
        int sumPrice = 0;

        for (StageProject stage : listStages){
            sumPrice += stage.getPriceStage();
        }
        return sumPrice;
    }
}
