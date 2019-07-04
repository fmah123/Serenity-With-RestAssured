package Test;


import Step.StepClass;
import TestConfig.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.runner.RunWith;
import org.junit.Test;

@RunWith(SerenityRunner.class)
public class VerifcationTests{
    @Steps
    StepClass testsetup;

    @Test
    public void MyFirstSerenityTest(){
        testsetup.TestSetUp();
        testsetup.SearchGame();
        testsetup.SearchIsExecutedSuccessfully();
        //testsetup.IShouldFindGame("Resident Evil 4");
    }









}
