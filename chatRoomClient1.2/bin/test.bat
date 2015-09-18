@echo off
echo ############################
echo  *----Client 1.2版------
echo * 建立標準的多人對話
echo * 無法自動重新連線
echo * 未有斷線的處理
echo ############################
set /p userNmae=請輸入使用者名稱:
java TcpClient %ip% %port% %userNmae%
pause