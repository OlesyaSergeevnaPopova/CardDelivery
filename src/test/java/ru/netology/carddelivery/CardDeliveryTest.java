package ru.netology.carddelivery;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {


    @Test
    void shouldRegister() {
        Configuration.holdBrowserOpen=true;

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy");
        String date_now = formatter.format(date);
        String str = formatter.format(date);

        open("http://localhost:9999");
        $("[placeholder=\"Город\"]").setValue("Ростов-на-Дону");
        $("[placeholder=\"Дата встречи\"]").setValue(str);
        $("[name=\"name\"]").setValue("Иванов Иван");
        $("[name=\"phone\"]").setValue("+79001112233");
        $("[data-test-id=\"agreement\"]").click();
        $(byText("Забронировать")).click();
        $(withText("Встреча успешно забронирована")).should(visible, Duration.ofSeconds(15));
        //Встреча успешно забронирована на

    }
}
