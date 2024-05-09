package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
	
	private int discountFixAmount = 1000; //고정할인
	
	@Override
	public int discount(Member member, int price) {
		if(member.getGrade() == Grade.VIP) { //Enum에는 ==쓰는게맞
			return discountFixAmount;
		}
		
		return 0;
	}

}
