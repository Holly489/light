$(function () {
    $('.login__register input').on('focusin', function () {
        $(this).parent().find('label').addClass('active');
    });

    $('.login__register input').on('focusout', function () {
        if (!this.value) {
            $(this).parent().find('label').removeClass('active');
        }
    });


    var $login = $('.login'),
        $register = $('.register');

    $('.switch__login').on('click', function () {
        $login.css("left", "400px");
        $register.css("left", "870px");
    });
    $('.switch__register').on('click', function () {
        $login.css("left", "870px");
        $register.css("left", "400px");
    });



    // 注册验证
    var usename = $('#register__fname').val(),
        password__val,
        register__confirm__password,
        register__cellphone,
        register__email,
        pattern = /^1[3-9]+\d{9}$/,
        myreg = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/,
        err = 0;

    usename = $('#register__fname').val();
    if (usename == "") {
        $('#register__fname').css('borderBottom', '1px solid red').parent().find('span').addClass('show');
        err = 0;
    } else {
        $('#register__fname').css('borderBottom', '1px solid #8facbd').parent().find('span').removeClass('show');
        err = 1;
    }
    $('#register__fname').bind('input propertychange', function () {
        usename = $('#register__fname').val();
        if (usename == null) {
            $('#register__fname').css('borderBottom', '1px solid red').parent().find('span').addClass('show');
            err = 0;
        } else {
            $('#register__fname').css('borderBottom', '1px solid #8facbd').parent().find('span').removeClass('show');
            err = 1;
        }
    });
    $('#register__password').bind('input propertychange', function () {
        password__val = $('#register__password').val();
        var num = checkStrong(password__val);

        switch (num) {
        case 0:
        $(".strength_L").css({ 'background': '#eeeeee', 'color': 'black' });
        $(".strength_M").css({ 'background': '#eeeeee', 'color': 'black' });
        $(".strength_H").css({ 'background': '#eeeeee', 'color': 'black' });
        break;
        case 1:
        $(".strength_L").css({ 'background': 'red', 'color': 'white' });
        $(".strength_M").css({ 'background': 'yellow', 'color': 'black' });
        $(".strength_H").css({ 'background': 'yellow', 'color': 'black' });
        break;
        case 2:

        $(".strength_L").css({ 'background': 'green', 'color': 'white' });
        $(".strength_M").css({ 'background': 'red', 'color': 'white' });
        $(".strength_H").css({ 'background': 'green', 'color': 'white' });
        break;
        case 3:
        case 4:
        case 5:
        $(".strength_L").css('background', 'green');
        $(".strength_M").css('background', 'green');
        $(".strength_H").css('background', 'red');
        break;
        default:
        break;
        }

        if (password__val.length < 6) {
            $('#register__password').css('borderBottom', '1px solid red').parent().find('span').addClass('show');
            err = 0;
        } else {
            $('#register__password').css('borderBottom', '1px solid #8facbd').parent().find('span').removeClass('show');
            err = 1;
        }
    });
    $('#register__confirm__password').bind('input propertychange', function () {
        register__confirm__password = $('#register__confirm__password').val();

        if (register__confirm__password != password__val) {
            $('#register__confirm__password').css('borderBottom', '1px solid red').parent().find('span').addClass('show');
            err = 0;
        } else {
            $('#register__confirm__password').css('borderBottom', '1px solid #8facbd').parent().find('span').removeClass('show');
            err = 1;
        }
    });
    $('#register__cellphone').bind('input propertychange', function () {
        register__cellphone = $('#register__cellphone').val();
        if (!pattern.test(register__cellphone)) {
            $('#register__cellphone').css('borderBottom', '1px solid red').parent().find('span').addClass('show');
            err = 0;
        } else {
            $('#register__cellphone').css('borderBottom', '1px solid #8facbd').parent().find('span').removeClass('show');
            err = 1;
        }
    });
    $('#register__email').bind('input propertychange', function () {
        register__email = $('#register__email').val();
        if (!myreg.test(register__email)) {
            $('#register__email').css('borderBottom', '1px solid red').parent().find('span').addClass('show');
            err = 0;
        } else {
            $('#register__email').css('borderBottom', '1px solid #8facbd').parent().find('span').removeClass('show');
            err = 1;
        }
    });

    $('#registerForm').on('submit', function () {
        var result = serializeToJson($(this));
        if (result.username.trim().length == 0) {
            alert('请输入用户名');
            return false;
        }
        if (result.password.trim().length == 0 || password__val.length < 6) {
            alert('请输入密码');
            return false;
        }
        if (result.confirm__password.trim().length == 0 || (register__confirm__password != password__val)) {
            alert('请确认密码');
            return false;
        }
        if (result.checkCode.trim().length == 0) {
            alert('请输入验证码');
            return false;
        }
        if (result.telephone.trim().length == 0) {
            alert('请输入电话号码');
            return false;
        }
        if (result.email.trim().length == 0) {
            alert('请输入邮箱');
            return false;
        }
        if (err == 0) {
            alert('请检查一遍信息');
            return false;
        }
    });
    function serializeToJson(form) {
        var result = {};
        var f = form.serializeArray();
        f.forEach(function (item) {
            result[item.name] = item.value;
        });
        return result;
    }
    function checkStrong(val) {
        var modes = 0;
        if (val.length < 6) return 0;
        if (val.length > 12) modes++;
        if (/\d/.test(val)) modes++; //数字
        if (/[a-z]/.test(val)) modes++; //小写
        if (/[A-Z]/.test(val)) modes++; //大写 
        if (/\W/.test(val)) modes++; //特殊字符
        return modes;
    };

    // 登录验证
    var login__name,
        login__password,
        err1;
    $('#login__name').bind('input propertychange', function () {
        login__name = $('#login__name').val();
        if (login__name == "") {
            $('#login__name').css('borderBottom', '1px solid red').parent().find('span').addClass('show');
            err1 = 0;
        } else {
            $('#login__name').css('borderBottom', '1px solid #8facbd').parent().find('span').removeClass('show');
            err1 = 1;
        }
    });
    $('#login__password').bind('input propertychange', function () {
        login__password = $('#login__password').val();
        if (login__password.length < 6) {
            $('#login__password').css('borderBottom', '1px solid red').parent().find('span').addClass('show');
            err1 = 0;
        } else {
            $('#login__password').css('borderBottom', '1px solid #8facbd').parent().find('span').removeClass('show');
            err1 = 1;
        }
    });
    $('#loginForm').on('submit', function () {
        var result = serializeToJson($(this));
        if (result.username.trim().length == 0) {
            alert('请输入用户名');
            return false;
        }
        if (result.password.trim().length == 0) {
            alert('请输入密码');
            return false;
        }
        if (result.checkCode.trim().length == 0) {
            alert('请输入验证码');
            return false;
        }
        if (err1 == 0) {
            alert('请检查一遍信息');
            return false;
        }
        // else {
        //     $.ajax({
        //         type: "POST",
        //         url: "/qwer/user/login",
        //         //方法1：将form表单数据序列化
        //         // data : $('#registerForm').serialize(),
        //         //方法2：传送json数据
        //         data: {
        //             username: result.username.trim(),
        //             password: result.password.trim(),
        //             checkCode: result.checkCode.trim()
        //         },
        //         dataType: "json",
        //         success: function (flag, data, errorMsg) {
        //             //接收后台返回的结果
        //             if (flag == true) {
        //                 alert("提交成功");
        //                 //window.location.Reload();
        //             } else {
        //                 alert("操作失败");
        //                 alert(errorMsg);
        //             }
        //         },
        //         error: function (data) {
        //             alert("操作异常" + data.responseText);
        //         }
        // error: function (jqXHR, textStatus, errorThrown) {
        //     /*弹出jqXHR对象的信息*/
        //     alert(jqXHR.responseText);
        //     alert(jqXHR.status);
        //     alert(jqXHR.readyState);
        //     alert(jqXHR.statusText);
        //     /*弹出其他两个参数的信息*/
        //     alert(textStatus);
        //     alert(errorThrown);
        // }
        // });
        // }
    });


    //验证码
    $('.check__img').on('click', function () {
        (this).src = "../user/checkCode?" + new Date().getTime();
    });

    // 表单提交
    $("#btn_sub1").click(function () {
        $.post("/qwer/user/login", $("#loginForm").serialize(), function (data) {
            if (data.flag) {
            	alert("登录成功");
                location.href = "../index.html";
            } else {
            	alert(data.errorMsg);
                console.log(data.errorMsg);
            }
        });
    });

    $("#btn_sub2").click(function () {
        $.post("/qwer/user/regist", $("#registerForm").serialize(), function (data) {
            if (data.flag) {
                location.href = "regist_ok.html";
            } else {
            	alert(data.errorMsg);
                console.log(data.errorMsg);
            }
        });
    });

});
