package com.bookmanagement.bookmanagement.resource;

import com.bookmanagement.bookmanagement.model.BookDTO;
import com.bookmanagement.bookmanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/books")
public class BookResource {

    @Autowired
    private BookService bookService;


    //1. create a book
    @PostMapping
    public ResponseEntity<BookDTO> create(@Valid @RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok().body(bookService.create(bookDTO));
    }

    //2. update a book with a specific id
    @PutMapping(path = "/{book-id}")
    public ResponseEntity<BookDTO> update(@PathVariable("book-id") Long id, @Valid @RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok().body(bookService.update(id, bookDTO));
    }

    //3. delete a book with a specific id
    @DeleteMapping(path = "/{book-id}")
    public ResponseEntity delete(@PathVariable("book-id") Long id) {
        bookService.delete(id);
        return ResponseEntity.ok().build();
    }

    //4. get all books
    @GetMapping(path = "/get-all")
    public ResponseEntity<List<BookDTO>> getAllBook() {
        return ResponseEntity.ok().body(bookService.findAll());
    }

    //5. get books that contain specific book name
    @GetMapping
    public ResponseEntity<List<BookDTO>> find(@RequestParam(value = "text", required = false) String text) {
        return ResponseEntity.ok().body(bookService.find(text));
    }

    //6. get all copies by book name
    @GetMapping(path = "/copies-book")
    public ResponseEntity<Integer> getCopiesByBookName(@RequestParam(value = "text", required = false) String text) {
        return ResponseEntity.ok().body(bookService.getCopiesByBookName(text));
    }

    //get all books of author
    @GetMapping(path = "/author")
    public ResponseEntity<List<BookDTO>> findAuthor(@RequestParam(value = "author", required = false) String author) {
        return ResponseEntity.ok().body(bookService.findAuthor(author));
    }

    //7. get all copies books of author
    @GetMapping(path = "/copies-author")
    public ResponseEntity<Integer> allCopiesOfAuthor(@RequestParam(value = "author", required = false) String author) {
        return ResponseEntity.ok().body(bookService.allCopiesOfAuthor(author));
    }
}
