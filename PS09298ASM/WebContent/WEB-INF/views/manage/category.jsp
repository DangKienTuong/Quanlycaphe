<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
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
						<tr>
							<td class="column1"><input type="text"
								placeholder="Search..."></td>
							<td></td>
							<td style="width: 50px;">
								<button class="myButtonG"><s:message code="category.search" /></button>
							</td>
						</tr>
						<tr>
							<td class="column1"><input type="text" placeholder="Add..."></td>
							<td><input type="text" placeholder=""></td>
							<td>
								<button class="myButtonG"><s:message code="category.add" /></button>
							</td>
						</tr>
						<tr>
							<td class="column1">1</td>
							<td class="column1">Ca phe</td>
							<td class="column6">
								<button class="myButtonY"><s:message code="category.edit" /></button>
								<button class="myButton"><s:message code="category.delete" /></button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>