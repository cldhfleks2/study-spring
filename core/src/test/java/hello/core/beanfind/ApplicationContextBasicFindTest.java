package hello.core.beanfind;


import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

//import static org.assertj.core.api.Assertions.assertThat;


public class ApplicationContextBasicFindTest {
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	@DisplayName("빈 이름으로 조회")
	public void findBeanByName() {
		MemberService memberService = ac.getBean(MemberService.class);
//		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	@DisplayName("구체 타입으로 조회")
	//유연성이 떨어짐
	public void findBeanByName2() {
		MemberService memberService = ac.getBean("memberService", MemberService.class);
//		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	@Test
	@DisplayName("빈 이름으로 조회 실패예제")
	public void findBeanByNameX() {
//		없는 빈 이름을 조회했으므로 이것은 예외가 터지는 상황이다. 
//		ac.getBean("XXXXX", MemberService.class);
		
		
//		() 함수를 실행시 해당 예외가 터져야함을 assertThrows으로 확인
		assertThrows(NoSuchBeanDefinitionException.class, 
				() -> ac.getBean("XXXXX", MemberService.class));
	}
	
	
	
	
	
	
	
	
	
}
