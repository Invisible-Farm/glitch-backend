package com.loeaf.ivfm.service.impl;

import com.loeaf.common.misc.ServiceImpl;
import com.loeaf.ivfm.model.RecommandIncense;
import com.loeaf.ivfm.repository.RecommandIncenseRepository;
import com.loeaf.ivfm.service.RecommandIncenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class RecommandIncenseServiceImpl
        extends ServiceImpl<RecommandIncenseRepository, RecommandIncense, String>
        implements RecommandIncenseService {
    private final RecommandIncenseRepository jpaRepo;

    @PostConstruct
    private void init() {
        super.set(jpaRepo, new RecommandIncense());
    }
}
