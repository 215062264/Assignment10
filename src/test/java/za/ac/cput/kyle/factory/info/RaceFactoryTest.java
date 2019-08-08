package za.ac.cput.kyle.factory.info;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.kyle.domain.info.Race;
import za.ac.cput.kyle.factory.info.RaceFactory;

public class RaceFactoryTest  {

    @Test
    public void getRace(){

        String raceNum = "2";
        String raceDescription = "Arab";

        Race race = RaceFactory.getRace(raceNum,raceDescription);
        System.out.println(race);
        Assert.assertNotNull(race.getRaceNum()+"\n"+race.getRaceDescription());

    }

}
