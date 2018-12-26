<%@ page import="java.util.ArrayList" %>
<%@ page import="classes.entities.Goods" %>
<%@ page import="classes.helpers.JSONHelper" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/12/22
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StockList</title>

    <script src="js/jquery.min.js"></script>

    <link rel="stylesheet" href="css/global.css" media="all" type="text/css">
    <link rel="stylesheet" href="css/stockList.css" media="all" type="text/css">
</head>



<body onload="generateStock();">
<jsp:include page="header.jsp"/>

<h2>Enjoy your shopping</h2>
<form class="stock"  method="post" action="liquidate">
    <div class="stock-shop">
        <div class="stock-list">
            <h3>Stock List</h3>
            <ul id="stock-ul" class="stock-list-ul" >
                <li class="stock-list-item">
                    <span class="stock-item-id">ID</span>
                    <span class="stock-item-name">Name</span>
                    <span class="stock-item-price">Price</span>
                    <span class="stock-item-kind">Kind</span>
                    <span class="stock-item-num">Num</span>
                    <span class="stock-item-add">Check</span>
                </li>
            </ul>
        </div>
        <div class="shop-list">
            <h3>Shop List</h3>
            <ul id="shop-ul" class="shop-list-ul"></ul>
        </div>
    </div>
    <div class="stock-footer">
        <button type="submit">提交</button>
    </div>
</form>

<jsp:include page="footer.jsp"/>
</body>
<script>
    function generateStock() {
        let stocks = JSON.parse('<%=request.getAttribute("stock_list")%>');
        console.log(stocks.length);
    // <ul class="stock-list-ul">
    //         <li class="stock-list-item">
    //         <span class="stock-item-id">1</span>
    //         <span class="stock-item-name">dsad</span>
    //         <span class="stock-item-price">50</span>
    //         <span class="stock-item-kind">xxx</span>
    //         <span class="stock-item-num">500</span>
    //         <span class="stock-item-add">+</span>
    //         </li>
    // </ul>
        let $ul=$('#stock-ul');
        let i=0;let size=stocks.length;
        for(j=0;j<size;j++){
            let i=j+1;
            let stock=stocks[j];
            let $li=$('<li></li>').prop({
                "id":"stock_li_"+i,
                "class":"stock-list-item"
            });
            let span_id=$('<span></span>').prop({
                "id":"stock_span_id_"+i,
                "class":"stock-item-id"
            }).text(stock.id);
            let span_name=$('<span></span>').prop({
                "id":"stock_span_name_"+i,
                "class":"stock-item-name"
            }).text(stock.name);
            let span_kind=$('<span></span>').prop({
                "id":"stock_span_kind_"+i,
                "class":"stock-item-kind"
            }).text(stock.kind);
            let span_price=$('<span></span>').prop({
                "id":"stock_span_price_"+i,
                "class":"stock-item-price"
            }).text(stock.price);
            let span_num=$('<span></span>').prop({
                "id":"stock_span_num_"+i,
                "class":"stock-item-num"
            }).text(stock.num);
            let span_add=$('<span></span>').prop({
                "id":"stock_span_add_"+i,
                "class":"stock-item-add"
            }).text("+").click(function () {
                let index=$(this).attr("id").substr(15);
                add_shop(index);
                $(this).text('').unbind('click');
            });
            $li.append(span_id,span_name,span_kind,span_price,span_num,span_add);
            $ul.append($li);
        }
    }

    function add_shop(i) {
        // <li class="shop-list-item">
        //     <label for="goods1">eqwe</label>
        //     <input type="text" id="goods1" name="goods1" value="1">
        // </li>
        let $shop_ul=$('#shop-ul');
        let $li=$('<li></li>').prop({
            "id":"shop_li_"+i,
            "class":"shop-list-item"
        });
        let $input=$('<input>').prop({
            "type":"text",
            "id":"shop_goods_"+i,
            "name":"shop_goods_"+i
        }).val(1);
        let $label=$('<label></label>').prop({
            "for":"shop_goods_"+i,
        }).text($('#stock_span_name_'+i).text());
        $li.append($label,$input);
        $shop_ul.append($li);
    }

</script>
</html>
