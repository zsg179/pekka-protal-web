<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link href="/css/taotao.css" rel="stylesheet"  -->
</head>
<body>
	<div class=item-rank>
		<div class="rank-title">
			<h3 class="title-info">人气单品</h3>
		</div>
		<div class=rank-body>
			<c:forEach items="${YKItemRanking }" var="YK" varStatus="status">
				<c:if test="${status.count <= 3 }">
					<div class=rank-body-item>
						<a class="rank-body-item-link"
							href="http://localhost:8086/item/${YK.id }.html">
							<div class="item-link-img" style="margin-left: -15px;">
								<div class="lazyimg"
									style="background: transparent none repeat scroll 0% 0%;"
									alt="${YK.title }" title="${YK.title }">
									<img class="imgloaded" src="${YK.image }" alt="${YK.title }" />
								</div>
							</div>
							<div class="goods-info" style="padding-top: 0px;">
								<div class="goods-rank-ranking"
									style="background-color: rgb(221, 69, 69); color: rgb(255, 255, 255); font-size: 14px;">
									${status.count }</div>
								<div class="goods-rank-name" style="color: rgb(102, 102, 102);">
									${YK.title }</div>
								<div class="goods-rank-price" style="color: rgb(221, 69, 69);">
									<fmt:formatNumber value="${YK.price * 0.01}" type="currency"
										pattern="￥.00" />
								</div>
							</div>
						</a>
					</div>
				</c:if>
				<c:if test="${status.count > 3 }">
					<div class=rank-body-item2>
						<a class="rank-body-item-link"
							href="http://localhost:8086/item/${YK.id }.html">
							<div class="goods-info" style="padding-top: 0px;">
								<div class="goods-rank-ranking2">
									${status.count }</div>
								<div class="goods-rank-name2" style="color: rgb(102, 102, 102);">
									${YK.title }</div>
							</div>
						</a>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
</body>
</html>