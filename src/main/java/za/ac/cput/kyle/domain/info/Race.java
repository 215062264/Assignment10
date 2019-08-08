package za.ac.cput.kyle.domain.info;

public class Race {

    private String raceNum;
    private String raceDescription;

    public Race(Builder builder) {
        this.raceNum = builder.raceNum;
        this.raceDescription = builder.raceDescription;
    }

    public String getRaceNum() {
        return raceNum;
    }

    public void setRaceNum(String raceNum) {
        this.raceNum = raceNum;
    }

    public String getRaceDescription() {
        return raceDescription;
    }

    public void setRaceDescription(String raceDescription) {
        this.raceDescription = raceDescription;
    }

    public static class Builder {

        private String raceNum;
        private String raceDescription;

        public Builder raceNum(String raceNum){
            this.raceNum = raceNum;
            return this;
        }

        public Builder raceDescription(String raceDescription){
            this.raceDescription = raceDescription;
            return this;
        }

        public Builder copy(Race race){
            this.raceNum = race.raceNum;
            this.raceDescription = race.raceDescription;
            return this;
        }

        public Race build() {
            return new Race(this);
        }

    }

    @Override
    public String toString() {
        return "Race{" +
                "raceNum='" + raceNum + '\'' +
                ", raceDescription='" + raceDescription + '\'' +
                '}';
    }
}
