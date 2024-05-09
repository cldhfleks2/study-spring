package hello.core.beanfind;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class ApplicationContextSameBeanFindTest {
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);
	
	@Test
	@DisplayName("타입으로 조회시 같은 타입이 둘이상이면 중복 오류가 발생")
	void findBeanByTypeDuplicate() {
//		MemberRepository bean = ac.getBean(MemberRepository.class);
		
	}
	
	@Test
	@DisplayName("타입으로 조회시 같은 타입이 둘이상이면 중복 오류가 발생")
	void findBeanByName() {
		MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
		assertThat(memberRepository).isInstanceOf(MemberRepository.class);
	}
	
	@Test
	@DisplayName("특정 타입을 모두 조회하기")
	void findAllBeanByType() {
		Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
		for (String key : beansOfType.keySet()) {
			System.out.println("key = " + key + " value = " + beansOfType.get(key));
		}
		System.out.println(beansOfType);
		assertThat(beansOfType.size()).isEqualTo(2);
	}
	
	
	
	@Configuration
	static class SameBeanConfig{
		@Bean
		public MemberRepository memberRepository1() {
			return new MemoryMemberRepository();
		}
		
		@Bean
		public MemberRepository memberRepository2() {
			return new MemoryMemberRepository();
		}
	}
}
