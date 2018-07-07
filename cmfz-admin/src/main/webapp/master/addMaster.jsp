<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

	<script type="text/javascript">
		$(function(){

			$('#photo').filebox({
				buttonText: "选择文件",
				buttonIcon: "icon-note",
				buttonAlign: 'right'
			})
		});

	</script>

	<br>
	<form id="ff" method="post" style="text-align: center" enctype="multipart/form-data">
		<table style="text-align: right">
			<tr>
				<td>上师法名：</td>
				<td>
					<input id="name" class="easyui-textbox" style="width:230px" name="masterName"/>
				</td>
			</tr>

			<tr>
				<td>上师图片：</td>
				<td>
					<input id="photo" class="easyui-filebox" style="width:230px" name="photo" />
				</td>
			</tr>

			<tr>
				<td>上师简介：</td>
				<td>
					<input id="sum" class="easyui-textbox" style="width:230px" name="masterSummary" />
				</td>
			</tr>

		</table>
	</form>

