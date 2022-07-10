// variable3

let str = '';

document.write('-------------------------- 구구단 2단 <br><br>');

str += '<table border=1 style="width: 200px; text-align: center;">';
for (let i = 1; i < 10; i++) {
    str += '<tr>';
    let multi = 2 * i;
    str += '<td>2</td><td>*</td><td>' + i + '</td><td>=</td><td>' + multi + '</td>';
    str += '</tr>';
};
str += '</table>';
document.write(str + '<br>');

str = '';

document.write('-------------------------- 달력형<br><br>');

str += '<table border=1><tr>';
for (let i = 1; i <= 30; i++) {
    str += '<td>' + i + '</td>';
    if (i % 7 == 0) {
        str += '</tr><tr>';
    };
};
str += '</table>';
document.write(str);



document.write('<br>----- 맨 윗줄에 요일 넣고 1일의 위치와 마지막날 조건 걸기 <br><br>');

// getFirstDay: 매개값으로 월 정보를 넣어주면 1의 위치가 조정되는 함수
// 예를 들어 6월이면 1이 네번째 위치에, 7월이면 1이 여섯번째 위치에
// getLastDay: 어느달이 며칠로 끝나는 지 구분하는 함수 (30일 or 31일 or 28일)

// 월 설정

let mon = 8;
showCalandar(mon);

function showCalandar(mon) {
    // 첫 행에 일~토 요일 입력
    let days = ['일', '월', '화', '수', '목', '금', '토'];
    str = '<table border=1><caption>' + mon + '월 달력</caption><tr>';
    for (let day of days) {
        str += '<th>' + day + '</th>';
    };

    str += '</tr><tr>';

    // 6월 1일을 위해 앞에 세 칸 만들기
    for (let i = 1; i < getFirstDay(mon); i++) {
        str += '<td></td>';
    };

    // 날짜값 넣기
    for (let i = 1; i <= getLastDay(mon); i++) {
        str += '<td>' + i + '</td>';
        // 칸수 조정을 위해 조건문 수정
        if (((getFirstDay(mon) - 1) + i) % 7 == 0) {
            str += '</tr><tr>';
        };
    };
    str += '</table>';
    document.write(str);
};

function getFirstDay(mon) {
    switch (mon) {
        case 1:
            return 7;
        case 5:
            return 1;
        case 6:
            return 4; // return 구문을 썼으므로 굳이 break 걸어 줄 필요 없다
        case 7:
            return 6;
        case 8:
            return 2;
        default:
            0;
    };
};

function getLastDay(mon) {
    switch (mon) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            return 31;
        case 4:
        case 6:
        case 9:
        case 11:
            return 30;
        case 11:
            return 28;
    }
}