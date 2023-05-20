package com.loeaf.ivfm.controller;

import com.loeaf.ivfm.dto.params.RecommandParam;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recommand")
public class RecommandController {

    @PostMapping()
    public ResponseEntity<Object> mint(@RequestBody RecommandParam recommandParam) {
        // 1. 커뮤니티 아이디로 부터 객체가 있는지 찾는다.
        // 2. 회원처리
        // 유저 아이디가 없으면 user 회원 추가
        // 있으면 회원 값을 가지고 사용
        // 3. 인센스 아이디로 부터 객체가 있는지 찾는다.
        // 4. Recommand 테이블로 insert 진행
        return ResponseEntity.ok(null);
    }
}