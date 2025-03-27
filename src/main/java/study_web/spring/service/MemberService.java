package study_web.spring.service;

import study_web.spring.domain.Member;
import study_web.spring.repository.MemberRepository;
import study_web.spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원X
        /*Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(member1 -> {
            throw new IllegalStateException("Member already exists");
        });*/
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(member1 -> {
                    throw new IllegalStateException("Member already exists");
                });
    }

    /**
     * 전체 회원 조회
     * */
    public List<Member> findMember() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
