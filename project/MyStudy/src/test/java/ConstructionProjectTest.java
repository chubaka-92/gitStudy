import org.junit.Assert;
import org.junit.Test;
import ru.study.java.ConstructionProject;
import ru.study.java.StageProject;
import ru.study.java.Status;

public class ConstructionProjectTest {
    @Test
    public void constructionProjectTest(){
        ConstructionProject proj = new ConstructionProject("Ремонт квартиры", Status.IN_PROGRESS);

        //Проверка названия созданного этапа
        String nameProj = proj.getName();
        Assert.assertEquals("Ремонт квартиры",nameProj);

        //Проверка статуса созданного этапа
        String statusProj = proj.getStatus();
        Assert.assertEquals("В работе",statusProj);

        //Проверка стоимости этапа
        int price = proj.getPriceProject();
        Assert.assertEquals(0,price);

        //проверка количества этапов в проете
        int countStage = proj.getCountStage();
        Assert.assertEquals(0,countStage);

        //Добаление этапа под договор для повторной проверки количичества этапов и стоимости проекта
        proj.addStage(new StageProject(1,"Дизайн-проект", Status.COMPLETED,
                12,10,2020,15,11,2020,50000));

        price = proj.getPriceProject();
        Assert.assertEquals(50000,price);

        countStage = proj.getCountStage();
        Assert.assertEquals(1,countStage);

        proj.addStage(new StageProject(2, "Черновые работы", Status.COMPLETED,
                16,11,2020,23,12,2020,150000));

        price = proj.getPriceProject();
        Assert.assertEquals(200000,price);

        countStage = proj.getCountStage();
        Assert.assertEquals(2,countStage);

        //Проверка изменение названия этапа
        proj.editNameProject("Ремонт квартиры");
        nameProj = proj.getName();
        Assert.assertEquals("Ремонт квартиры",nameProj);

        //Проверка изменение статуса этапа
        proj.editStatusProject(Status.SUSPENDED);
        statusProj = proj.getStatus();
        Assert.assertEquals("Приостановлен",statusProj);

    }
}

