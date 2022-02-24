<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script type="text/javascript">
	$(function(){
	  $('.slider').bxSlider({
	    mode: 'fade',
	    slideWidth: 1200,
	    captions: true,
	    auto: true,
	    autoDelay: 300,
	    controls: false,
	    paper: false,
	    speed: 2000
	  });
	});
</script>
<style type="text/css">
	#image{
		width: 1000px;
		margin-left: auto;
		margin-right: auto;
		margin-top: 150px;
		
	}
</style>
</head>
<body>
	<table id="image">
	<tr>
	<td>
	<div class="slider">
			<div><img src="resources/img/p1.png"></div>
			<div><img src="resources/img/p2.png"></div>
			<div><img src="resources/img/p3.png"></div>
			<div><img src="resources/img/p4.png"></div>
			<div><img src="resources/img/p5.png"></div>
	</div>
	</td>
	</tr>
	</table>
</body>
</html>