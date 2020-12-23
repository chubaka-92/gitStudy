package ru.study.java;

public class test {
    public static void main(String[] args) {

        //Договор
        Agreement agr1 = new Agreement("ОАО НОРКА","ИП Хозяин",120); //Договор
        System.out.println(agr1.toString());
        System.out.println("*****************");


        //проекты
        ConstructionProject proj1 = new ConstructionProject("Ремонт квартиры","В работе");
        System.out.println(proj1.toString());
        System.out.println("*****************");


        //этапы
        StageProject stage1Project1 = new StageProject("Дизайн-проект","Выполнено",12,10,2020,15,11,2020);
        System.out.println(stage1Project1.toString());
        System.out.println("*****************");

        StageProject stage2Project1 = new StageProject("Черновые работы","В работе",17,11,2020,22,12,2020);
        System.out.println(stage2Project1.toString());
        System.out.println("*****************");

        StageProject stage3Project1 = new StageProject("Чистовые работы","Ожидает начала работ",23,12,2020,25,2,2021);
        System.out.println(stage3Project1.toString());

/*        InfoShort agr = agr1;
        InfoShort proj = proj1;
        InfoShort stage2 = stage2Project1;*/

        shortInfo(agr1);
        shortInfo(proj1);
        shortInfo(stage1Project1);
        shortInfo(stage2Project1);
        shortInfo(stage3Project1);

        stage1Project1.editNameStage("");

        shortInfo(stage1Project1);


    }
    public static void shortInfo(InfoShort info){
        info.infoShort();
    }
}

