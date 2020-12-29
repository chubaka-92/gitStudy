import org.junit.Test;
import ru.study.java.*;
import ru.study.java.Validate.ValidEmptyValue;
import ru.study.java.Validate.ValidNegativeValue;
import ru.study.java.Validate.ValidOldValue;

import java.time.DateTimeException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertEquals;

public class StageProjectTest {
    /**
     * Проверка метода getName
     * Возвращает наименование этапа
     */
    @Test
    public void getNameTest(){
        StageProject stage = new StageProject(1,"Дизайн-проект", Status.COMPLETED,
                13,10,2020,15,11,2020,50000);

        assertEquals("Дизайн-проект", stage.getName());
    }

    /**
     * Проверка метода getNumberStage
     * Возвращает номер этапа
     */
    @Test
    public void getNumberStageTest(){
        StageProject stage = new StageProject(1,"Дизайн-проект", Status.COMPLETED,
                13,10,2020,15,11,2020,50000);

        assertEquals(1,stage.getNumberStage());
    }

    /**
     * Проверка метода getStatus
     * Возвращает статус этапа
     */
    @Test
    public void getStatusTest(){
        StageProject stage = new StageProject(1, "Дизайн-проект", Status.COMPLETED,
                    13, 10, 2020, 15, 11, 2020, 50000);

        assertEquals("Завершен", stage.getStatus());
    }

    /**
     * Проверка метода getStartDate
     * Возвращает дату старта этапа
     */
    @Test
    public void getStartDateTest(){
        StageProject stage = new StageProject(1,"Дизайн-проект", Status.COMPLETED,
                13,10,2020,15,11,2020,50000);

        assertEquals("2020-10-13",stage.getStartDate());
    }

    /**
     * Проверка метода getEndDate
     * Возвращает дату окончания этапа
     */
    @Test
    public void getEndDateTest(){
        StageProject stage = new StageProject(1,"Дизайн-проект", Status.COMPLETED,
                12,10,2020,15,11,2020,50000);

        assertEquals("2020-11-15",stage.getEndDate());
    }

    /**
     * Проверка метода getPriceStage
     * Возвращает стоимость этапа
     */
    @Test
    public void getPriceStageTest(){
        StageProject stage = new StageProject(1,"Дизайн-проект", Status.COMPLETED,
                    12,10,2020,15,11,2020,50000);

        assertEquals(50000, stage.getPriceStage());
    }

    /**
     * Проверка метода setNameStage
     * Задаем наименование этапа
     */
    @Test
    public void setNameStageTest() {
        StageProject stage = new StageProject(1,"Дизайн-проект", Status.COMPLETED,
                    13,10,2020,15,11,2020,50000);

        stage.setNameStage("Черновые работы");
        assertEquals("Черновые работы", stage.getName());
    }

    /**
     * Проверка метода setNameStage
     * Задаем Пустое наименование этапа
     */
    @Test
    public void setEmptyNameStageExeptionTest()  throws ValidEmptyValue {
        StageProject stage = new StageProject(1,"Дизайн-проект", Status.COMPLETED,
                    13,10,2020,12,11,2020,50000);

        ValidEmptyValue valid = assertThrows(ValidEmptyValue.class, () -> stage.setNameStage(""));
           //assertNotNull(valid.getMessage());
        assertEquals("Название не может быть пустым",valid.getMessage());
    }

    /**
     * Проверка метода setNumberStage
     * Задаем номер этапа
     */
    @Test
    public void setNumberStageTest(){
        StageProject stage = new StageProject(1,"Дизайн-проект", Status.COMPLETED,
                    13,10,2020,15,11,2020,50000);
        int newNumbStage = 2;
        stage.setNumberStage(newNumbStage);
        assertEquals(newNumbStage,stage.getNumberStage());
    }

    /**
     * Проверка метода setNumberStage
     * Задаем текущий номер этапа
     */
    @Test
    public void setOldNumberStageExeptionTest(){
        StageProject stage = new StageProject(1,"Дизайн-проект", Status.COMPLETED,
                13,10,2020,15,11,2020,50000);
        int newNumbStage = 1;
        ValidOldValue valid = assertThrows(ValidOldValue.class, () ->  stage.setNumberStage(newNumbStage) );
        assertEquals("Номер этапа: " + newNumbStage + " является текущим номером этапа", valid.getMessage());
    }

    /**
     * Проверка метода setNumberStage
     * Задаем отрецательный номер этапа
     */
    @Test
    public void setNegativeNumberStageExeptionTest(){
        StageProject stage = new StageProject(1,"Дизайн-проект", Status.COMPLETED,
                13,10,2020,15,11,2020,50000);
        int newNumbStage = -2;
        ValidNegativeValue valid = assertThrows(ValidNegativeValue.class, () -> { stage.setNumberStage(newNumbStage); });
        assertEquals("Номер этапа не может быть отрицательным", valid.getMessage());
    }

    /**
     * Проверка метода setStatusStage
     * Задаем статус этапа
     */
    @Test
    public void setStatusStageTest(){
        StageProject stage = new StageProject(1, "Дизайн-проект", Status.COMPLETED,
                    13, 10, 2020, 15, 11, 2020, 50000);
        stage.setStatusStage(Status.AGREED);
        String statusStage = stage.getStatus();
        assertEquals("Cогласован", statusStage);
    }

    /**
     * Проверка метода setStatusStage
     * Задаем пустой статус этапа
     */
    @Test
    public void setEmptyStatusStageExeptionTest(){
        StageProject stage = new StageProject(1, "Дизайн-проект", Status.COMPLETED,
                    13, 10, 2020, 15, 11, 2020, 50000);

        ValidEmptyValue valid = assertThrows(ValidEmptyValue.class, () -> { stage.setStatusStage(null); });
        assertEquals("Статус не может быть пустым", valid.getMessage());
    }

    /**
     * Проверка метода setStartDate
     * Задаем дату старта этапа
     */
    @Test
    public void setStartDateTest(){
        StageProject stage = new StageProject(1,"Дизайн-проект", Status.COMPLETED,
                13,10,2020,15,11,2020,50000);

        stage.setStartDate(25,9,2020);
        assertEquals("2020-09-25",stage.getStartDate());
    }

    /**
     * Проверка метода setStartDate
     * Задаем не корректную дату старта этапа
     */
    @Test
    public void setNoValidStartDateTest(){
        StageProject stage = new StageProject(1,"Дизайн-проект", Status.COMPLETED,
                13,10,2020,15,11,2020,50000);

        //не корректный день
        DateTimeException valid = assertThrows(DateTimeException.class, () ->
                                            { stage.setStartDate(45,9,2020); });
        assertNotNull(valid.getMessage());

        //не корректный месяц
        valid = assertThrows(DateTimeException.class, () -> { stage.setStartDate(15,16,2020); });
        assertNotNull(valid.getMessage());
    }

    /**
     * Проверка метода setEndDate
     * Задаем дату окончания этапа
     */
    @Test
    public void setEndDateTest(){
        StageProject stage = new StageProject(1,"Дизайн-проект", Status.COMPLETED,
                12,10,2020,15,11,2020,50000);

        stage.setEndDate(23,12,2020);
        assertEquals("2020-12-23",stage.getEndDate());
    }

    /**
     * Проверка метода setEndDate
     * Задаем не корректную дату завершения этапа
     */
    @Test
    public void setNoValidEndDateTest(){
        StageProject stage = new StageProject(1,"Дизайн-проект", Status.COMPLETED,
                12,10,2020,15,11,2020,50000);

        //не корректный день
        DateTimeException valid = assertThrows(DateTimeException.class, () ->
                                            { stage.setEndDate(45,9,2020); });
        assertNotNull(valid.getMessage());

        //не корректный месяц
        valid = assertThrows(DateTimeException.class, () -> { stage.setEndDate(15,13,2020); });
        assertNotNull(valid.getMessage());
    }
}
