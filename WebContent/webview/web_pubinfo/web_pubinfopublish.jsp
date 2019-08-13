<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/openresource/layui/css/layui.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/images/web_icon.png"/>
	<script src="${pageContext.request.contextPath}/openresource/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/openresource/ckeditor_4.10.0_standard/ckeditor/ckeditor.js"></script>
	<script  src="${pageContext.request.contextPath}/static/js/web_js/jquery.js"></script>
	<script type="text/javascript">
   	     //JS校验form表单信息
   	     function checkData(){
   	    	var arrImg = ["jpg","png","gif"];//图片格式
   	    	var pub_title = $("#pub_title").val();
   	    	var pub_content = $("#pub_content").val();
   	    	var price = $("#price").val();
   	     	var upFile = $("#upFile").val();
   	     	var suffix = upFile.substr(upFile.lastIndexOf(".")+1);
   	        if("" == pub_title){
	     		alert("请输入标题！");
	     		return false;
	     	}if("" == pub_content){
	     		alert("请输入美食描述！");
	     		return false;
	     	}if(""== price){
	     		alert("请输入价格！");
	     		return false;
	     	}if(""== upFile){
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

<body class="overflow:none;" >

	<div class="layui-layout layui-layout-admin">
		<form class="layui-form" action="${pageContext.request.contextPath}/publishInfoSave.do"
			id="form1" name="form1" method="post" enctype="multipart/form-data"  onsubmit="return checkData()" >
			<div class="sw_div_max_box">
				<!-- 内容主体区域 -->
				<div class="sw_div_box">

					<div style="padding: 30px; background-color: #F2F2F2;">
						<div class="layui-row layui-col-space15">
							<div class="layui-col-md12">
								<div class="layui-card">
									<br> <br>
									<div class="">
										<h1 align="center">信息录入</h1>
									</div>
									<div class="layui-card-body">
										<fieldset class="layui-elem-field layui-field-title"
											style="margin-top: 30px;">
											<legend>美食上传</legend>
										</fieldset>
										<div style="padding: 20px; background-color: #F2F2F2;">
											<div class="layui-row layui-col-space15">
											    <div class="layui-col-md12">
													<div class="layui-card">
														<div class="layui-card-header" style="color:red;">*类型(必选)</div>
														<div class="layui-card-body">
															<div class="layui-form-item">
																<div class="">
																	<select name="pub_type" requre lay-filter="pub_type">
																		<option value="1" selected="selected">食谱</option>
																		<option value="2" >美食圈</option>
																		<option value="3" >小知识</option>
																	</select>
																</div>
															</div>
														</div>
													</div>
												</div>
												<div class="layui-col-md12">
													<div class="layui-card">
														<div class="layui-card-header" style="color:red;">*标题（美食标题）</div>
														<div class="layui-card-body">
															<div class="layui-form-item">
																<div class="">
																	<input type="text" name="pub_title" id="pub_title" class="layui-input" placeholder="清输入美食标题">
																</div>
															</div>
														</div>
													</div>
												</div>
												<div class="layui-col-md12">
													<div class="layui-card">
														<div class="layui-card-header" style="color:blue;">内容（此处的内容可以放文字、图片、超链接、等类型，可以自由个性化排版，显示结果以此处排版内容为准）</div>
														<div class="layui-card-body">
															<div class="layui-form-item layui-form-text">
																<div class="" style="height: 1200px;">
																	<textarea name="pub_content" id="pub_content" placeholder="请输入内容（此处的内容可以放文字、图片、超链接、等类型，可以自由排版，显示结果以此处排版内容为准）" rows="30"
																		class="layui-textarea" ></textarea>
																</div>
															</div>
														</div>
													</div>
												</div>
												<div class="layui-col-md12">
													<div class="layui-card">
														<div class="layui-card-header" style="color:red;">*价格（美食价格）</div>
														<div class="layui-card-body">
															<div class="layui-form-item">
																<div class="">
																	<input type="text" name="price" id="price" class="layui-input" placeholder="清输入美食价格">
																</div>
															</div>
														</div>
													</div>
												</div>
												<div class="layui-col-md12">
													<div class="layui-card">
														<div class="layui-card-header">图片信息</div>
														<div class="layui-card-body">
															<div class="layui-upload">
																<div class="layui-card-header">标题图片（/为美化需要，要求图片的长宽比例为1:1）</div>
																<div class="layui-card-body">
																	<input type="file" name="upFile"  id="upFile" />
																	<div class="layui-upload-list"></div>
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
	<script type="text/javascript">CKEDITOR.replace('pub_content',{ height: '1000px'});</script>
	<script>
		layui.use('form', function() {
			var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功

			//……

			//但是，如果你的HTML是动态生成的，自动渲染就会失效
			//因此你需要在相应的地方，执行下述方法来手动渲染，跟这类似的还有 element.init();
			form.render();
		});
		layui.use('element', function() {
			var element = layui.element;

		});
	</script>
	
</body>
</html>
