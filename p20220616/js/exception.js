// exception.js
let fname = document.getElementById('selectFile');
let data = '';
const reader = new FileReader();

try {

    // addEventListener가 매개변수로 갖는 것: 뭔 이벤트인지, 실행할 함수
    reader.addEventListener('load', function () {
        data = reader.result;
        console.log('파일 내용: ' + data);
    }) 
    reader.addEventListener('error', function () {
        throw '파일 읽기 에러';
    })
    fname.addEventListener('change', function () {
        reader.readAsText(fname.files[0], 'utf-8');
    })

} catch (err) {
    console.log(err.message);
    console.log('정상진행');
}