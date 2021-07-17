package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormPageObjectsTests {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }


    @Test
    void positiveFillTest(){
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("1@ya.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9250750048");
        $("#dateOfBirthInput").click();
        $(byClassName("react-datepicker__month-select")).selectOption("April");
        $(byClassName("react-datepicker__year-select")).selectOption("1988");
        $(byClassName("react-datepicker__day--012")).click();
        $("#subjectsInput").setValue("History").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/test.jpg"));
        $("#currentAddress"). setValue("My address");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $(byText("Submit")).scrollTo().click();

        $(byClassName("modal-body")).shouldHave(text("Ivan"));
        $(byClassName("modal-body")).shouldHave(text("Ivanov"));
        $(byClassName("modal-body")).shouldHave(text("1@ya.ru"));
        $(byClassName("modal-body")).shouldHave(text("Male"));
        $(byClassName("modal-body")).shouldHave(text("9250750048"));
        $(byClassName("modal-body")).shouldHave(text("12 April,1988"));
        $(byClassName("modal-body")).shouldHave(text("History"));
        $(byClassName("modal-body")).shouldHave(text("Reading"));
        $(byClassName("modal-body")).shouldHave(text("test.jpg"));
        $(byClassName("modal-body")).shouldHave(text("My address"));
        $(byClassName("modal-body")).shouldHave(text("NCR"));
        $(byClassName("modal-body")).shouldHave(text("Noida"));








    }

}
