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
							<th class="column1"><s:message code="sale.id" /></th>
							<th class="column2"><s:message code="sale.proid" /></th>
							<th class="column6" style="width: 50px;"><s:message
									code="sale.action" /></th>
						</tr>
					</thead>
					<tbody>
						<form:form action="manage/searchSale.htm">
							<tr>
								<td class="column1"><input type="text" name="search"
									placeholder="<s:message code="sale.psearch"/>"></td>
								<td></td>
								<td>
									<button class="myButtonG">
										<s:message code="sale.search" />
									</button>
								</td>
							</tr>
						</form:form>
						<form:form action="manage/insertSale.htm" modelAttribute="sale">
							<tr>
								<td class="column1"></td>
								<td><form:select path="product.id" items="${products}"
										itemValue="id" itemLabel="name" /></td>
								<td>
									<button class="myButtonG">
										<s:message code="sale.add" />
									</button>
								</td>
							</tr>
						</form:form>
						<c:forEach var="u" items="${sales}">
							<form:form action="manage/editSale.htm" modelAttribute="sale"
								method="POST">
								<tr>
									<td class="column1">${u.id}</td>
									<td class="column1"><form:select path="product.id">
											<c:forEach items="${products}" var="product">
												<option
													<c:if test="${product.name eq u.product.name}">selected="selected"</c:if>
													value="${product.id}">${product.name}</option>
											</c:forEach>
										</form:select></td>
									<td class="column6"><form:hidden path="id" value="${u.id}" />
									<form:hidden path="id" value="${u.date}" />
										<button class="myButtonY">
											<s:message code="sale.edit" />	
										</button>
							</form:form>
							<form:form action="manage/deleteSale.htm" modelAttribute="sale"
								method="POST">
								<form:hidden path="id" value="${u.id}" />
								<form:hidden path="id" value="${u.product.id}" />
								<form:hidden path="id" value="${u.date}" />
								<button class="myButton">
									<s:message code="sale.delete" />
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