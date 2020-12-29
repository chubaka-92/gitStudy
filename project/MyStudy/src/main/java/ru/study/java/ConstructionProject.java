package ru.study.java;

import ru.study.java.Validate.ValidEmptyValue;

import java.util.ArrayList;
import java.util.List;

public class ConstructionProject{

    private String name;
    private Status status;
    private List<StageProject> listStages = new ArrayList<>();
    private long priceProject = 0;

    public ConstructionProject(String name, Status status){
        editNameProject(name);
        editStatusProject(status);
    }

    public String toString(){
        return "Название проекта: " + name + "\nСтатус: " + status.toString();
    }

    //Изменение имени проекта
    public void editNameProject(String newName){
        if(!(newName.equals(""))){
            this.name = newName;
        } else {
            throw new ValidEmptyValue("Название проекта не может быть пустым");
        }
    }

    //Изменение статуса проекта
    public void editStatusProject(Status newStatus) {
        if(newStatus != null){
            this.status = newStatus;
        } else {
            throw new ValidEmptyValue("Статус проекта не может быть пустым");
        }
    }

    //Добавление Этапа в проект
    public void addStage(StageProject stage){
        this.listStages.add(stage);
    }

    public String getName() { return name; }

    public String getStatus() { return status.toString(); }

    //получаем количество этапов в проекте
    public int getCountStage(){
        return this.listStages.size();
    }

    //получаем стоимость проекта
    public long getPriceProject() {
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

    public boolean isEmptyListProjects() {
        return listStages.size() == 0;
    }

}
