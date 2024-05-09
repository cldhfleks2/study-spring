package hello.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicyTest {
	
	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
	
	@Test
	@DisplayName("VIP 는 10%할인")
	void vip_o() {
		//given
		Member member = new Member(1L, "memberVIP", Grade.VIP);
		
		//when
		int discount = discountPolicy.discount(member, 10000);
		
		//then
		Assertions.assertThat(discount).isEqualTo(1000);
		
		
	}
	
	@Test
	@DisplayName("VIP아니면 노 할ㅇ린")
	void vip_x() {
		//given
		Member member = new Member(2L, "memberBASIC", Grade.BASIC);
		
		//when
		int discount = discountPolicy.discount(member, 10000);
		
		//then
		Assertions.assertThat(discount).isEqualTo(0);
		
		
	}
}
