'use script';

function userDelete(){
	if(window.confirm("ユーザーを削除すると元に戻せません。ユーザーを削除しますか？")) {
		return true;
	}else {
		return false;
	}
}

function reviewDelete(){
	if(window.confirm("レビューを削除しますか？")) {
		return true;
	}else {
		return false;
	}
}

function logoutLink(){
	if(window.confirm("ログアウトしてよろしいですか？")) {
		return true;
	}else {
		return false;
	}
}