package com.pl.flightsmaven.wings;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WingRepo extends CrudRepository<Wing, Long> {
   List<Wing> findAll();
}
