package com.loeaf.ivfm.controller;

import com.loeaf.file.domain.FileInfo;
import com.loeaf.file.domain.FileInfoSubType;
import com.loeaf.file.domain.FileInfoType;
import com.loeaf.file.service.AbsDataParserService;
import com.loeaf.file.service.FileInfoService;
import com.loeaf.ivfm.dto.MintResultOutput;
import com.loeaf.ivfm.dto.params.PolygonMintParam;
import com.loeaf.ivfm.model.Incense;
import com.loeaf.ivfm.model.NftType;
import com.loeaf.siginin.util.HttpUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/polygon")
public class polygonController {
    @Autowired
    private FileInfoService fileInfoService;

    @PostMapping(value = "/mint")
    public ResponseEntity<Object> mint(@RequestBody PolygonMintParam id) {
        FileInfo fileInfo = this.fileInfoService.findById(id.getFileInfoId());
        if (fileInfo == null) {
            return ResponseEntity.ok(-1);
        }
        fileInfo.setTokenId(id.getTokenId());
        fileInfo.setTxHash(id.getTxHash());
        NftType nftType = NftType.valueOf(id.getSymbol());
        fileInfo.setSymbol(nftType);
        this.fileInfoService.regist(fileInfo);
        return ResponseEntity.ok(fileInfo);
    }
}