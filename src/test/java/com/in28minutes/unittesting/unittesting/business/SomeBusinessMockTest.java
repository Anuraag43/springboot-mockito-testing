package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SomeBusinessMockTest {

    SomeBusinessImpl business = new SomeBusinessImpl();
    SomeDataService dataServiceMock = mock(SomeDataService.class);

//  Not working this way below at class level:
//  business.setSomeDataService(dataServiceMock);

    // Note: Use @BeforeEach, NOT @BeforeAll coz it complains that before() must be static
    @BeforeEach
    public void before(){
        business.setSomeDataService(dataServiceMock);
    }
    @Test
    public void calculateSumUsingDataService_basic(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
        assertEquals(6, business.calculateSumUsingDataService());
    }
    @Test
    public void calculateSumUsingDataService_empty(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[0]);
        assertEquals(0, business.calculateSumUsingDataService());
    }
    @Test
    public void calculateSumUsingDataService_oneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
        assertEquals(5, business.calculateSumUsingDataService());
    }


/*
New way with Mockto
    @Test
    public void calculateSumUsingDataService_empty(){
//        SomeBusinessImpl business = new SomeBusinessImpl();
//        SomeDataService dataServiceTest = mock(SomeDataService.class);
        business.setSomeDataService(dataServiceMock);

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[0]);

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

*/



/*
    @Test
    public void calculateSumUsingDataService_empty(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStubEmpty());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStubOne());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);

    }
*/

}
