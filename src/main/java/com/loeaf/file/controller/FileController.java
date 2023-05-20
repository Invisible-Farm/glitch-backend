package com.loeaf.file.controller;

import com.loeaf.common.domain.ResResult;
import com.loeaf.file.domain.FileInfo;
import com.loeaf.file.domain.FileInfoSubType;
import com.loeaf.file.domain.FileInfoType;
import com.loeaf.file.service.FileInfoService;
import com.loeaf.ivfm.dto.FileInfoImageSet;
import com.loeaf.ivfm.dto.ImageByTokenIdOutput;
import com.loeaf.ivfm.model.Incense;
import com.loeaf.ivfm.service.IncenseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/file")
@Api(value = "file")
public class FileController {
    @Autowired
    private FileInfoService service;
    @Autowired
    private IncenseService incenseService;
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("image") MultipartFile file) {
        List<FileInfo> result = this.service.procCPFiles(new MultipartFile[]{file});
        ResResult resResult = new ResResult();
        resResult.setData(result);
        return ResponseEntity.ok(resResult);
    }
    @GetMapping("/incense/{id}")
    public ResponseEntity<?> uploadFile(@PathVariable("id")String id) {
        FileInfoImageSet fileInfoImageSet = new FileInfoImageSet();
        Incense incense = this.incenseService.findById(id);
        // 인센스 이미지 처리
        List<FileInfo> fileInfos = incense.getFileInfos().stream().filter(p ->
                p.getFileInfoType().equals(FileInfoType.IMAGE)
                &&
                p.getFileInfoSubType().equals(FileInfoSubType.INCENSE)).collect(Collectors.toList());
        FileInfo fileInfo = fileInfos.get((int)(Math.random() * fileInfos.size()));
        fileInfoImageSet.setIncenseImageId(fileInfo.getId());
        fileInfoImageSet.setIncenseImage(fileInfo.getFileUrlPath());
        // Prov 미디어 처리
        List<FileInfo> proofFileVod = incense.getFileInfos().stream().filter(p ->
                p.getFileInfoType().equals(FileInfoType.VIDEO)
                &&
                p.getFileInfoSubType().equals(FileInfoSubType.PROOFOFVALUE)).collect(Collectors.toList());
        if (proofFileVod.size() > 0) {
            fileInfoImageSet.setProofOfValueMovieId(proofFileVod.get(0).getId());
            fileInfoImageSet.setProofOfValueMovie(proofFileVod.get(0).getFileUrlPath());
        }
        // Prov 이미지 처리
        List<FileInfo> proofFileImg = incense.getFileInfos().stream().filter(p ->
                p.getFileInfoType().equals(FileInfoType.IMAGE)
                &&
                p.getFileInfoSubType().equals(FileInfoSubType.PROOFOFVALUE)).collect(Collectors.toList());
        if (proofFileImg.size() > 0) {
            fileInfoImageSet.setProofOfValueImageId(proofFileImg.get(0).getId());
            fileInfoImageSet.setProofOfValueImage(proofFileImg.get(0).getFileUrlPath());
        }
        // get random image
        return ResponseEntity.ok(fileInfoImageSet);
    }
}