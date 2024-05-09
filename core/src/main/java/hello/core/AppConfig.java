package hello.core;


import hello.core.discount.DiscountPolicy;
//import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 생성자 주입 관리
@Configuration
public class AppConfig {
	
	//@Bean(name="") 이름지정가능
	@Bean //스프링 컨테이너에 등록시키는 어노테이션
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}
	
	@Bean
//	여기만 변경
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
	
	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
	@Bean
//	여기만 변경
	public DiscountPolicy discountPolicy() {
//		return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}
	
	
}
