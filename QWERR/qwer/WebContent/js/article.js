$(function () {



    $('.comment__input__txt').focus(function () {
        $(this).addClass("comment__input__txt__show");
    });
    $('.comment__input__txt').blur(function () {
        $(this).removeClass("comment__input__txt__show");
    });

/*    $(".comment__submit").on("click", function () {
        var value = $(".comment__input__txt").val();
        if (value.trim().length == 0) {
            return 0;
        }
        var user__name = $(".user__info__name2").text();

        var li = $("<li class='list__item'><span class='comment__user__name'>" + user__name + "</span><p class='comment__content'>" + value + "</p><span class='comment__time'>"+new Date().Format("yyyy-MM-dd hh:mm:ss")+"</span></li>");
        // li.html();
        $(".comment__list").prepend(li);
        li.slideDown();
        $(".comment__input__txt").val("");
    });*/
    $(".comment__submit").on("click", function () {
    	var value = $(".comment__input__txt").val();
    	if (value.trim().length == 0) {
    	return 0;
    	}
    	var user__name = $(".user__info__name2").text();

    	var li = $("<li class='list__item'><span class='comment__user__name'>" + user__name + "</span><p class='comment__content'>" + value + "</p ><span class='comment__time'>" + new Date().Format("yyyy-MM-dd hh:mm:ss") + "</span></li>");
    	// li.html();
    	$(".comment__list").prepend(li);
    	li.slideDown();
    	$(".comment__input__txt").val("");

    	if (type == 1) {
    		var Request = new Object();
        	Request = GetRequest();
        	var title, type;
        	title = Request['title'];
        	type = Request['type'];
    	$.post("http://106.15.94.131/qwer/comment/saveBookComment",
    	{
    	'title': title,
    	'comment': value
    	},
    	function (data) {

    	}
    	)
    	} else {
    		var Request = new Object();
        	Request = GetRequest();
        	var title, type;
        	title = Request['title'];
        	type = Request['type'];
    	$.post("http://106.15.94.131/qwer/comment/saveArticleComment",
    	{
    	'title': title,
    	'comment': value
    	},
    	function (data) {

    	}
    	)
    	}
    	});
    	if (type == 1) {
    		var Request = new Object();
        	Request = GetRequest();
        	var title, type;
        	title = Request['title'];
        	type = Request['type'];
    	$.post("http://106.15.94.131/qwer/comment/getBookComment",
    	{
    		'book_title': title
    	},
    	function (data) {
    	var data8 = eval(data);
    	for (var i in data) {
    	var li = $("<li class='list__item'><span class='comment__user__name'>shaobingblingbling</span><p class='comment__content'>" + data8[i].comment_content + "</p ><span class='comment__time'>" + data8[i].comment_date + "</span></li>");
    	$(".comment__list").prepend(li);
    	}
    	}
    	)
    	} else {
    		var Request = new Object();
        	Request = GetRequest();
        	var title, type;
        	title = Request['title'];
        	type = Request['type'];
    	$.post("http://106.15.94.131/qwer/comment/getArticleComment",
    	{
    		'book_title': title
    	},
    	function (data) {
    	var data9 = eval(data);
    	for (var i in data) {
    	var li = $("<li class='list__item'><span class='comment__user__name'>shaobingblingbling</span><p class='comment__content'>" + data9[i].comment_content + "</p ><span class='comment__time'>" + data9[i].comment_date + "</span></li>");
    	$(".comment__list").prepend(li);
    	}
    	}
    	)
    	}


//    $("ul").on("click", "a", function () {
//        $(this).parent().slideUp(function () {
//            $(this).remove();
//        });
//    });

    /*function GetQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg); //获取url中"?"符后的字符串并正则匹配
        var context = "";
        if (r != null)
            context = r[2];
        reg = null;
        r = null;
        return context == null || context == "" || context == "undefined" ? "" : context;
    }

    var title = GetQueryString['title'],
        type = GetQueryString['type'];
    // var test = window.location.href;
    // var title = test.split("?title=")[1];
*/
    function GetRequest() {
    	var url = location.search; //获取url中"?"符后的字串
    	var theRequest = new Object();
    	if (url.indexOf("?") != -1) {
    	var str = url.substr(1);
    	strs = str.split("&");
    	for (var i = 0; i < strs.length; i++) {
    	theRequest[strs[i].split("=")[0]] = decodeURIComponent(strs[i].split("=")[1]);
    	}
    	}
    	return theRequest;
    	}
    	var Request = new Object();
    	Request = GetRequest();
    	var title, type;
    	title = Request['title'];
    	type = Request['type'];

    // var div = $('<p>123123123123</p>');
    // $(".the__con").append(1321312312312312321);

    if (type == 1) {
        $.post("http://106.15.94.131/qwer/book/getMarkdown",
            {
                'book_title': title
            },
            function (data) {
                var div = $(data);
                $(".the__con").append(div);
            }
        );
    } else {
        $.post("http://106.15.94.131/qwer/article/getMarkdown",
            {
                'book_title': title
            },
            function (data) {
                var div1 = $(data);
                $(".the__con").append(div1);
            }
        );
    }
    // $(window).scroll(function () {

    //     //滚动条所在位置的高度
    //     totalheight = parseFloat($(window).height()) + parseFloat($(window).scrollTop());
    //     //当前文档高度小于或等于滚动条所在位置高度则是页面底部
    //     if (($(document).height() - $('.comment').height()) <= totalheight) {
    //         //页面到达底部
    //         $.post("http://106.15.94.131/qwer/article/getArticle", { 'article_book_id': article_book_id, 'article_page': article_page }, function (data) {
    //             var data1 = eval(data);
    //             $(".l-con__title").text(data1[i].article_title);
    //             $(".auther").text(data1[i].article_author);
    //             for (var i in data) {
    //                 var div = $("<hr style='margin-top: 20px;border: none;border-top: 1px dotted #ccc;'><div class='l-con__con'>" + data1[i].article_content + "</div><img src=" + data1[i].book_img_uri + " style='width: 70%'>");
    //                 $(".the__con").append(div);
    //             }
    //         });
    //         book__page++;
    //     }
    // });


/*    //获取用户名
    $.post("/qwer/user/getUsername", function (temp) {
        $(".user__info__name2").text(temp.data);
    });
    $.get("/qwer/user/saveHistory", {
        article: $(".l-con__title").text(),
        uri: window.location.href
    });*/
    $.post("http://106.15.94.131/qwer/recommend/getFourRecommend", function (data) {
    	var data4 = eval(data);
    	for (var i in data) {
    	$(".item_info").eq(i).text(data4[i].recommend_title);
    	$(".item__").eq(i).text(data4[i].recommend_outline)

    	if (data4[i].recommend_type == 1) {
    	$(".item").eq(i).attr('href', 'http://106.15.94.131/qwer/html/article.html?title=' + data4[i].recommend_title + "&type=1");
    	} else {
    	$(".item").eq(i).attr('href', 'http://106.15.94.131/qwer/html/article.html?title=' + data4[i].recommend_title + "&type=2");
    	}
    	}
    	});
    Date.prototype.Format = function (fmt) { //author: 
    	var o = {
    	"M+": this.getMonth() + 1, //月份
    	"d+": this.getDate(), //日
    	"h+": this.getHours(), //小时
    	"m+": this.getMinutes(), //分
    	"s+": this.getSeconds(), //秒
    	"q+": Math.floor((this.getMonth() + 3) / 3), //季度
    	"S": this.getMilliseconds() //毫秒
    	};
    	if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    	for (var k in o)
    	if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    	return fmt;
    	};
});













