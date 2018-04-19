/**
 * 天气预报页面下拉框事件.
 * author: yangbin
 **/
$(function () {
    $("#select-city-id").change(function () {
        var cityId = $("#select-city-id").val();
        var url = '/report/' + cityId;
        window.location.href = url;
    })
});