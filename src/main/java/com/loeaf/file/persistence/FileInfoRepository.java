package com.loeaf.file.persistence;

import com.loeaf.file.domain.FileInfo;
import com.loeaf.ivfm.model.Incense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {

    FileInfo findByTokenId(String tokenId);
}
