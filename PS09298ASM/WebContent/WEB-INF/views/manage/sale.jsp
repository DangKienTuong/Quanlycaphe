<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="limiter">
	<div class="container-table100">
		<div class="wrap-table100">
			<div class="table100">
				<table>
					<thead>
						<tr class="table100-head">
							<th class="column1"><s:message code="sale.id" /></th>
							<th class="column2"><s:message code="sale.proid" /></th>
							<th class="column2"><s:message code="sale.date" /></th>
							<th class="column6" style="width: 50px;"><s:message code="sale.action" /></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="column1"><input type="text"
								placeholder="<s:message code="sale.psearch" />"></td>
							<td></td>
							<td></td>
							<td>
								<button class="myButtonG"><s:message code="sale.search" /></button>
							</td>
						</tr>
						<tr>
							<td class="column1"><input type="text" placeholder="<s:message code="sale.padd" />"></td>
							<td><input type="text" placeholder=""></td>
							<td><input type="date" name="birthday"></td>
							<td>
								<button class="myButtonG"><s:message code="sale.add" /></button>
							</td>
						</tr>
						<tr>
							<td class="column1">1</td>
							<td class="column1">1</td>
							<td><input type="date" name="birthday" value="2020-02-12"></td>
							<td class="column6">
								<button class="myButtonY"><s:message code="sale.edit" /></button>
								<button class="myButton"><s:message code="sale.delete" /></button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>