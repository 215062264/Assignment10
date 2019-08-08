package za.ac.cput.kyle.repository.info;

import za.ac.cput.kyle.domain.info.Gender;
import za.ac.cput.kyle.repository.IRepository;

import java.util.Set;

public interface GenderRepository extends IRepository<Gender, String> {

    Set<Gender> getAll();

}
