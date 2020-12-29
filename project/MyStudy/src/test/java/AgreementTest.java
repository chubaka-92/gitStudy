import org.junit.Assert;
import org.junit.Test;
import ru.study.java.Agreement;
import ru.study.java.ConstructionProject;
import ru.study.java.StageProject;
import ru.study.java.Status;

public class AgreementTest {
    /**
     * Проверка метода getNumbAgree
     * Возвращает номер договора
     */
    @Test
    public void getNumbAgreeTest(){
        Agreement agr = new Agreement("ОАО НОРКА","ИП Хозяин",120,9,8,2020);

        Assert.assertEquals(9, agr.getNumbAgree());
    }

    /**
     * Проверка метода getDeadLineDays
     * Возвращает Колличество запланированных дней договора
     */
    @Test
    public void getDeadLineDaysTest(){
        Agreement agr = new Agreement("ОАО НОРКА","ИП Хозяин",120,9,8,2020);

        Assert.assertEquals(120, agr.getDeadLineDays());
    }

    /**
     * Проверка метода getClient
     * Возвращает клиента договора
     */
    @Test
    public void getClientTest(){
        Agreement agr = new Agreement("ОАО НОРКА","ИП Хозяин",120,9,8,2020);

        Assert.assertEquals("ОАО НОРКА", agr.getClient());
    }

    /**
     * Проверка метода getContractor
     * Возвращает исполнителя договора
     */
    @Test
    public void getContractorTest(){
        Agreement agr = new Agreement("ОАО НОРКА","ИП Хозяин",120,9,8,2020);

        Assert.assertEquals("ИП Хозяин", agr.getContractor());
    }

    /**
     * Проверка метода getDateCreatedAgree
     * Возвращает дату создания договора
     */
    @Test
    public void getDateCreatedAgreeTest(){
        Agreement agr = new Agreement("ОАО НОРКА","ИП Хозяин",120,9,8,2020);

        Assert.assertEquals("2020-08-09", agr.getDateCreatedAgree());
    }

    /**
     * Проверка метода countProjects
     * Возвращает количество проектов под договором
     */
    @Test
    public void nullCountProjectsTest(){
        Agreement agr = new Agreement("ОАО НОРКА","ИП Хозяин",120,9,8,2020);

        Assert.assertEquals(0,agr.countProjects());
    }

    /**
     * Проверка метода getPriceAgree
     * Возвращает стоимость договора (без проектов)
     */
    @Test
    public void getNullPriceAgreeTest(){
        Agreement agr = new Agreement("ОАО НОРКА","ИП Хозяин",120,9,8,2020);

        Assert.assertEquals(0,agr.getPriceAgree());
    }

    /**
     * Проверка метода countProjects
     * Возвращает количество проектов под договором
     */
    @Test
    public void countProjectsTest(){
        Agreement agr = new Agreement("ОАО НОРКА","ИП Хозяин",120,9,8,2020);

        //добавляем проекты под договор для подсчета проектов
        agr.addProject(new ConstructionProject("Ремонт квартиры",Status.IN_PROGRESS));
        agr.addProject(new ConstructionProject("Ремонт туалета",Status.PENDING_APPROVAL));

        Assert.assertEquals(2,agr.countProjects());
    }

    /**
     * Проверка метода getPriceAgree
     * Возвращает стоимость договора
     */
    @Test
    public void getPriceAgreeTest(){
        Agreement agr = new Agreement("ОАО НОРКА","ИП Хозяин",120,9,8,2020);

        //добавляем проекты под договор для подсчета проектов
        ConstructionProject proj1 = new ConstructionProject("Ремонт квартиры",Status.IN_PROGRESS);
        ConstructionProject proj2 = new ConstructionProject("Ремонт туалета",Status.PENDING_APPROVAL);

        agr.addProject(proj1);
        agr.addProject(proj2);

        proj1.addStage(new StageProject(1,"Дизайн-проект", Status.COMPLETED,
                12,10,2020,15,11,2020,50000));
        proj1.addStage( new StageProject(2, "Черновые работы",Status.IN_PROGRESS,
                17,11,2020,22,12,2020,85000));
        proj2.addStage(new StageProject(1, "Чистовые работы",Status.PENDING_START_WORK,
                23,12,2020,25,2,2021,200000));

        Assert.assertEquals(335000,agr.getPriceAgree());
    }

    /**
     * Проверка метода addProject
     * добавляем новый проект под договором
     */
    @Test
    public void addProjectTest(){
        Agreement agr = new Agreement("ОАО НОРКА","ИП Хозяин",120,9,8,2020);

        agr.addProject(new ConstructionProject("Ремонт квартиры",Status.IN_PROGRESS));
        Assert.assertEquals(false,agr.isEmptyListProjects());
    }
}
