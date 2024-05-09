package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

import org.springframework.context.annotation.Bean;
@Configuration
//기존의 Configuration이 붙은것들을 전부 설정정보로 등록됨을 방지하고
//컴포넌트 스캔을 실행
@ComponentScan( 
//		basePackages = "hello.core.member",
		excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
	
	
	
}
