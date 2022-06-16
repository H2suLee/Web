// 커링 함수 p72
function orderSet(burger, bev) {
    console.log('버거: ' + burger + ', 음료: ' + bev);
};
orderSet('치즈버거', '콜라');

// 파라미터를 두 개 가지는 위 함수 구문을 아래와 같이 커링으로 해체할 수 있다
function orderSet_curring(burger) {
    return function (bev) {
        console.log('버거: ' + burger + ', 음료: ' + bev);
    };
};
console.log(orderSet_curring('치즈버거')); // function(bev) 구문을 반환
orderSet_curring('치즈버거')('사이다');

let bevFnc = orderSet_curring('치즈버거');
bevFnc('커피');

// p73 예제

function orderSet2(burg) {
    return function orderBev(bever) {
        return function orderSide(side) {
            return function orderSource(source) {
                return function count(cnt) {
                    console.log('세트 : ' + burg + ', 음료 : ' + bever + ', 사이드 : ' + side + ', 소스 : ' + source + ', 주문 수 : ' + cnt + '개');
                }
            }
        }
    }
}
orderSet2('치즈버거')('콜라')('맥너겟')('케첩')('5');
