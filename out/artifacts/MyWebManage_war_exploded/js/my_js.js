/**
 * Created by dim on 2017/4/7.
 */
$(document).ready(function () {

    $("#logoff").click(function () {
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
            + "&invalid_action=" + $("#invalid_action_add").val()
            + "&invalid_action_id=" + $("#invalid_action_id_add").val(),
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


var str = [{
    "2016": "{\"name\": \"张殷杰\", \"minzu\": \"汉族\", \"hunfou\": \"否\", \"xingbie\": \"男\", \"username\": \"zyj\", \"waiguoyu\": \"英语\", \"yewukeer\": \"数据库\", \"yewukeyi\": \"网络\", \"baokaodian\": \"哈尔滨工业大学（威海）\", \"chushengdi\": \"上海市上海市崇明县\", \"biyexuexiao\": \"哈尔滨工业大学\", \"biyezhuanye\": \"计算机\", \"zhucexuehao\": \"130410229\", \"zuihouxueli\": \"本科结业\", \"baokaodanwei\": \"哈尔滨工业大学\", \"baokaoleibie\": \"非定向\", \"baokaoyuanxi\": \"计算机\", \"xianyijunren\": \"非军人\", \"zuihouxuewei\": \"学士学位\", \"baokaozhuanye\": \"计算机科学与技术\", \"gudingdianhua\": \"46944696349\", \"hukousuozaidi\": \"上海市上海市长宁区\", \"kaoshifangshi\": \"全国统考\", \"yidongdianhua\": \"49349434933\", \"zhengzhililun\": \"政治\", \"beiyongxinxier\": \"\", \"beiyongxinxiyi\": \"\", \"dianziyouxiang\": \"\", \"jiguansuozaidi\": \"天津市天津市\", \"zhengjianhaoma\": \"341122199606060037\", \"kaoshenglaiyuan\": \"普通全日制应届本科毕业生\", \"yanjiufangxiang\": \"计算机\", \"zhengzhimianmao\": \"群众\", \"zhuanxiangjihua\": \"无\", \"zhengjianleixing\": \"居民身份证\", \"biyezhengshubianhao\": \"353828535255225555\", \"dingxiangjiuyedanwei\": \"\", \"kaoshengtongxundizhi\": \"上海市上海市宝山区\", \"xuexiyugongzuojingli\": \"无无\", \"xueweizhengshubianhao\": \"\", \"jiatingzhuyaochengyuan\": \"无无\", \"kaoshengdangansuozaidi\": \"哈工大威海\", \"kaoshengzuobiqingkuang\": \"无无\", \"baokaodiansuozaishengshi\": \"山东省威海市\", \"hukousuozaidixiangxidizhi\": \"\", \"huodezuihouxuelibiyenianyue\": \"2017.7.1\", \"dingxiangjiuyedanweisuozaidi\": \"\", \"xianzaixuexihuogongzuodanwei\": \"无无\", \"qudezuihouxuelidexuexixingshi\": \"普通全日制\", \"kaoshengdangansuozaidanweidizhi\": \"上海市上海市宝山区\", \"kaoshengtongxundizhiyouzhengbianma\": \"283838\", \"kaoshengdangansuozaidanweiyouzhengbianma\": \"283926\", \"heshihediheyuanyinshouguohezhongjianglihuochufen\": \"无无\"}",
    "2015": "{\"name\": \"张殷杰\", \"minzu\": \"汉族\", \"hunfou\": \"否\", \"xingbie\": \"男\", \"username\": \"zyj\", \"waiguoyu\": \"英语\", \"yewukeer\": \"数据库\", \"yewukeyi\": \"网络\", \"baokaodian\": \"哈尔滨工业大学（威海）\", \"chushengdi\": \"上海市上海市崇明县\", \"biyexuexiao\": \"哈尔滨工业大学\", \"biyezhuanye\": \"计算机\", \"zhucexuehao\": \"130410229\", \"zuihouxueli\": \"本科结业\", \"baokaodanwei\": \"哈尔滨工业大学\", \"baokaoleibie\": \"非定向\", \"baokaoyuanxi\": \"计算机\", \"xianyijunren\": \"非军人\", \"zuihouxuewei\": \"学士学位\", \"baokaozhuanye\": \"计算机科学与技术\", \"gudingdianhua\": \"46944696349\", \"hukousuozaidi\": \"上海市上海市长宁区\", \"kaoshifangshi\": \"全国统考\", \"yidongdianhua\": \"49349434933\", \"zhengzhililun\": \"政治\", \"beiyongxinxier\": \"\", \"beiyongxinxiyi\": \"\", \"dianziyouxiang\": \"\", \"jiguansuozaidi\": \"天津市天津市\", \"zhengjianhaoma\": \"341122199606060037\", \"kaoshenglaiyuan\": \"普通全日制应届本科毕业生\", \"yanjiufangxiang\": \"计算机\", \"zhengzhimianmao\": \"群众\", \"zhuanxiangjihua\": \"无\", \"zhengjianleixing\": \"居民身份证\", \"biyezhengshubianhao\": \"353828535255225555\", \"dingxiangjiuyedanwei\": \"\", \"kaoshengtongxundizhi\": \"上海市上海市宝山区\", \"xuexiyugongzuojingli\": \"无无\", \"xueweizhengshubianhao\": \"\", \"jiatingzhuyaochengyuan\": \"无无\", \"kaoshengdangansuozaidi\": \"哈工大威海\", \"kaoshengzuobiqingkuang\": \"无无\", \"baokaodiansuozaishengshi\": \"山东省威海市\", \"hukousuozaidixiangxidizhi\": \"\", \"huodezuihouxuelibiyenianyue\": \"2017.7.1\", \"dingxiangjiuyedanweisuozaidi\": \"\", \"xianzaixuexihuogongzuodanwei\": \"无无\", \"qudezuihouxuelidexuexixingshi\": \"普通全日制\", \"kaoshengdangansuozaidanweidizhi\": \"上海市上海市宝山区\", \"kaoshengtongxundizhiyouzhengbianma\": \"283838\", \"kaoshengdangansuozaidanweiyouzhengbianma\": \"283926\", \"heshihediheyuanyinshouguohezhongjianglihuochufen\": \"无无\"}"
}]
