'带日期时间格式的ping ' 
'syntax: cscript sping.vbs>sping.txt

Set shell = WScript.CreateObject("WScript.Shell")
Set re = New RegExp
re.Pattern = "^Reply|^Request"

Set myping = shell.Exec("ping 192.168.108.94 -t")

while Not myping.StdOut.AtEndOfStream
	strLine = myping.StdOut.ReadLine()
	r = re.Test(strLine)
	
	If r Then
		WScript.Echo date &" "& time & chr(9) & strLine
	End if
Wend