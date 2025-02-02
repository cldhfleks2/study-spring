package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
//import hello.core.member.MemberServiceImpl;

public class MemberApp {
	public static void main(String[] args) {
//		MemberService memberService = new MemberServiceImpl();
		
//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = appConfig.memberService();
		
		//스프링컨테이너 객체 (bean등을 관리 해주는곳)
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService
		= applicationContext.getBean("memberService", MemberService.class);
		
		
		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);
		
		
		
		
		Member findMember = memberService.findMember(1L);
	}
}
