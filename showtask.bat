call runcrud.bat
if "%ERRORLEVEL%" == "0" goto runbrowser
echo.
echo ERROR runcrud.bat
goto errors

:runbrowser
start chrome " http://localhost:8080/crud/v1/task/getTasks"
goto end

:errors
echo There were errors

:end
echo.
echo Finished!