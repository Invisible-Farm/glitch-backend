package com.loeaf.ivfm.repository;

import com.loeaf.ivfm.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community, String> {
}