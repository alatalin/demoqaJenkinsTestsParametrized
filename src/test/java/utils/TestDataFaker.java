package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestDataFaker {
    Faker faker = new Faker(new Locale("en-GB"));

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String mobileNumber = faker.phoneNumber().subscriberNumber(10);
    public String notValidMobileNumber = faker.phoneNumber().subscriberNumber(9);
    public String dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 28));
    public String monthOfBirth = faker.options().option("January", "February", "March", "April",
            "May", "June", "July", "August", "September", "October", "November", "December");
    public String yearOfBirth = String.format("%s", faker.number().numberBetween(1924, 2012));
    public String subject = faker.options().option("Accounting", "Arts", "Biology", "Chemistry", "Civics", "Commerce", "Computer Science", "Economics", "English",
            "Hindi", "History", "Maths", "Physics", "Social Studies");
    public String hobby = faker.options().option("Sports", "Reading", "Music");
    public String picture = faker.options().option("JPEG_65Kb.jpeg", "PNG_140Kb.png");
    public String address = faker.address().fullAddress();
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = getRandomCity(state);

    public String getRandomCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return null;
        }
    }

}
