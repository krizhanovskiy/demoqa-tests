package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import org.junit.jupiter.api.Test;

public class StudentRegistrationForm {

    public void typeFirstName(String firstName){
        $("[id=firstName]").setValue(firstName);
    }

    public void typeLastName(String lastName){
        $("[id=lastName]").setValue(lastName);
    }

    public void typeEmail(String email){
        $("[id=userEmail]").setValue(email);
    }

    public void genderSelection(){
        $("[for=gender-radio-1]").click();
    }

    public void typePhone(String phone){
        $("[id=userNumber]").setValue(phone);
    }

    public void typeBirthday(){
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption(0);
        $("[class=react-datepicker__year-select]").click();
        $("[class=react-datepicker__year-select]").selectOption("2020");
        $(byText("17")).click();
    }

    public void subjectsSelection(){
        $("[id=subjectsContainer]").click();
        $("[id=subjectsInput]").setValue("E").pressEnter();
    }

    public void hobbiesSelection(){
        $("[for=hobbies-checkbox-1]").click();
    }

    public void uploadPicture(){
        var picture = "/Users/v.krizhanovskiy/Downloads/Screenshot.png";
        $("[id=uploadPicture]").sendKeys(picture);
    }

    public void typeAddress(String adress){
        $("[id=currentAddress]").setValue(adress);
    }

    public void stateSelection(){
        $("[id=react-select-3-input]").sendKeys("NCR");
        $("[id=react-select-3-input]").pressEnter();
    }

    public void citySelection(){
        $("[id=react-select-4-input]").sendKeys("Noida");
        $("[id=react-select-4-input]").pressEnter();
    }

    public void submitButtomClick(){
        $("[id=submit]").click();
    }

    public void checkResult(String firstName, String lastName, String email, String phone, String adress){
        $("[class=table-responsive]").shouldHave(
                text("Student Name"), text(firstName + " " + lastName),
                text("Student Email"), text(email),
                text("Gender"), text("Male"),
                text("Mobile"), text(phone),
                text("Date of Birth"), text("17 January,2020"),
                text("Subjects"), text("English"),
                text("Hobbies"), text("Sports"),
                text("Picture"), text("Screenshot.png"),
                text("Address"), text(adress),
                text("State and City"), text("NCR Noida")
                );
    }


}
