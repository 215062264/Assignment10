package za.ac.cput.kyle.service.info;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.kyle.domain.info.Gender;
import za.ac.cput.kyle.factory.info.GenderFactory;
import za.ac.cput.kyle.repository.info.GenderRepositoryImpl;
import java.util.Set;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenderServiceTest {

    private GenderRepositoryImpl repository;
    private Gender gender;

    private Gender getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (GenderRepositoryImpl) GenderRepositoryImpl.getRepository();
        this.gender = GenderFactory.getGender("1","Male");
    }

    @Test
    public void a_create() {
        Gender created = this.repository.create(this.gender);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.gender);
    }

    @Test
    public void c_update() {

        String genderID = "1";
        String genderDescription = "Russian";

        Gender updated = new Gender.Builder().copy(getSaved()).genderID(genderID)
                .genderDescription(genderDescription)
                .build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(genderID, updated.getGenderID());
    }

    @Test
    public void d_delete() {
        Gender saved = getSaved();
        this.repository.delete(saved.getGenderID());
        d_getAll();
    }

    @Test
    public void b_read() {
        Gender saved = getSaved();
        Gender read = this.repository.read(saved.getGenderID());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Gender> races = this.repository.getAll();
        System.out.println("In get all, all = " + races);
    }

}
