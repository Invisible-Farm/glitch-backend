package com.loeaf.ivfm.service.impl;

import com.loeaf.common.misc.ServiceImpl;
import com.loeaf.ivfm.model.Incense;
import com.loeaf.ivfm.repository.IncenseRepository;
import com.loeaf.ivfm.service.IncenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class IncenseServiceImpl
        extends ServiceImpl<IncenseRepository, Incense, String>
        implements IncenseService {
    private final IncenseRepository jpaRepo;

    @PostConstruct
    private void init() {
        super.set(jpaRepo, new Incense());
    }
}
