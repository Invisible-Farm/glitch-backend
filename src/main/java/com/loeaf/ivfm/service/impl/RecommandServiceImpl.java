package com.loeaf.ivfm.service.impl;

import com.loeaf.common.misc.ServiceImpl;
import com.loeaf.ivfm.model.Recommand;
import com.loeaf.ivfm.repository.RecommandRepository;
import com.loeaf.ivfm.service.RecommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class RecommandServiceImpl
        extends ServiceImpl<RecommandRepository, Recommand, String>
        implements RecommandService {
    private final RecommandRepository jpaRepo;

    @PostConstruct
    private void init() {
        super.set(jpaRepo, new Recommand());
    }
}
