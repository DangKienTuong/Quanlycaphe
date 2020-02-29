<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
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
							<th class="column6" style="width: 50px;"><s:message code="user.action" /></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="column1"><input type="text"
								placeholder="<s:message code="user.psearch" />"></td>
							<td></td>
							<td></td>
							<td>
								<button class="myButtonG"><s:message code="user.search" /></button>
							</td>
						</tr>
						<tr>
							<td class="column1"><input type="text" placeholder="<s:message code="user.padd" />"></td>
							<td><input type="text" placeholder=""></td>
							<td><input type="text"></td>
							<td>
								<button class="myButtonG"><s:message code="user.add" /></button>
							</td>
						</tr>
						<tr>
							<td class="column1">Tuongngaotang</td>
							<td class="column1">123</td>
							<td>Đặng Kiến Tường</td>
							<td class="column6">
								<button class="myButtonY"><s:message code="user.edit" /></button>
								<button class="myButton"><s:message code="user.delete" /></button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>