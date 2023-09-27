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
    public void testToStringContainsCorrectLabelsAndData(){

        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expectedResult="\n" +
                "ID: "+ job1.getId()+"\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n";

        String actualresult=job1.toString();
        assertEquals(expectedResult,actualresult);

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine (){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));;
        //int lastIndex = (job1.toString().length() -2);
        int lastIndex = (job1.toString().length() -1);

        //assertEquals(System.lineSeparator(),job1.toString().substring(0,2));
        assertEquals('\n',job1.toString().charAt(0));
        assertEquals('\n',job1.toString().charAt(lastIndex));
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job2 = new Job("", new Employer("Launchcode"), new Location("Saint Louis"), new PositionType("Web - Full Stack"), new CoreCompetency("Javascript"));
        String actualresult1="\n" +
                "ID: "+job2.getId()+"\n" +
                "Name: Data not available\n" +
                "Employer: Launchcode\n" +
                "Location: Saint Louis\n" +
                "Position Type: Web - Full Stack\n" +
                "Core Competency: Javascript\n";

        String expectedResult1=job2.toString();
        assertEquals(actualresult1,expectedResult1);

        Job job3 = new Job("Full Stack Developer", new Employer(""), new Location("Saint Louis"), new PositionType("Web - Full Stack"), new CoreCompetency("Javascript"));
        String actualresult2="\n" +
                "ID: " +job3.getId()+"\n"+
                "Name: Full Stack Developer\n" +
                "Employer: Data not available\n" +
                "Location: Saint Louis\n" +
                "Position Type: Web - Full Stack\n" +
                "Core Competency: Javascript\n";

        String expectedResult2=job3.toString();
        assertEquals(actualresult2,expectedResult2);

    }

}
