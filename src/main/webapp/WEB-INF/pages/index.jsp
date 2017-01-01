<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/13
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <title>JokeTaker 首页</title>

  <script language="javascript" type="text/javascript" src="1.9.0/jquery.js">
    $(function(){
      $.get(
              '/joke/getAJoke',
              function(ret)//回调函数,ret为服务器返回的数据，名字可以随便取，是合法的标识符就可以了。
              {
                if(typeof ret!='object')
                {
                  ret=json.parse();  //首先你要明白一点，在客户端和服务器之间传递的是json字符串,所以需要把json字符串
//转化成js对象,js才方便操作它
                }
//后面要怎么操作就看具体问题了
              }
      );
    });
  </script>

  <script>
    function displayDate(){
      document.getElementById("demo").innerHTML=Date();
    }
  </script>
  <!-- 新 Bootstrap 核心 CSS 文件 -->
  <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
<h1>这里是JokeTaker首页</h1>

<h3 id="demo">出现此页面，说明配置成功。</h3>
<%
  out.println("Hello World！");
%>
<button type="button" onclick="displayDate()">显示日期</button>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>