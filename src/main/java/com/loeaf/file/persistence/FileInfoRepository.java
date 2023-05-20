package com.loeaf.file.persistence;

import com.loeaf.file.domain.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {

    List<FileInfo> findByTokenId(String tokenId);
}
