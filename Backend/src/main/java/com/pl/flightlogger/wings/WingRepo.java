package com.pl.flightlogger.wings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WingRepo extends JpaRepository<Wing, Long> {

}
