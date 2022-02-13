$(function () {
    $.post("http://106.15.94.131/qwer/article/getArticle", function (data) {
        var data1 = eval(data);
        for (var i in data) {
            var div = $("<a href='article.html?title=" + data1[i].article_title + "&type=2'><div class='book__list'><div class='book__img'><img src=" + data1[i].article_img_uri + " class='the__book__img'></div><div class='book__info'><div class='book__name'>" + data1[i].article_title + "</div><div class='book__specific__information'><div class='book__writer'>" + data1[i].article_author + "</div><span>/</span><div class='book__time'>" + data1[i].article_date + "</div></div><div class='book__introduce'>" + data1[i].article_content + "</div></div></div>");
            $(".book").prepend(div);
        }
    });
});