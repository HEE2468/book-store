// 退出
function logout() {
    window.sessionStorage.setItem("userName", null);
    window.sessionStorage.setItem("userId", null);
    window.location.href = "index.html"
}


