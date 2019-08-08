package za.ac.cput.kyle.repository.info;


import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.kyle.domain.info.Race;
import za.ac.cput.kyle.factory.info.RaceFactory;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RaceRepositoryTest {

    private RaceRepository repository;
    private Race race;

    private Race getSavedGender() {
        Set<Race> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (RaceRepositoryImpl) RaceRepositoryImpl.getRepository();
        this.race = RaceFactory.getRace("7","Asian");
    }

    @Test
    public void a_create() {
        Race created = this.repository.create(this.race);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.race);
    }

    @Test
    public void b_read() {
        Race savedGenders = getSavedGender();
        System.out.println("In read, raceNum = "+ savedGenders.getRaceNum());
        Race read = this.repository.read(savedGenders.getRaceNum());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedGenders, read);
    }

    @Test
    public void d_delete() {
        Race savedGenders = getSavedGender();
        this.repository.delete(savedGenders.getRaceNum());
        getAll();
    }

    @Test
    public void c_update() {
        String raceNum = "1";
        String raceDescription = "Russian";

        Race updated = new Race.Builder().copy(getSavedGender()).raceNum(raceNum)
                .raceDescription(raceDescription)
                .build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(raceNum, updated.getRaceNum());
    }

    @Test
    public void getAll() {
        Set<Race> all = this.repository.getAll();
        System.out.println("In get All, all = " + all);
    }

}
