/**
 * Created by dim on 2017/4/7.
 */
$(document).ready(function () {

    $("#logoff").click(function () {
        alert("logoff");
        window.location.href = "login.jsp";
    });

    //根据不同条件查询考生
    $("#searchStuBtn").click(function () {
        //获取查询内容
        var year = $("#searchStuYear").val();
        var name = $("#searchStuName").val();
        var baokaodian = $("#searchBaokaodian").val();
        var baokaohao = $("#searchBaokaohao").val();
        $.ajax({
            type: "post",
            url: "SearchStudentServlet",
            data: "year=" + year
            + "&name=" + name
            + "&baokaodian=" + baokaodian
            + "&baokaohao=" + baokaohao,
            dataType: "text",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            beforeSend:function(xhr){
                // alert(xhr);
            },
            success: function (result) {
                location.reload();
            }
        })
    });

    //根据不同条件查询违规考生
    $("#searchInvalidBtn").click(function () {
        //获取查询内容
        var year = $("#searchInvalidYear").val();
        var name = $("#searchInvalidName").val();
        var invalidAction = $("#searchInvalidAction").val();
        $.ajax({
            type: "post",
            url: "SearchInvalidActionServlet",
            data: "year=" + year
            + "&name=" + name
            + "&invalidAction=" + invalidAction,
            dataType: "text",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            beforeSend:function(xhr){
                // alert(xhr);
            },
            success: function (result) {
                location.reload();
            }
        })
    });

    $("#clearInvalidBtn").click(function () {
        $("#searchInvalidYear").val("");
        $("#searchInvalidName").val("");
        $("#searchAction").val("");
    });

    $("#clearStuBtn").click(function () {
        $("#searchStuYear").val("");
        $("#searchStuName").val("");
        $("#searchBaokaodian").val("");
        $("#searchBaokaohao").val("");
    });

    //考生信息查看和修改界面返回按钮
    $("#back").click(function () {
        history.go(-1);
    });

    //开启报考系统
    $("#systemOn").click(function () {
        $.ajax({
            type: "post",
            url: "ManageBaokaoServlet",
            data: "state=on",
            dataType: "text",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            beforeSend:function(xhr){
                // alert(xhr);
            },
            success: function (result) {
                location.reload();
            }
        })
    });

    //关闭报考系统
    $("#systemOff").click(function () {
        $.ajax({
            type: "post",
            url: "ManageBaokaoServlet",
            data: "state=off",
            dataType: "text",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            beforeSend:function(xhr){
                // alert(xhr);
            },
            success: function (result) {
                location.reload();
            }
        })
    });

    //违规行为添加按钮
    $("#invalid_action_add_submit").click(function () {
        $.ajax({
            type: "post",
            url: "AddInvalidActionServlet",
            data: "invalid_action_name=" + $("#invalid_action_name_add").val()
            + "&invalid_action=" + $("#invalid_action_add").val(),
            dataType: "text",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            beforeSend:function(xhr){
                // alert(xhr);
            },
            success: function (result) {
                location.reload();
            }
        })
    });

    //违规行为修改按钮
    $("#invalid_tbody").on('click', '.invalid_modify', function() {
        var $this = $(this),
            $tr = $($this.parents('tr')[0]),
            $action = $($tr.find('td')[3]),
            $if_can_exam = $($tr.find('td')[4]),
            invalid_action = $action.text(),
            invalid_if_can_exam = $if_can_exam.text();
        $("#invalid_action").val(invalid_action);
        $("#invalid_if_can_exam").val(invalid_if_can_exam);
    });

    //违规行为修改提交
    $("#btnModifyInvalidAction").click(function () {
        //获取模态框数据
        var invalid_action = $("#invalid_action").val();
        var invalid_if_can_exam = $("#invalid_if_can_exam").val();
        $.ajax({
            type: "post",
            url: "ModifyInvalidActionInfoServlet",
            data: "examName=" + examName + "&examAddr=" + examAddr + "&examTime=" + examTime,
            dataType: "text",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            beforeSend:function(xhr){
                // alert(xhr);
            },
            success: function (result) {
                location.reload();
            }
        })
    });

    //能否参加考试RdaioButton响应
    $("#invalid_tbody").on('click', '.optionsRadios1', function() {
        var $this = $(this),
            $tr = $($this.parents('tr')[0]),
            $invalid_action_id = $($tr.find('td')[0]),
            optionsRadios = $invalid_action_id.text();

        $.ajax({
            type: "post",
            url: "ModifyIfCanExamServlet",
            data: "optionsRadios=" + optionsRadios + "&ifCan=yes",
            dataType: "text",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            beforeSend:function (xhr) {

            },
            success: function (result) {
                // location.reload();
            }
        })
    });

    $("#invalid_tbody").on('click', '.optionsRadios2', function() {
        var $this = $(this),
            $tr = $($this.parents('tr')[0]),
            $invalid_action_id = $($tr.find('td')[0]),
            optionsRadios = $invalid_action_id.text();
        $.ajax({
            type: "post",
            url: "ModifyIfCanExamServlet",
            data: "optionsRadios=" + optionsRadios + "&ifCan=no",
            dataType: "text",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            beforeSend:function (xhr) {

            },
            success: function (result) {
                // location.reload();
            }
        })
    });

    $("#student_info_tbody").on('click', '.showStudentInfo', function() {
        alert("sd")
        var $this = $(this),
            $tr = $($this.parents('tr')[0]),
            $id = $($tr.find('td')[0]),
            student_info_id = $id.text();
        alert(student_info_id)
        $.ajax({
            type: "post",
            url: "ShowStudentInfoServlet",
            data: "student_info_id=" + student_info_id,
            dataType: "text",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            beforeSend:function (xhr) {

            },
            success: function (result) {
                location.reload();
            }
        })
    });

    // //exam修改点击函数
    // $("#exam_tbody").find("tr").mouseenter(function () {
    //
    //     //获取表格中的一行数据
    //     var row = this.rowIndex;
    //     $("#exam_tbody").find("a").click(function () {
    //         var title = document.getElementById("table").rows[row].cells[0].innerText;
    //         var examTime = document.getElementById("table").rows[row].cells[1].innerText;
    //         var examAddr = document.getElementById("table").rows[row].cells[2].innerText;
    //         //向模态框中传值
    //         $("#myModalLabel").text("考试信息修改：" + title);
    //         $("#examTime").val(examTime);
    //         $("#examAddr").val(examAddr);
    //         $("#modal-container-325223").modal("show");
    //     })
    // });
    //
    // //exam提交更改
    // $("#updateExamInfo").click(function () {
    //     //获取模态框数据
    //     var examName = $("#myModalLabel").text().substr(7,2);
    //     var examAddr = $("#examAddr").val();
    //     var examTime = $("#examTime").val();
    //     $.ajax({
    //         type: "post",
    //         url: "ModifyExamInfoServlet",
    //         data: "examName=" + examName + "&examAddr=" + examAddr + "&examTime=" + examTime,
    //         dataType: "text",
    //         contentType: "application/x-www-form-urlencoded; charset=utf-8",
    //         beforeSend:function(xhr){
    //             // alert(xhr);
    //         },
    //         success: function (result) {
    //             location.reload();
    //         }
    //     })
    // });
    //
    // //proctor修改点击函数
    // $("#proctor_tbody").find("tr").mouseenter(function () {
    //     //获取表格中的一行数据
    //     var row = this.rowIndex;
    //     $("#proctor_tbody").find("a").click(function () {
    //         var proctorName = document.getElementById("table").rows[row].cells[1].innerText;
    //         var examInfo = document.getElementById("table").rows[row].cells[2].innerText;
    //         //向模态框中传值
    //         $("#proctorName").val(proctorName);
    //         $("#examInfo").val(examInfo);
    //         $("#modal-container-325224").modal("show");
    //     })
    // });
    //
    // //proctor修改提交
    // $("#updateExamInfo").click(function () {
    //     //获取模态框数据
    //     var proctorName = $("#proctorName").val();
    //     var examInfo = $("#examInfo").val();
    //     $.ajax({
    //         type: "post",
    //         url: "ModifyProctorServlet",
    //         data: "proctorName=" + proctorName + "&examInfo=" + examInfo,
    //         dataType: "text",
    //         contentType: "application/x-www-form-urlencoded; charset=utf-8",
    //         beforeSend:function(xhr){
    //             // alert(xhr);
    //         },
    //         success: function (result) {
    //             location.reload();
    //         }
    //     })
    // });

});




