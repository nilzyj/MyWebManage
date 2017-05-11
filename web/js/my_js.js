/**
 * Created by dim on 2017/4/7.
 */
$(document).ready(function () {
    $("#logoff").click(function () {
        window.location.href = "login.jsp";
    })
});

//exam修改点击函数
$(document).ready(function () {
    $("#exam_tbody").find("tr").mouseenter(function () {

        //获取表格中的一行数据
        var row = this.rowIndex;
        $("#exam_tbody").find("a").click(function () {
            var title = document.getElementById("table").rows[row].cells[0].innerText;
            var examTime = document.getElementById("table").rows[row].cells[1].innerText;
            var examAddr = document.getElementById("table").rows[row].cells[2].innerText;
            //向模态框中传值
            $("#myModalLabel").text("考试信息修改：" + title);
            $("#examTime").val(examTime);
            $("#examAddr").val(examAddr);
            $("#modal-container-325223").modal("show");
        })
    })
});

//exam提交更改
$(document).ready(function () {
    $("#updateExamInfo").click(function () {
        //获取模态框数据
        var examName = $("#myModalLabel").text().substr(7,2);
        var examAddr = $("#examAddr").val();
        var examTime = $("#examTime").val();
        $.ajax({
                type: "post",
                url: "ModifyExamInfoServlet",
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
    })
});

//proctor修改点击函数
$(document).ready(function () {
    $("#proctor_tbody").find("tr").mouseenter(function () {
        //获取表格中的一行数据
        var row = this.rowIndex;
        $("#proctor_tbody").find("a").click(function () {
            var proctorName = document.getElementById("table").rows[row].cells[1].innerText;
            var examInfo = document.getElementById("table").rows[row].cells[2].innerText;
            //向模态框中传值
            $("#proctorName").val(proctorName);
            $("#examInfo").val(examInfo);
            $("#modal-container-325224").modal("show");
        })
    })
});

//proctor修改提交
$(document).ready(function () {
    $("#updateExamInfo").click(function () {
        //获取模态框数据
        var proctorName = $("#proctorName").val();
        var examInfo = $("#examInfo").val();
        $.ajax({
            type: "post",
            url: "ModifyProctorServlet",
            data: "proctorName=" + proctorName+ "&examInfo=" + examInfo,
            dataType: "text",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            beforeSend:function(xhr){
                // alert(xhr);
            },
            success: function (result) {
                location.reload();
            }
        })
    })
});
