package study_web.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study_web.spring.repository.MemberRepository;
import study_web.spring.repository.MemoryMemberRepository;
import study_web.spring.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
