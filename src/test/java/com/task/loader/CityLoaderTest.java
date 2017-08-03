package com.task.loader;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author Dmitriy Lyashenko
 */
public class CityLoaderTest {

    private final CityLoader cityLoader = new CityLoader();

    @Test
    public void differentCityLoadersSameCountOfElements(){
        //When
        CityLoader otherCityLoader = new CityLoader();

        //Then
        assertEquals(cityLoader.getCitiesCount(), otherCityLoader.getCitiesCount());
    }

    @Test
    public void uniqueElementsCount(){
        //When
        Set<String> stringSet = new LinkedHashSet<>(Arrays.asList(cityLoader.getCities()));

        //Then
        assertEquals(stringSet.size() - 1, cityLoader.getCitiesCount());
    }

    @Test
    public void uniqueElements(){
        //When
        Set<String> stringSet = new LinkedHashSet<>(Arrays.asList(cityLoader.getCities()));

        //Then
        assertEquals(stringSet.toString(), Arrays.toString(cityLoader.getCities()));
    }
}