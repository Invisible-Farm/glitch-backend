package com.loeaf.ivfm.repository;

import com.loeaf.ivfm.model.Recommand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommandRepository extends JpaRepository<Recommand, String> {
}