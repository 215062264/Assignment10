package za.ac.cput.kyle.factory.info;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.kyle.domain.info.Gender;
import za.ac.cput.kyle.factory.info.GenderFactory;

public class GenderFactoryTest {

    @Test
    public void getGender(){

        String genderID = "2";
        String genderDescription = "Female";

        Gender gender = GenderFactory.getGender(genderID,genderDescription);
        System.out.println(gender);
        Assert.assertNotNull(gender.getGenderID()+"\n"+gender.getGenderDescription());

    }

}
