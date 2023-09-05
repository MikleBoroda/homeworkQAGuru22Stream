package ui_tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {
    @Test
    void fillingAndCheckingFrom() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1680x1050";
        open("https://demoqa.com/automation-practice-form");

        //заполнение формы
        $(".element-group .header-text span.pr-1").click();
        $("#firstName").setValue("Mixa");
        $("#lastName").setValue("Smith");
        $("#userEmail").setValue("test@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9991112233");
        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").sendKeys(Keys.COMMAND + "A");
        $("#dateOfBirthInput").sendKeys(Keys.SPACE);
        $("#dateOfBirthInput").setValue("09 Sep 1989");
        $(".subjects-auto-complete__input #subjectsInput").click();
        $(".subjects-auto-complete__input #subjectsInput").setValue("Maths").sendKeys(Keys.ENTER);
        $("input#uploadPicture").uploadFile(new File("/Users/mikhail/Desktop/PictureFirst.png"));
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#currentAddress").setValue("Vladimir city");
        $("#stateCity-wrapper input#react-select-3-input").setValue("u").sendKeys(Keys.ENTER);
        $("#stateCity-wrapper input#react-select-4-input").setValue("a").sendKeys(Keys.ENTER);
        $("#submit").click();

        //проверка формы
        $(byText("Mixa Smith"));
        $(byText("test@mail.ru"));
        $(byText("Male"));
        $(byText("9991112233"));
        $(byText("09 September,1989"));
        $(byText("Maths"));
        $(byText("Sports, Reading"));
        $(byText("PictureFirst.png"));
        $(byText("Vladimir city"));
        $(byText("Uttar Pradesh Agra"));
        $("#closeLargeModal").click();
    }

}
