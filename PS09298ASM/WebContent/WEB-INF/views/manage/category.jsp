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
							<th class="column1"><s:message code="category.id" /></th>
							<th class="column2"><s:message code="category.name" /></th>
							<th class="column6"><s:message code="category.action" /></th>
						</tr>
					</thead>
					<tbody>
					<form:form action="manage/searchCat.htm">
						<tr>
							<td class="column1"></td>
							<td><input type="text"
								placeholder="Search..." name="search"></td>
							<td style="width: 50px;">
								<button class="myButtonG"><s:message code="category.search" /></button>
							</td>
						</tr>
						</form:form>
						<form:form action="manage/insertCat.htm" modelAttribute="category"
							method="POST">
						<tr>
							<td class="column1"></td>
							<td><form:input path="name" /><form:errors path="name"/></td>
							<td>
								<button class="myButtonG"><s:message code="category.add" /></button>
							</td>
						</tr>
						</form:form>
						<c:forEach var="u" items="${categories}">
						<form:form action="manage/editCat.htm"
										method="POST" modelAttribute="category">
						<tr>
							<td class="column1">${u.id}</td>
							<td><input value="${u.name}"
									name="name"></td>
									
							<td class="column6">
							<form:hidden path="id" value="${u.id}" />
								<button class="myButtonY"><s:message code="category.edit" /></button>
								</form:form> <form:form action="manage/deleteCat.htm" modelAttribute="category"
										method="POST">
										<form:hidden path="id" value="${u.id}" />
										<form:hidden path="name" value="${u.name}" />
								<button class="myButton"><s:message code="category.delete" /></button>
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