package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationForm;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selenide.open;


public class FormFillingTestsWithFaker {

    Faker faker = new Faker();

    String url = "https://demoqa.com/automation-practice-form";
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String phone = faker.phoneNumber().subscriberNumber(10);
    String address = faker.address().fullAddress();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    StudentRegistrationForm studentRegistrationForm = new StudentRegistrationForm();

//  тест проверки заполнения формы
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
