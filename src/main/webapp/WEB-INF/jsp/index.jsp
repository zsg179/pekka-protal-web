<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>皮卡玩具商城(PEKKA.COM)-正品低价、品质保障、配送及时、轻松购物！</title>
<meta name="description" content="皮卡PEKKA.COM-专业的综合网上购物商城。便捷、诚信的服务，为您提供愉悦的网上商城购物体验! ">
<meta name="Keywords" content="网上购物,网上商城,皮卡商城">
<link href="/css/taotao.css" rel="stylesheet"/>
<script type="text/javascript">
	window.pageConfig={
	compatible:true,
	navId:"home",
	enableArea: true
	};
</script>
<style type="text/css">
#categorys-2013 .mc {
	display: block;
}
#categorys-2013 .mt {
	background: 0
}
</style>
</head>
<body>
<!-- header start -->
<jsp:include page="commons/header.jsp" />
<!-- header end -->
<div class="w">
<div id="o-slide">
<div class="slide" id="slide">
<script type="text/javascript">
;(function(cfg, doc) {
    if ( !cfg.DATA_MSlide ) {
        cfg.DATA_MSlide=[];
    }
    //var data = [{"srcB":"http://image.taotao.com/images/2015/03/03/2015030304360302109345.jpg","height":240,"alt":"","width":670,"src":"http://image.taotao.com/images/2015/03/03/2015030304360302109345.jpg","widthB":550,"href":"http://sale.jd.com/act/e0FMkuDhJz35CNt.html?cpdad=1DLSUE","heightB":240},{"srcB":"http://image.taotao.com/images/2015/03/03/2015030304353109508500.jpg","height":240,"alt":"","width":670,"src":"http://image.taotao.com/images/2015/03/03/2015030304353109508500.jpg","widthB":550,"href":"http://sale.jd.com/act/UMJaAPD2VIXkZn.html?cpdad=1DLSUE","heightB":240},{"srcB":"http://image.taotao.com/images/2015/03/03/2015030304345761102862.jpg","height":240,"alt":"","width":670,"src":"http://image.taotao.com/images/2015/03/03/2015030304345761102862.jpg","widthB":550,"href":"http://sale.jd.com/act/UMJaAPD2VIXkZn.html?cpdad=1DLSUE","heightB":240},{"srcB":"http://image.taotao.com/images/2015/03/03/201503030434200950530.jpg","height":240,"alt":"","width":670,"src":"http://image.taotao.com/images/2015/03/03/201503030434200950530.jpg","widthB":550,"href":"http://sale.jd.com/act/kj2pmwMuYCrGsK3g.html?cpdad=1DLSUE","heightB":240},{"srcB":"http://image.taotao.com/images/2015/03/03/2015030304333327002286.jpg","height":240,"alt":"","width":670,"src":"http://image.taotao.com/images/2015/03/03/2015030304333327002286.jpg","widthB":550,"href":"http://sale.jd.com/act/xcDvNbzAqK0CoG7I.html?cpdad=1DLSUE","heightB":240},{"srcB":"http://image.taotao.com/images/2015/03/03/2015030304324649807137.jpg","height":240,"alt":"","width":670,"src":"http://image.taotao.com/images/2015/03/03/2015030304324649807137.jpg","widthB":550,"href":"http://sale.jd.com/act/eDpBF1s8KcTOYM.html?cpdad=1DLSUE","heightB":240}];
	var data = ${ad1};//轮播图

    cfg.DATA_MSlide = data;
    // 初始化一个广告信息
    if ( cfg.DATA_MSlide.length > 1 ) {
    	var first = pageConfig.FN_GetCompatibleData( cfg.DATA_MSlide[0] );
        var TPL = ''
            +'<ul class="slide-items">'
            +'<li clstag="homepage|keycount|home2013|09a1">'
            +'<a href="'+ first.href +'" target="_blank" title="'+ first.alt +'">'
            +'<img src="'+ first.src +'" width="'+ first.width +'" height="'+ first.height +'" >'
            +'</a>'
            +'</li>'
            +'</ul><div class="slide-controls"><span class="curr">1</span></div>';
        doc.write(TPL);
    }
})(pageConfig, document);;</script>
</div>
<!--大广告slide end-->
</div>

<!-- 商品分类 -->

<div class=category-title>
<span class="title">当季热卖</span>
</div>
<div class=hot-content>
<div class=content-left-img>
	<a class=content-a href="${hotADURL }" target="_blank">
		<img data-img="1" data-lazyload="${hotAD}"/>
	</a>
</div>
<!-- 商品部分 -->
<div class=content-item-list>
	<c:forEach items="${hotItemList}" var="h"> 
		<div class=content-item>
			<a href="http://localhost:8086/item/${h.id }.html" title="${h.title }" target="_blank">
				<img class="content-item-img" src="${h.image }" alt="皮卡商城" width="190px" height="190px"/>
				<div class="content-item-name">
					${h.title }
				</div>
				<div class="content-item-price">
					<fmt:formatNumber value="${h.price * 0.01}" type="currency" pattern="￥.00"/>
				</div>
			</a>
		</div>
	 </c:forEach>
</div>
<jsp:include page="_HOT_AD.jsp"/>
<%-- <%@ include file="_HOT_AD.jsp" %> --%>
</div>


<div class=category-title>
<span class="title">益智玩具</span>
</div>
<div class=hot-content>
<div class=content-left-img>
	<a class=content-a href="${yizhiADURL }" target="_blank">
		<img data-img="1" data-lazyload="${yizhiAD}"/>
	</a>
</div>
<!-- 商品部分 -->
<div class=content-item-list>
	<c:forEach items="${yizhiItemList}" var="yz"> 
		<div class=content-item>
			<a href="http://localhost:8086/item/${yz.id }.html" title="${yz.title }" target="_blank">
				<img class="content-item-img" src="${yz.image }" alt="皮卡商城" width="190px" height="190px"/>
				<div class="content-item-name">
					${yz.title }
				</div>
				<div class="content-item-price">
					<fmt:formatNumber value="${yz.price * 0.01}" type="currency" pattern="￥.00"/>
				</div>
			</a>
		</div>
	 </c:forEach>
</div>
<jsp:include page="_YIZHI_AD.jsp"/>
</div>

<div class=category-title>
<span class="title">遥控电动</span>
</div>
<div class=hot-content>
<div class=content-left-img>
	<a class=content-a href="${yaokongADURL }" target="_blank">
		<img data-img="1" data-lazyload="${yaokongAD}"/>
	</a>
</div>
<!-- 商品部分 -->
<div class=content-item-list>
	<c:forEach items="${yaokongItemList}" var="yk"> 
		<div class=content-item>
			<a href="http://localhost:8086/item/${yk.id }.html" title="${yk.title }" target="_blank">
				<img class="content-item-img" src="${yk.image }" alt="皮卡商城" width="190px" height="190px"/>
				<div class="content-item-name">
					${yk.title }
				</div>
				<div class="content-item-price">
					<fmt:formatNumber value="${yk.price * 0.01}" type="currency" pattern="￥.00"/>
				</div>
			</a>
		</div>
	 </c:forEach>
</div>
<jsp:include page="_YAOKONG_AD.jsp"/>
</div>

<div class=category-title>
<span class="title">积木拼插</span>
</div>
<div class=hot-content>
<div class=content-left-img>
	<a class=content-a href="${jmpcADURL }" target="_blank">
		<img data-img="1" data-lazyload="${jmpcAD}"/>
	</a>
</div>
<!-- 商品部分 -->
<div class=content-item-list>
	<c:forEach items="${jmpcItemList}" var="jmpc"> 
		<div class=content-item>
			<a href="http://localhost:8086/item/${jmpc.id }.html" title="${jmpc.title }" target="_blank">
				<img class="content-item-img" src="${jmpc.image }" alt="皮卡商城" width="190px" height="190px"/>
				<div class="content-item-name">
					${jmpc.title }
				</div>
				<div class="content-item-price">
					<fmt:formatNumber value="${jmpc.price * 0.01}" type="currency" pattern="￥.00"/>
				</div>
			</a>
		</div>
	 </c:forEach>
</div>
<jsp:include page="_JMPC_AD.jsp"/>
</div>

<div class=category-title>
<span class="title">动漫模型</span>
</div>
<div class=hot-content>
<div class=content-left-img>
	<a class=content-a href="${dmmxADURL }" target="_blank">
		<img data-img="1" data-lazyload="${dmmxAD}"/>
	</a>
</div>
<!-- 商品部分 -->
<div class=content-item-list>
	<c:forEach items="${dmmxItemList}" var="dmmx"> 
		<div class=content-item>
			<a href="http://localhost:8086/item/${dmmx.id }.html" title="${dmmx.title }" target="_blank">
				<img class="content-item-img" src="${dmmx.image }" alt="皮卡商城" width="190px" height="190px"/>
				<div class="content-item-name">
					${dmmx.title }
				</div>
				<div class="content-item-price">
					<fmt:formatNumber value="${dmmx.price * 0.01}" type="currency" pattern="￥.00"/>
				</div>
			</a>
		</div>
	 </c:forEach>
</div>
<jsp:include page="_DMMX_AD.jsp" />
</div>

<div class=category-title>
<span class="title">健身玩具</span>
</div>
<div class=hot-content>
<div class=content-left-img>
	<a class=content-a href="${jswjADURL }" target="_blank">
		<img data-img="1" data-lazyload="${jswjAD}"/>
	</a>
</div>
<!-- 商品部分 -->
<div class=content-item-list>
	<c:forEach items="${jswjItemList}" var="jswj"> 
		<div class=content-item>
			<a href="http://localhost:8086/item/${jswj.id }.html" title="${jswj.title }" target="_blank">
				<img class="content-item-img" src="${jswj.image }" alt="皮卡商城" width="190px" height="190px"/>
				<div class="content-item-name">
					${jswj.title }
				</div>
				<div class="content-item-price">
					<fmt:formatNumber value="${jswj.price * 0.01}" type="currency" pattern="￥.00"/>
				</div>
			</a>
		</div>
	 </c:forEach>
</div>
<jsp:include page="_JSWJ_AD.jsp"/>
</div>

<div class=category-title>
<span class="title">毛绒玩具</span>
</div>
<div class=hot-content>
<div class=content-left-img>
	<a class=content-a href="${mrwjADURL }" target="_blank">
		<img data-img="1" data-lazyload="${mrwjAD}"/>
	</a>
</div>
<!-- 商品部分 -->
<div class=content-item-list>
	<c:forEach items="${mrwjItemList}" var="mrwj"> 
		<div class=content-item>
			<a href="http://localhost:8086/item/${mrwj.id }.html" title="${mrwj.title }" target="_blank">
				<img class="content-item-img" src="${mrwj.image }" alt="皮卡商城" width="190px" height="190px"/>
				<div class="content-item-name">
					${mrwj.title }
				</div>
				<div class="content-item-price">
					<fmt:formatNumber value="${mrwj.price * 0.01}" type="currency" pattern="￥.00"/>
				</div>
			</a>
		</div>
	 </c:forEach>
</div>
<jsp:include page="_MRWJ_AD.jsp" />
</div>

<div class=category-title>
<span class="title">创意DIY</span>
</div>
<div class=hot-content>
<div class=content-left-img>
	<a class=content-a href="${cyDIYADURL }" target="_blank">
		<img data-img="1" data-lazyload="${cyDIYAD}"/>
	</a>
</div>
<!-- 商品部分 -->
<div class=content-item-list>
	<c:forEach items="${cyDIYItemList}" var="cyDIY"> 
		<div class=content-item>
			<a href="http://localhost:8086/item/${cyDIY.id }.html" title="${cyDIY.title }" target="_blank">
				<img class="content-item-img" src="${cyDIY.image }" alt="皮卡商城" width="190px" height="190px"/>
				<div class="content-item-name">
					${cyDIY.title }
				</div>
				<div class="content-item-price">
					<fmt:formatNumber value="${cyDIY.price * 0.01}" type="currency" pattern="￥.00"/>
				</div>
			</a>
		</div>
	 </c:forEach>
</div>
<jsp:include page="_CYDIY_AD.jsp"/>
</div>

<div class=category-title>
<span class="title">乐器</span>
</div>
<div class=hot-content>
<div class=content-left-img>
	<a class=content-a href="${yqADURL }" target="_blank">
		<img data-img="1" data-lazyload="${yqAD}"/>
	</a>
</div>
<!-- 商品部分 -->
<div class=content-item-list>
	<c:forEach items="${yqItemList}" var="yq"> 
		<div class=content-item>
			<a href="http://localhost:8086/item/${yq.id }.html" title="${yq.title }" target="_blank">
				<img class="content-item-img" src="${yq.image }" alt="皮卡商城" width="190px" height="190px"/>
				<div class="content-item-name">
					${yq.title }
				</div>
				<div class="content-item-price">
					<fmt:formatNumber value="${yq.price * 0.01}" type="currency" pattern="￥.00"/>
				</div>
			</a>
		</div>
	 </c:forEach>
</div>
<jsp:include page="_YQ_AD.jsp"/>
</div>
</div>

<!-- footer start -->
<jsp:include page="commons/footer.jsp" />
<!-- footer end -->
 

<script type="text/javascript">
	$(function(){
		hot_ranking();
		//setTimeout("yizhi_ranking();", 2000);
		yizhi_ranking();
		yaokong_ranking();
		jmpc_ranking();
		dmmx_ranking();
		jswj_ranking();
		mrwj_ranking();
		cydiy_ranking();
		yq_ranking();
		//setInterval('hot_ranking()', 60000);
	})

	function hot_ranking() {
		 $.ajax({
			url	:"/item/getSalesRanking.action",
			type:"post",
			dataType:"json",
			data:{key:"_HOT_AD"},
			success:function(data){
				
			} 
		}); 
		//$.post("/item/getSalesRanking.action",{key:"_HOT_AD"});
	}
	function yizhi_ranking() {
		$.ajax({
			url	:"/item/getSalesRanking.action",
			type:"post",
			dataType:"json",
			data:{key:"_YIZHI_AD"},
			success:function(data){
				
			} 
		});
	}
	function yaokong_ranking() {
		$.ajax({
			url	:"/item/getSalesRanking.action",
			type:"post",
			dataType:"json",
			data:{key:"_YAOKONG_AD"},
			success:function(data){
				
			} 
		});
	}
	function jmpc_ranking() {
		$.ajax({
			url	:"/item/getSalesRanking.action",
			type:"post",
			dataType:"json",
			data:{key:"_JMPC_AD"},
			success:function(data){
				
			} 
		});
	}
	function dmmx_ranking() {
		$.ajax({
			url	:"/item/getSalesRanking.action",
			type:"post",
			dataType:"json",
			data:{key:"_DMMX_AD"},
			success:function(data){
				
			} 
		});
	}
	function jswj_ranking() {
		$.ajax({
			url	:"/item/getSalesRanking.action",
			type:"post",
			dataType:"json",
			data:{key:"_JSWJ_AD"},
			success:function(data){
				
			} 
		});
	}
	function mrwj_ranking() {
		$.ajax({
			url	:"/item/getSalesRanking.action",
			type:"post",
			dataType:"json",
			data:{key:"_MRWJ_AD"},
			success:function(data){
				
			} 
		});
	}
	function cydiy_ranking() {
		$.ajax({
			url	:"/item/getSalesRanking.action",
			type:"post",
			dataType:"json",
			data:{key:"_CYDIY_AD"},
			success:function(data){
				
			} 
		});
	}
	function yq_ranking() {
		$.ajax({
			url	:"/item/getSalesRanking.action",
			type:"post",
			dataType:"json",
			data:{key:"_YQ_AD"},
			success:function(data){
				
			} 
		});
	}
</script>

</body>
</html>