package com.task.loader;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author Dmitriy Lyashenko
 */
public class SurnameLoaderTest {

    private final SurnameLoader surnameLoader = new SurnameLoader();

    @Test
    public void differentSurnameLoadersSameCountOfElements(){
        //When
        SurnameLoader otherSurnameLoader = new SurnameLoader();

        //Then
        assertEquals(surnameLoader.getManEnding().length, otherSurnameLoader.getManEnding().length);
        assertEquals(surnameLoader.getWomanEnding().length, otherSurnameLoader.getWomanEnding().length);
    }

    @Test
    public void uniqueElementsCount(){
        //When
        Set<String> stringSetMan = new LinkedHashSet<>(Arrays.asList(surnameLoader.getManEnding()));
        Set<String> stringSetWoman = new LinkedHashSet<>(Arrays.asList(surnameLoader.getWomanEnding()));

        //Then
        assertEquals(stringSetMan.size(), surnameLoader.getManEnding().length);
        assertEquals(stringSetWoman.size(), surnameLoader.getWomanEnding().length);
    }

    @Test
    public void uniqueElements(){
        //When
        Set<String> stringSetMan = new LinkedHashSet<>(Arrays.asList(surnameLoader.getManEnding()));
        Set<String> stringSetWoman = new LinkedHashSet<>(Arrays.asList(surnameLoader.getWomanEnding()));

        //Then
        assertEquals(stringSetMan.toString(), Arrays.toString(surnameLoader.getManEnding()));
        assertEquals(stringSetWoman.toString(), Arrays.toString(surnameLoader.getWomanEnding()));
    }
}