package com.loeaf.ivfm.service.impl;

import com.loeaf.common.misc.ServiceImpl;
import com.loeaf.ivfm.model.Community;
import com.loeaf.ivfm.repository.CommunityRepository;
import com.loeaf.ivfm.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl
        extends ServiceImpl<CommunityRepository, Community, String>
        implements CommunityService {
    private final CommunityRepository jpaRepo;

    @PostConstruct
    private void init() {
        super.set(jpaRepo, new Community());
    }
}
