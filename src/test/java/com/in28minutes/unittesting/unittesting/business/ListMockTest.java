package com.in28minutes.unittesting.unittesting.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {
    List<String> mockList = mock(List.class);

/*
    @Test
    public void size_basic()  {
        when(mockList.size()).thenReturn(5);
        assertEquals(5,mockList.size());
    }
    @Test
    public void returnDifferentValues()  {
        when(mockList.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mockList.size());
        assertEquals(10,mockList.size());
    }

    @Test
    public void returnWithParameters(){
        when(mockList.get(0)).thenReturn("in28Minutes");
        assertEquals("in28Minutes",mockList.get(0));
        assertEquals(null,mockList.get(1));
    }
    @Test
    public void returnWithGenericParameters(){
        when(mockList.get(anyInt())).thenReturn("in28Minutes");
        assertEquals("in28Minutes",mockList.get(0));
//        assertEquals(null,mockList.get(1)); ==> Fails coz it expects to see "in28Minutes" here too"
        assertEquals("in28Minutes", mockList.get(1));
    }

*/
    /*
@Test
public void verificationBasics(){
    //SUT
    String value1 = mockList.get(0);
    String value2 = mockList.get(1);

    //verify method call
    verify(mockList).get(0);
//        verify(mockList).get(anyInt());
    verify(mockList, times(2)).get(anyInt());
    verify(mockList, atLeast(1)).get(anyInt());
    verify(mockList, atMost(2)).get(anyInt());
    verify(mockList, never()).get(2);

}
*/

/*
    // Capture the argument being sent to a method
    @Test
    public void argumentCapturing() {
        //SUT
        mockList.add("SomeString");

        //verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockList).add(captor.capture());

        assertEquals("SomeString", captor.getValue());
    }
*/

    /*
    //Capture multiple arguments being passed to a method
    @Test
    public void multipleArgumentCapturing() {
        //SUT
        mockList.add("SomeString1");
        mockList.add("SomeString2");

        //verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockList, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();

        assertEquals("SomeString1", allValues.get(0));
        assertEquals("SomeString2", allValues.get(1));

        // This doesn't mean only exact comparisons work. In some cases we can send 1,2,3,4 for method Arguments
        // and check for 1+2+3+4 value in the assert statement.
    }
*/
    @Test
    public void spying(){
        /*
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0)); //null
        System.out.println(arrayListMock.size()); // 0


        arrayListMock.add("Test1");
        arrayListMock.add("Test2");

        System.out.println(arrayListMock.size()); //0
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size()); //5

*/
        // The issue with using mock is every method from the class gets mocked, there is no real method in the class
        // All methods start sending default values unless we override them ( like when() ).

        ArrayList arrayListSpy = spy(ArrayList.class);
//        System.out.println(arrayListSpy.get(0)); // ==> Null Pointer Exception
//        System.out.println(arrayListSpy.size()); // 0

        //Instead
        arrayListSpy.add("Test0");
        System.out.println(arrayListSpy.size()); // 1
        System.out.println(arrayListSpy.get(0)); // Test0

        arrayListSpy.add("Test1");
        arrayListSpy.add("Test2");

        System.out.println(arrayListSpy.size()); // 3 ( Now it retained the behavior by storing the values in it )
        when(arrayListSpy.size()).thenReturn(5);

        arrayListSpy.add("Test4");
        System.out.println(arrayListSpy.size());//5(Here size is overridden hence it takes precedence over actual value)

        // When we create a spy, the original behavior of the class is retained.
        // we can stub specific methods.
/*
        Usecase:
        There might be scenarios where we would want to use the original dependency. We dont not want to mock the dep,
        we want to find out whats happening with it.
*/

/*
        The thing with spy is we can also call verify() methods on it.
*/
        verify(arrayListSpy).add("Test4");

/*
        Check that on this arrayListSpy the add method is called with Arg "Test4" and still see test case succeed.

        If we do not have access to a specific class to get the data from it but you would want to check whats going
        underneath the class, check what methods are being called and things like that, we can create spy and do
        verifications on it.

        Spying is like real worl spying ==> Let the action to happen and keep watch on it.
        Mocking is instead of the real world action, Spying is in addition to the real world action.
        Allow the action to happen and then observe it.

*/



    }
}
