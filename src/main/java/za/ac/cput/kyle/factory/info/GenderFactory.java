package za.ac.cput.kyle.factory.info;

import za.ac.cput.kyle.domain.info.Gender;

public class GenderFactory {

    public static Gender getGender(String genderID, String genderDescription) {
        return new Gender.Builder()
                .genderID(genderID)
                .genderDescription(genderDescription)
                .build();
    }

}
