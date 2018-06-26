package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface ListRepository extends CrudRepository<LinkList,Long> {
    Iterable<LinkList> findAllByUrlContainingIgnoreCase(String s);

}
