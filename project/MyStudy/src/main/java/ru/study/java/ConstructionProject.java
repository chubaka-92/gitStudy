package ru.study.java;

public class ConstructionProject implements InfoShort{

    private String name;
    private String status;
    private int massStageLength = 0;
    private StageProject [] massStages = new StageProject[massStageLength];
    private int priceAgree = 0;

    public ConstructionProject(){}

    public ConstructionProject(String name, String status){
        this.name = name;
        this.status = status;
    }

    public String toString(){
        return "Название проекта: " + name + "\nСтатус: " + status;
    }

    public void editNameProject(String newName) {
        if(!(newName.equals(""))){
            this.name = newName;
        } else {
            System.out.println("Название проекта не может быть пустым");
        }
    }

    public void editStatusProject(String newStatus) {
        if(newStatus != null){
            this.status = newStatus;
        } else {
            System.out.println("Статус проекта не может быть пустым");
        }
    }

    public String getName() { return name; }

    public String getStatus() { return status; }


    //Добавление Этапа в проект
    public void addStage(StageProject stage){
        this.massStageLength++;
        this.massStages[massStageLength-1] = stage;
    }

    @Override
    public void infoShort() {
        System.out.println("Название проекта: " + name + ". Статус: " + status);
    }
}
