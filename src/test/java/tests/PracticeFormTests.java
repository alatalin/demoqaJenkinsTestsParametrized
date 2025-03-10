package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;
import utils.TestDataFaker;

import static io.qameta.allure.Allure.step;

public class PracticeFormTests extends TestBase {

    private final StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();
    TestDataFaker testDataFaker = new TestDataFaker();

    @Test
    @DisplayName("Полное заполнение формы")
    @Tags({
            @Tag("Smoke"),
            @Tag("Positive")
    })
    @Owner("alatalin")
    public void succesfullFillAllPracticeFormTest() {
        step("Открываем форму", () -> {
            studentRegistrationPage.openPage()
                    .disableBanners();
        });
        step("Заполняем форму", () -> {
            studentRegistrationPage.setFirstName(testDataFaker.firstName)
                    .setLastName(testDataFaker.lastName)
                    .setUserEmail(testDataFaker.email)
                    .setGenderWrapper(testDataFaker.gender)
                    .setUserNumber(testDataFaker.mobileNumber)
                    .setDateOfBirth(testDataFaker.dayOfBirth, testDataFaker.monthOfBirth, testDataFaker.yearOfBirth)
                    .setSubjects(testDataFaker.subject)
                    .setHobbies(testDataFaker.hobby)
                    .imageUpload(testDataFaker.picture)
                    .setCurrentAddress(testDataFaker.address)
                    .setUserState(testDataFaker.state)
                    .setUserCity(testDataFaker.city)
                    .submitButtonClick();
        });
        step("Проверяем результат", () -> {
            studentRegistrationPage.checkRegistrationResultMessage("Thanks for submitting the form")
                    .checkRegistrationResultTable("Student Name", testDataFaker.firstName + " " + testDataFaker.lastName)
                    .checkRegistrationResultTable("Student Email", testDataFaker.email)
                    .checkRegistrationResultTable("Gender", testDataFaker.gender)
                    .checkRegistrationResultTable("Mobile", testDataFaker.mobileNumber)
                    .checkRegistrationResultTable("Date of Birth", testDataFaker.dayOfBirth + " " + testDataFaker.monthOfBirth + "," + testDataFaker.yearOfBirth)
                    .checkRegistrationResultTable("Subjects", testDataFaker.subject)
                    .checkRegistrationResultTable("Hobbies", testDataFaker.hobby)
                    .checkRegistrationResultTable("Picture", testDataFaker.picture)
                    .checkRegistrationResultTable("Address", testDataFaker.address)
                    .checkRegistrationResultTable(testDataFaker.state, testDataFaker.city);
        });
    }

    @Test
    @DisplayName("Минимальное заполнение формы")
    @Tags({
            @Tag("Smoke"),
            @Tag("Positive")
    })
    @Owner("alatalin")
    public void succesfullMimimumDataPracticeFormTest() {
        step("Открываем форму", () -> {
            studentRegistrationPage.openPage()
                    .disableBanners();
        });
        step("Заполняем форму", () -> {
            studentRegistrationPage.setFirstName(testDataFaker.firstName)
                    .setLastName(testDataFaker.lastName)
                    .setGenderWrapper(testDataFaker.gender)
                    .setUserNumber(testDataFaker.mobileNumber)
                    .submitButtonClick();
        });
        step("Проверяем результат", () -> {
            studentRegistrationPage.checkRegistrationResultMessage("Thanks for submitting the form")
                    .checkRegistrationResultTable("Student Name", testDataFaker.firstName + " " + testDataFaker.lastName)
                    .checkRegistrationResultTable("Gender", testDataFaker.gender)
                    .checkRegistrationResultTable("Mobile", testDataFaker.mobileNumber);
        });
    }

    @Test
    @DisplayName("Невалидный номер телефона")
    @Tags({
            @Tag("Smoke"),
            @Tag("Negative")
    })
    @Owner("alatalin")
    public void notValidPhoneNumberPracticeFormTest() {
        step("Открываем форму", () -> {
            studentRegistrationPage.openPage()
                    .disableBanners();
        });
        step("Заполняем форму", () -> {
            studentRegistrationPage.setFirstName(testDataFaker.firstName)
                    .setLastName(testDataFaker.lastName)
                    .setGenderWrapper(testDataFaker.gender)
                    .setUserNumber(testDataFaker.notValidMobileNumber)
                    .submitButtonClick();
        });
        step("Проверяем результат", () -> {
            studentRegistrationPage.checkMobileNumberError();
        });
    }

}
