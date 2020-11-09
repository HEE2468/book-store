

function buySearchBook(bookDetailsId){
    if(window.sessionStorage.getItem("userId") !== null){
        $.ajax({
            type: "post",
            url: "car/buySearchBook",
            data: {
                bookDetailsId: bookDetailsId,
                userId: window.sessionStorage.getItem("userId")
            },
            datatype: "json",
            error: function () {
                //请求出错处理
                alert("出错了，请与管理员联系");
            },
            success: function (result) {
                if (result.code === -1) {
                    alert(result.msg);
                }else{
                    layer.msg("操作成功!", {time:800}, function(){
                        //location.reload();
                        console.log("操作成功!")
                    });
                }
            }
        });
    }else{
        alert("请先登录!")
    }

}