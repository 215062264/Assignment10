package za.ac.cput.kyle.factory.info;

import za.ac.cput.kyle.domain.info.Race;

public class RaceFactory {

    public static Race getRace(String raceNum, String raceDescription) {
        return new Race.Builder()
                .raceNum(raceNum)
                .raceDescription(raceDescription)
                .build();
    }
}
