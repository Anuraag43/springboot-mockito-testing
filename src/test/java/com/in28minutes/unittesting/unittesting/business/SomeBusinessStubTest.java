package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    --> Big work

class SomeDataServiceStub implements SomeDataService {
 @Override
    public int[] retrieveAllData() {
        return new int[]{1,2,3};
    }
    public int[] retrieveAllDataEmpty() {
        return new int[]{};
    }
     public int[] retrieveAllDataOne() {
        return new int[]{5};
    }

}
*/


class SomeDataServiceStub implements SomeDataService {
 @Override
    public int[] retrieveAllData() {
        return new int[]{1,2,3};
    }
}
class SomeDataServiceStubEmpty implements SomeDataService {
 @Override
    public int[] retrieveAllData() {
        return new int[]{};
    }
}
class SomeDataServiceStubOne implements SomeDataService {
 @Override
    public int[] retrieveAllData() {
        return new int[]{5};
    }
}


public class SomeBusinessStubTest {

    @Test
    public void calculateSumUsingDataService_basic(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

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


/*
    Two ways to do this ==> change the method in interface, class SomeDataService, SomeDataServiceStub and SomeBusinessImpl methods..
    --> Big work

    or

    we can just create new classes of SomeDataService with same method name returning different values
    --> less work

    @Test
    public void calculateSumUsingDataService_empty(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        int actualResult = business.calculateSumUsingDataServiceEmpty();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_oneValue(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        int actualResult = business.calculateSum(new int[] {5});
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);

    }
*/

/*

    @Test
    public void calculateSum(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] {1,2,3});
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_empty(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] {});
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_oneValue(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] {5});
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }

*/
}
