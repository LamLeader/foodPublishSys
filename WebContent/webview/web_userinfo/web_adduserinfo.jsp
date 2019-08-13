<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/openresource/layui/css/layui.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/images/web_icon.png"/>
	<script src="${pageContext.request.contextPath}/openresource/layui/layui.js"></script>
	<script  src="${pageContext.request.contextPath}/static/js/web_js/jquery.js"></script>
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
		    alert("添加用户成功！！！");	
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
	 function validatePSW(){
	    	var psw=document.getElementById("user_pwd").value;
	    	var regPwd=document.getElementById("regPwd").value;
	    	if(psw==""){
			    alert("请输入密码！！！");	
			    return false;
			}if(psw!=regPwd){
			    alert("输入新密码与确认密码前后不一致！！！");	
			    document.getElementById("regPwd").value="";
			    return false;
			}
	    }
	</script>
	<script type="text/javascript">
   	     //JS校验form表单信息
   	     function checkData(){
   	    	var arrImg = ["jpg","png","gif"];//图片格式
   	     	var upFile = $("#upFile").val();
   	     	var suffix = upFile.substr(upFile.lastIndexOf(".")+1);
   	        if(""== upFile){
   	     		alert("选择需要导入的图片！");
   	     		return false;
   	     	}
	   	
   	     	return true;
   	     }
   	     
   	     //ajax 方式下载文件操作
		 $(document).ready(function(){
       		$('#exportExcel').click(function(){
         			$('#form2').ajaxSubmit({  
         				dataType: 'text',
         				error: errorMsg
         			}); 
				function errorMsg(){ 
					alert("导出excel出错！");    
				}
       		});
   	     });
    </script>
</head>
<body >
<div class="layui-layout layui-layout-admin">
 <form class="layui-form" action="${pageContext.request.contextPath}/userInfoSave.do" id="form1" name="form1" method="post" onsubmit="return validateForm()">
    <div class="sw_div_max_box">
			<!-- 内容主体区域 -->
			<div class="sw_div_box">
				<div style="padding: 30px; background-color: #F2F2F2;">
					<div class="layui-row layui-col-space15">
						<div class="layui-col-md12">
							<div class="layui-card">
								<br> <br>
								<div class="">
									<h1 align="center">个人资料录入</h1>
								</div>
								<div class="layui-card-body">
									<fieldset class="layui-elem-field layui-field-title"
										style="margin-top: 30px;">
										<legend>信息录入</legend>
									</fieldset>
										<div style="padding: 20px; background-color: #F2F2F2;">
											<div class="layui-row layui-col-space15">
											   <!--  左边 -->
												<div class="layui-col-md6">
													<div class="layui-card">
														<div class="layui-card-header">个人信息</div>
														<div class="layui-card-body">
															<div class="layui-form-item">
																<label class="layui-form-label">登录名称</label>
																<div class="layui-input-block">
																	<input type="text" name="user_phone" id="user_phone" requre lay-verify="user_phone"
																		autocomplete="off" placeholder="请输入您的电话号码!!!" onblur="validateCellphone()"
																		class="layui-input">
																</div>
															</div>
															<div class="layui-form-item">
																<label class="layui-form-label">用户名</label>
																<div class="layui-input-block">
																	<input type="text" name="user_name"  id="user_name" 
																		class="layui-input">
																</div>
															 </div>
															 <div class="layui-form-item">
																<label class="layui-form-label">登录级别</label>
																<div class="layui-input-block">
																	<select name="user_level" requre lay-filter="user_level">
																		<option value="管理员" >管理员</option>
																		<option value="用户"  selected="selected">用户</option>
																	</select>
																</div>
											                   </div>
														</div>
													</div>
												</div>
												<!-- 右边 -->
												<div class="layui-col-md6">
													<div class="layui-card">
														<div class="layui-card-header">其他信息</div>
														<div class="layui-card-body">
														    <div class="layui-form-item">
																<label class="layui-form-label">登录密码</label>
																<div class="layui-input-block">
																	<input type="password" name="user_pwd" id="user_pwd"
																		lay-verify="pass" placeholder="请输入长度为6-12位的密码"
																		autocomplete="off" class="layui-input" maxlength="12">
																</div>
															</div>
															<div class="layui-form-item">
																<label class="layui-form-label">确认密码</label>
																<div class="layui-input-block">
																	<input type="password" id="regPwd" required
																		lay-verify="regPwd" placeholder="输入长度为6-12位的确认密码"
																		autocomplete="off" class="layui-input" onblur="validatePSW()">
																</div>
															</div>
														</div>
													</div>
											</div>
										</div>
								</div>
							</div>
						</div>
					</div>
						<br>
							<div  style="width: 600px;margin: 0 auto;text-align: center;">
								<button   style="padding: 5px 20px;border: 1px solid red;border-radius:5px;background-color: red;">立即提交</button>
								<button type="reset"   style="padding: 5px 20px;margin-left:20px;border: 1px solid red;border-radius:5px;background-color: red;">重置</button>
							</div>
					</div>
			</div>
		</div>
     </form>
</div>
	<br><br><br>
<script src="../../openresource/layui/layui.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  //日期
  laydate.render({
    elem: '#date'
  });
  laydate.render({
    elem: '#date1'
  });
  
  //创建一个编辑器
  var editIndex = layedit.build('LAY_demo_editor');
 
  //自定义验证规则
  form.verify({
	  name: function(value){
	      if(value.length <1){
	        return '姓名至少得1个字符啊';
	      }
    },loginname: function(value){
         if(value.length <1){
            return '请输入登录名';
          }
    },position: function(value){
         if(value.length <1){
            return '请输入您的职位';
          }
    },personalMotto: function(value){
         if(value.length <1){
            return '请输入您的个人格言';
          }
    },resume: function(value){
         if(value.length <1){
            return '请输入您的个人简历';
          }
    },age: function(value){
    	var regNum = /^[0-9]{1,2}$/;
    	var age = $("#age").val();
    	 if(value.length <1){
             return '请输入年龄';
           }
    	  if(!(regNum.test(age))){
            return '友情提示年龄在1到99岁之间请检查';
          } 
    },pass: [/(.+){6,12}$/, '密码必须6到12位']
    ,content: function(value){
      layedit.sync(editIndex);
    }
  });
  //监听提交
   form.on('submit(demo1)', function(data){
    layer.alert(JSON.stringify(data.field), {
      title: '您提交的提交信息',
      
    });
    return true;
  });
  
});
</script>
	
</body>
</html>