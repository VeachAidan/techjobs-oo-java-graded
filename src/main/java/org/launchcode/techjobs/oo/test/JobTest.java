
package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {


    @Test
    public void emptyTest() {
        assertEquals(1, 1);
    }

    @Test
    public void testSettingJobId() {
        Job testJob = new Job();
        Job testJob2 = new Job();
        assertNotEquals(testJob2,testJob);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        // You don't need to use instanceOf to test that the fields in
        // your Job object have the correct types. You just need to test
        // that the fields are getting set to what you expect them to be.

        Employer testEmployer = new Employer("Google");
        Location testLocation = new Location("Washington");
        PositionType testPositionType = new PositionType("Junior Developer");
        CoreCompetency testCoreCompetency = new CoreCompetency("Java");
        Job testJob = new Job("Web Developer",testEmployer,testLocation,testPositionType,testCoreCompetency);

        assertEquals(testJob.getName(),"Web Developer");
        assertEquals("Google", testJob.getEmployer().getValue());
        assertEquals("Washington", testJob.getLocation().getValue());
        assertEquals("Junior Developer",testJob.getPositionType().getValue());
        assertEquals("Web Developer",testJob.getCoreCompetency().getValue());

        assertTrue(testJob.getName() instanceof String);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job testJob = new Job("Web Developer",new Employer("Google"),new Location("Washington"),new PositionType("Junior Developer"),new CoreCompetency("Java"));
        Job testJob2 = new Job("Web Developer",new Employer("Google"),new Location("Washington"),new PositionType("Junior Developer"),new CoreCompetency("Java"));
        assertFalse(testJob.equals(testJob2));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        // Job job2 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        // ID:  1
        // Name: Web Developer
        // Employer: LaunchCode
        // Location: St. Louis
        // Position Type: Front-end developer
        // Core Competency: JavaScript
        Job testJob = new Job("Web Developer",new Employer("Google"),new Location("Washington"),new PositionType("Junior Developer"),new CoreCompetency("Java"));
        assertEquals(testJob.toString(),"\n" +
                "ID: " + testJob.getId() +
                "\nName: Web Developer" +
                "\nEmployer: Google" +
                "\nLocation: Washington" +
                "\nPosition Type: Junior Developer" +
                "\nCore Competency: Java" +
                "\n");
    }

    @Test
    public void testToStringHandlesEmptyField() {
        // What if one of the fields is empty?
        // Job job2 = new Job("", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        // ID:  1
        // Name: Data not available
        // Employer: LaunchCode
        // Location: St. Louis
        // Position Type: Front-end developer
        // Core Competency: JavaScript
        Job testJob = new Job("",new Employer("Google"),new Location("Washington"),new PositionType("Junior Developer"),new CoreCompetency("Java"));
        assertEquals(testJob.toString(),"\n" +
                "ID: " + testJob.getId() +
                "\nName: Data not available" +
                "\nEmployer: Google" +
                "\nLocation: Washington" +
                "\nPosition Type: Junior Developer" +
                "\nCore Competency: Java" +
                "\n");
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job testJob = new Job("Web Developer",new Employer("Google"),new Location("Washington"),new PositionType("Junior Developer"),new CoreCompetency("Java"));
//        assertTrue(testJob.toString().startsWith("\n"));
//        assertTrue(testJob.toString().endsWith("\n"));

        assertEquals(testJob.toString().charAt(0),'\n');
        assertEquals(testJob.toString().charAt(testJob.toString().length()-1),'\n');
    }

}