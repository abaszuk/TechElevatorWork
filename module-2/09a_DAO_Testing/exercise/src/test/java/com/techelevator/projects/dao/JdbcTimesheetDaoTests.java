package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");

    private JdbcTimesheetDao dao;


    @Before
    public void setup() {
        dao = new JdbcTimesheetDao(dataSource);
    }

    @Test
    public void getTimesheetById_with_valid_id_returns_correct_timesheet() {
        Timesheet timesheet1 = dao.getTimesheetById(1);

        assertTimesheetsMatch(timesheet1,TIMESHEET_1);
    }

    @Test
    public void getTimesheetById_with_invalid_id_returns_null_timesheet() {
        Timesheet fakeSheet = dao.getTimesheetById(999);
        Assert.assertEquals(null,fakeSheet);
    }

    @Test
    public void getTimesheetsByEmployeeId_with_valid_employee_id_returns_list_of_timesheets_for_employee() {
        //ACT
        List<Timesheet> timesheets = dao.getTimesheetsByEmployeeId(1);

        //ASSERT
        Assert.assertEquals(2,timesheets.size());

    }

    @Test
    public void getTimesheetsByProjectId_with_valid_id_returns_list_of_all_timesheets_for_project() {
        List<Timesheet> timesheets = dao.getTimesheetsByProjectId(1);
        Assert.assertEquals(3,timesheets.size());

    }

    @Test
    public void createTimesheet_creates_timesheet() {
        Timesheet newTimesheet = new Timesheet(0,2,2,LocalDate.now(),1.0,true,"new timesheet");
        Timesheet createdTimesheet = dao.createTimesheet(newTimesheet);

        int newId = createdTimesheet.getTimesheetId();
        newTimesheet.setTimesheetId(newId);
        assertTimesheetsMatch(newTimesheet,createdTimesheet);
    }

    @Test
    public void updateTimesheet_updates_timesheet() {
        Timesheet timesheetToUpdate = dao.getTimesheetById(1);

        timesheetToUpdate.setBillable(false);
        timesheetToUpdate.setDateWorked(LocalDate.now());
        timesheetToUpdate.setDescription("description");
        timesheetToUpdate.setEmployeeId(2);
        timesheetToUpdate.setHoursWorked(3);
        timesheetToUpdate.setProjectId(2);

        dao.updateTimesheet(timesheetToUpdate);
        Timesheet updatedTimesheet = dao.getTimesheetById(1);

        assertTimesheetsMatch(timesheetToUpdate,updatedTimesheet);
    }

    @Test
    public void deleteTimesheetById_deletes_timesheet() {
        int rowsAffect = dao.deleteTimesheetById(1);

        Assert.assertEquals(1,rowsAffect);
    }

    @Test
    public void getBillableHours_returns_correct_total() {
        double billableHoursTotal = TIMESHEET_1.getHoursWorked() + TIMESHEET_2.getHoursWorked() + TIMESHEET_3.getHoursWorked();

        double actualHours = dao.getBillableHours(1,1) + dao.getBillableHours(2,1) + dao.getBillableHours(2,2);

        Assert.assertEquals(billableHoursTotal,actualHours,0.01);
    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
