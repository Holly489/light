$(document).ready(function () {

    $('#header').prepend('<div id="menu-icon"><span class="first"></span><span class="second"></span><span class="third"></span></div>');

    $("#menu-icon").on("click", function () {
        $("nav").slideToggle();
        $(this).toggleClass("active");
    });

    document.querySelector('body').style.overflowX = 'hidden';
    $(document).on("mousewheel DOMMouseScroll", function (e) {
        var delta = (e.originalEvent.wheelDelta && (e.originalEvent.wheelDelta > 0 ? 1 : -1)) ||  // chrome & ie
            (e.originalEvent.detail && (e.originalEvent.detail > 0 ? -1 : 1));              // firefox
        var a = $(this).scrollTop();
        if (a >= 0 && a < window.innerHeight - 30) {
            if (delta < 0) {
                // 向下滚
                window.scrollTo({
                    top: window.innerHeight - 50,
                    behavior: "smooth"
                });
                // animate_scroll(window, window.innerHeight - 90);
                // $('body').css("overflow-y", "scroll");
            } else if (delta > 0) {
                // 向上滚
                window.scrollTo({
                    top: 0,
                    behavior: "smooth"
                });
                // animate_scroll(window, 0);
                // $('body').css("overflow-y", "hidden");
            }

        }
    });

    // function animate_scroll(obj, dis) {
    //     clearInterval(obj.timer);
    //     // document.body.onmousewheel = function () { return false; }
    //     obj.timer = setInterval(function () {
    //         var step = (dis - window.pageYOffset) / 10;
    //         if (step > 0) {
    //             step = Math.ceil(step);
    //         } else {
    //             step = Math.floor(step);
    //         }
    //         if (window.pageYOffset == dis) {
    //             clearInterval(obj.timer);
    //         }
    //         // if (step == 0) {
    //         // document.body.onmousewheel = function () { return true; }
    //         // }
    //         window.scroll(0, window.pageYOffset + step);
    //     }, 20);
    // }

    //查看更多
    $('.readmore h3').click(function () {
        if ($(this).text() == "发现更多") {
            $(this).text('返回');
            $(this).parents().parents().addClass('showfull');
        } else {
            $(this).text('发现更多');
            $(this).parents().parents().removeClass('showfull');
        }
    });

    //喜欢
    $('.like').click(function () {
        $(this).toggleClass('clicked');
        $(this).children("svg").toggleClass('clicked1');
    });
    /*//历史记录
    $.post("/qwer/user/history", function (data) {
        // var data = [{ "history_article": "baidu", "history_uri": "www.baidu.com" }];
        var data1 = eval(data);
        if (data1.history_article == null)
            return;
        for (var i in data) {
            $(".history").append("<a href=" + data1[i].history_uri + " class='history_1'>" + data1[i].history_article + "</a>")
        }
    });*/
    //每日四本书
    $.post("/qwer/recommend/findRecommend", function (data) {
        var data2 = eval(data);
        for (var i in data) {

            $(".rec__name").eq(i).text(data2[i].recommend_title);
            $(".rec__writer").eq(i).text(data2[i].recommend_img_outline);
            $(".rec__info").eq(i).text(data2[i].recommend_outline);
            $(".rec-img").eq(i).attr('src', data2[i].recommend_img_uri);
            if (data2[i].recommend_type == 1) {
                $(".rec__link").eq(i).attr('href', 'http://106.15.94.131/qwer/html/article.html?title=' + data2[i].recommend_title + "&type=1");
            } else {
                $(".rec__link").eq(i).attr('href', 'http://106.15.94.131/qwer/html/article.html?title=' + data2[i].recommend_title + "&type=2");
            }

        }
    });
    $.post("/qwer/recommend/findRecommend", function (data) {
    	var data3 = eval(data);
    	for (var i in data) {
    	$(".slide__text-heading").eq(i).text(data3[i].recommend_title);
    	$(".slide__text-desc").eq(i).text(data3[i].recommend_outline)
    	$(".slide__bg").eq(i).css("background-image", "url(" + data3[i].recommend_img_uri + ")");
    	if (data3[i].recommend_type == 1) {
    	$(".slide__text-link").eq(i).attr('href', 'http://106.15.94.131/qwer/html/article.html?title=' + data3[i].recommend_title + "&type=1");
    	} else {
    	$(".slide__text-link").eq(i).attr('href', 'http://106.15.94.131/qwer/html/article.html?title=' + data3[i].recommend_title + "&type=2");
    	}
    	}
    	});
/*
    $.post("/qwer/recommend/findRecommend", function (data) {
        var data3 = eval(data);
        for (var i in data) {
            $(".slide__text-heading").eq(i).text(data3[i].recommend_title);
            $(".slide__text-desc").eq(i).text(data3[i].recommend_outline)
            $(".slide__text-link").eq(i).attr('href', data3[i].recommend_img_uri);
            if (data3[i].recommend_type == 1) {
                $(".slide__bg").eq(i).css("background-image", 'http://106.15.94.131/qwer/html/book.html?title=' + data3[i].recommend_title + "&type=1");
            } else {
                $(".slide__bg").eq(i).css("background-image", 'http://106.15.94.131/qwer/html/article.html?title=' + data3[i].recommend_title + "&type=2");
            }
        }
    });
*/
   /* var str = "aaaa\nbbbb\tasd";
    // var ans = str.replace(/<br\/>/g, "\n");
    // var ans = str.replace(/\\r\\n/g, '<br/>');
    console.log(ans);*/

    /*// ans = str.replace(/\\/g, "&nbsp;")
    $(".slide__text-desc").text(ans);
    console.log(ans);*/
    var lun_l = document.querySelector('.btn_l');
    var lun_r = document.querySelector('.btn_r');
    var box = document.querySelector('.recommend');//移动的盒子
    var distant = 1220;//每一次移动的距离
    var mostNum = 1;//最多移动多少次
    lun(lun_l, lun_r, box, distant, mostNum);
    function lun(obj1, obj2, obj_box, obj_distant, obj_mostNum) {

        var flag = 0;
        var x = 0;
        obj1.style.display = 'none';
        obj1.style.display = 'display';

        obj1.addEventListener('click', function () {
            flag--;
            slow(obj_box, -obj_distant * flag);
            butt(obj1, obj2, obj_mostNum, flag);
        });

        obj2.addEventListener('click', function () {
            flag++;
            slow(obj_box, -obj_distant * flag);
            butt(obj1, obj2, obj_mostNum, flag);
        });


        function butt(obj1, obj2, secend, flag) {
            if (flag == 0) {
                obj1.style.display = 'none';
            } else {
                obj1.style.display = 'block';
            }
            if (flag == secend) {
                x = 1;
                obj2.style.display = 'none';
            } else {
                x = 0;
                obj2.style.display = 'block';
            }
        }
        function slow(obj, dis) {
            clearInterval(obj.timer);
            obj.timer = setInterval(function () {
                var step = (dis - obj.offsetLeft) / 10;
                if (step > 0) {
                    step = Math.ceil(step);
                } else {
                    step = Math.floor(step);
                }
                if (obj.offsetLeft == dis) {
                    clearInterval(obj.timer);
                }
                obj.style.left = obj.offsetLeft + step + 'px';
            }, 20);
        }
    }
    $.post("http://106.15.94.131/qwer/recommend/getHistoryRecommend", function (data) {
    	var data4 = eval(data);
    	for (var i in data) {
    	$(".title").eq(i).text(data4[i].recommend_title);
    	$(".content p").eq(i).text(data4[i].recommend_outline)
    	$(".img-content").eq(i).css('background-image',"url("+ data4[i].recommend_img_uri+")");
    	if (data4[i].recommend_type == 1) {
    	$(".img__link").eq(i).attr('href', 'http://106.15.94.131/qwer/html/article.html?title=' + data4[i].recommend_title + "&type=1");
    	} else {
    	$(".img__link").eq(i).attr('href', 'http://106.15.94.131/qwer/html/article.html?title=' + data4[i].recommend_title + "&type=2");
    	}
    	}
    	});
});