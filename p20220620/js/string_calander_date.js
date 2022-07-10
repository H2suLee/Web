let today = new Date();
console.log(`올해는 ${today.getFullYear()}년도 입니다.`);
console.log(`이번 달은 ${today.getMonth()+1}월 입니다.`); // 0월부터 시작하므로 +1 해줘야
console.log(`오늘은 ${today.getDate()}일 입니다.`);
console.log(`오늘은 ${today.getDay()}요일 입니다.`);

today = new Date('2022-06');
console.log(`올해는 ${today.getFullYear()}년도 입니다.`);
console.log(`이번 달은 ${today.getMonth()+1}월 입니다.`);
console.log(`오늘은 ${today.getDate()}일 입니다.`); // 날짜 기본값 1일
console.log(`오늘은 ${today.getDay()}요일 입니다.`); // 요일 기본값 3(수요일)

today = new Date(2022, 0, 1); // 2022-01-01
today = new Date(2022, 5, 1); // 2022-06-01
today = new Date(2022, 5, 0); // 2022-05-31
today = new Date(2022, 6); // 2022년 7월
console.log(`올해는 ${today.getFullYear()}년도 입니다.`); // 2022
console.log(`이번 달은 ${today.getMonth()+1}월 입니다.`); // 7
console.log(`오늘은 ${today.getDate()}일 입니다.`); // 날짜 기본값 1일
console.log(`오늘은 ${today.getDay()}요일 입니다.`); // 5요일 (금요일)

// 연도와 월 정보를 넣어주면 달력 만들어주는 프로그램 작성하기
let year = 2022;
let month = 6;

// makeCalendar(year, month);

// function makeCalendar(y, m) {
//     let dayInfo = new Date(y, m - 1).getDay(); // 3, 매개값으로 들어온 월의 첫번째 요일.
//     // console.log(`${y}, ${m-1}`);
//     // console.log(dayInfo);
//     let lastDateInfo = new Date(y, m, 0).getDate(); // 마지막 날의 정보, 30 아니면 31
//     // 년, 월 달력 정보 생성.
//     let days = ['일', '월', '화', '수', '목', '금', '토'];
//     str = `<table border=1><caption> [ ${y}년 ${m}월 ]</caption><tr>`;

//     // thead
//     // for in로 돌리면 days 배열의 인덱스 값 나옴(0~6)
//     // for of로 돌려야 요일 값 나옴(일~토)
//     for (let day of days) {
//         str += '<th>' + day + '</th>';
//     }

//     str += '</tr><tr>';
//     for (let i = 0; i < dayInfo; i++) {
//         str += '<td></td>'; // 1일에 맞추어서 빈칸 만들어 주기, 수요일이므로 앞에 세 칸
//     }
//     for (let i = 1; i <= lastDateInfo; i++) {
//         str += '<td>' + i + '</td>'; // 1~30 넣기
//         if ((dayInfo + i) % 7 == 0) { // 7의 배수마다 tr 넣기
//             str += '</tr><tr>';
//         }
//     }
//     str += '</tr></table>';
//     document.write(str);
// }

function makeC(year, month) {
    // 1일이 무슨 요일인지부터
    let firstDay = new Date(year, month - 1).getDay();
    console.log(firstDay); // 3

    let lastDay = new Date(year, month, 0).getDate();
    console.log(lastDay); // 30

    let tag = '<table border = 1>';

    // thead
    let days = ['일', '월', '화', '수', '목', '금', '토'];
    tag += '<thead><tr>';
    days.forEach(val => {
        tag += `<th>${val}</th>`;
    });
    tag += '</tr></thead><tr>';

    // tbody
    for (let i = 0; i < firstDay; i++) {
        tag += '<td></td>'
    }
    for (let i = 1; i <= lastDay; i++) {
        tag += `<td>${i}</td>`
        if ((i + firstDay) % 7 == 0) {
            tag += '</tr><tr>';
        }
    }
<<<<<<< HEAD
    str += '</tr></table>';
    document.write(str);
}

function makeC(year, month) {
    // 1일이 무슨 요일인지부터
    let firstDay = new Date(year, month - 1).getDay();
    console.log(firstDay); // 3

    let lastDay = new Date(year, month, 0).getDate();
    console.log(lastDay); // 30

    let tag = '<table border = 1>';

    // thead
    let days = ['일', '월', '화', '수', '목', '금', '토'];
    tag += '<thead><tr>';
    days.forEach(val => {
        tag += `<th>${val}</th>`;
    });
    tag += '</tr></thead><tr>';

    // tbody
    for (let i = 0; i < firstDay; i++) {
        tag += '<td></td>'
    }
    for (let i = 1; i <= lastDay; i++) {
        tag += `<td>${i}</td>`
        if ((i + firstDay) % 7 == 0) {
            tag += '</tr><tr>';
        }
    }
=======
>>>>>>> ec7b9eac03679c6683694f20c8d2b1df73096ca9
    tag += '</tr></table>';

    return tag;
};

result = makeC(year, month);
console.log(result);
<<<<<<< HEAD
document.write(result);
=======
document.write(result);
>>>>>>> ec7b9eac03679c6683694f20c8d2b1df73096ca9
