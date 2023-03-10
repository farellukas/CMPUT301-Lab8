package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class CustomListTest {

    private CustomList list;

    /**
     * create a mocklist for my citylist
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity() {
        CustomList cityList = MockCityList();
        City city = new City("Vancouver", "British Columbia");
        assertFalse(cityList.hasCity(city));
        cityList.addCity(city);
        assertTrue(cityList.hasCity(city));
    }

    @Test
    void testDelete() {
        CustomList cityList = MockCityList();
        City city = new City("Toronto", "Ontario");
        cityList.addCity(city);
        assertEquals(1, cityList.getCount());
        assertTrue(cityList.hasCity(city));
        cityList.delete(city);
        assertEquals(0, cityList.getCount());
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testDeleteException() {
        CustomList cityList = MockCityList();
        City city = new City("Waterloo", "Ontario");
        assertThrows(NoSuchElementException.class, () -> {
            cityList.delete(city);
        });
    }

    @Test
    void testCountCities() {
        CustomList cityList = MockCityList();
        assertEquals(0, cityList.countCities());
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        assertEquals(1, cityList.countCities());
    }
}
