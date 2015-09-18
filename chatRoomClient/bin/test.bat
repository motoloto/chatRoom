@echo off
echo ############################
echo  聊天室 1.1版
echo *目前只能一對一連線，中途斷線會跳出錯誤
set ip=10.100.7.130
set port=20
echo ############################
java TcpClient %ip% %port%
pause