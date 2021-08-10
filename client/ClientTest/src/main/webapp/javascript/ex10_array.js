// ex10_array.js

// 배열, Array
// - 자바의 Array + Collection

//int[] nums = new int[3];
var nums = new Array(); //new ArrayList();

// Indexer 지원
nums[0] = 10;
nums[1] = 20;
nums[2] = 30;

console.log(nums);

nums[5] = 50; // 사용 금지(중간에 빈 방 두지 말것)

console.log(nums);
console.log(nums[3]);
console.log(nums[6]);

// 배열 초기화 리스트
// int[] nums = new int[] {10, 20, 30};
// int[] nums = {10, 20, 30};

nums = new Array(10, 20, 30); //X
nums = [ 10, 20, 30 ]; //O
console.log(nums);

// 빈 배열 만들기
nums = new Array();
nums = []; //O

//길이
nums = [10, 20, 30, 40, 50];
console.log(nums.length);

//메소드
nums.push(60); //append, 배열 끝에 추가(index 미사용). Stack.push()
nums.push(70);
console.log(nums);

console.log(nums.pop()); //마지막 방 가져오기. Stack.pop()
console.log(nums);

console.log(nums.shift()); //첫번째 방 가져오기. 삭제 <-> pop()
console.log(nums);

//탐색
for (var i = 0; i < nums.length; i++){
    console.log(i, nums[i]);
}

//for in: 기존 향상된 for문과 다르다.
for (var i in nums){
    console.log(i);
}

//ES6 -> 향상된 for문(=iterator)item, index
nums.forEach(function(item, index) { 
    console.log('forEach', item, index);
});
