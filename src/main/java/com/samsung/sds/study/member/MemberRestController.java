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
    @PutMapping("/{id}/email")
    public Member updateMemberEmail(@PathVariable Long  id,
                                    @RequestParam String email){
        Member member = memberRepository.findById(id).get();
        member.setEmail(email);
        return memberRepository.save(member);
    }
    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long  id,
                               @RequestParam String name,
                               @RequestParam String email){
        Member member = memberRepository.findById(id).get();
        member.setEmail(email);
        member.setName(name);
        return memberRepository.save(member);
    }

    @PostMapping("/member")
    public Member setMember(@RequestParam String name,
                            @RequestParam String email){
        Member member = new Member();
        member.setEmail(email);
        member.setName(name);
        return memberRepository.save(member);
    }

}
