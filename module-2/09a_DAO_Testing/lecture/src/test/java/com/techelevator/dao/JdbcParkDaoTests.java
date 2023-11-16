package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests {

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);

    private JdbcParkDao sut;

    @Before
    public void setup() {
        sut = new JdbcParkDao(dataSource);
    }

    @Test
    public void getParkById_with_valid_id_returns_correct_park() {
        //ACT
        Park park1 = sut.getParkById(1);

        //ASSERT - same as the assertParksMatch method at bottom
//        Assert.assertEquals(park1.getParkId(),PARK_1.getParkId());
//        Assert.assertEquals(park1.getParkName(),PARK_1.getParkName());
//        Assert.assertEquals(park1.getDateEstablished(), PARK_1.getDateEstablished());
//        Assert.assertEquals(park1.getHasCamping(),PARK_1.getHasCamping());
//        Assert.assertEquals(park1.getArea(),PARK_1.getArea(),.01);
        assertParksMatch(PARK_1,park1);
    }

    @Test
    public void getParkById_with_invalid_id_returns_null_park() {
        //ACT
        Park fakePark = sut.getParkById(999);

        //ASSERT
        Assert.assertEquals(null,fakePark);
        //same as above but different
        Assert.assertNull(fakePark);
    }

    @Test
    public void getParksByState_with_valid_state_returns_correct_parks() {
        //ACT
        List<Park> parks = sut.getParksByState("AA");

        //ASSERT
        Assert.assertEquals(2,parks.size());
    }

    @Test
    public void getParksByState_with_invalid_state_returns_empty_list() {
        //ACT
        List<Park> parks = sut.getParksByState("ZZ");

        //ASSERT
        Assert.assertEquals(0,parks.size());
    }

    @Test
    public void createPark_creates_park() {
        //ARRANGE
        Park newPark = new Park(0,"Test",LocalDate.now(),99,true);

        //ACT
        Park createdPark = sut.createPark(newPark);

        //ASSERT
        int newId = createdPark.getParkId();
        newPark.setParkId(newId);
        assertParksMatch(newPark,createdPark);

        //EXTRA
        Park parkInDb = sut.getParkById(newId);
        assertParksMatch(createdPark,parkInDb);
    }

    @Test
    public void updatePark_updates_park() {
        //ARRANGE
        Park parkToUpdate = sut.getParkById(1);

        parkToUpdate.setDateEstablished(LocalDate.now());
        parkToUpdate.setHasCamping(false);
        parkToUpdate.setArea(999);
        parkToUpdate.setParkName("update test");

        //ACT
        Park updatedPark = sut.updatePark(parkToUpdate);

        //ASSERT
        Assert.assertNotNull(updatedPark);

        Park retrievedPark = sut.getParkById(1);
        assertParksMatch(updatedPark,retrievedPark);


    }

    @Test
    public void deleteParkById_deletes_park() {
        //ACT
        int rowsAffected = sut.deleteParkById(1);

        //ASSERT
        Assert.assertEquals(1,rowsAffected);

        Park park = sut.getParkById(1);
        Assert.assertNull(park);
    }

    @Test
    public void linkParkState_adds_park_to_list_of_parks_in_state() {
        //ACT
        sut.linkParkState(2,"CC");

        //ASSERT
        List<Park> parks = sut.getParksByState("CC");
        Assert.assertEquals(2,parks.size());
    }

    @Test
    public void unlinkParkState_removes_park_from_list_of_parks_in_state() {
        //ACT
        sut.unlinkParkState(2,"BB");

        //ASSERT
        List<Park> parks = sut.getParksByState("BB");
        Assert.assertEquals(0,parks.size());
    }

    private void assertParksMatch(Park expected, Park actual) {
        Assert.assertEquals(expected.getParkId(), actual.getParkId());
        Assert.assertEquals(expected.getParkName(), actual.getParkName());
        Assert.assertEquals(expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(expected.getHasCamping(), actual.getHasCamping());
    }

}
