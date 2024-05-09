package hello.core.singleton;

// 싱글톤 패턴 구현하는 방법은 많다.
public class SingletonServiceTest {
//  static이라 딱 하나만 존재함	
	private static final SingletonServiceTest instance = new SingletonServiceTest();
	
// 외부에서 new생성자 호출을 막음
// 중요!!
	private SingletonServiceTest() { }
	
	
	
	//생성자를 이렇게 내보낸다..
	public static SingletonServiceTest getInstance() {
		return instance;
	}
	
	
	
	public void logic() {
		System.out.println("싱글톤 객체 로직 호출");
//		System.out.println();
	}
	
}
