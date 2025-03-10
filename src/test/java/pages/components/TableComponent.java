package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TableComponent {

    public void checkResultTableSellValue (String key, String value){
        $(".table").shouldHave(text(key)).shouldHave(text(value));
    }
}
