$OOP.create({
    modifier: "PASSPORT.Signup.Base:PASSPORT.Page.BasePage",
    proto: {
        dependence: [
        ],
        load: function () {
        },
        render: function () {
        },
        compose: function () {
        },
        bind: function () {
        },
        startup: function () {
        },
        checkNickname: function(nickname) {
            var errmsg      = "";
            if (nickname.length == 0 || nickname.length > 16) {
                errmsg      = "请输入2~16个字的昵称";
            } else if (true == this.conditionExist("nickname", nickname)) {
                errmsg      = "昵称已经被使用";
            }
            
            return errmsg;
        },
        checkPassword: function(password) {
            var errmsg      = "";
            var regNumber = /\d+/; 
            var regString = /[a-zA-Z]+/;
            var regSpecial= /[-~!@#$%^&*()/\|,.<>?"'();:_+=\[\]{}]/;
            var check_3 = 0;
            if(regNumber.test(password)){
                check_3 += 1;
            }
            if(regString.test(password)){
                check_3 += 1;
            }
            if(regSpecial.test(password)){
                check_3 += 1;
            }
            if (password.length < 6 || password.length > 20 || password.indexOf(" ") != -1 || check_3<2) {
                errmsg      = '密码不符合我们的要求';
            }
            
            return errmsg;
        },
        checkCode: function(code) {
            var errmsg       = "";
            if (code.length == 0) {
                errmsg       = "验证码不能为空";
            }
            
            return errmsg;
        },
        checkDpasswd: function(dpassword){
            var errmsg       = "";
            if (dpassword != this.password.val()) {
                errmsg       = "密码输入不一致";
            }
            return errmsg;
        },
        conditionExist: function(type, condition) {
            var success       = true;
            $.ajax({
                type: "post",
                url: "/signup/isConditionExist",
                data: "&type=" + type + "&condition=" + condition,
                dataType: "json",
                async: false,
                success: function(R) {
                    if (R.status == 0) {
                        success   = false;
                    } else {
                        success   = true;
                    }
                }
            });
            
            return success;
        },
        sendVerifyCode: function() {
            var _this       = this;
            var username    = _this.username.val();
            var imgcode     = _this.imgcode.val();
            if (_this.iCount == 60) {
                $.ajax({
                    type: "post",
                    url: "/signup/sendVerifyCode",
                    data: "&username=" + username + "&img_code=" + imgcode + "&agent_type=" + _this.agentType,
                    dataType: "json",
                    async: false,
                    success: function(R) {
                        if (R.status == 0) {
                            $('#pic_captc').modal('hide');      // 关闭模态对话框
                            
                            _this.sendVercode.attr("disabled", true);
                            _this.sendVercode.html("重新发送（60秒）");
                            _this.iCount --;
                            window.setTimeout(function(){_this.changeTime();}, 1000);
                            _this.showError("public", "");
                            if (_this.signupType == "email") {
                                _this.showError("public", "验证码已发送到邮箱，20分钟内有效");
                            } else {
                                _this.showError("public", "验证码已发送到手机，20分钟内有效");
                            }
                        } else {
                            if (R.data == "hcapt") {    // hit captcha
                                _this.showPicCaptCode();
                            } else if (R.data == "hcapt_err") {
                                _this.flushCaptcha();
                                alert(R.resp);
                            } else {
                                $('#pic_captc').modal('hide');      // 关闭模态对话框
                                _this.sendVercode.html("获取验证码");
                                _this.showError("username", R.resp);
                            }
                        }
                    }
                });
            }
        },
        showPicCaptCode: function() {     // 注册图片验证码
            $("#pic_captc").modal({
                backdrop: true,
                keyboard: true,
            });
        },
        flushCaptcha: function() {        // 重新刷新验证码
            $("#img_captc").attr("src","/captcha?type=signup&level=medium&t="+(new Date()).getTime());
        },
        changeTime: function() {
            var _this = this;
            
            if (_this.iCount == 0) {
                _this.sendVercode.removeAttr("disabled");
                _this.sendVercode.html("获取验证码");
                _this.iCount  = 60;
            } else {
                _this.sendVercode.attr("disabled", true);
                _this.sendVercode.html("重新发送（" + _this.iCount + "秒）");
                _this.iCount--;
                
                window.setTimeout(function(){_this.changeTime();}, 1000);
            }
        }
    }
});
$('#password').on('input propertychange', function() {
    var now_passport = $(this).val();
    if(now_passport == ""){
        $(".checklist li").removeClass("right").removeClass("err");
        $(".checkbar").html('<span class="one"></span><span class="two"></span><span class="three"></span>');
        $(".checktype").html("");
    }else{
        var checknum = 0;
        // 6-20个字符
        if (now_passport.length >= 6 && now_passport.length <= 20) {
            checknum += 1;
            $(".citem1").removeClass("err").addClass("right");
        }else{
            $(".citem1").removeClass("right").addClass("err");
        }
        // 是否含有空格
        if(now_passport.indexOf(" ") == -1){
            checknum += 1;
            $(".citem2").removeClass("err").addClass("right");
        }else{
            $(".citem2").removeClass("right").addClass("err");
        }
        // 是否含有字母、数字、标点符号
        var regNumber = /\d+/; 
        var regString = /[a-zA-Z]+/;
        var regSpecial= /[-~!@#$%^&*()/\|,.<>?"'();:_+=\[\]{}]/;
        var check3 = 0;
        if(regNumber.test(now_passport)){
            check3 += 1;
        }
        if(regString.test(now_passport)){
            check3 += 1;
        }
        if(regSpecial.test(now_passport)){
            check3 += 1;
        }
        if(check3>=2){
            checknum += 1;
            $(".citem3").removeClass("err").addClass("right");
        }else{
            $(".citem3").removeClass("right").addClass("err");
        }
        checktype = 0;
        if(checknum == 1){
            checktype = 1;//弱
            $(".checktype").html("弱").css("color","#FF4C44");
            $(".checkbar").html('<span style="background:#FF4C44"></span><span></span><span class="three"></span>');
        }else if(checknum == 3 && check3==3){
            checktype = 3;//强
            $(".checktype").html("强").css("color","#7ED35A");
            $(".checkbar").html('<span style="background: #7ED35A"></span><span style="background: #7ED35A"></span><span style="background: #7ED35A" class="three"></span>');
        }else{
            checktype = 2;//中
            $(".checktype").html("中").css("color","#FFCB51");
            $(".checkbar").html('<span style="background:#FFCB51"></span><span style="background:#FFCB51"></span><span class="three"></span>');
        }
    }
    
});
function showPassportDesc(obj){
    obj = $(obj);
    obj.parents('.itm').next().css('visibility','visible');
    $(".passcheck").show();
}