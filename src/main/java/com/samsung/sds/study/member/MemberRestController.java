package com.samsung.sds.study.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/member")
public class MemberRestController {

    @Autowired
    MemberRepository memberRepository;

    @GetMapping
    public List<Member> getMembers(){
        return memberRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Member> getMember(@PathVariable Long  id){
        return memberRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long  id){
        memberRepository.deleteById(id);
    }

    @DeleteMapping
    public void deleteMembers(){
        memberRepository.deleteAll();
    }

    @PutMapping("/{id}/name")
    public Member updateMemberName(@PathVariable Long  id,
                                   @RequestParam String name){
        Member member = memberRepository.findById(id).get();
        member.setName(name);
        return memberRepository.save(member);
    }






}
