package com.loeaf.ivfm.controller;

import com.loeaf.common.domain.ResResult;
import com.loeaf.file.service.AbsDataParserService;
import com.loeaf.ivfm.model.Incense;
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


    @PostMapping("/incense")
    public ResponseEntity<Object> InitIncense(HttpServletRequest request) throws IOException {
        List<Incense> incenses = new ArrayList<>();
        AbsDataParserService absDataParserService = new AbsDataParserService() {
            @Override
            protected List procSampleDataObj(ArrayList<List<String>> parseDatas) {
                ArrayList<Incense> incenses = new ArrayList<>();
                for (int i = 0; i < parseDatas.size(); i++) {
                    List<String> parseData = parseDatas.get(i);
                    parseData.get(0);
                    parseData.get(1);
                    Incense incense = new Incense(UUID.randomUUID().toString(), parseData.get(0), parseData.get(1));
                    incenses.add(incense);
                }
                return incenses;
            }
        };
        List<Incense> incenseList = absDataParserService.procParseFile("incense.csv");
        for (Incense o : incenseList) {
            incenseService.regist(o);
        }
        return ResponseEntity.ok(1);
    }

    @GetMapping("/incense")
    public ResponseEntity<ResResult> GetIncense(HttpServletRequest request) throws IOException {
        List<Incense> incenses = incenseService.findAll();
        return ResponseEntity.ok(new ResResult(incenses));
    }

}
