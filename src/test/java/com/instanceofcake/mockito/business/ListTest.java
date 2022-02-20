package com.instanceofcake.mockito.business;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void testSize() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);

		assertEquals(2, listMock.size());
	}

	@Test
	public void testSizeReturnMultipletimes() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());

	}

	@Test
	public void testGet() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn(23);
		assertEquals(23, listMock.get(0));
	}

	@Test
	public void testGetArgumentmatcher() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenReturn("Evy");
		assertEquals("Evy", listMock.get(0));
		assertEquals("Evy", listMock.get(3));

	}

	@Test(expected = NullPointerException.class)
	public void testException() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenThrow(NullPointerException.class);
		listMock.get(1);

	}

}
