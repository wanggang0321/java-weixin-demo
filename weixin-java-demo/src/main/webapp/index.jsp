<html>
<script type="text/javascript" src="js/jquery-3.2.0.js"></script>
<body>
<h2>消息推送测试</h2>
<div>
    请输入要发送的openid:
    <input type="text" id="openid" /><input type="button" value="发送" onclick="send()" /><span id="resultinfo"></span>
</div>
<script>
    function send() {
        $.ajax({
            url:"http://localhost:8080/weixin-java-demo/push/demo3",
            type:"post",
            data:{
                "openId":$("#openid").val()
            },success:function(result){
                $("#resultinfo").val("发送成功")
            },error:function(msg){
                $("#resultinfo").val("发送失败")
            }
        });
    }
</script>
</body>
</html>
