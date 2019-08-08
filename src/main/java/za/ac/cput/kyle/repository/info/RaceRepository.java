package za.ac.cput.kyle.repository.info;

import za.ac.cput.kyle.domain.info.Race;
import za.ac.cput.kyle.repository.IRepository;

import java.util.Set;

public interface RaceRepository extends IRepository <Race, String>{

    Set<Race> getAll();
}
