package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.graalvm.compiler.nodeinfo.InputType.State;


public class PracticeFormPageObjectsTests {
    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void positiveFillTest(){
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName("Ivanov")
                .typeEmail("1@ya.ru")
                .selectGender("Male")
                .typePhone("9250750048")
                .setDateOfBirth("12", "April", "1988")
                .typeSubjects("History")
                .selectHobbies("Reading")
                .uploadPicture()
                .typeCurrentAddress("My address")
                .selectState("NCR")
                .selectCity("Noida")
                .submitPage()

                .checkResultsValue("Ivan")
                .checkResultsValue("Ivanov")
                .checkResultsValue("1@ya.ru")
                .checkResultsValue("Male")
                .checkResultsValue("9250750048")
                .checkResultsValue("12 April,1988")
                .checkResultsValue("History")
                .checkResultsValue("Reading")
                .checkResultsValue("test.jpg")
                .checkResultsValue("My address")
                .checkResultsValue("NCR")
                .checkResultsValue("Noida");
    }

}
