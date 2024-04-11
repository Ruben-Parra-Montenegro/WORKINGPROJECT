@echo off
set PATH_TO_FX="C:\Users\ruben\Desktop\CSIPROJECT\openjfx-22_windows-x64_bin-sdk\javafx-sdk-22\lib"
"C:\Program Files\Java\jdk-21\bin\java.exe" --module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml -jar "C:\Users\ruben\Desktop\CSIPROJECT\WORKINGPROJECT\WORKINGPROJECT.jar"
pause