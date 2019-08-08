package za.ac.cput.kyle.domain.info;

public class Gender {

    private String genderID;
    private String genderDescription;

    public Gender(Builder builder) {
        this.genderID = builder.genderID;
        this.genderDescription = builder.genderDescription;
    }

    public String getGenderID() {
        return genderID;
    }

    public void setGenderID(String genderID) {
        this.genderID = genderID;
    }

    public String getGenderDescription() {
        return genderDescription;
    }

    public void setGenderDescription(String genderDescription) {
        this.genderDescription = genderDescription;
    }

    public static class Builder {

        private String genderID;
        private String genderDescription;

        public Builder genderID(String genderID){
            this.genderID = genderID;
            return this;
        }

        public Builder genderDescription(String genderDescription){
            this.genderDescription = genderDescription;
            return this;
        }

        public Builder copy(Gender gender){
            this.genderID = gender.genderID;
            this.genderDescription = gender.genderDescription;
            return this;
        }

        public Gender build() {
            return new Gender(this);
        }

    }

    @Override
    public String toString() {
        return "Gender{" +
                "genderID='" + genderID + '\'' +
                ", genderDescription='" + genderDescription + '\'' +
                '}';
    }
}
