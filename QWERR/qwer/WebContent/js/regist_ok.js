$(function () {
	$.post("http://106.15.94.131/qwer/review/getReview", function (data) {
		$("body").css("background-image", "url(" + data.review_img_uri + ")");
		$(".com").text(data.review_content);
		$(".comment__title").text(data.review_title);
		});
	var time = setInterval(function () {
		$.post("http://106.15.94.131/qwer/user/regist_OK", function (data) {
			if(data.flag){
				location.href = "../index.html";
				}
			});
		}, 7000);
	}
);