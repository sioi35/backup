
// ex09_data.js
// 날짜시간 자료형 + 함수


//현재시각
//Calendar c = Calendar.getInstance();
//Date d = new Date();

var now = new Date();
console.log(now);

// 요소 추출
// c.get(calendar.YEAR);
console.log(now.getYear()); //121, 1999년 이전 2자리 표기 함수
console.log(now.getFullYear()); //2021, 2000년 이후
console.log(now.getMonth()); //5, 0~11 월
console.log(now.getDate()); //23, 일
console.log(now.getDay()); //3, 요일(0~6)
console.log(now.getHours());  //10, 시
console.log(now.getMinutes()); //19, 분
console.log(now.getSeconds()); //14, 초
console.log(now.getMinutes()); // 19, 밀리초
console.log(now.getTime()); //틱값

//덤프(+출력)
// -%tF(2021-06-23), %tT(10:22:30), %tA(요일)
console.log(now);
console.log(now.toString());
console.log(now.toLocaleString()); //현지 설정

console.log(now.toDateString());
console.log(now.toTimeString());

console.log(now.toLocaleDateString());
console.log(now.toLocaleTimeString());
console.log('------------------------');

//특정 시각
var christmas = new Date();
christmas.setFullYear(2021);
christmas.setMonth(11);
christmas.setDate(25);
christmas.setHours(0);
christmas.setMinutes(0);
christmas.setSeconds(0);

console.log(christmas.toLocaleString());

//연산
// - tick 연산
console.log(christmas - now);
console.log((christmas - now) / 1000 / 60 / 60 / 24);

//오늘 + 100일
var tick = now.getTime() + (100 * 24 * 60 * 60 * 1000);
var hday = new Date();
hday.setTime(tick); //tick 수정
console.log(hday.toLocaleString());
