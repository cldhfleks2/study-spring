package hello.core.beanfind;

import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import hello.core.discount.DiscountPolicy;

public class ApplicationContextExtendsFindTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

	@Test
	@DisplayName("부모타입 조회시 자식이 둘이상이면 중복오류")
	void findBeanByParentTypeDuplicate() {
		assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(DiscountPolicy.class));
	}

	@Test
	@DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 빈 이름을 지정하면 된다")
	void findBeanByParentTypeBeanName() {
		
	}

	@Test
	@DisplayName("특정 하위 타입으로 조회")
	void findBeanBySubType() {
		
	}

	@Test
	@DisplayName("부모 타입으로 모두 조회하기")
	void findAllBeanByParentType() {
		
	}
	
	
	
	
	
	@Configuration
	static class TestConfig{
		
	}
}
