package com.bookmanagement.bookmanagement;

import com.bookmanagement.bookmanagement.entity.BookEntity;
import com.bookmanagement.bookmanagement.exception.ResourceNotFoundException;
import com.bookmanagement.bookmanagement.repository.BookRepository;
import com.bookmanagement.bookmanagement.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void test_delete_successful() {
        final BookEntity mockEntity = new BookEntity(9L, "text delete test","author delete test", 10);
        doReturn(Optional.of(mockEntity)).when(bookRepository).findById(Mockito.anyLong());
        bookService.delete(9L);
        Mockito.verify(bookRepository, Mockito.atLeastOnce()).delete(Mockito.any(BookEntity.class));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void test_delete_throw_exception() {
        doReturn(Optional.empty()).when(bookRepository).findById(Mockito.anyLong());
        bookService.delete(10L);
    }

}