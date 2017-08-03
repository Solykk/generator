package com.task.loader;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author Dmitriy Lyashenko
 */
public class NameLoaderTest {

    private final NameLoader nameLoader = new NameLoader();

    @Test
    public void differentNameLoadersSameCountOfElementsManNames(){
        //When
        NameLoader otherNameLoader = new NameLoader();

        //Then
        assertEquals(nameLoader.getManNamesElementsCount(), otherNameLoader.getManNamesElementsCount());
    }

    @Test
    public void uniqueElementsCountManNames(){
        //When
        Set<String> stringSet = new LinkedHashSet<>(Arrays.asList(nameLoader.getManNames()));

        //Then
        assertEquals(stringSet.size() - 1, nameLoader.getManNamesElementsCount());
    }

    @Test
    public void uniqueElementsManNames(){
        //When
        Set<String> stringSet = new LinkedHashSet<>(Arrays.asList(nameLoader.getManNames()));

        //Then
        assertEquals(stringSet.toString(), Arrays.toString(nameLoader.getManNames()));
    }

    @Test
    public void differentNameLoadersSameCountOfElementsWomanNames(){
        //When
        NameLoader otherNameLoader = new NameLoader();

        //Then
        assertEquals(nameLoader.getWomanNamesElementsCount(), otherNameLoader.getWomanNamesElementsCount());
    }

    @Test
    public void uniqueElementsCountWomanNames(){
        //When
        Set<String> stringSet = new LinkedHashSet<>(Arrays.asList(nameLoader.getWomanNames()));

        //Then
        assertEquals(stringSet.size() - 1, nameLoader.getWomanNamesElementsCount());
    }

    @Test
    public void uniqueElementsWomanNames(){
        //When
        Set<String> stringSet = new LinkedHashSet<>(Arrays.asList(nameLoader.getWomanNames()));

        //Then
        assertEquals(stringSet.toString(), Arrays.toString(nameLoader.getWomanNames()));
    }
}