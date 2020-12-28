import org.junit.Assert;
import org.junit.Test;
import ru.study.java.Agreement;
import ru.study.java.ConstructionProject;
import ru.study.java.StageProject;
import ru.study.java.Status;

public class AgreementTest {
    @Test
    public void agreementTest() {
        Agreement agr = new Agreement("ОАО НОРКА","ИП Хозяин",120,9,8,2020);

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

        //дата создания договора
        String createdDateArgee = agr.getDateCreatedAgree();
        Assert.assertEquals("2020-08-09",createdDateArgee);


        //добавляем проекты под договор для подсчета проектов
        ConstructionProject proj1 = new ConstructionProject("Ремонт квартиры",Status.IN_PROGRESS);
        ConstructionProject proj2 = new ConstructionProject("Ремонт туалета",Status.PENDING_APPROVAL);

        agr.addProject(proj1);
        agr.addProject(proj2);
        //Количество проектов под договором
        int countProject = agr.countProjects();
        Assert.assertEquals(2,countProject);


        //добавляем этапы в проекты для расчеты стоимости договора
        proj1.addStage(new StageProject(1,"Дизайн-проект", Status.COMPLETED,
                12,10,2020,15,11,2020,50000));
        proj1.addStage( new StageProject(2, "Черновые работы",Status.IN_PROGRESS,
                17,11,2020,22,12,2020,85000));
        proj2.addStage(new StageProject(1, "Чистовые работы",Status.PENDING_START_WORK,
                23,12,2020,25,2,2021,200000));

        //проверяем сумму договора
        int priceAgree = agr.getPriceAgree();
        Assert.assertEquals(335000,priceAgree);

    }
}
