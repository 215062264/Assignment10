package za.ac.cput.kyle.service.info;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.kyle.domain.info.Race;
import za.ac.cput.kyle.factory.info.RaceFactory;
import za.ac.cput.kyle.repository.info.RaceRepositoryImpl;
import java.util.Set;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RaceServiceTest {

    private RaceRepositoryImpl repository;
    private Race race;

    private Race getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (RaceRepositoryImpl) RaceRepositoryImpl.getRepository();
        this.race = RaceFactory.getRace("1","Japanese");
    }

    @Test
    public void a_create() {
        Race created = this.repository.create(this.race);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.race);
    }

    @Test
    public void c_update() {

        String raceNum = "1";
        String raceDescription = "Russian";

        Race updated = new Race.Builder().copy(getSaved()).raceNum(raceNum)
                .raceDescription(raceDescription)
                .build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(raceNum, updated.getRaceNum());
    }

    @Test
    public void d_delete() {
        Race saved = getSaved();
        this.repository.delete(saved.getRaceNum());
        d_getAll();
    }

    @Test
    public void b_read() {
        Race saved = getSaved();
        Race read = this.repository.read(saved.getRaceNum());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Race> races = this.repository.getAll();
        System.out.println("In get all, all = " + races);
    }

}
