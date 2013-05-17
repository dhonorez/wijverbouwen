<div class="navbar navbar-inner navbar-fixed-top"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:util="urn:jsptagdir:/WEB-INF/tags/util"
	xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">

	<jsp:directive.page contentType="text/html;charset=UTF-8" />

	<div class="navbar-inner">
		<div class="container">

			<button type="button" class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
            
			<a class="brand" href="index.html"><img src="${pageContext.servletContext.contextPath}/images/hartje2.png" alt="" style="width:25px;height:25px;"/> Huwelijkslijst Noke &amp; Dylan</a>
			<div class="nav-collapse collapse">
				<ul class="nav">
					<li id="navIndex"><a href="${pageContext.servletContext.contextPath}/index.html">Home</a></li>
					<li id="navShop"><a href="${pageContext.servletContext.contextPath}/shop.html">Shop</a></li>
					<li id="navContact"><a href="${pageContext.servletContext.contextPath}/contact.html">Contact</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>