<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>


    <script type="text/javascript">
        $(function(){
            $("#addArticle").linkbutton({
                onClick:function(){
                    $("#artff").form("submit",{
                        url:"${pageContext.request.contextPath}/article/addArticle",
                        /*onSubmit : function(param) {
                            console.log("提交前执行");
                            param.introduction = editor.txt.html();
                            return $("#artff").form("validate");
                        },*/
                        success:function(res){
                            if(res=="success"){
                                $.messager.alert('提示消息','创建成功');
                            } else {
                                $.messager.alert("提示消息","创建失败");
                            }
                        }
                    });
                }
            });


            $("#reBoot").linkbutton({
                onClick:function() {
                    editor.txt.clear();
                },
            })
        })

        $('#pic').filebox({
            buttonText: "选择图片",
            buttonIcon: "icon-note",
            buttonAlign: 'right'
        })

        $('#status').combobox({
            limitToList:true,//设置为true时，输入的值只能是列表框中的内容
            panelHeight:50, //下拉面板高度
        });
    </script>

<form id="artff" method="post" enctype="multipart/form-data" style="background: #a3c4d7;">

    <div style="margin: 0px 30px;">
        <table>
            <tr><td>&nbsp;</td></tr>
            <tr>
                <td style="text-align: right">文章标题：</td>
                <td>
                    <input id="name" class="easyui-textbox" style="width:230px" name="articleName"/>
                </td>
            </tr>
            <tr><td>&nbsp;</td></tr>
            <tr>
                <td style="text-align: right">文章作者：</td>
                <td>
                    <input id="master" class="easyui-textbox" style="width:230px" name="masterID"/>
                </td>
            </tr>
            <tr><td>&nbsp;</td></tr>
            <tr>
                <td style="text-align: right">文章状态：</td>
                <td>
                    <select id="status" class="easyui-combobox" name="articleStatus" style="width:230px;">
                        <option value="上架">上架</option>
                        <option value="下架">下架</option>
                    </select>
                </td>
            </tr>
            <tr><td>&nbsp;</td></tr>
            <tr>
                <td style="text-align: right">文章封面：</td>
                <td>
                    <input id="pic" class="easyui-filebox" style="width:230px" name="myFile" />
                </td>
            </tr>
            <tr><td>&nbsp;</td></tr>
            <tr>
                <td style="text-align: right">文章内容：</td>
                <td></td>
            </tr>
        </table>
    </div>

    <div id="editor" style="margin: 0px 30px;">
        <p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>
    </div>
    <div style="background: #a3c4d7;height: 80px;margin: 0px 30px;">
        <table>
            <tr><td>&nbsp;</td></tr>
            <tr>
                <td><a id="addArticle">创建文章</a></td>
                <td><a id="reBoot">重置内容</a></td>
            </tr>
        </table>
    </div>

</form>


    <!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.min.js"></script>
    <script type="text/javascript">
        var E = window.wangEditor
        var editor = new E('#editor');
        // 或者 var editor = new E( document.getElementById('editor') )
        editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/article/upload';  // 上传图片到服务器
        editor.customConfig.uploadFileName = 'files'; //上传图片的名称
        editor.create()
    </script>



