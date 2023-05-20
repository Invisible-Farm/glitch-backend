package com.loeaf.file.persistence;

import com.loeaf.file.domain.FileInfo;
import com.loeaf.ivfm.model.NftType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {

    List<FileInfo> findByTokenIdAndSymbol(String tokenId, NftType nftTypeInfo);
}
