package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data) {
        int sum = 0;
        for (int value : data) {
            sum += value;
        }
        return sum;
    }

    public int calculateSumUsingDataService() {
        int sum = 0;
        int[] data = someDataService.retrieveAllData();
        for (int value : data) {
            sum += value;
        }

        //someDataService.storeSum(sum); ==> Verify if another ethod call inside this method works.
        return sum;
    }


/*
    Normal flow
    public int calculateSumUsingDataService() {
        int sum = 0;
        int[] data = someDataService.retrieveAllData();
        for (int value : data) {
            sum += value;
        }
        return sum;
    }
*/

}
/*
    --> Big work
    public int calculateSumUsingDataServiceEmpty(){
        int sum = 0;
        int[] data = someDataService.retrieveAllDataEmpty();
        for(int value: data){
            sum += value;
        }
        return sum;
    }
    public int calculateSumUsingDataServiceOne(){
        int sum = 0;
        int[] data = someDataService.retrieveAllDataOne();
        for(int value: data){
            sum += value;
        }
        return sum;
    }
*/




