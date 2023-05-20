package com.loeaf.ivfm.repository;

import com.loeaf.ivfm.model.Incense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncenseRepository extends JpaRepository<Incense, String> {
    Incense findByName(String incesnseType);
}