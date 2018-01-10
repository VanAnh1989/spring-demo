var a = 0;
function DangKy() {
	$.post('/addUser' ,{'user' : $("#user").val() , 'pass' : $("#pass").val()} , (data,status) => {
		alert(status);
	});
	
	$("#user").val("");
	$("#pass").val("");
}

function DangNhap(){
	window.location.href="/checkUser/?user="+$("#user").val()+"&"+"pass="+$("#pass").val();
}

function sendMail(){
	$.post('/sendMail' ,{'content' : $("#mail").val()} , (data,status) => {
		alert(status);
	});
}