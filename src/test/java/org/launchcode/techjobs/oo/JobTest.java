package org.launchcode.techjobs.oo;

import org.junit.Assert;
import org.junit.Test;

import static java.lang.System.lineSeparator;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void emptyTest() {
        assertEquals(10,10,.001);
    }
    @Test
    public void testSettingJobId(){
        // To verify that the IDs of the two objects are distinct
        Job job1 = new Job();
        Job job2 = new Job();
        Assert.assertNotEquals(job1.getId(),job2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester",job1.getName());

        assertTrue(job1.getEmployer() instanceof Employer);
        Assert.assertEquals(job1.getEmployer().getValue(),"ACME");

        assertTrue(job1.getLocation() instanceof Location);
        Assert.assertEquals(job1.getLocation().getValue(),"Desert");

        assertTrue(job1.getPositionType() instanceof PositionType);
        Assert.assertEquals(job1.getPositionType().getValue(),"Quality control");

        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
        Assert.assertEquals(job1.getCoreCompetency().getValue(),"Persistence");

    }
    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Full Stack Developer", new Employer("Launchcode"), new Location("Saint Louis"), new PositionType("Web - Full Stack"), new CoreCompetency("Javascript"));
        Assert.assertFalse(job1.equals(job2));
    }


    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));;
        int lastIndex = (job1.toString().length() -2);
        assertEquals(lineSeparator(),job1.toString().substring(0,2));
        assertEquals(lineSeparator(),job1.toString().substring(lastIndex));
    }


    @Test
    public void testToStringContainsCorrectLabelsAndData(){

        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String actualResult=lineSeparator() +
                "ID: "+job1.getId()+ lineSeparator() +
                "Name: Product tester"+ lineSeparator() +
                "Employer: ACME"+ lineSeparator() +
                "Location: Desert"+ lineSeparator() +
                "Position Type: Quality control"+ lineSeparator() +
                "Core Competency: Persistence"+ lineSeparator();

        String expectedResult=job1.toString();
        Assert.assertEquals(actualResult,expectedResult);


    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job job2 = new Job("", new Employer("Launchcode"), new Location("Saint Louis"), new PositionType("Web - Full Stack"), new CoreCompetency("Javascript"));
        String actualresult1=lineSeparator() +
                "ID: "+job2.getId()+lineSeparator() +
                "Name: Data not available" + lineSeparator() +
                "Employer: Launchcode" + lineSeparator() +
                "Location: Saint Louis" + lineSeparator() +
                "Position Type: Web - Full Stack" + lineSeparator() +
                "Core Competency: Javascript" + lineSeparator();

        String expectedResult1=job2.toString();
        Assert.assertEquals(actualresult1,expectedResult1);

        Job job3 = new Job("Full Stack Developer", new Employer(""), new Location("Saint Louis"), new PositionType("Web - Full Stack"), new CoreCompetency("Javascript"));
        String actualResult2=lineSeparator() +
                "ID: "+job3.getId()+lineSeparator() +
                "Name: Full Stack Developer" + lineSeparator() +
                "Employer: Data not available" + lineSeparator() +
                "Location: Saint Louis" + lineSeparator() +
                "Position Type: Web - Full Stack" + lineSeparator() +
                "Core Competency: Javascript" + lineSeparator();

        String expectedResult2=job3.toString();
        Assert.assertEquals(actualResult2,expectedResult2);

    }


}