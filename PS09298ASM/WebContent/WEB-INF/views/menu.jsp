<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<nav
	class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
	id="ftco-navbar">
	<div class="container">
		<a class="navbar-brand" href="#">Coffee Shop<small>Management</small></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#ftco-nav" aria-controls="ftco-nav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="oi oi-menu"></span> Menu
		</button>
		<div class="collapse navbar-collapse" id="ftco-nav">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a href="manage/product.htm"
					class="nav-link"><s:message code="menu.product" /></a></li>
				<li class="nav-item"><a href="manage/category.htm" class="nav-link"><s:message code="menu.category" /></a></li>
				<li class="nav-item"><a href="manage/user.htm" class="nav-link"><s:message code="menu.user" /></a></li>
				<li class="nav-item"><a href="manage/sale.htm" class="nav-link"><s:message code="menu.sale" /></a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="dropdown04"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><s:message code="menu.statistical" /></a>
					<div class="dropdown-menu" aria-labelledby="dropdown04">
						<a class="dropdown-item" href="manage/top.htm"><s:message code="menu.top" /></a> <a
							class="dropdown-item" href="manage/revenue.htm"><s:message code="menu.revenue" /></a>
					</div></li>
				<li class="nav-item"><a href="manage/contact.htm" class="nav-link"><s:message code="menu.contact" /></a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="room.html" id="dropdown04"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><s:message code="menu.lang" /></a>
					<div class="dropdown-menu" aria-labelledby="dropdown04">
						<a class="dropdown-item" href="shop.html" data-lang="en">English</a> <a
							class="dropdown-item" href="product-single.html" data-lang="vi">Tiếng việt</a>
					</div></li>
			</ul>
		</div>
	</div>
</nav>
<!-- END nav -->