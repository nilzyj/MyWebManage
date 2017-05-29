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
            beforeSend: function (xhr) {
                // alert(xhr);
            },
            success: function (result) {
                $("body").html(result)
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
            beforeSend: function (xhr) {
                // alert(xhr);
            },
            success: function (result) {
                $("body").html(result)
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
            beforeSend: function (xhr) {
                // alert(xhr);
            },
            success: function (result) {
                $("body").html(result)
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
            beforeSend: function (xhr) {
                // alert(xhr);
            },
            success: function (result) {
                $("body").html(result)
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
            beforeSend: function (xhr) {
                // alert(xhr);
            },
            success: function (result) {
                $("body").html(result)
            }
        })
    });

    //违规行为修改按钮
    $("#invalid_tbody").on('click', '.invalid_modify', function () {
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
            beforeSend: function (xhr) {
                // alert(xhr);
            },
            success: function (result) {
                $("body").html(result)
            }
        })
    });

    //能否参加考试RdaioButton响应
    $("#invalid_tbody").on('click', '.optionsRadios1', function () {
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
            beforeSend: function (xhr) {

            },
            success: function (result) {
                $("body").html(result)
            }
        })
    });

    $("#invalid_tbody").on('click', '.optionsRadios2', function () {
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
            beforeSend: function (xhr) {

            },
            success: function (result) {
                $("body").html(result)
            }
        })
    });

    $("#student_info_tbody").on('click', '.showStudentInfo', function () {
        var $this = $(this),
            $tr = $($this.parents('tr')[0]),
            $id = $($tr.find('td')[0]),
            student_info_id = $id.text();
        $.ajax({
            type: "post",
            url: "ShowStudentInfoServlet",
            data: "student_info_id=" + student_info_id,
            dataType: "text",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success: function (result) {
                $(".modal-body").html(result)
                $("#modal-container-stu-info").modal("show")
            }
        })
    });

    $("#student_info_tbody").on('click', '.modifyStudentInfo', function () {
        var $this = $(this),
            $tr = $($this.parents('tr')[0]),
            $id = $($tr.find('td')[0]),
            student_info_id = $id.text();
        $.ajax({
            type: "post",
            url: "ModifyStudentInfoServlet",
            data: "student_info_id=" + student_info_id,
            dataType: "text",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success: function (result) {
                $(".modal-body").html(result)
                $("#modal-container-stu-info").modal("show")
            }
        })
    });
    // $('#pagination').on('click', '[data-page]', function () {
    //     var $this = $(this),
    //         pageNum = $this.data('page'),
    //         $tbody = $('#student_info_tbody'),
    //         begin = parseInt(pageNum - 1) * 6;
    //     $tbody.html("");
    //     for (var index = begin; index < begin + 5 || index < NUMBER; index++) {
    //         $tr = $('<tr />');
    //         $('<td />').text(DATALIST[index].ID).appendTo($tr);
    //         $('<td />').text(DATALIST[index].year).appendTo($tr);
    //         $('<td />').text(DATALIST[index].name).appendTo($tr);
    //         $('<td />').text(DATALIST[index].baokaodian).appendTo($tr);
    //         $('<td />').text(DATALIST[index].baokaohao).appendTo($tr);
    //         $('<td />').append($('<a />').attr({
    //             'href': 'javascript:;',
    //             'role': 'button',
    //             'class': 'btn showStudentInfo'
    //         }).text('查看')).appendTo($tr);
    //         $tbody.append($tr);
    //     }
    //
    //
    // })

    $('#pagination').on('click', '[data-page]', function () {
        var $this = $(this),
            pageNum = $this.data('page');
        $.ajax({
            type: "post",
            url: "GetStudentInfoServlet",
            data: "pageNum=" + pageNum,
            dataType: "text",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success: function (result) {
                $("body").html(result)
            }
        })
    })
});




