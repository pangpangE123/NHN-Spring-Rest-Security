package nhn.academy.controller;

import nhn.academy.model.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    @GetMapping("/name")
    public String getName(){
        return "신건영";
    }

    @GetMapping("/me")
    // TODO 2. Memeber 객체를 반환하고 어플리케이션을 실행시켜 요청을 시켰을때 기대하던 json형태의 데이터가 반환되는지 확인
    public Member getMe(){
        return new Member("신건영", 20);
    }
}
