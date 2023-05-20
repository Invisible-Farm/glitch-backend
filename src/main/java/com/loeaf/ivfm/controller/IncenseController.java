package com.loeaf.ivfm.controller;

import com.loeaf.common.domain.ResResult;
import com.loeaf.ivfm.model.Incense;
import com.loeaf.ivfm.service.IncenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/incense")
public class IncenseController {
    @Autowired
    private IncenseService incenseService;

    @GetMapping("")
    public ResponseEntity<ResResult> GetIncense(HttpServletRequest request) throws IOException {
        List<Incense> incenses = incenseService.findAll();
        return ResponseEntity.ok(new ResResult(incenses));
    }
}