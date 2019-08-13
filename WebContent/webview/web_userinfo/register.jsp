<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="google-site-verification" content="2gKQfz4b2duFoGhkAMtl9EsHRd0nJWda-SxknzWYAGA">
    <meta name="y_key" content="e4b03bf435642365">
    <meta property="wb:webmaster" content="5d3113ad6af60df9">
    <meta name="varify-v1" content="baidu-z6YB9Um9kaoKXmFf">
    <meta name="baidu-site-verification" content="f4bd7fa0f7e3712360b62873fcb22edd">
    <meta name="apple-itunes-app" content="app-id=434212566">
    <link href="${pageContext.request.contextPath}/static/foodrescourse/bootstrap.min.css" charset="UTF-8" rel="stylesheet" type="text/css" media="screen">
    <link href="${pageContext.request.contextPath}/static/foodrescourse/passport.css" charset="UTF-8" rel="stylesheet" type="text/css" media="screen">
    
    <title>手机号注册 - 吃货天堂</title>

    
    
    <style>
        .passcheck{position:absolute;width:282px;height:104px;top:0;left:332px;background:#fff;border:1px solid #f0efed;padding:5px 10px;box-sizing: border-box;border-radius:6px;display: none;}
        .checkbar{width:154px;height:15px;display: inline-block;vertical-align: middle;border-radius: 3px;overflow: hidden;}
        .checkbar span{width:50px;height:15px;float:left;margin-right: 2px;background: #eee;}
        .checkbar span.three{margin-right:0;}
        .checklist{margin-top:5px;}
        .checklist li{padding:1px 0;font-size:12px;}
        .checklist b{display: inline-block;width:20px;height:20px;vertical-align: middle;background: url(https://i1.douguo.com//upload/banner/1531891081.png) no-repeat;background-size: 15px; }
        .checklist .right b{background: url("https://i1.douguo.com//upload/banner/1550215311.png") no-repeat 1px; background-size: 13px;}
        .checklist .err b{background: url("https://i1.douguo.com//upload/banner/1550215325.png") no-repeat 1px;background-size: 13px;}
        .cicon{display: block;width:12px;height:12px;position: absolute;top:15px;left:-10px; }
    </style>
     <script type="text/javascript">
      /* 表单验证 */
     function validateForm(){
        var user_phone=document.getElementById("user_phone").value;
     	var user_name=document.getElementById("user_name").value;
     	var user_pwd=document.getElementById("user_pwd").value;
     	if(user_phone==""){
 		    alert("请输入电话号码！！！");	
 		    return false;
 		}if(user_name==""){
 		    alert("请输入用户名！！！");	
 		    return false;
 		}if(user_pwd==""){
 		    alert("输入密码！！！");	
 		    return false;
 		}if(user_phone!=""&&user_name!=""&&user_pwd!=""){
 		    alert("恭喜你注册成功！！！");	
		    return true;
		}
     }
     /* 手机号码验证 */
 	function validateCellphone(){
 		var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;  
 		var user_phone=$("#user_phone").val();  
         if (!myreg.test(user_phone)) { 
         	 alert("请输入正确的号码！！！");
             return false;  
         }else {  
             return true;  
         }  
 	}
     </script>
</head>
<body>
        <div class="loheader">
        <div class="htop">
            <div class="hlogo"><a title="吃货天堂" href="">吃货天堂</a></div>      
        </div>    
    </div>
    <div id="main" class="clearfix">
        
<div class="bglo clearfix">         
    <div class="thed">
        <h2>新用户注册</h2>
        <span>已有账号，<a href="${pageContext.request.contextPath}/exitLogin.do">直接登录 &gt;</a></span>       
    </div>
     <form action="${pageContext.request.contextPath}/userInfoRegister.do" method="post" id="form" name="form" onsubmit="return validateForm()">
    <div class="logibox">
        <div class="itm clearfix">
            <div class="iput">
                <input id="user_phone"  name="user_phone" placeholder="请输入手机号" autocomplete="off" onblur="validateCellphone()" class="wwinct r5" type="text">
            </div>
            <span class="lowrong mll" id="err_username"><p></p></span>
        </div>
        <div class="iisi" style="visibility: visible;">输入常用的手机号，便于登录和找回密码</div>
        <div class="itm clearfix">
            <div class="iput">
                <input id="user_name" name="user_name" placeholder="请输入昵称" onfocus="showdesc(this);" class="wwinct r5" maxlength="16" type="text">
            </div>
            <span class="lowrong mll" id="err_nickname"><p></p></span>
        </div>
        <div class="iisi">中英文均可，最多16个字喔~</div>
        <div class="itm clearfix" style="position: relative;">
            <div class="iput">
                <input id="user_pwd" name="user_pwd" placeholder="请输入密码" onfocus="showPassportDesc(this);" class="wwinct r5" maxlength="20" type="password">
            </div>
            <span class="lowrong mll" id="err_password"><p></p></span>
            <div class="passcheck">
                <img class="cicon" src="./手机号注册 - 美食天堂_files/1550543732.jpg" alt="">
                <div>强度：
                    <p class="checkbar">
                        <span class="one"></span>
                        <span class="two"></span>
                        <span class="three"></span>
                    </p>
                    <span class="checktype"></span>
                </div>
                <ul class="checklist">
                    <li class="citem1"><b></b>密码长度为6-20位</li>
                    <li class="citem2"><b></b>只能包含字母，数字以及标点符号（除空格）</li>
                    <li class="citem3"><b></b>字母数字和标点符号至少包含两种</li>
                </ul>
            </div>
        </div>
        <!-- <div class="iisi">密码长度为6-20位，不能含有空格</div>
        <div class="itm clearfix">
            <div class="iput">
                <input id="dpasswd" placeholder="确认密码" onfocus="showdesc(this);" class="wwinct r5" maxlength="20" type="password">
            </div>
            <span class="lowrong mll" id="err_dpasswd"><p></p></span>
        </div> 
        <div class="iisi">再输入一次密码</div>-->
       <!--  <div class="itm clearfix" id="jiaoyanma_div">
            <div class="yanm">
                <input id="code" class="yzma r5" maxlength="6" type="text" placeholder="输入验证码" disabled="">
                <button class="btn" style="margin-top:-9px;font-size:12px;height:34px;width:132px;margin-left:53px;" id="send_vercode" disabled="">获取验证码</button>
            </div>
        </div> -->
        <div class="itm clearfix">
            <span class="lowrong mll" id="err_public" style="margin-left: 65px"></span>
        </div>
        <div class="iloo" style="margin-bottom: 30px;">
            <span class="lxieyi">
                <input type="checkbox" checked="checked" class="czl" id="agreement"> 我已阅读并且同意<a href="#" target="_blank" title="用户协议">美食天堂使用协议</a>
                <b id="agreement_tip" class="fwn ff0 pls"></b>
            </span>
            <input id="signup" type="submit" class="btnrdz r3" style="background: #FFB31A">注册</button>
        </div>
     </div>   
      </form>       
</div>

    </div>
    <div id="footer">
    <div class="foot ptm">
        <div class="clink relative">
            <a href="#" rel="nofollow" target="_blank">关于吃货天堂</a> ·
             <a href="#" rel="nofollow" target="_blank">关于工作</a> ·
            <a href="#" rel="nofollow" target="_blank">意见反馈</a> ·
                <a href="#" target="_blank">友情链接</a> · 
            <a href="#" target="_blank">菜谱大全</a> ·
            <a href="#" target="_blank">品牌馆</a>
        </div>
        <div class="cght">
            ©2009-2015 <a href="#" target="_blank">xxxxxx</a> <a href="http://www.miibeian.gov.cn/" target="_blank" rel="nofollow">xxxxx</a> xxxxx
        </div>
        <div class="botfans mt15">
            <span class="bonefans">
            </span>
            <span class="bonefans">
            </span>
            <span class="bonefans">            
            </span>
        </div>
     </div>
    </div>
    


<!-- <div id="pic_captc" class="modal hide fade getup" tabindex="-1" role="dialog" style="top:34%;left:56%;font-family:&#39;Microsoft Yahei&#39;;">
    <p class="uptips">请输入图片验证码</p>
    <p class="upinput"><input type="text" id="img_captc_code" maxlength="5"><span><img id="img_captc" src="./手机号注册 - 美食天堂_files/captcha"></span></p><p>
    <a class="btnoff" id="verify_imgcaptc">获取短信验证码</a>
</p></div> -->

<script async="" src="${pageContext.request.contextPath}/static/foodrescourse/analytics.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/foodrescourse/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/foodrescourse/base.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/foodrescourse/md5.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/foodrescourse/bootstrap.min.js"></script>

<script type="text/javascript">
    var _SIGNUPTYPE         = "mobile";
</script>

<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/static/foodrescourse/signup.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/foodrescourse/webbase.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/foodrescourse/websignup.js"></script>



<script type="text/javascript">
/*验证邮箱或者手机号*/
function isEmailOrPhone(text) {
    if(!text){
        return false;
    }
    var email = /^([a-z0-9\+_\-]+)(\.[a-z0-9\+_\-]+)*@([a-z0-9\-]+\.)+[a-z]{2,6}$/i;
    var phone = /^1[3|4|5|7|8][0-9]\d{8}$/;
    if (text && (email.test(text) || phone.test(text))) {
        return true;
    } else{
        return false;
    }
}
function isEmail(text) {
    if(!text){
        return false;
    }
    var email = /^([a-z0-9\+_\-]+)(\.[a-z0-9\+_\-]+)*@([a-z0-9\-]+\.)+[a-z]{2,6}$/i;
    if (text && email.test(text)) {
        return true;
    } else{
        return false;
    }
}

function isPhone(text) {
    if(!text){
        return false;
    }
    var phone = /^1[3|4|5|7|8][0-9]\d{8}$/;
    if (text && phone.test(text)) {
        return true;
    } else{
        return false;
    }
}
</script>
<script type="text/javascript">
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
  ga('create', 'UA-60338497-1', 'auto');
  ga('send', 'pageview');
</script>

</body></html>