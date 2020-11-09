(function(exports) {

    $(function () {
        // 已经登录
       // alert(window.sessionStorage.getItem("userId"));
        if(window.sessionStorage.getItem("userId")!=="null" && window.sessionStorage.getItem("userId")!==null ){
            $("#loginName").text(window.sessionStorage.getItem("userName"));
            document.getElementById("noLogin").style.display="none";
            document.getElementById("hasLogin").style.display="block";
            // 计算购物车中的数量
            $.ajax({
                type:"post",
                url:"car/countUserCar",
                data : {
                    userId : window.sessionStorage.getItem("userId")
                },
                datatype: "json",
                error: function(){
                    //请求出错处理
                    alert("出错了，请与管理员联系");
                },
                success:function(result){
                    $("#carNumber").text("购物车（"+result+"）");
                }
            });
        }else{
            document.getElementById("noLogin").style.display="block";
            document.getElementById("hasLogin").style.display="none";
        }
    });

    // 横幅跳转到个人中心
    $("#center-nav").click(function(){
        if(window.sessionStorage.getItem("userId")!=="null"){
            window.location.href = "mycenter.html"
        }
    });

    // 横幅跳转到订单
    $("#order-nav").click(function(){
        if(window.sessionStorage.getItem("userId")!=="null" && window.sessionStorage.getItem("userId")!==null){
            window.location.href = "myorder.html"
        }
    });

    // 退出
    $("#out-nav").click(function(){
        window.sessionStorage.setItem("userName",null);
        window.sessionStorage.setItem("userId",null);
        window.location.reload();
    });

    // 搜索
    $("#search-nav").click(function(){
        document.getElementById("main-page").style.display="none";
        findBooksDetailsLike(1);
    });

    function findBooksDetailsLike(currentPage) {
        $.ajax({
            type:"post",
            url:"details/findBooksDetailsLike",
            data : {
                bookName : $("#searchNavValue").val(),
                currentPage:currentPage
            },
            datatype: "json",
            error: function(){
                //请求出错处理
                alert("出错了，请与管理员联系");
            },
            success:function(result){
                let res = result;
                // 分页
                layui.use(['laypage', 'layer'], function(){
                    var laypage = layui.laypage,layer = layui.layer;
                    laypage.render({
                        elem: 'pagination-layui',
                        count: res.totalElements, //数据总元素,
                        curr:currentPage,
                        jump: function(obj,first){
                            if (!first) {
                                findBooksDetailsLike(obj.curr);
                            }
                        }
                    });
                    var html =  ' <div class="products" id="products">'+
                            '<div class="container">'+
                                '<h3 style="color: #7F7F7F">查询到相关记录'+ res.totalElements +'条</h3>'+
                            '<div class="col-md-12 product-model-sec" id="book-details-show">';

                    for (var i in res.content) {
                       // alert("bookDetailsId:"+res.content[i].bookDetailsId);
                        html +=
                            '<div class="product-grid">'+
                                '<a href="mybookdetails.html?bookDetailsId='+res.content[i].bookDetailsId +'">'+
                                    '<div class="more-product"><span> </span></div>'+
                                         '<div class="product-img b-link-stripe b-animate-go  thickbox">'+
                                                '<img src="'+res.content[i].image+'" class="img-responsive" alt="夜礼服" width="240" height="240">'+
                                            '<div class="b-wrapper">'+
                                             '<h4 class="b-animate b-from-left  b-delay03">'+
                                                '<button>查看详情</button>'+
                                             '</h4>'+
                                            '</div>'+
                                         '</div>'+
                                '</a>'+
                            '<div class="product-info simpleCart_shelfItem">'+
                                    '<div class="product-info-cust prt_name">'+
                                            '<h4>'+res.content[i].bookName+'</h4>'+
                                                '<span class="item_price"> ¥ '+res.content[i].price+'</span>'+
                                                '<input type="button" id="buy-book" class="item_add items" value="加入购物车" onclick="buySearchBook('+res.content[i].bookDetailsId +')">'+
                                            '<div class="clearfix"> </div>'+
                                    '</div>'+
                            '</div>'+
                            '</div>';
                    }
                    html +=     '</div>'+
                            '</div>'+
                        '</div>'+
                        '</div>';
                    $('#search-page').html(html);
                });
            }
        });
    }




    // 首页
    $("#item-index-nav").click(function(){
        window.location.reload();
    })

})(window);

