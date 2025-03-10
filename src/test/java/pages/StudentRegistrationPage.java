package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.TableComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;


public class StudentRegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapperInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbies = $("#hobbiesWrapper"),
            imageUpload = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            userStateInput = $("#react-select-3-input"),
            userCityInput = $("#react-select-4-input"),
            submitButton = $("#submit"),
            registrationResultMessage = $("#example-modal-sizes-title-lg");

    public CalendarComponent calendarComponent = new CalendarComponent();
    public TableComponent tableComponent = new TableComponent();

    @Step("Открываем страницу")
    public StudentRegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    @Step("Убираем баннер")
    public StudentRegistrationPage disableBanners() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    @Step("Заполняем имя")
    public StudentRegistrationPage setFirstName(String value) {
        firstNameInput.scrollTo().setValue(value);
        return this;
    }

    @Step("Заполняем фамилию")
    public StudentRegistrationPage setLastName(String value) {
        lastNameInput.scrollTo().setValue(value);
        return this;
    }

    @Step("Заполняем электронную почту")
    public StudentRegistrationPage setUserEmail(String value) {
        userEmailInput.scrollTo().setValue(value);
        return this;
    }

    @Step("Выбираем пол")
    public StudentRegistrationPage setGenderWrapper(String value) {
        genderWrapperInput.$(byText(value)).scrollTo().click();
        return this;
    }

    @Step("Заполняем телефон")
    public StudentRegistrationPage setUserNumber(String value) {
        userNumberInput.scrollTo().setValue(value);
        return this;
    }

    @Step("Заполняем дату рождения")
    public StudentRegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.scrollTo().click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Выбираем предмет")
    public StudentRegistrationPage setSubjects(String subject) {
        subjectsInput.scrollTo().setValue(subject).pressEnter();
        return this;
    }

    @Step("Выбираем хобби")
    public StudentRegistrationPage setHobbies(String value) {
        hobbies.$(byText(value)).scrollTo().click();
        return this;
    }

    @Step("Загружаем картинку")
    public StudentRegistrationPage imageUpload(String value) {
        imageUpload.scrollTo().uploadFromClasspath(value);
        return this;
    }

    @Step("Заполняем фактический адрес")
    public StudentRegistrationPage setCurrentAddress(String value) {
        currentAddressInput.scrollTo().setValue(value);
        return this;
    }

    @Step("Выбираем штат")
    public StudentRegistrationPage setUserState(String value) {
        userStateInput.scrollTo().setValue(value).pressEnter();
        return this;
    }

    @Step("Выбираем город")
    public StudentRegistrationPage setUserCity(String value) {
        userCityInput.scrollTo().setValue(value).pressEnter();
        return this;
    }

    @Step("Нажимаем на кнопку 'Submit'")
    public StudentRegistrationPage submitButtonClick() {
        submitButton.scrollTo().click();
        return this;
    }

    @Step("Проверяем сообщение о заполнении формы")
    public StudentRegistrationPage checkRegistrationResultMessage(String value) {
        registrationResultMessage.shouldHave(text(value));
        return this;
    }

    @Step("Проверяем поле {key} с ведёнными данными {value}")
    public StudentRegistrationPage checkRegistrationResultTable(String key, String value) {
        tableComponent.checkResultTableSellValue(key, value);
        return this;
    }

    @Step("Проверяем, что граница поля номера телефона красного цвета")
    public StudentRegistrationPage checkMobileNumberError() {
        userNumberInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }
}

