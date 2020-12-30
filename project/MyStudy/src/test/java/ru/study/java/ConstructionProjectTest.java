package ru.study.java;

import org.junit.Assert;
import org.junit.Test;
import ru.study.java.validation.ValidEmptyValueExeption;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ConstructionProjectTest {
    /**
     * Проверка метода getName
     * Возвращает наименование проекта
     */
    @Test
    public void getNameTest(){
        ConstructionProject proj = new ConstructionProject("Ремонт квартиры", Status.IN_PROGRESS);

        Assert.assertEquals("Ремонт квартиры", proj.getName());
    }

    /**
     * Проверка метода getStatus
     * Возвращает статус проекта
     */
    @Test
    public void getStatusTest(){
        ConstructionProject proj = new ConstructionProject("Ремонт квартиры", Status.IN_PROGRESS);

        assertEquals("В работе", proj.getStatus());

    }

    /**
     * Проверка метода getPriceProject
     * Возвращает стоимость проекта без этапов
     */
    @Test
    public void getPriceProjectNullStageTest(){
        ConstructionProject proj = new ConstructionProject("Ремонт квартиры", Status.IN_PROGRESS);

        assertEquals(0,proj.getPriceProject());
    }

    /**
     * Проверка метода getCountStage
     * Возвращает количество этапов проекта(у которого нет этапов)
     */
    @Test
    public void getNullCountStageTest(){
        ConstructionProject proj = new ConstructionProject("Ремонт квартиры", Status.IN_PROGRESS);

        assertEquals(0,proj.getCountStage());
    }

    /**
     * Проверка метода getPriceProject
     * Возвращает стоимость проекта
     */
    @Test
    public void getPriceProjectTest(){
        ConstructionProject proj = new ConstructionProject("Ремонт квартиры", Status.IN_PROGRESS);

        //Добаление этапа под договор для повторной проверки стоимости проекта
        proj.addStage(new StageProject(1,"Дизайн-проект", Status.COMPLETED,
                12,10,2020,15,11,2020,50000));

        proj.addStage(new StageProject(2, "Черновые работы", Status.COMPLETED,
                16,11,2020,23,12,2020,150000));

        assertEquals(200000,proj.getPriceProject());
    }

    /**
     * Проверка метода getCountStage
     * Возвращает количество этапов проекта
     */
    @Test
    public void getCountStageTest(){
        ConstructionProject proj = new ConstructionProject("Ремонт квартиры", Status.IN_PROGRESS);

        //Добаление этапа под договор для повторной проверки количичества этапов
        proj.addStage(new StageProject(1,"Дизайн-проект", Status.COMPLETED,
                12,10,2020,15,11,2020,50000));

        proj.addStage(new StageProject(2, "Черновые работы", Status.COMPLETED,
                16,11,2020,23,12,2020,150000));

        assertEquals(2,proj.getCountStage());
    }

    /**
     * Проверка метода editNameProject
     * Задаем наименование проекта
     */
    @Test
    public void editNameProjectTest() {
        ConstructionProject proj = new ConstructionProject("Ремонт квартиры", Status.IN_PROGRESS);

        proj.editNameProject("Ремонт ванной");
        Assert.assertEquals("Ремонт ванной", proj.getName());
    }

    /**
     * Проверка метода editNameProject
     * Задаем Пустое наименование проекта
     */
    @Test
    public void editNameProjectExeptionTest(){
        ConstructionProject proj = new ConstructionProject("Ремонт квартиры", Status.IN_PROGRESS);

        ValidEmptyValueExeption valid = assertThrows(ValidEmptyValueExeption.class, () -> proj.editNameProject(""));
        assertEquals("Название проекта не может быть пустым",valid.getMessage());
    }

    /**
     * Проверка метода editStatusProject
     * Задаем статус проекта
     */
    @Test
    public void editStatusProjectTest() {
        ConstructionProject proj = new ConstructionProject("Ремонт квартиры", Status.IN_PROGRESS);

        //Проверка изменение статуса этапа
        proj.editStatusProject(Status.SUSPENDED);
        Assert.assertEquals("Приостановлен",proj.getStatus());
    }

    /**
     * Проверка метода editStatusProject
     * Задаем пустой статус проекта
     */
    @Test
    public void editStatusProjectExeptionTest() {
        ConstructionProject proj = new ConstructionProject("Ремонт квартиры", Status.IN_PROGRESS);

        ValidEmptyValueExeption valid = assertThrows(ValidEmptyValueExeption.class, () -> proj.editStatusProject(null));
        assertEquals("Статус проекта не может быть пустым",valid.getMessage());
    }

    /**
     * Проверка метода addStage
     * добавляем этап под проект
     */
    @Test
    public void addStageTest(){
        ConstructionProject proj = new ConstructionProject("Ремонт квартиры", Status.IN_PROGRESS);

        proj.addStage(new StageProject(1,"Дизайн-проект", Status.COMPLETED,
                12,10,2020,15,11,2020,50000));
        assertEquals(false,proj.isEmptyListProjects());
    }
}

