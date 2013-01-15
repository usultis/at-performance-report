package com.usulful.selenium;

import com.google.common.base.Predicate;
import org.openqa.selenium.WebElement;

public class WebElementPredicates {

    public static Predicate<? super WebElement> withText(final String text) {
        return new Predicate<WebElement>() {
            @Override
            public boolean apply(WebElement webElement) {
                return webElement.getText().trim().equals(text);
            }
        };
    }

    public static Predicate<? super WebElement> withTitle(final String title) {
        return new Predicate<WebElement>() {
            @Override
            public boolean apply(WebElement webElement) {
                String title = webElement.getAttribute("title");
                return title != null && title.trim().equals(title);
            }
        };
    }
}
