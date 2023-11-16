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
       //Act
        Park park1 = sut.getParkById(1);

        //Assert
        assertParksMatch(PARK_1, park1);

    }

    @Test
    public void getParkById_with_invalid_id_returns_null_park() {
        //Act
        Park fakePark = sut.getParkById(999);

        //Assert
        Assert.assertEquals(null, fakePark);
        Assert.assertNull(fakePark);
    }

    @Test
    public void getParksByState_with_valid_state_returns_correct_parks() {
        //Act
        List<Park> parks = sut.getParksByState("AA");

        //Assert
        Assert.assertEquals(2, parks.size());
        assertParksMatch(PARK_1, parks.get(0));
        assertParksMatch(PARK_3, parks.get(1));
    }

    @Test
    public void getParksByState_with_invalid_state_returns_empty_list() {
        //Act
        List<Park> parks = sut.getParksByState("ZZ");

        //Assert
        Assert.assertEquals(0, parks.size());
    }

    @Test
    public void createPark_creates_park() {

        //Arrange
        Park newPark = new Park(0, "Test", LocalDate.now(), 99, true);

        //Act
        Park createdPark = sut.createPark(newPark);

        //Assert

        //The original park that we made on 71 does not have an id
        //and we know it will be different from the createdPark
        //because the database generates the id for us every time
        //we insert. To check if all the fields between our newPark
        //and the createdPark match, we need to iron out the id -
        //so we can take the id that the database generated for createdPark
        //and assign to our newPark from line 71. That way all fields
        //should match successfully now
        int newId = createdPark.getParkId();
        newPark.setParkId(newId);

        assertParksMatch(newPark, createdPark);

        Park parkInDb = sut.getParkById(newId);
        assertParksMatch(createdPark, parkInDb);
    }

    @Test
    public void updatePark_updates_park() {
        //Arrange
        Park parkToUpdate = sut.getParkById(1);

        parkToUpdate.setDateEstablished(LocalDate.now());
        parkToUpdate.setHasCamping(false);
        parkToUpdate.setArea(999);
        parkToUpdate.setParkName("Update Test");

        //Act
        Park updatedPark = sut.updatePark(parkToUpdate);

        //Assert
        Assert.assertNotNull(updatedPark);

        Park retrievedPark = sut.getParkById(1);
        assertParksMatch(updatedPark, retrievedPark);

    }

    @Test
    public void deleteParkById_deletes_park() {
        //Act
        int rowsAffected = sut.deleteParkById(1);

        //Assert
        Assert.assertEquals(1, rowsAffected);

        Park park = sut.getParkById(1);
        Assert.assertNull(park);
    }

    @Test
    public void linkParkState_adds_park_to_list_of_parks_in_state() {
        //Act
        sut.linkParkState(2, "CC");

        //Assert
        List<Park> parks = sut.getParksByState("CC");
        Assert.assertEquals(2, parks.size());
    }

    @Test
    public void unlinkParkState_removes_park_from_list_of_parks_in_state() {
        //Act
        sut.unlinkParkState(2, "BB");

        //Assert
        List<Park> parks = sut.getParksByState("BB");
        Assert.assertEquals(0, parks.size());
    }

    private void assertParksMatch(Park expected, Park actual) {
        Assert.assertEquals(expected.getParkId(), actual.getParkId());
        Assert.assertEquals(expected.getParkName(), actual.getParkName());
        Assert.assertEquals(expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(expected.getHasCamping(), actual.getHasCamping());
    }

}
