package com.loeaf.ivfm.controller;


import com.loeaf.common.domain.ResResult;
import com.loeaf.file.domain.FileInfo;
import com.loeaf.file.service.FileInfoService;
import com.loeaf.ivfm.dto.ImageByTokenIdOutput;
import com.loeaf.ivfm.model.Incense;
import com.loeaf.ivfm.model.NftType;
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
        NftType nftTypeInfo = NftType.GFT;
        if(nftType.equals("PSBT")){
            nftTypeInfo = NftType.PSBT;
        } else if(nftType.equals("IFT")){
            nftTypeInfo = NftType.IFT;
        } else {
            nftTypeInfo = NftType.GFT;

        }
        List<FileInfo> incenses = fileInfoService.findByTokenId(tokenId, nftTypeInfo);
        if (incenses == null) {
            return ResponseEntity.ok(new ImageByTokenIdOutput());
        }
        ImageByTokenIdOutput imageByTokenIdOutput = new ImageByTokenIdOutput();
        imageByTokenIdOutput.setImage(incenses.get(0).getFileUrlPath());
        imageByTokenIdOutput.setImage(incenses.get(0).getFileUrlPath());
        var p = incenses.get(0).getIncense();
        imageByTokenIdOutput.setIncense(p.getName());
        return ResponseEntity.ok(imageByTokenIdOutput);
    }
}