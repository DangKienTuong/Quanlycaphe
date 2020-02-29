<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<section class="home-slider owl-carousel">

	<div class="slider-item"
		style="background-image: url(images/bg_3.jpg);"
		data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row slider-text justify-content-center align-items-center">

				<div class="col-md-7 col-sm-12 text-center ftco-animate">
					<h1 class="mb-3 mt-5 bread"><s:message code="contact.title" /></h1>
				</div>

			</div>
		</div>
	</div>
</section>

<section class="ftco-section contact-section">
	<div class="container mt-5">
		<div class="row block-9">
			<div class="col-md-6 ftco-animate">
			${message}
				<form action="manage/send.htm" method="post" class="contact-form">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<input type="text"name="from" class="form-control" placeholder="<s:message code="contact.email" />">
							</div>
						</div>
					</div>
					<div class="form-group">
						<input type="text" name="subject" class="form-control" placeholder="<s:message code="contact.subject" />">
					</div>
					<div class="form-group">
						<textarea name="body" id="" cols="30" rows="7" class="form-control"
							placeholder="<s:message code="contact.message" />"></textarea>
					</div>
					<div class="form-group">
						<input type="submit" value="<s:message code="contact.button" />"
							class="btn btn-primary py-3 px-5">
					</div>
				</form>
			</div>
		</div>
	</div>
</section>
