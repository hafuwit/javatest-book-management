package com.bookmanagement.bookmanagement.service;

import com.bookmanagement.bookmanagement.entity.BookEntity;
import com.bookmanagement.bookmanagement.exception.ResourceNotFoundException;
import com.bookmanagement.bookmanagement.exception.ValidationInputException;
import com.bookmanagement.bookmanagement.model.BookDTO;
import com.bookmanagement.bookmanagement.repository.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.awt.print.Book;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    private Supplier<? extends RuntimeException> resourceNotFoundException = () -> new ResourceNotFoundException("Resource not found.");
    private final String MISSING_MANDATORY_FIELD = "Missing mandatory fields";

    public void delete(final Long id) {
        final BookEntity entity = bookRepository.findById(id).orElseThrow(resourceNotFoundException);
        bookRepository.delete(entity);
    }

    public BookDTO create(final BookDTO dto) {
        if (StringUtils.isEmpty(dto.getText())) {
            throw new ValidationInputException(MISSING_MANDATORY_FIELD);
        }
        final BookEntity entity = new BookEntity(dto.getText(), dto.getAuthor(), dto.getCopies());
        bookRepository.save(entity);
        return convertFromEntity(entity);
    }

    public BookDTO update(final Long id, final BookDTO dto) {
        final BookEntity entity = bookRepository.findById(id).orElseThrow(resourceNotFoundException);
        if (StringUtils.isEmpty(dto.getText())) {
            throw new ValidationInputException(MISSING_MANDATORY_FIELD);
        }
        entity.setAuthor(dto.getAuthor());
        entity.setText(dto.getText());
        entity.setCopies(dto.getCopies());
        bookRepository.save(entity);
        return this.convertFromEntity(entity);
    }

    public List<BookDTO> find(final String text) {
        if (StringUtils.isEmpty(text)) {
            return bookRepository.findAll().stream()
                    .map(this::convertFromEntity)
                    .collect(Collectors.toList());
        }
        return bookRepository.findDistinctByTextIgnoreCaseContaining(text).stream()
                .map(this::convertFromEntity)
                .collect(Collectors.toList());
    }

    public List<BookDTO> findAll() {
        return bookRepository.findAll().stream()
                .map(this::convertFromEntity)
                .collect(Collectors.toList());
    }

    public Integer getCopiesByBookName(final String text) {
        if (StringUtils.isEmpty(text)) {
            return 0;
        }
        return bookRepository.allCopiesByBookName(text);
    }

    public List<BookDTO> findAuthor(final String author) {
        if (StringUtils.isEmpty(author)) {
            return bookRepository.findAll().stream()
                    .map(this::convertFromEntity)
                    .collect(Collectors.toList());
        }
        return bookRepository.findAuthor(author).stream()
                .map(this::convertFromEntity)
                .collect(Collectors.toList());
    }

    public Integer allCopiesOfAuthor(final String author) {
        if (StringUtils.isEmpty(author)) {
            return 0;
        }
        return bookRepository.allCopiesOfAuthor(author);
    }

    private BookDTO convertFromEntity(final BookEntity entity) {
        final BookDTO result = new BookDTO();
        BeanUtils.copyProperties(entity, result);
        return result;
    }
}
