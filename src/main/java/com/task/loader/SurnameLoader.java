package com.task.loader;

/**
 * @author Dmitriy Lyashenko
 */
public class SurnameLoader {

    private String[] manEnding = {
        "ский", "цкий", "ов", "ович", "евич", "кин", "ин", "ых", "ев", "иев", "нин", "цев", "цов", "евцев", "овцев",
            "ец", "енко", "енков", "иенко"
    };

    private String[] womanEnding = {
        "ская", "цкая", "ова", "ович", "евич", "кина", "ина", "ых", "ева", "иева", "нина", "цева", "цова", "евцева",
            "овцева", "ец", "енко", "енкова", "иенко"
    };

    public String[] getManEnding() {
        return manEnding;
    }

    public String[] getWomanEnding() {
        return womanEnding;
    }
}
