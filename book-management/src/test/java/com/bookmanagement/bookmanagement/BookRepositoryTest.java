package com.bookmanagement.bookmanagement;

import com.bookmanagement.bookmanagement.entity.BookEntity;
import com.bookmanagement.bookmanagement.repository.BookRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest

public class BookRepositoryTest {

	@Autowired
	private TestEntityManager testEntityManager;
	@Autowired
	private BookRepository bookRepository;

	@Before
	public void setUp() {
		final BookEntity book01 = new BookEntity("Sale for Dummies", "Google", 49);
		final BookEntity book02 = new BookEntity("Sale for Strategy", "Google", 36);
		final BookEntity book03 = new BookEntity("Facebook guidelines for posts", "Facebook", 3000);
		testEntityManager.persist(book01);
		testEntityManager.persist(book02);
		testEntityManager.persist(book03);
	}

	@Test
	public void test_repository() {
		List<BookEntity> results = bookRepository.findDistinctByTextIgnoreCaseContaining("Sale for");
		Assert.assertEquals(2, results.size());
		Assert.assertTrue(results.get(0).getAuthor().equalsIgnoreCase("Google"));

		results = bookRepository.findDistinctByTextIgnoreCaseContaining("posts");
		Assert.assertEquals(1, results.size());
		Assert.assertTrue(results.get(0).getAuthor().equalsIgnoreCase("Facebook"));

		int copies = bookRepository.allCopiesByBookName("Sale for Dummies");
		Assert.assertEquals(49, copies);

		int copiesOfAuthor = bookRepository.allCopiesOfAuthor("Facebook");
		Assert.assertEquals(3000, copiesOfAuthor);
	}
}