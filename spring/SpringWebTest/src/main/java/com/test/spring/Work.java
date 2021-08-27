package com.test.spring;

import org.springframework.stereotype.Repository;

//DIController의 의존 객체

//의존 객체로서의 자격 부여 -> @Autowired에 의해서 호출 당할 자격이 생긴다.
//의미를 구분하기 위해서.. Role(역할)
//1. @Service    > 서비스 객체 > 중간 단계 업무 객체
//2. @Repository > 저장소 객체(DAO)
//3. @Component  > 일반 객체 > 모듈

//@Component
//@Service
@Repository
public class Work {

	public String doit() {
		
		System.out.println("메소드 호출");
		
		return "의존 객체의 반환값";
	}
	
}
