package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.*;
import hello.core.order.*;

public class OrderApp {
	public static void main(String[] args) {
//		직접 AppConfig를 사용하여 객체를 생성, DI사용하는 예제
//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = appConfig.memberService();
//		OrderService orderService = appConfig.orderService();
		
//		본격적으로 스프링컨테이너를 사용하는 방법
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
		
		
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(memberId, "itemA", 20000);
		
		//System.out.println("order = " + order.toString()); 똑같음
		System.out.println("order = " + order);
		System.out.println("order = " + order.calculatePrice());
	}
}
