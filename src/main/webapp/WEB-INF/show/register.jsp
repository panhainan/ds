<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>css/bootstrapValidator.css"/>
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<%-- <link rel="stylesheet" href="<%=basePath%>css/bootstrap-theme.min.css"> --%>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="<%=basePath%>js/jquery1.11.2.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=basePath%>js/bootstrap.min.js"></script>

<script type="text/javascript" src="<%=basePath%>js/bootstrapValidator.js"></script>
<title>梦之站 | 注册</title>
<style rel="stylesheet">
body {
	background-color: #DBDBDB;
		font-family: 宋体;
}

p {
	font-size: 20px;
	font-weight: 200;
}
</style>
</head>
<body>
	<!-- 导航栏 -->
	<div class="container">
		<div class="row">
			<h3>
				<a href="<%=basePath%>" alt="主页"><img src="<%=basePath%>img/icon/logo.png"
					alt="DreamStation"> </a>
			</h3>
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-ex1-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.html" title="首页">梦之站</a>
				</div>

				<div class="collapse navbar-collapse navbar-ex1-collapse">
					<ul id="main-menu-links" class="nav navbar-nav">
						<li><a href="<%=basePath%>introduction">团队介绍</a>
						</li>
						<li><a href="<%=basePath%>member">成员风采</a>
						</li>
						<li><a href="<%=basePath%>news/list">团队动态</a>
						</li>
						<li><a href="<%=basePath%>project/list">科研成果</a>
						</li>
						<li><a href="<%=basePath%>message/list">留言板</a>
						</li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<c:if test="${memberSession!=null}">
							<li><a href="<%=basePath%>manage/main">${memberSession.name}</a>
							</li>
						</c:if>
						<c:if test="${memberSession==null}">
							<li><a href="<%=basePath%>member/go-login">登录</a></li>
							<li><a href="<%=basePath%>member/go-register">注册</a></li>
						</c:if>
					</ul>
				</div>

			</nav>
		</div>
	</div>
	<div class="container"
		style="background-color: #ffffff;padding-bottom: 20px;">
		<div class="row">
			<ol class="breadcrumb container">
				<li class="first"><a href="<%=basePath%>">首页</a>
				</li>
				<li class="last"><a href="<%=basePath%>manage/go-register"
					class="active">注册</a>
				</li>
			</ol>
			<p style="margin: 20px;color: red">&emsp;&emsp;${message}</p>
			<p style="margin: 20px;">&emsp;&emsp;欢迎您的到来，请认真填写以下信息，填写完成后点击确认注册，然后等待梦之站的确定，谢谢！</p>
			<p style="margin: 20px;">&emsp;&emsp;注意此页面主要是为已加入梦之站的成员服务，其他游客注册无效！</p>
			<div style="margin: 20px;">
				<form id="shippingForm" class="form-horizontal"   action="<%=basePath%>member/register" method="post" role="form">
<fieldset>
					<div class="form-group">
						<label for="truename" class="col-sm-4 control-label">真实姓名<sup>*</sup></label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="truename" name="name" data-bv-regexp="true" data-bv-regexp-regexp="^[\u4e00-\u9fa5]{1,7}$|^[\dA-Za-z_]{1,14}$" data-bv-regexp-message="超出最大长度(7个汉字，14个字符)"
								placeholder="请输入真实姓名" required>
						</div>
					</div>
					<div class="form-group">
						<label for="grade" class="col-sm-4 control-label">目前情况<sup>*</sup></label> 
						<select name="gradeNumber"
							class="col-sm-3" id="grade" style="margin-left: 15px;">
							<option value="1" style="height: 25px;line-height: 25px;">大一</option>
							<option value="2" style="height: 25px;line-height: 25px;">大二</option>
							<option value="3" style="height: 25px;line-height: 25px;">大三</option>
							<option value="4" style="height: 25px;line-height: 25px;">大四</option>
							<option value="5" style="height: 25px;line-height: 25px;">毕业</option>
							<option value="6" style="height: 25px;line-height: 25px;">老师</option>
							<option value="0" style="height: 25px;line-height: 25px;">其他</option>
						</select>
					</div>
					<div class="form-group">
						<label for="categoryNumber" class="col-sm-4 control-label">所属类别<sup>*</sup></label>
						<select class="col-sm-3" id="category" name="categoryNumber"
							style="margin-left: 15px;">
							<option value="1" style="height: 25px;line-height: 25px;">程序员</option>
							<option value="2" style="height: 25px;line-height: 25px;">设计师</option>
							<option value="3" style="height: 25px;line-height: 25px;">导师</option>
						</select>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-4 control-label">常用邮箱<sup>*</sup></label>
						<div class="col-sm-4">
							<input type="email" name="loginEmail" class="form-control" data-bv-regexp="true" data-bv-regexp-regexp="^[a-zA-Z][a-zA-Z0-9_]{3,20}[a-zA-Z0-9]@[a-zA-Z0-9]+\.[a-zA-Z]{2,4}$" data-bv-regexp-message="长度不符合要求（邮箱前缀3-20，后缀2-4）"
								id="email" placeholder="请输入常用邮箱，用来进行登录和其他操作" required>
						</div>
					</div>
					<div class="form-group">
						<label for="loginpass" class="col-sm-4 control-label">登录密码<sup>*</sup></label>
						<div class="col-sm-4">
							<input type="password" class="form-control" name="loginPass" id="loginpass"  data-bv-regexp="true" data-bv-regexp-regexp="^[\dA-Za-z_]{6,16}$" data-bv-regexp-message="长度不符合要求(6-16个字符)"
								placeholder="请输入登录密码" required>
						</div>
					</div>
					<div class="form-group">
						<label for="loginpass" class="col-sm-4 control-label">确认密码<sup>*</sup></label>
						<div class="col-sm-4">
							<input type="password" class="form-control" name="confirmLoginPass" id="loginpass"
								placeholder="请确认登录密码" required>
						</div>
					</div>
					<div class="form-group">
						<label for="phone" class="col-sm-4 control-label">联系电话<sup>*</sup></label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="phone" id="phone"  data-bv-regexp="true" data-bv-regexp-regexp="^[\dA-Za-z_]{6,16}$" data-bv-regexp-message="长度不符合要求(6-16个字符)"
								placeholder="请输入联系电话" required>
						</div>
					</div>
					<div class="form-group">
						<label for="qq" class="col-sm-4 control-label">Q Q 号码<sup>*</sup></label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="qq" id="qq"  data-bv-regexp="true" data-bv-regexp-regexp="^[\dA-Za-z_]{6,16}$" data-bv-regexp-message="长度不符合要求(6-16个字符)"
								placeholder="请输入Q Q 号码" required>
						</div>
					</div>
					<div class="form-group">
						<label for="introduction" class="col-sm-4 control-label">个人简介<sup>*</sup></label>
						<div class="col-sm-6">
							<textarea style="resize:none" name="introduction" class="form-control" id="introduction"  data-bv-regexp="true" data-bv-regexp-regexp="^[\u4e00-\u9fa5]{20,80}$|^[\dA-Za-z_]{40,160}$" data-bv-regexp-message="长度不符合要求(20-80个汉字，40-160个字符)"
								placeholder="请输入100字以内的个人介绍" required></textarea>
						</div>
					</div>


					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-4">
							<button type="submit" class="btn btn-primary btn-lg">确认注册</button>
						</div>
					</div>
					</fieldset>
				</form>

			</div>
		</div>
	</div>
	<!-- 底部版权声明 -->
	<div class="container text-center">
		<hr>
		<div class="row">
			<div class="col-md-12">
				<address>
					Copyright@<strong>梦之站</strong> &emsp;| &emsp;
					湖南省长沙市(雨花区)万家丽南路2段960号<br> <abbr title="Phone">电话:</abbr>
					0731-2309047 &emsp;&emsp; <abbr title="Email">邮箱:</abbr> <a
						href="mailto:#">dreamstationx.@sina.com</a>
				</address>
			</div>
		</div>
	</div>
	<script type="text/javascript">
    $(document).ready(function() {
        $('#shippingForm')
            .on('init.form.bv', function(e, data) {
                //console.log(data);
            })
            .bootstrapValidator({
                message: '输入的值无效',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    name: {
                        validators: {
                            notEmpty: {
                                message: '姓名必须填写'
                            }
                        }
                    },
                    loginPass: {
		                validators: {
		                    notEmpty: {
		                        message: '登录密码不能为空'
		                    },
		                }
		            },
		            confirmLoginPass: {
		                validators: {
		                    notEmpty: {
		                        message: '确认密码不能为空'
		                    },
		                    identical: {
		                        field: 'loginPass',
		                        message: '两次密码输入不一致'
		                    }
		                }
		            },
                    phone: {
                        message: '输入的电话号码非法',
                        validators: {
                            notEmpty: {
                                message: '电话号码必填'
                            },
                            digits: {
                                message: '电话号码必须都为数字'
                            }
                        }
                    },
                    qq: {
                        message: '输入的QQ号码非法',
                        validators: {
                            notEmpty: {
                                message: 'QQ号码必填'
                            },
                            digits: {
                                message: 'QQ号码必须都为数字'
                            }
                        }
                    },
                    loginEmail: {
                        validators: {
		                    notEmpty: {
		                        message: '邮箱必须填写'
		                    },
		                    emailAddress: {
		                        message: '输入的值不是一个邮箱地址'
		                    }
		                }
                    }
                }
            })
            .on('added.field.bv', function(e, data) {
                console.log('Added element --> ', data.field, data.element, data.options);
            })
            .on('change', 'input[type="checkbox"][name="receiver"]', function() {
                var sameAsSender   = $(this).is(':checked'),
                    $receiverPhone = $('#shippingForm').find('input[name="receiverPhone"]').eq(0),
                    $receiverCity  = $('#shippingForm').find('input[name="receiverCity"]').eq(0);

                if (sameAsSender) {
                    $('#receiverInfo').hide();

                    $('#shippingForm')
                        // Remove field
                        .bootstrapValidator('removeField', 'receiverName')
                        .bootstrapValidator('removeField', 'receiverAddress')
                        .bootstrapValidator('removeField', $receiverPhone)
                        .bootstrapValidator('removeField', $receiverCity);
                } else {
                    $('#receiverInfo').show();

                    $('#shippingForm')
                        // Add field
                        .bootstrapValidator('addField', 'receiverName', {
                            validators: {
                                notEmpty: {
                                    message: 'The name is required'
                                }
                            }
                        })
                        .bootstrapValidator('addField', 'receiverAddress')      // The options are automatically parsed from HTML attributes
                        .bootstrapValidator('addField', $receiverPhone, {
                            message: 'The phone number is not valid',
                            validators: {
                                notEmpty: {
                                    message: 'The phone number is required'
                                },
                                digits: {
                                    message: 'The value can contain only digits'
                                }
                            }
                        })
                        .bootstrapValidator('addField', $receiverCity);  // The options are automatically parsed from HTML attributes
                }
            });
    });
</script>
</body>
</html>
