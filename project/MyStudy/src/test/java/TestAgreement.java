import org.junit.Assert;
import org.junit.Test;
import ru.study.java.Agreement;

public class TestAgreement {
    @Test
    //public void testNewAgreement() throws Exception {
    public void testNewAgreement(){
        Agreement agr = new Agreement("ОАО НОРКА","ИП Хозяин",120);

        int numbAgree = agr.getNumbAgree();
        Assert.assertEquals(1,numbAgree);

        int dedlineDays = agr.getDeadLineDays();
        Assert.assertEquals(120,dedlineDays);

        String client = agr.getClient();
        Assert.assertEquals("ОАО НОРКА",client);

        String contractor = agr.getContractor();
        Assert.assertEquals("ИП Хозяин",contractor);

    }
}
