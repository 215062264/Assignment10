package za.ac.cput.kyle.service.info;

import za.ac.cput.kyle.domain.info.Race;
import za.ac.cput.kyle.service.IService;

import java.util.Set;

public interface RaceService extends IService<Race, String> {

    Set<Race> getAll();
}
