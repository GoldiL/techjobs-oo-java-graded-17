package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId(){
        Job developer = new Job();
        Job tester = new Job();
        assertNotEquals(tester.getId(),developer.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));;

        assertTrue(job1 instanceof Job);

        assertTrue(job1.getName() == "Product tester");

        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getEmployer().getValue() == "ACME");

        assertTrue(job1.getLocation() instanceof  Location);
        assertTrue(job1.getLocation().getValue() == "Desert");

        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getPositionType().getValue() == "Quality control");

        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(job1.getCoreCompetency().getValue() == "Persistence");

    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));;
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));;

        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine (){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));;
        int lastIndex = (job1.toString().length() -2);

        assertEquals(System.lineSeparator(),job1.toString().substring(0,2));
        assertEquals(System.lineSeparator(),job1.toString().substring(lastIndex));
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job2 = new Job("", new Employer("Launchcode"), new Location("Saint Louis"), new PositionType("Web - Full Stack"), new CoreCompetency("Javascript"));
        String actualresult1="\r\n" +
                "ID: 1\r\n" +
                "Name: Data not available\r\n" +
                "Employer: Infosys\r\n" +
                "Location: Saint Louis\r\n" +
                "Position Type: Web - Full Stack\r\n" +
                "Core Competency: Javascript\r\n";

        String expectedResult1=job2.toString();
        assertEquals(actualresult1,expectedResult1);

        Job job3 = new Job("Full Stack Developer", new Employer(""), new Location("Saint Louis"), new PositionType("Web - Full Stack"), new CoreCompetency("Javascript"));
        String actualresult2="\r\n" +
                "ID: 2\r\n" +
                "Name: Full Stack Developer\r\n" +
                "Employer: Data not available\r\n" +
                "Location: Saint Louis\r\n" +
                "Position Type: Web - Full Stack\r\n" +
                "Core Competency: Angular\r\n";

        String expectedResult2=job3.toString();
        assertEquals(actualresult2,expectedResult2);

    }

}
