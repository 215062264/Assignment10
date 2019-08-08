package za.ac.cput.kyle.service.info;

import za.ac.cput.kyle.domain.info.Gender;
import za.ac.cput.kyle.service.IService;

import java.util.Set;

public interface GenderService extends IService<Gender, String> {

    Set<Gender> getAll();
}
