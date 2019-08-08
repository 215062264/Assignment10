package za.ac.cput.kyle.repository.info;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.kyle.domain.info.Gender;
import za.ac.cput.kyle.factory.info.GenderFactory;
import java.util.Set;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenderRepositoryTest {

    private GenderRepository repository;
    private Gender gender;

    private Gender getSavedGender() {
        Set<Gender> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
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
    public void b_read() {
        Gender savedGenders = getSavedGender();
        System.out.println("In read, genderID = "+ savedGenders.getGenderID());
        Gender read = this.repository.read(savedGenders.getGenderID());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedGenders, read);
    }

    @Test
    public void d_delete() {
        Gender savedGenders = getSavedGender();
        this.repository.delete(savedGenders.getGenderID());
        getAll();
    }

    @Test
    public void c_update() {
        String genderID = "1";
        String genderDescription = "Female";

        Gender updated = new Gender.Builder().copy(getSavedGender()).genderID(genderID)
                .genderDescription(genderDescription)
                .build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(genderID, updated.getGenderID());
    }

    @Test
    public void getAll() {
        Set<Gender> all = this.repository.getAll();
        System.out.println("In get All, all = " + all);
    }

}
