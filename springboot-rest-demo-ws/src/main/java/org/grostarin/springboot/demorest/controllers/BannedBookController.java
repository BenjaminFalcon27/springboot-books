package org.grostarin.springboot.demorest.controllers;

import javax.validation.Valid;

import org.grostarin.springboot.demorest.annotations.LogExecutionTime;
import org.grostarin.springboot.demorest.domain.BannedBook;
import org.grostarin.springboot.demorest.domain.Book;
import org.grostarin.springboot.demorest.dto.BannedBookSearch;
import org.grostarin.springboot.demorest.dto.BookSearch;
import org.grostarin.springboot.demorest.services.BannedBookService;
import org.grostarin.springboot.demorest.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/banned-books")
public class BannedBookController {

  @Autowired
  private BannedBookService bannedBookService;

  @GetMapping
  @LogExecutionTime
  public Iterable<BannedBook> findAll(@Valid BannedBookSearch bookSearchDTO) {
    return bannedBookService.findAll(bookSearchDTO);
  }

  @GetMapping("/{id}")
  public BannedBook findOne(@PathVariable long id) {
    return bannedBookService.findOne(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public BannedBook create(@RequestBody BannedBook book) {
    return bannedBookService.create(book);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable long id) {
    bannedBookService.delete(id);
  }

  @PutMapping("/{id}")
  public BannedBook updateBook(@RequestBody BannedBook book, @PathVariable long id) {
    return bannedBookService.updateBook(book, id);
  }
}
