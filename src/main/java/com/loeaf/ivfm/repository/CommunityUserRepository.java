package com.loeaf.ivfm.repository;

import com.loeaf.ivfm.model.CommunityUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityUserRepository extends JpaRepository<CommunityUser, String> {
}