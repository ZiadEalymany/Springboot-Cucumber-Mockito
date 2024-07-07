package com.asset.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MyTests {

    @BeforeEach
    public void init() {
      MockitoAnnotations.openMocks(this);
      System.out.println("in beforeEach method");
    }
    
	@Test
	public void whenNotUseMockAnnotation_thenCorrect() {
		System.out.println("...test 1 started...");
		
		List<String> mockList = Mockito.mock(ArrayList.class);

		mockList.add("one");
		Mockito.verify(mockList).add("one");
		assertEquals(0, mockList.size());

		Mockito.when(mockList.size()).thenReturn(100);
		assertEquals(100, mockList.size());
		
		System.out.println("...test 1 finished...");
	}

	@Mock
	List<String> mockedList;

	@Test
	public void whenUseMockAnnotation_thenMockIsInjected() {
		System.out.println("...test 2 started...");
		
		mockedList.add("one");
		Mockito.verify(mockedList).add("one");
		assertEquals(0, mockedList.size());

		Mockito.when(mockedList.size()).thenReturn(100);
		assertEquals(100, mockedList.size());
		
		System.out.println("...test 2 finished...");
	}
    
    
}
