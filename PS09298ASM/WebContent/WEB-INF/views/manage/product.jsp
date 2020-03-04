<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="limiter">
	<div class="container-table100">
		<div class="wrap-table100">
			<div class="table100">
				<table>
					<thead>
						<tr class="table100-head">
							<th class="column1"><s:message code="product.id" /></th>
							<th class="column2"><s:message code="product.name" /></th>
							<th class="column3"><s:message code="product.catid" /></th>
							<th class="column4"><s:message code="product.photo" /></th>
							<th class="column5"><s:message code="product.price" /></th>
							<th class="column6"><s:message code="product.describe" /></th>
							<th class="column6"><s:message code="product.action" /></th>
						</tr>
					</thead>
					<tbody>
						<form:form action="manage/searchPro.htm">
							<tr>
								<td class="column1"></td>
								<td><input type="text" name="search"
									placeholder="Search..."></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td style="width: 350px;">
									<button class="myButtonG">
										<s:message code="product.search" />
									</button>
								</td>
							</tr>
						</form:form>
						<form action="manage/insertPro.htm" method="post" enctype="multipart/form-data">
							<tr>
								<td class="column1">Add...</td>
								<td><input name="name" /></td>
								<td><select name="categoryid">
											<c:forEach items="${categories}" var="category">
												<option
													value="${category.id}">${category.name}</option>
											</c:forEach>
										</select></td>
								<td><input type="file" name="photo" /></td>
								<td><input name="price" /></td>
								<td><textarea name="describe" /></textarea></td>
								<td>
									<button class="myButtonG">
										<s:message code="product.add" />
									</button>
								</td>
							</tr>
							</form>
						<c:forEach var="u" items="${products}">
							<form:form action="manage/editPro.htm" modelAttribute="product"
								method="POST">
								<tr>
									<td class="column1">${u.id}</td>
									<td class="column2"><input value="${u.name}" name="name"></td>
									<td class="column3"><form:select path="category.id">
											<c:forEach items="${categories}" var="category">
												<option
													<c:if test="${category.name eq u.category.name}">selected="selected"</c:if>
													value="${category.id}">${category.name}</option>
											</c:forEach>
										</form:select></td>
									<td class="column4"><img src="files/${photo_name}"
										width="30px" height="40px">
										<button class="myButtonY">
											<s:message code="product.upload" />
										</button></td>
									<td class="column5"><input value="${u.price}" name="price"></td>
									<td class="column6"><textarea rows="3" cols="30"
											name="describe">${u.describe}</textarea></td>
									<td class="column6"><form:hidden path="id" value="${u.id}" />
										<button class="myButtonY">
											<s:message code="product.edit" />
										</button>
							</form:form>
							<form:form action="manage/deletePro.htm" modelAttribute="product"
								method="POST">
								<form:hidden path="id" value="${u.id}" />
								<form:hidden path="name" value="${u.name}" />
								<form:hidden path="category.id" value="${u.category.id}" />
								<form:hidden path="photo" value="${u.photo}" />
								<form:hidden path="price" value="${u.price}" />
								<form:hidden path="describe" value="${u.describe}" />
								<button class="myButton">
									<s:message code="product.delete" />
								</button>
							</form:form>
							</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>