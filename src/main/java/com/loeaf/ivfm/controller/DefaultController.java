package com.loeaf.ivfm.controller;


import com.loeaf.common.domain.ResResult;
import com.loeaf.file.domain.FileInfo;
import com.loeaf.file.service.FileInfoService;
import com.loeaf.ivfm.dto.ImageByTokenIdOutput;
import com.loeaf.ivfm.model.Incense;
import com.loeaf.ivfm.service.IncenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping()
public class DefaultController {
    @Autowired
    private FileInfoService fileInfoService;
    @Autowired
    private IncenseService incenseService;

    @GetMapping("/{nftType}/{tokenId}")
    public ResponseEntity<ImageByTokenIdOutput> getImageByTokenId(@PathVariable("nftType")String nftType, @PathVariable("tokenId")String tokenId) throws IOException {
        System.out.println(nftType);
        FileInfo incenses = fileInfoService.findByTokenId(tokenId);
        ImageByTokenIdOutput imageByTokenIdOutput = new ImageByTokenIdOutput();
        imageByTokenIdOutput.setImage(incenses.getFileUrlPath());
        var p = incenses.getIncense();
        imageByTokenIdOutput.setIncense(p.getName());
        return ResponseEntity.ok(imageByTokenIdOutput);
    }
}