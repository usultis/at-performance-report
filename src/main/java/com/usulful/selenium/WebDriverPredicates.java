package com.usulful.selenium;

import com.google.common.base.Predicate;
import org.openqa.selenium.WebDriver;

public class WebDriverPredicates {

    public static Predicate<WebDriver> pageSourceContains(final String text) {
        return new PageSourceContaining(text);
    }

    private static class PageSourceContaining implements Predicate<WebDriver> {
        private final String text;

        public PageSourceContaining(String text) {
            this.text = text;
        }

        @Override
        public boolean apply(WebDriver webDriver) {
            return false;
        }

        @Override
        public String toString() {
            return "page source containing '" + text + "'";
        }
    }
}
