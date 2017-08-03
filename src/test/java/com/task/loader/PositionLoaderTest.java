package com.task.loader;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author Dmitriy Lyashenko
 */
public class PositionLoaderTest {

    private final PositionLoader positionLoader = new PositionLoader();

    @Test
    public void differentPositionLoadersSameCountOfElements(){
        //When
        PositionLoader otherPositionLoader = new PositionLoader();

        //Then
        assertEquals(positionLoader.getPositionsCount(), otherPositionLoader.getPositionsCount());
    }

    @Test
    public void uniqueElementsCount(){
        //When
        Set<String> stringSet = new LinkedHashSet<>(Arrays.asList(positionLoader.getPositions()));

        //Then
        assertEquals(stringSet.size() - 1, positionLoader.getPositionsCount());
    }

    @Test
    public void uniqueElements(){
        //When
        Set<String> stringSet = new LinkedHashSet<>(Arrays.asList(positionLoader.getPositions()));

        //Then
        assertEquals(stringSet.toString(), Arrays.toString(positionLoader.getPositions()));
    }
}