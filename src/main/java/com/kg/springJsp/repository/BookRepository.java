package com.kg.springJsp.repository;
import java.io.Serializable;
import com.kg.springJsp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Serializable>
 {
    
}