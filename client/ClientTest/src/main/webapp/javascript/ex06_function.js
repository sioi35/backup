/*
    ex06_function.js

    자바스크립트의 함수
    - 함수를 객체(데이터)처럼 취급할 수 있다.
        -> 함수는 1급 객체(First Class Object)이다.

    1급 객체
    1. 함수를 변수나 데이터 구조에 담을 수 있다.
    2. 함수를 매개변수로 전달할 수 있다.(=1번)
    3. 함수를 반환값으로 사용할 수 있다.(=1번)

*/

var n1;

function f1(){
    console.log('f1');
}

n1 = f1(); //함수의 반환값을 n1에 대입
console.log(n1); //undefined

n1 = f1; // 함수 자체를 n1에 대입
console.log(n1);

n1(); // ******

var n2 = n1;
n2();
console.log(n2);
console.log("------------------");

function f3(){
    console.log('f3');
}

function f4(temp){
    console.log(temp);
}

f4(100);
var n3 = f3;
f4(n3);
f4(f3);
f4(f3()); //undefined -> X
console.log("------------------");

function f5(){
    console.log('f5');
}

function f6(temp){
    temp(); //== f5()
}

f6(f5);
console.log("------------------");

function f7(){
    console.log('f7');
}

function f8(){
    return f7;
}

f8()();
console.log("------------------");
//-------------------------------

// 자바스크립트의 함수 선언
// 1. 명시적 선언(실명)
// 2. 암시적 선언(=익명 함수, 함수 리터럴)
// 3. 즉시 호출

function hello(){
    console.log("hello");
}

hello();

// 2. 암시적 선언(=익명 함수, 함수 리터럴)
var m1 = function(){
    console.log('hi');
};

m1();

// 3. 익명함수 -> 즉시 호출
(function(){
    console.log('good!');
})();

console.log("------------------");

// 연산자 + 자료형
// - 자바스크립트는 오라클과 비슷하게 자동 형변환이 잦다.
// - 자동 형변환이 많다. -> 개발자 편함. 개발자 불편함(가독성 저하).
// - 자동 형변환이 적다. -> 개발자 불편함(직접 구현). 개발자 편함(가독성 향상).
console.log(null == undefined);

// == 연산자
// - 자료형의 비교는 하지 않고 데이터만 같은지 판단
console.log(100 == 100); //true
console.log(100 == "100"); //true
console.log(1 == true); //true

// ===, !== 연산자
// - 자료형도 비교하고, 값도 비교한다.
// - 엄격한(strict) 같음 비교
// - 자바와 동일
console.log(100 === 100);
console.log(100 === "100"); //false
console.log(1 === true); //false
console.log(null === undefined); //false




