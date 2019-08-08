package za.ac.cput.kyle.repository.info;


import za.ac.cput.kyle.domain.info.Gender;

import java.util.*;

public class GenderRepositoryImpl implements GenderRepository {

    private static GenderRepositoryImpl repository = null;
    private Map<String, Gender> gender;

    private GenderRepositoryImpl() {
        this.gender = new HashMap<>();
    }

    public static GenderRepository getRepository(){
        if(repository == null) repository = new GenderRepositoryImpl();
        return repository;
    }

    public Gender create(Gender gender){
        this.gender.put(gender.getGenderID(),gender);
        return gender;
    }

    public Gender read(String genderID){
        return this.gender.get(genderID);
    }

    public Gender update(Gender gender) {
        this.gender.replace(gender.getGenderID(),gender);
        return this.gender.get(gender.getGenderID());
    }

    public void delete(String genderID) {
        this.gender.remove(genderID);
    }

    public Set<Gender> getAll(){
        Collection<Gender> gender = this.gender.values();
        Set<Gender> set = new HashSet<>();
        set.addAll(gender);
        return set;
    }

}
