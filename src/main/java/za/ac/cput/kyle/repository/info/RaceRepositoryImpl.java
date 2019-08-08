package za.ac.cput.kyle.repository.info;

import za.ac.cput.kyle.domain.info.Race;

import java.util.*;

public class RaceRepositoryImpl implements RaceRepository  {

    private static RaceRepositoryImpl repository = null;
    private Map<String, Race> race;

    private RaceRepositoryImpl() {
        this.race = new HashMap<>();
    }

    public static RaceRepository getRepository(){
        if(repository == null) repository = new RaceRepositoryImpl();
        return repository;
    }

    public Race create(Race race){
        this.race.put(race.getRaceNum(),race);
        return race;
    }

    public Race read(String genderID){
        return this.race.get(genderID);
    }

    public Race update(Race race) {
        this.race.replace(race.getRaceNum(),race);
        return this.race.get(race.getRaceNum());
    }

    public void delete(String genderID) {
        this.race.remove(genderID);
    }

    public Set<Race> getAll(){
        Collection<Race> race = this.race.values();
        Set<Race> set = new HashSet<>();
        set.addAll(race);
        return set;
    }

}
