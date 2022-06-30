/**
 * upload_jquery.js
 */

// Ajax => XMLHttpRequest, fetch, $.ajax()

$(document).ready(function() {
	$.ajax({
		url: 'MemberServlet',
		method: 'get', // 디폴트가 get, 이 라인은 생략해도 됨
		data: 'cmd=select',
		success: showList,
		error: function(error) {
			console.error(error);
		}
	});

	// 추가버튼 클릭
	$('form[name="memberForm"]').on('submit', insertTr);


}) // document.ready ends

function insertTr(e) {

	e.preventDefault();
	// e.preventDefault()를 안 한 상태에서 submit 이벤트를 발생시키면 폼태그가 갖고 있는 내용이 실행됨(삽입하고 리턴으로 retCode)
	// : <form name="memberForm" action="memberUpload" method="post" enctype="multipart/form-data">

	console.log(e.target); // 폼 자체를 불러옴
	let formData = new FormData(e.target); // 
	for (let data of formData.entries()) {
		console.log('entries???', data); // key 랑 value
		console.log('???', data[1]);
	}
	// ajax => 데이터 등록, 화면에도 추가
	$.ajax({
		url: 'memberUpload',
		method: 'post',
		data: formData,
		dataType: 'json',
		contentType: false,
		processData: false,
		success: function(result) {
			/*			let tbody = document.querySelector('#show > table > tbody')
						let tr = document.createElement('tr');
			
						for (let data of formData.entries()) {
							let td = document.createElement('td');
							td.textContent = data[1];
							tr.append(td);
						}
						tbody.append(tr);*/
			
			let tr = $('<tr />');
			for (let data of formData.entries()) {
				$(tr).append($('<td />').text(data[1]));
			}
			$('#show > table > tbody').append($(tr));

			// return data를 오브젝트 형태로 받는 경우
			/*			let tbody = $('#show > table > tbody');
						tbody.append(makeTr(result))
			*/
			// return data를 Fufilled를 받느냐 마느냐에 따라 하는 경우
		},
		error: function(error) {
			console.error(error);
		}
	})
}

function showList(result) {
	console.log(result);
	let tbody = $('#show > table > tbody');
	$(result).each(function(idx, elem) {

		console.log('elem, ', elem.membAddr);
		tbody.append(makeTr(elem));
	});
}

function makeTr(elem) {

	let btn = $('<button />').text('삭제');
	btn.on('click', delTr);
	let ckBox = $('<input />').attr('type', 'checkbox');

	let imgSrc = elem.membImage ? '<img src="images/' + elem.membImage + '" width="80px">' : '';
	return $('<tr />').attr('id', elem.membNo)
		.append($('<td />').text(elem.membNo),
			$('<td />').text(elem.membName),
			$('<td />').text(elem.membPhone),
			$('<td />').text(elem.membAddr),
			$('<td />').text(elem.membBirth),
			$('<td />').html(imgSrc), // undefined이나 null일 때 아무것도 안뜨게 하는 거 구현하기
			$('<td />').append(btn),
			$('<td />').append(ckBox)
		)
}

function delTr(e) {
	console.log(e.target); // <button>삭제</button>
	let no = $(e.target).parent().parent().attr('id');
	$.ajax({
		url: 'MemberServlet',
		method: 'post',
		data: 'cmd=remove&no=' + no,
		success: function(result) {
			if (result.retCode == 'Success') {
				$('#' + no).remove();
			} else {
				console.log(result);
			}
		},
		error: function(error) {
			alert('처리중 에러');
		}
	})
}
// delTr이 makeTr 안에 있을때 코드
/*function() {
		console.log(this); // <button>삭제</button>
		console.log(this.parentElement); // <td> 한 뭉텅이
		$.ajax({
			url: 'MemberServlet',
			method: 'post',
			data: 'cmd=remove&no=' + elem.membNo,
			success: function(result) {
				if (result.retCode == 'Success') {
					$('#' + elem.membNo).remove();
				} else {
					console.log(result);
				}
			},
			error: function(error) {
				alert('처리중 에러');
			}
		})
	}*/