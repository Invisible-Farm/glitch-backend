package com.loeaf.ivfm.controller;

import com.loeaf.common.domain.ResResult;
import com.loeaf.file.service.AbsDataParserService;
import com.loeaf.ivfm.model.Community;
import com.loeaf.ivfm.model.Incense;
import com.loeaf.ivfm.service.CommunityService;
import com.loeaf.ivfm.service.IncenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/init")
public class InitController {
    @Autowired
    private IncenseService incenseService;
    @Autowired
    private CommunityService communityService;


    @PostMapping("/incense")
    public ResponseEntity<Object> InitIncense(HttpServletRequest request) throws IOException {
        AbsDataParserService absDataParserService = new AbsDataParserService() {
            @Override
            protected List procSampleDataObj(ArrayList<List<String>> parseDatas) {
                ArrayList<Incense> incenses = new ArrayList<>();
                for (int i = 0; i < parseDatas.size(); i++) {
                    List<String> parseData = parseDatas.get(i);
                    parseData.get(0);
                    Incense incense = new Incense(UUID.randomUUID().toString(), parseData.get(0));
                    incenses.add(incense);
                }
                return incenses;
            }
        };
        List<Incense> incenseList = absDataParserService.procParseFile("Incense.csv");
        for (Incense o : incenseList) {
            incenseService.regist(o);
        }
        return ResponseEntity.ok(1);
    }

    @PostMapping("/community")
    public ResponseEntity<Object> InitCommnit(HttpServletRequest request) throws IOException {
        AbsDataParserService absDataParserService = new AbsDataParserService() {
            @Override
            protected List procSampleDataObj(ArrayList<List<String>> parseDatas) {
                ArrayList<Community> incenses = new ArrayList<>();
                for (int i = 0; i < parseDatas.size(); i++) {
                    List<String> parseData = parseDatas.get(i);
                    parseData.get(0);
                    Community incense = new Community(UUID.randomUUID().toString(), parseData.get(0));
                    incenses.add(incense);
                }
                return incenses;
            }
        };
        List<Community> communityList = absDataParserService.procParseFile("community.csv");
        for (Community o : communityList) {
            communityService.regist(o);
        }
        return ResponseEntity.ok(1);
    }

}
