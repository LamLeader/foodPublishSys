<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="keywords" content="#">
    <meta name="description" content="#">
    <meta name="author" content="美食天堂 #">
    <meta name="google-site-verification" content="2gKQfz4b2duFoGhkAMtl9EsHRd0nJWda-SxknzWYAGA">
    <meta name="y_key" content="e4b03bf435642365">
    <meta property="wb:webmaster" content="5d3113ad6af60df9">
    <meta name="varify-v1" content="baidu-z6YB9Um9kaoKXmFf">
    <meta name="baidu-site-verification" content="f4bd7fa0f7e3712360b62873fcb22edd">
    <meta name="apple-itunes-app" content="app-id=434212566">
    <link href="./static/foodrescourse/bootstrap.min.css" charset="UTF-8" rel="stylesheet" type="text/css" media="screen">
    <link href="./static/foodrescourse/passport.css" charset="UTF-8" rel="stylesheet" type="text/css" media="screen">
    <script type="text/javascript">
    /* 表单验证 */
    function validateForm(){
        var user_phone=document.getElementById("user_phone").value;
        var user_pwd=document.getElementById("user_pwd").value;
    	if(user_phone==""){
		    alert("请输入电话号码！！！");	
		    return false;
		}if(user_pwd==""){
		    alert("输入密码！！！");	
		    return false;
		}if(user_phone!=""&&user_pwd!=""){
		   /*  alert("恭喜你登录成功！！！");	 */
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
        <a href="${pageContext.request.contextPath}/initIndex.do" style="margin-top: 90px;font-size:15pt;">返回首页</a>
        <div class="htop">
            <div class="hlogo"><a title="吃货天堂" href="">吃货天堂</a></div>      
        </div>    
    </div>
    <div id="main" class="clearfix">
        
<div class="bgsi">
    <div class="shic" style="margin-top:78px"><img src="./static/foodrescourse/sinin.png"></div>
</div>
<div class="silo clearfix">
    <div class="wizh">
        <h2>登录</h2>
        <span><a href="${pageContext.request.contextPath}/regiser.do">去注册 &gt;</a></span>
    </div>
     <form action="${pageContext.request.contextPath}/loginUserInfo.do" method="post" id="form" name="form" onsubmit="return validateForm()">
      ${msg}
    <div class="logone">                        
        <div class="iput">
            <input id="user_phone"  name="user_phone" placeholder="请输入手机号" class="dlsi r5" type="text" onblur="validateCellphone()">
        </div>
        <div class="iput">
            <input id="user_pwd" name="user_pwd" placeholder="请输入密码" class="dlsi r5" maxlength="20" type="password">
        </div>
        <div class="iput">
            <select name="type">
                  <option value="用户" selected="selected">用户</option>
                  <option value="管理员">管理员</option>
            </select>
        </div>
        <!-- <div id="captcha" class="tymm" style="display: none">
            <input id="code" class="yzma r5" maxlength="4" type="text" placeholder="输入验证码">
            <img class="czl mls mrs" width="100" height="30" id="codeimg" src="./登录 - 美食天堂_files/captcha">
            <a href="javascript:void(0);" id="chgcapt">换一张</a>
        </div>
        <input id="ajaxurl" type="hidden" value="https%3A%2F%2Fwww.douguo.com%2F">
        <div class="forg"><a href="https://passport.douguo.com/forget">忘记密码 &gt;</a><span id="err" class="twro" style="margin-left:20px;visibility: hidden"></span></div> -->
        <div class="mtsu">
            <button id="login" class="btnrlo r3" style="background: #FFB31A">登录</button>
        </div>
        <div class="otth">
    <h3>使用社交账号登录美食天堂</h3>
    <ul id="ds">
        <li>
            <a href=""><i class="ic_txzh"></i>腾讯账号</a>
            <a href="" class="ml36"><i class="ic_xlwb"></i>新浪微博</a>
        </li>
    </ul>
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


<script async="" src="./static/foodrescourse/analytics.js"></script>
<script type="text/javascript" src="./static/foodrescourse/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="./static/foodrescourse/base.js"></script>
<script type="text/javascript" src="./static/foodrescourse/md5.js"></script>
<script type="text/javascript" src="./static/foodrescourse/bootstrap.min.js"></script>

<script type="text/javascript" src="./static/foodrescourse/web.js"></script>


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