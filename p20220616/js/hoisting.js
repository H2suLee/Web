// hoisting 이해하기

var a = 1;
var b = 5;

function outerFunc() {
    function innerFnc() {
        a = b; // 4
    }
    console.log(a); // 1
    a = 3;
    b = 4;
    innerFnc();
    console.log(a); // 4
    var b = 2;
    console.log(b); //2
}
outerFunc();
console.log(b); // 5