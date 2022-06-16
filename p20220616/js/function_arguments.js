// arguments 객체 p71
// 함수 실행시 함수로 전달된 실제 인자들의 정보를 담고있는 객체
function sumNumber() {
    console.log(arguments); // 함수가 호출되면 arguments 객체가 매개값을 관리해 줌
    let result = 0;
    for (let i = 0; i < arguments.length; i++) {
        result += arguments[i];
    };
    return result;
};
sumNumber(1, 2, 3, 4, 5);
console.log(sumNumber(1, 2, 3, 4, 5));
console.log('---------------------------')