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
							<th class="column1"><s:message code="user.usn" /></th>
							<th class="column2"><s:message code="user.pass" /></th>
							<th class="column2"><s:message code="user.fname" /></th>
							<th class="column6" style="width: 50px;"><s:message
									code="user.action" /></th>
						</tr>
					</thead>
					<tbody>
						<form:form action="manage/search.htm">
							<tr>
								<td class="column1"><input type="text" name="search"
									placeholder="<s:message code="user.psearch"/>"></td>
								<td></td>
								<td></td>
								<td>
									<button class="myButtonG">
										<s:message code="user.search" />
									</button>
								</td>
							</tr>
						</form:form>
						<form:form action="manage/insert.htm" modelAttribute="user"
							method="POST">
							<tr>
								<td class="column1"><form:input path="username" /></td>
								<td class="column1"><form:input path="password" /></td>
								<td class="column1"><form:input path="fullname" /></td>
								<td>
									<button class="myButtonG">
										<s:message code="user.add" />
									</button> ${messageI}
								</td>
							</tr>
						</form:form>

						<c:forEach var="u" items="${users}">
						<form:form action="manage/edit.htm"
										method="POST">
							<tr>
								<td class="column1"><input value="${u.username}"
									name="username"></td>
								<td class="column1"><input value="${u.password}"
									name="password"></td>
								<td><input value="${u.fullname}" name="fullname"></td>
								<td class="column6">
										<button class="myButtonY">
											<s:message code="user.edit" />
										</button>
									</form:form> <form:form action="manage/delete.htm" modelAttribute="user"
										method="POST">
										<form:hidden path="username" value="${u.username}" />
										<form:hidden path="password" value="${u.password}" />
										<form:hidden path="fullname" value="${u.fullname}" />
										<button class="myButton">
											<s:message code="user.delete" />
										</button>
									</form:form></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</div>