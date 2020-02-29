<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
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
						<tr>
							<td class="column1"><input type="text"
								placeholder="Search..."></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td style="width: 350px;">
								<button class="myButtonG"><s:message code="product.search" /></button>
							</td>
						</tr>
						<tr>
							<td class="column1"><input type="text" placeholder="Add..."></td>
							<td><input type="text" placeholder=""></td>
							<td><input type="text" placeholder=""></td>
							<td><button class="myButtonY"><s:message code="product.upload" /></button></td>
							<td><input type="text" placeholder=""></td>
							<td><input type="text" placeholder=""></td>
							<td>
								<button class="myButtonG"><s:message code="product.add" /></button>
							</td>
						</tr>
						<tr>
							<td class="column1">1</td>
							<td class="column2">Ca phe da</td>
							<td class="column3">1</td>
							<td class="column4"><button class="myButtonY"><s:message code="product.upload" /></button></td>
							<td class="column5">14000</td>
							<td class="column6">Esspresso duong</td>
							<td class="column6">
								<button class="myButtonY"><s:message code="product.edit" /></button>
								<button class="myButton"><s:message code="product.delete" /></button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>