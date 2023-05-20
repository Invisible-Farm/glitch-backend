package com.loeaf.ivfm.controller;

import com.loeaf.common.domain.ResResult;
import com.loeaf.ivfm.model.Community;
import com.loeaf.ivfm.model.Incense;
import com.loeaf.ivfm.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/community")
public class CommunityController {
    @Autowired
    private CommunityService communityService;

    @GetMapping("")
    public ResponseEntity<ResResult> GetCommunity(HttpServletRequest request) throws IOException {
        List<Community> incenses = communityService.findAll();
        return ResponseEntity.ok(new ResResult(incenses));
    }
}