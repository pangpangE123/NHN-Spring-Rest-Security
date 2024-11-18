package nhn.academy.controller;

import nhn.academy.model.ClassType;
import nhn.academy.model.Member;
import nhn.academy.model.MemberCreateCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    @GetMapping("/name")
    public String getName(){
        return "신건영";
    }

    @GetMapping("/me")
    public Member getMe(){
        return new Member("신건영", 10, "admin",ClassType.A);
    }

    @PostMapping("/members")
    public ResponseEntity addMember(@RequestBody  MemberCreateCommand memberCreateCommand){
        System.out.println(memberCreateCommand);
        return ResponseEntity.ok().build();
    }
}
