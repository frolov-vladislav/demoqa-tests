package com.vladfrolov.tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @Test
    public void dragAndDrop(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement firstColumn = $$(".column").first();
        firstColumn.shouldHave(text("A"));
        element("#column-a").dragAndDropTo("#column-b");
        firstColumn.shouldHave(text("B"));
    }
}