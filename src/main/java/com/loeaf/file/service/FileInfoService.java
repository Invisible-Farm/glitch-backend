package com.loeaf.file.service;

import com.loeaf.common.misc.Service;
import com.loeaf.file.domain.FileInfo;
import com.loeaf.ivfm.model.Incense;
import com.loeaf.ivfm.model.NftType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileInfoService extends Service<FileInfo, String> {
    List<FileInfo> procCPFiles(MultipartFile[] multipartFiles);
    void sendS3Files() throws IOException;

    List<FileInfo> findByTokenId(String tokenId, NftType nftTypeInfo);
}
