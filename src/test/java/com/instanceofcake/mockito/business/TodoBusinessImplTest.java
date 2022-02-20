package com.instanceofcake.mockito.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.instanceofcake.mockito.data.api.TodoService;
import com.instanceofcake.mockito.data.api.TodoServiceStub;

public class TodoBusinessImplTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_UsingStub() {
		TodoService stub = new TodoServiceStub();
		TodoBusinessImpl todo = new TodoBusinessImpl(stub);

		List<String> actual = todo.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, actual.size());
		assertEquals(Arrays.asList("Learn Spring MVC", "Learn Spring"), actual);
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_UsingMock() {
		TodoService mockTodoService = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		when(mockTodoService.retrieveTodos("Dummy")).thenReturn(todos);
		TodoBusinessImpl todo = new TodoBusinessImpl(mockTodoService);

		List<String> actual = todo.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, actual.size());
		assertEquals(Arrays.asList("Learn Spring MVC", "Learn Spring"), actual);
		
	    verify(mockTodoService).retrieveTodos("Dummy");
	    verify(mockTodoService,never()).retrieveTodos("Dummy1");
	    verify(mockTodoService,times(1)).retrieveTodos("Dummy");
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_UsingBDDMock() {
		// Given --> setup
		TodoService mockTodoService = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		given(mockTodoService.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl todo = new TodoBusinessImpl(mockTodoService);

		// When --> actual method call
		List<String> actual = todo.retrieveTodosRelatedToSpring("Dummy");

		// Then --> assertion
		assertEquals(2, actual.size());
		assertEquals(Arrays.asList("Learn Spring MVC", "Learn Spring"), actual);

	}

}
