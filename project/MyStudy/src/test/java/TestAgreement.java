import org.junit.Assert;
import org.junit.Test;
import ru.study.java.Agreement;
import ru.study.java.ConstructionProject;
import ru.study.java.StageProject;

public class TestAgreement {
    @Test
    //public void testNewAgreement() throws Exception {
    public void testNewAgreement(){
        Agreement agr = new Agreement("ОАО НОРКА","ИП Хозяин",120);

        //номер договора
        int numbAgree = agr.getNumbAgree();
        Assert.assertEquals(1,numbAgree);

        //срок договора в днях
        int dedlineDays = agr.getDeadLineDays();
        Assert.assertEquals(120,dedlineDays);

        //клиент
        String client = agr.getClient();
        Assert.assertEquals("ОАО НОРКА",client);

        //Исполнитель
        String contractor = agr.getContractor();
        Assert.assertEquals("ИП Хозяин",contractor);

        //Количество проектов по договору
        ConstructionProject proj1 = new ConstructionProject("Ремонт квартиры","В работе");
        ConstructionProject proj2 = new ConstructionProject("Ремонт туалета","Согласование");

        agr.addProject(proj1);
        agr.addProject(proj2);
        int countProject = agr.countProjects();
        Assert.assertEquals(2,countProject);


        //добавляем этапы
        proj1.addStage(new StageProject("Дизайн-проект","Выполнено",
                12,10,2020,15,11,2020,50000));
        proj1.addStage( new StageProject("Черновые работы","В работе",
                17,11,2020,22,12,2020,85000));
        proj2.addStage(new StageProject("Чистовые работы","Ожидает начала работ",
                23,12,2020,25,2,2021,200000));

        //проверяем сумму договора
        int priceAgree = agr.getPriceAgree();
        Assert.assertEquals(335000,priceAgree);

    }
}
