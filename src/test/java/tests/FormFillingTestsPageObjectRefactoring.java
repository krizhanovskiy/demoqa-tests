package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationForm;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class FormFillingTestsPageObjectRefactoring {
    String url = "https://demoqa.com/automation-practice-form";
    String firstName = "Ivan";
    String lastName = "Ivanov";
    String email = "name@example.com";
    String phone = "9260000001";
    String address = "Moscow";

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    StudentRegistrationForm studentRegistrationForm = new StudentRegistrationForm();

    @Test
    void successfulSubmitStudentRegistrationFormTest() {
//        открытие браузера
        open(url);

//        заполнение имени
        studentRegistrationForm.typeFirstName(firstName);
//        заполнение фамилии
        studentRegistrationForm.typeLastName(lastName);
//        заполнение электронной почты
        studentRegistrationForm.typeEmail(email);
//        выбор пола
        studentRegistrationForm.genderSelection();
//        ввод номера телефона
        studentRegistrationForm.typePhone(phone);
//        заполнение даты рождения
        studentRegistrationForm.typeBirthday();
//        выбор темы
        studentRegistrationForm.subjectsSelection();
//        выбор хобби
        studentRegistrationForm.hobbiesSelection();
//        загрузка фотографии
        studentRegistrationForm.uploadPicture();
//        Ввод адреса
        studentRegistrationForm.typeAddress(address);
//        выбор штата
        studentRegistrationForm.stateSelection();
//        выбор города
        studentRegistrationForm.citySelection();
//
        studentRegistrationForm.submitButtomClick();

//        проверка переданных значений
        studentRegistrationForm.checkResult(firstName, lastName, email, phone, address);
    }


}
