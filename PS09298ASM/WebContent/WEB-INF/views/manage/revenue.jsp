<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="limiter">
	<div class="container-table100">
		<div class="wrap-table100">
			<div class="table100">
				<table>
					<thead>
						<tr class="table100-head">
							<th class="column2"><s:message code="revenue.name" /></th>
							<th class="column1"><s:message code="revenue.my" /></th>
							<th class="column2"><s:message code="revenue.re" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="a" items="${arrays}">
							<tr>
								<td class="column1">${a[0]}</td>
								<td class="column1">${a[1]}</td>
								<td class="column1">${a[2]}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>