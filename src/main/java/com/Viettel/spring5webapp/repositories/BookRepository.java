package com.Viettel.spring5webapp.repositories;

import com.Viettel.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
