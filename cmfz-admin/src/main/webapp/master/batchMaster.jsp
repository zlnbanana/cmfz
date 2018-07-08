<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

	<script type="text/javascript">
		$(function(){

			$('#batch').filebox({
				buttonText: "选择Excel文件",
				buttonIcon: "icon-note",
				buttonAlign: 'right'
			})
		});

	</script>

	<br>
	<form id="masff" method="post" style="text-align: center" enctype="multipart/form-data">
		<table style="text-align: right">
			<tr>
				<td>多个上师信息：</td>
				<td>
					<input id="batch" class="easyui-filebox" style="width:230px" name="excel" />
				</td>
			</tr>
		</table>
	</form>

