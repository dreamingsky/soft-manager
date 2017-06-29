    $(document).ready(function () {
               jQuery(document).ready(function() {
               		  App.init();
               		  Login.init();
               		});
      })


      function login(){

            var userName = $("#userName").val();
            var password = $("#password").val();

            $.ajax({
                url : baseUrl +"/login/validate",
                type:"post",
                dataType:"json",
                async :false,
                data : {"userName":userName,"password":password},
                success : function(data){
                    if(data.code==0){
                        window.location = baseUrl +"/index";
                    }else{
                        $("#alertMess").html("请输入正确的用户名或密码");
                        $("#alertDiv").show();
                    }
                }


            });
      }