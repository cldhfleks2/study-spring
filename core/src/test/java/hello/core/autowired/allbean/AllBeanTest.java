package hello.core.autowired.allbean;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//동적으로 빈을 여러개 받아서 선택해야할때 Map을 사용한다. 는 예제
public class AllBeanTest {

	@Test
	void findAllBean() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
		
		DiscountService discountService = ac.getBean(DiscountService.class);
		Member member = new Member(1L, "userA", Grade.VIP);
//		이름이 fixDiscountPolicy인것을 찾는다.
		int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");
		
		assertThat(discountService).isInstanceOf(DiscountService.class);
		assertThat(discountPrice).isEqualTo(2000);
	}
	
	static class DiscountService{
		private final Map<String, DiscountPolicy> policyMap;
		private final List<DiscountPolicy> policies;

		@Autowired
		public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
			this.policyMap = policyMap;
			this.policies = policies;
		}

//		discountCode는 찾으려는 클래스이름
		public int discount(Member member, int price, String discountCode) {
			 DiscountPolicy discountPolicy = policyMap.get(discountCode);
			 
			 System.out.println("discountCode = " + discountCode);
			 System.out.println("discountPolicy = " + discountPolicy);
			 
			 return discountPolicy.discount(member, price);
		}
	}
	
	
	
	
	
	
	
}


