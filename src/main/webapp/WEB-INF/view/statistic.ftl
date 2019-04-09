<#include "main.ftl"/>
<@main title="Статистика"/>
<#macro content>
<br>

<div class="card">
    <h6 class="card-header">Статистика </h6>
    <div class="card-body">
    <#--<link rel="stylesheet" href="http://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css" />-->
        <link type="text/css" rel="StyleSheet" href="http://bootstraptema.ru/plugins/2016/shieldui/style.css" />
    <#--<script src="http://bootstraptema.ru/plugins/jquery/jquery-1.11.3.min.js"></script>-->
        <script src="http://bootstraptema.ru/plugins/2016/shieldui/script.js"></script>

        <br>
        <div class="container">
            <form method="get" action="/statistic">
                Статистика за
            <select class="custom-select custom-select col-md-1" type="text" name="date" id="yearpicker">
                <#list years as year>
                <#if yearNow == year>
                    <option value="#{year}" selected>#{year}</option>
                <#else ><option value="#{year}">#{year}</option>
                </#if>
                </#list>
            </select>год
                <button type="submit" class="btn btn-outline-primary btn-sm">показать</button>
            </form>

            <#--<script>-->
                <#--var startYear = 2017;-->
                <#--var y = ${yearNow};-->
                <#--for (i = new Date().getFullYear(); i > startYear; i--)-->
                <#--{-->
                    <#--if (i==y){-->
                        <#--$('#yearpicker').append($('<option selected/>').val(i).html(i));-->
                <#--}else {-->
                        <#--$('#yearpicker').append($('<option />').val(i).html(i));-->
                    <#--}-->
                <#--}-->
                <#--&lt;#&ndash;<#if yearNow?has_content>$('#yearpicker').append($('<option selected/>').html(${yearNow}));</#if>&ndash;&gt;-->
            <#--</script>-->

                <div class="col-md-8 col-md-offset-2">

                    <!-- График --><div id="chart">

                    <script>
                        var arr = [];
                            <#list mountCount as m>
                            arr.push(#{m});
                            </#list>

                        $(document).ready(function () {
                            $("#chart").shieldChart({
                                theme: "bootstrap",
                                primaryHeader: {
                                    text: "Количество выданных книг"
                                },
                                seriesSettings: {
                                    area: {
                                        pointMark: {
                                            enabled: true
                                        }
                                    }
                                },
                                axisX: {
                                    categoricalValues: ["Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"]
                                },
                                dataSeries: [{
                                    seriesType: "area",
                                    collectionAlias: "Количество",
//                                    data: [48, 50, 55, 64, 73, 79, 82, 83, 80, 70,76, 50 ]
                                    data: arr
                                }],
                                events: {
                                    legendSeriesClick: function (e) {
                                        // остановить событие щелчка элемента серии, так что
                                        // пользователь нажимает не переключить видимость серии
                                        e.preventDefault();
                                    }
                                }
                            });
                        });
                    </script><!-- /.График -->
                </div>
            </div>
        </div>
    </div>
</div>

</#macro>
<#macro contentLeft>
<br>

<ul class="list-group">
    <li class="list-group-item list-group-item-secondary">Информация:</li>
        <li class="list-group-item">Статистика выданных книг отображается за текущий год </li>
</ul>
</#macro>