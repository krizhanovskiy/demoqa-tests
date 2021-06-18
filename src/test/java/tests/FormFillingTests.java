package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class FormFillingTests {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

//  тест проверки заполнения формы
    @Test
    void successfulSubmitStudentRegistrationFormTest() {
//        открытие браузера
        open("https://demoqa.com/automation-practice-form");
//        заполнение имени
        $("[id=firstName]").setValue("Ivan");
//        заполнение фамилии
        $("[id=lastName]").setValue("Ivanov");
//        заполнение электронной почты
        $("[id=userEmail]").setValue("name@example.com");
//        выбор пола
        $("[for=gender-radio-1]").click();
//        ввод номера телефона
        $("[id=userNumber]").setValue("9260000001");

//        заполнение даты рождения
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption(0);
        $("[class=react-datepicker__year-select]").click();
        $("[class=react-datepicker__year-select]").selectOption("2020");
        $(byText("17")).click();

//        выбор темы
        $("[id=subjectsContainer]").click();
        $("[id=subjectsInput]").setValue("E").pressEnter();
//        выбор хобби
        $("[for=hobbies-checkbox-1]").click();
//        загрузка фотографии
        var picture = "/Users/v.krizhanovskiy/Downloads/Screenshot.png";
        $("[id=uploadPicture]").sendKeys(picture);
//        Ввод адреса
        $("[id=currentAddress]").setValue("Moscow");
//        выбор штата
        $("[id=react-select-3-input]").sendKeys("NCR");
        $("[id=react-select-3-input]").pressEnter();
//        выбор города
        $("[id=react-select-4-input]").sendKeys("Noida");
        $("[id=react-select-4-input]").pressEnter();
        $("[id=submit]").click();

//        проверка переданных значений
        $("[class=table-responsive]").shouldHave(
                text("Student Name"), text("Ivan Ivanov"),
                text("Student Email"), text("name@example.com"),
                text("Gender"), text("Male"),
                text("Mobile"), text("9260000001"),
                text("Date of Birth"), text("17 January,2020"),
                text("Subjects"), text("English"),
                text("Hobbies"), text("Sports"),
                text("Picture"), text("Screenshot.png"),
                text("Address"), text("Moscow"),
                text("State and City"), text("NCR Noida")
                );
    }


}
