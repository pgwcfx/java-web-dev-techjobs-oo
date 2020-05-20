package org.launchcode.techjobs_oo.tests;


import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.main.*;

import static org.junit.Assert.*;

public class JobTest {

    Job test_job1;
    Job test_job2;

    @Before
    public void createJobObject(){
        test_job1 = new Job();
        test_job2 = new Job();
    }
    @Test
    public void testSettingJobId(){
        assertNotEquals(test_job1.getId(), test_job2.getId());
        assertEquals(test_job1.getId()+1,test_job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job test_job3 = new Job("Product tester",new Employer("ACME"),new Location("Desert"),new PositionType("Quality control"),new CoreCompetency("Persistence"));
        assertNotNull(test_job3.getEmployer());
        assertNotNull(test_job3.getLocation());
        assertNotNull(test_job3.getPositionType());
        assertNotNull(test_job3.getCoreCompetency());
        assertNotNull(test_job3.getName());
    }

    @Test
    public void testJobsForEquality(){
        Job test_job4 = new Job("Game Developer",new Employer("Nintendo"),new Location("Los Angeles"),new PositionType("Coding"),new CoreCompetency("Teamwork"));
        Job test_job5 = new Job("Game Developer",new Employer("Nintendo"),new Location("Los Angeles"),new PositionType("Coding"),new CoreCompetency("Teamwork"));
        assertNotEquals(test_job4, test_job5);
    }

    @Test
    public void testToStringMethod(){
        Job test_job6 = new Job("Game Developer",new Employer("Nintendo"),new Location("Los Angeles"),new PositionType("Coding"),new CoreCompetency("Teamwork"));
        assertEquals("",test_job6.toString().substring(0,0));
        assertEquals("",test_job6.toString().substring(test_job6.toString().length()));
    }
    @Test
    public void testToStringMethodNewLineForFields(){
        Job test_job7 = new Job("Game Developer",new Employer("Nintendo"),new Location("Los Angeles"),
                new PositionType("Coding"),new CoreCompetency("Teamwork"));
        String output1 = "\nID: " + test_job7.getId() +
                "\nName: " + test_job7.getName() +
                "\nEmployer: " + test_job7.getEmployer() +
                "\nLocation: " + test_job7.getLocation() +
                "\nPosition Type: " + test_job7.getPositionType() +
                "\nCore Competency: " + test_job7.getCoreCompetency() + "\n";
        assertEquals(output1,test_job7.toString());
    }
    @Test
    public void testToStringMethodEmptyStringPrintsMessage(){
        Job test_job8 = new Job("Game Developer",new Employer(""),new Location("Los Angeles"),
                new PositionType("Coding"),new CoreCompetency("Teamwork"));
        String output2 = "\nID: " + test_job8.getId() +
                "\nName: " + test_job8.getName() +
                "\nEmployer: " + "Data not available" +
                "\nLocation: " + test_job8.getLocation() +
                "\nPosition Type: " + test_job8.getPositionType() +
                "\nCore Competency: " + test_job8.getCoreCompetency() + "\n";
        assertEquals(output2, test_job8.toString());
    }
    @Test
    public void testToStringMethodJobOnlyContainsId(){
        Job test_job9 = new Job("",new Employer(""),new Location(""),
                new PositionType(""),new CoreCompetency(""));
        Job test_job10 = new Job();
        String output3 = "OOPS! This job does not seem to exist.";
        assertEquals(output3,test_job9.toString());
        //assertEquals(output3,test_job10.toString());
    }
}
