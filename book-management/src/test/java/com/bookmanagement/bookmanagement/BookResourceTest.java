package com.bookmanagement.bookmanagement;

import com.bookmanagement.bookmanagement.model.BookDTO;
import com.bookmanagement.bookmanagement.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
@WebAppConfiguration
public class BookResourceTest {
    @MockBean
    private BookService bookService;
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    @Before
    public void setup() {
        // Setup MockMVC to use our Spring Configuration
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }


    @Test
    public void test_find_successful() throws Exception {
        final BookDTO dto1 = new BookDTO("mock text", "mock author", 15);
        List<BookDTO> dto = Arrays.asList(dto1);
        Mockito.when(bookService.findAll()).thenReturn(dto);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/v1/books/get-all").accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].text", is(dto.get(0).getText())))
            .andExpect(jsonPath("$[0].author", is(dto.get(0).getAuthor())))
            .andExpect(jsonPath("$[0].copies", is(dto.get(0).getCopies())));
    }
}
