//6
package com.example.LibManagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    public Book save(Book book){
        return bookRepository.save(book);
    }
    public List<Book> fetchAllbooks(){
        return bookRepository.findAll();
    }
    public Optional<Book> findById(Long id){
        return bookRepository.findById(id);
    }
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
    public Book borrowBook(Long bookId, Long userId) {
        Book book = findById(bookId).orElseThrow(() -> new RuntimeException("Book with ID " + bookId + " not found"));
        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User with Id "+userId+"does not exist"));

        if (book != null && !book.isBorrowed() && user != null) {
            book.setBorrowedBy(user);
            book.setBorrowed(true);
            return save(book);
        }
        // Handle errors (e.g., book not found, book already borrowed, user not found)
        return null;
    }

    public Book returnBook(Long bookId){
        Book book = findById(bookId).orElseThrow(() -> new RuntimeException("Book with ID " + bookId + " not found"));

        if(book.isBorrowed()){
            book.setBorrowedBy(null);
            book.setBorrowed(false);
            return save(book);
        }
        return null;
    }

}
