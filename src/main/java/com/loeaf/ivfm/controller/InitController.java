package com.loeaf.ivfm.controller;

import com.loeaf.file.domain.FileInfo;
import com.loeaf.file.domain.FileInfoSubType;
import com.loeaf.file.domain.FileInfoType;
import com.loeaf.file.service.AbsDataParserService;
import com.loeaf.file.service.FileInfoService;
import com.loeaf.ivfm.model.Community;
import com.loeaf.ivfm.model.Incense;
import com.loeaf.ivfm.service.CommunityService;
import com.loeaf.ivfm.service.IncenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    @Autowired
    private FileInfoService fileInfoService;


    @PostMapping("/incense")
    public ResponseEntity<Object> InitIncense() throws IOException {
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

    @PostMapping("/incense_img")
    public ResponseEntity<Object> incenseImg(HttpServletRequest request) throws IOException {
        AbsDataParserService absDataParserService = new AbsDataParserService() {
            @Override
            protected List procSampleDataObj(ArrayList<List<String>> parseDatas) {
                ArrayList<FileInfo> obj = new ArrayList<>();
                for (int i = 0; i < parseDatas.size(); i++) {
                    List<String> parseData = parseDatas.get(i);
                    String incesnseType = parseData.get(0);
                    String incesnseFileName = parseData.get(1);
                    FileInfo instance = new FileInfo();
                    instance.setId(UUID.randomUUID().toString());
                    instance.setIncense(incenseService.findByIncenseType(incesnseType));
                    instance.setFileName(incesnseFileName);
                    instance.setFilePath("/IVFN/Incense");
                    instance.setFileUrlPath("https://dhk.ha.nso.li/IVFN/Incense"+"/"+incesnseFileName);
                    instance.setFileInfoType(FileInfoType.IMAGE);
                    instance.setFileInfoSubType(FileInfoSubType.INCENSE);
                    obj.add(instance);
                }
                return obj;
            }
        };
        List<FileInfo> communityList = absDataParserService.procParseFile("incense_img.csv");
        for (FileInfo o : communityList) {
            fileInfoService.regist(o);
        }
        return ResponseEntity.ok(1);
    }

    @PostMapping("/incense_media")
    public ResponseEntity<Object> incenseMedia(HttpServletRequest request) throws IOException {
        AbsDataParserService absDataParserService = new AbsDataParserService() {
            @Override
            protected List procSampleDataObj(ArrayList<List<String>> parseDatas) {
                ArrayList<FileInfo> obj = new ArrayList<>();
                for (int i = 0; i < parseDatas.size(); i++) {
                    List<String> parseData = parseDatas.get(i);
                    String incesnseType = parseData.get(0);
                    String incesnseFileName = parseData.get(1);
                    FileInfo instance = new FileInfo();
                    instance.setId(UUID.randomUUID().toString());
                    instance.setIncense(incenseService.findByIncenseType(incesnseType));
                    instance.setFileName(incesnseFileName);
                    instance.setFilePath("/IVFN/proofOfValue/media");
                    instance.setFileUrlPath("https://dhk.ha.nso.li/IVFN/proofOfValue/media"+"/"+incesnseFileName);
                    instance.setFileInfoType(FileInfoType.VIDEO);
                    instance.setFileInfoSubType(FileInfoSubType.PROOFOFVALUE);
                    obj.add(instance);
                }
                return obj;
            }
        };
        List<FileInfo> communityList = absDataParserService.procParseFile("incense_media.csv");
        for (FileInfo o : communityList) {
            fileInfoService.regist(o);
        }
        return ResponseEntity.ok(1);
    }

    @PostMapping("/incense_sumnail")
    public ResponseEntity<Object> incenseSumnail(HttpServletRequest request) throws IOException {
        AbsDataParserService absDataParserService = new AbsDataParserService() {
            @Override
            protected List procSampleDataObj(ArrayList<List<String>> parseDatas) {
                ArrayList<FileInfo> obj = new ArrayList<>();
                for (int i = 0; i < parseDatas.size(); i++) {
                    List<String> parseData = parseDatas.get(i);
                    String incesnseType = parseData.get(0);
                    String incesnseFileName = parseData.get(1);
                    FileInfo instance = new FileInfo();
                    instance.setId(UUID.randomUUID().toString());
                    instance.setIncense(incenseService.findByIncenseType(incesnseType));
                    instance.setFileName(incesnseFileName);
                    instance.setFilePath("/IVFN/proofOfValue/sumnail");
                    instance.setFileUrlPath("https://dhk.ha.nso.li/IVFN/proofOfValue/sumnail"+"/"+incesnseFileName);
                    instance.setFileInfoType(FileInfoType.IMAGE);
                    instance.setFileInfoSubType(FileInfoSubType.PROOFOFVALUE);
                    obj.add(instance);
                }
                return obj;
            }
        };
        List<FileInfo> communityList = absDataParserService.procParseFile("incense_media_sumnail.csv");
        for (FileInfo o : communityList) {
            fileInfoService.regist(o);
        }
        return ResponseEntity.ok(1);
    }

}
