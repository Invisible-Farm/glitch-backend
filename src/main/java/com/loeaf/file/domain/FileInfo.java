package com.loeaf.file.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.loeaf.common.domain.Domain;
import com.loeaf.common.misc.Action;
import com.loeaf.file.domain.listener.FileInfoListener;
import com.loeaf.ivfm.model.Incense;
import com.loeaf.ivfm.model.NftType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.File;

/**
 * 파일에 대한 기본 정보를 구현하는 Model
 */
@Entity
@EntityListeners(FileInfoListener.class)
@Table(name="file_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileInfo extends Domain implements Action {
    /**
     * 파일명
     */
    @Column(name = "file_name")
    private String fileName;

    /**
     * 파일을 읽을때 식별하기 위한 폴더
     */
    @Column(name = "file_path")
    private String filePath;

    @Column(name = "file_url_path")
    private String fileUrlPath;

    @Column(name = "file_type")
    private String fileType;
    /**
     * 임시로 파일을 떨어틀어놓을 경로
     */
    private String tmpPath;
    /**
     * home에서 부터 target까지의 경로
     */
    private String localPath;

    /**
     * 파일경로
     */
    @Column(name = "origin_file_name")
    private String originFileName;

    /**
     * NFT 발행 시 종류
     */
    @Column(name = "nft_type")
    private NftType nftType;
    /**
     * NFT 토큰값
     */
    @Column(name = "nftToken")
    private String nftToken;

    /**
     * 확장자
     */
    @Column(name = "file_ext")
    private String fileExtention;

    private String smallFileName;

    private String NormalFileName;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @JsonBackReference
    private Incense incense;

    @Column
    private FileInfoType fileInfoType;

    @Column
    private FileInfoSubType fileInfoSubType;

    @Override
    public String toString() {
        return this.getFilePath() + "/" + this.getFileName() + "." + this.getFileExtention();
    }

    @Override
    public void delete() {
        new File(this.toString()).delete();
    }

}