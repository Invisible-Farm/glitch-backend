package com.loeaf.ivfm.controller;

import com.loeaf.file.domain.FileInfo;
import com.loeaf.file.service.FileInfoService;
import com.loeaf.ivfm.dto.params.RecommandParam;
import com.loeaf.ivfm.model.Incense;
import com.loeaf.ivfm.model.Recommand;
import com.loeaf.ivfm.model.RecommandIncense;
import com.loeaf.ivfm.service.IncenseService;
import com.loeaf.ivfm.service.RecommandIncenseService;
import com.loeaf.ivfm.service.RecommandService;
import com.loeaf.siginin.dto.param.UserParam;
import com.loeaf.siginin.model.Account;
import com.loeaf.siginin.service.AccountService;
import com.loeaf.siginin.service.SigininService;
import com.loeaf.siginin.service.UserService;
import com.loeaf.siginin.types.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.FilenameFilter;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/recommand")
public class RecommandController {
    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private RecommandService recommandService;
    @Autowired
    private RecommandIncenseService recommandIncenseService;
    @Autowired
    private SigininService sigininService;
    @Autowired
    private IncenseService incenseService;
    @Autowired
    private FileInfoService fileInfoService;


    @PostMapping()
    public ResponseEntity<Object> mint(@RequestBody RecommandParam recommandParam) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        // 1. 커뮤니티 아이디로 부터 객체가 있는지 찾는다.
        // from 유저 찾기
        Account fromAccount = getAccount(recommandParam.getFrom());
        Account toAccount = getAccount(recommandParam.getTo());
        Incense incense = this.incenseService.findById(recommandParam.getIncenseUuid());
        FileInfo incenseFile = this.fileInfoService.findById(recommandParam.getIncenseImgUuid());
        FileInfo profOfValueFile = this.fileInfoService.findById(recommandParam.getProfOfValueUuid());
        FileInfo profOfValueSumnailFile = this.fileInfoService.findById(recommandParam.getProfOfValueSumnailUuid());

        // recommand 등록 진행
        Recommand recommand = new Recommand();
        recommand.setId(UUID.randomUUID().toString());
        recommand.setStroy(recommandParam.getStory());
        recommand.setFromUser(fromAccount.getUser());
        recommand.setToUser(toAccount.getUser());
        recommand.setMyResponse(recommandParam.getMyResponse());
        recommand.setRegistDate(new Date());
        Recommand result = this.recommandService.regist(recommand);

        RecommandIncense recommandIncense = new RecommandIncense();
        recommandIncense.setId(UUID.randomUUID().toString());
        recommandIncense.setIncense(incense);
        recommandIncense.setRecommand(recommand);
        var recommandVal = this.recommandIncenseService.regist(recommandIncense);

        // 4. Incense 파일 등록
        // 4-1. incense로 부터 파일을 찾는다.
        // 4-2. incense img 등록
        FileInfo incenseRepleFile = new FileInfo();
        incenseRepleFile.setId(UUID.randomUUID().toString());
        incenseRepleFile.setFileName(incenseFile.getFileName());
        incenseRepleFile.setFilePath(incenseFile.getFilePath());
        incenseRepleFile.setFileType(incenseFile.getFileType());
        incenseRepleFile.setFileUrlPath(incenseFile.getFileUrlPath());
        incenseRepleFile.setFileInfoType(incenseFile.getFileInfoType());
        incenseRepleFile.setFileInfoSubType(incenseFile.getFileInfoSubType());
        incenseRepleFile.setRecommandIncense(recommandVal);
        incenseRepleFile.setIncense(incense);
        fileInfoService.regist(incenseRepleFile);

        // 4-3. incnese movie 등록
        FileInfo profOfValueRepleFile = new FileInfo();
        profOfValueRepleFile.setId(UUID.randomUUID().toString());
        profOfValueRepleFile.setFileName(profOfValueFile.getFileName());
        profOfValueRepleFile.setFilePath(profOfValueFile.getFilePath());
        profOfValueRepleFile.setFileType(profOfValueFile.getFileType());
        profOfValueRepleFile.setFileUrlPath(profOfValueFile.getFileUrlPath());
        profOfValueRepleFile.setFileInfoType(profOfValueFile.getFileInfoType());
        profOfValueRepleFile.setFileInfoSubType(profOfValueFile.getFileInfoSubType());
        profOfValueRepleFile.setRecommandIncense(recommandVal);
        profOfValueRepleFile.setIncense(incense);
        fileInfoService.regist(profOfValueRepleFile);

        // 4-4. incnese sumnail 등록
        FileInfo profOfValueSumnailRepleFile = new FileInfo();
        profOfValueSumnailRepleFile.setId(UUID.randomUUID().toString());
        profOfValueSumnailRepleFile.setFileName(profOfValueSumnailFile.getFileName());
        profOfValueSumnailRepleFile.setFilePath(profOfValueSumnailFile.getFilePath());
        profOfValueSumnailRepleFile.setFileType(profOfValueSumnailFile.getFileType());
        profOfValueSumnailRepleFile.setFileUrlPath(profOfValueSumnailFile.getFileUrlPath());
        profOfValueSumnailRepleFile.setFileInfoType(profOfValueSumnailFile.getFileInfoType());
        profOfValueSumnailRepleFile.setFileInfoSubType(profOfValueSumnailFile.getFileInfoSubType());
        profOfValueSumnailRepleFile.setRecommandIncense(recommandVal);
        profOfValueSumnailRepleFile.setIncense(incense);
        fileInfoService.regist(profOfValueSumnailRepleFile);

        // 5-2. Movie 파일
        // 5-3. Movie Sumnail 파일
        // 5-4. Certification 파일
        return ResponseEntity.ok(result);
    }

    private Account getAccount(String recommandParam) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String fromUuid = recommandParam;
        Account fromAccount = accountService.findByLoginIdAndType(fromUuid, AccountType.WALLET);
        // 2. 회원처리
        if (fromAccount == null) {
            // 유저 아이디가 없으면 user 회원 추가
            UserParam userForm = new UserParam();
            userForm.setLoginId(fromUuid);
            userForm.setAccountType(AccountType.WALLET.getValue());
            sigininService.signUp(userForm);
            fromAccount = accountService.findByLoginIdAndType(fromUuid, AccountType.WALLET);
        } return fromAccount;
    }
}