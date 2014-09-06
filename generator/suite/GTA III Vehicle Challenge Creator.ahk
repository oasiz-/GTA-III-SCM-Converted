; ######################################################################################################
; ########################################### HEADER SECTION ###########################################
; ######################################################################################################

/*
Subheadings:

	#AUTO-EXECUTE
	FileList
	OpenReadme
*/


; Only one instance of the program can be running at a time.
#SingleInstance Force
; Tell the program what to do if it is closed.
OnExit, ExitSequence
; Change the name of the program in the tray menu, then remove the standard tray items
; and add the ones relevant to this program.
SplitPath, A_ScriptName,,,,ProgramNameNoExt
menu, tray, tip, %ProgramNameNoExt%
menu, tray, NoStandard
menu, tray, Add, Restart Program, RestartSequence
menu, tray, Add, Exit, ExitSequence
; RefreshRate: Used throughout the program, for example as a sleep time between loops.
RefreshRate = 20 ; In ms
; We don't need 6 decimals floating point precision, it'll only increase file size so we set it to 2 instead.
SetFormat, Float, 0.2

; Create some arrays needed to find the game and to see if it's still running. Both the window class and name are used for improved accuracy.
GameWindowClassArray := {GTAVC:"Grand theft auto 3", GTA3:"Grand theft auto 3", GTASA:"Grand theft auto San Andreas", GTA4:"Grand theft auto IV"}
GameWindowNameArray := {GTAVC:"GTA: Vice City", GTA3:"GTA3", GTASA:"GTA: San Andreas", GTA4:"GTAIV"}
GameRunningAddressArray := {GTAVC:0x00400000, GTASA:0x00400000, GTA3:0x00400000}
CurrentGame = GTA3
;VehicleNameArray := {90:"Landstalker", 91:"Idaho", 92:"Stinger", 93:"Linerunner", 94:"Perennial", 95:"Sentinel", 96:"Patriot", 97:"Firetruck",98:"Trashmaster", 99:"Stretch", 100:"Manana", 101:"Infernus", 102:"Blista", 103:"Pony", 104:"Mule", 105:"Cheetah", 106:"Ambulance", 107:"FBI Car", 108:"Moonbeam", 109:"Esperanto", 110:"Taxi", 111:"Kuruma", 112:"Bobcat", 113:"Mr. Whoopy", 114:"BF Injection", 115:"Manana with corpse", 116:"Police", 117:"Enforcer", 118:"Securicar", 119:"Banshee", 120:"Predator", 121:"Bus", 122:"Rhino", 123:"Barracks OL", 124:"Train", 125:"Chopper", 126:"Dodo", 127:"Coach", 128:"Cabbie", 129:"Stallion", 130:"Rumpo", 131:"RC Bandit", 132:"Triad Fish Van", 133:"Mr Wong's", 134:"Mafia Sentinel", 135:"Yardio Lobo", 136:"Yakuza Stinger", 137:"Diablo Stallion", 138:"Cartel Cruiser", 139:"Hoods Rumpo XL", 140:"Airtrain", 141:"DeadDodo", 142:"Speeder", 143:"Reefer", 144:"Panlantic", 145:"Flatbed", 146:"Yankee", 147:"Helicopter", 148:"Borgnine", 149:"Toyz", 150:"Ghost"}
;RestrictedVehiclesArray := [115, 120, 124, 125, 131, 140, 141, 142, 143, 147, 150] ; Boats are not available atm.
;Original above, because AHK absolutely suck when dealing with arrays I've just removed the non-usable vehicles manually below:
VehicleNameArray := {90:"Landstalker", 91:"Idaho", 92:"Stinger", 93:"Linerunner", 94:"Perennial", 95:"Sentinel", 96:"Patriot", 97:"Firetruck",98:"Trashmaster", 99:"Stretch", 100:"Manana", 101:"Infernus", 102:"Blista", 103:"Pony", 104:"Mule", 105:"Cheetah", 106:"Ambulance", 107:"FBI Car", 108:"Moonbeam", 109:"Esperanto", 110:"Taxi", 111:"Kuruma", 112:"Bobcat", 113:"Mr. Whoopy", 114:"BF Injection", 116:"Police", 117:"Enforcer", 118:"Securicar", 119:"Banshee", 121:"Bus", 122:"Rhino", 123:"Barracks OL", 126:"Dodo", 127:"Coach", 128:"Cabbie", 129:"Stallion", 130:"Rumpo", 132:"Triad Fish Van", 133:"Mr Wong's", 134:"Mafia Sentinel", 135:"Yardio Lobo", 136:"Yakuza Stinger", 137:"Diablo Stallion", 138:"Cartel Cruiser", 139:"Hoods Rumpo XL", 144:"Panlantic", 145:"Flatbed", 146:"Yankee", 148:"Borgnine", 149:"Toyz"}
CarColsArray := {Black:"0 0",White:"1 1",Blue:"2 2",Red:"3 3",Purple:"5 5",Yellow:"6 6",Silver:"75 75",Orange:"22 22",Green:"46 46"}
WeatherArray := {Sunny:"0", Cloudy:"1", Rainy:"2", Foggy:"3"}
PolicePresetsPerCPArray := {0:"0.0", 1:"0.3", 2:"0.4", 3:"0.7", 4:"1", 5:"1.3", 6:"1.4", 7:"3", 8:"4", 9:"5"}
PolicePresetsPerCPCapArray := {0:"0", 1:"2", 2:"3", 3:"4", 4:"3", 5:"4", 6:"5", 7:"4", 8:"5", 9:"6"}
MaxNumCheckpoints := 32 ; GTA3 only supports showing 32 radar blips at a time.
ThreadNameLength := 7 ; Thread names are limited to 7.
CameraAddedHeight := 15.0
SaveHotkey := "F8"
MinimumRequiredCheckpoints := 5

; Sound stuff
StartGameInstructionSound := "Start.wav"
FileInstall, Sounds\Start.wav, %StartGameInstructionSound%
IngameInstructionSound := "Ingame.wav"
FileInstall, Sounds\Ingame.wav, %IngameInstructionSound%
CameraInstructionSound := "IntroCamera.wav"
FileInstall, Sounds\IntroCamera.wav, %CameraInstructionSound%
FirstCheckpointInstructionSound := "CamSaved.wav"
FileInstall, Sounds\CamSaved.wav, %FirstCheckpointInstructionSound%
Checkpoint1CreatedSound := "CP1Created.wav"
FileInstall, Sounds\CP1Created.wav, %Checkpoint1CreatedSound%
Checkpoint2CreatedSound := "CP2Created.wav"
FileInstall, Sounds\CP2Created.wav, %Checkpoint2CreatedSound%
Checkpoint3CreatedSound := "CP3Created.wav"
FileInstall, Sounds\CP3Created.wav, %Checkpoint3CreatedSound%
Checkpoint4CreatedSound := "CP4Created.wav"
FileInstall, Sounds\CP4Created.wav, %Checkpoint4CreatedSound%
Checkpoint5CreatedSound := "CP5Created.wav"
FileInstall, Sounds\CP5Created.wav, %Checkpoint5CreatedSound%
CheckpointGenericCreatedSound := "CPGenericCreated.wav"
FileInstall, Sounds\CPGenericCreated.wav, %CheckpointGenericCreatedSound%

TrayTip, GTA III Vehicle Challenge Creator, Enter everything you want`, then confirm and press F6 ingame to save current coordinates to file`.,20,
; Enable debug functions if they exist and if the program is not compiled.
; This way normal users can't (accidentally) activate them.
If (IsLabel("DebugFunctions") AND A_IsCompiled != 1)
	gosub DebugFunctions
goto SetupFile

; ######################################################################################################
; ############################################# SETUP FILE #############################################
; ######################################################################################################

SetupFile:
FileName := "coords.txt"

If FileExist(FileName)
{
	if (SkipOverwriteWarning != 1)
	{
		MsgBox, 4,, A previous coordinate file exists`. The program cannot currently open previous files`, so a new one will overwrite the old`. Are you sure you want to contiue?
		IfMsgBox Yes
			FileDelete, %FileName%
		else
		{
			MsgBox This tool will now shut down`.
			ExitApp
		}
	}
}
sleep 50
File := FileOpen(FileName, "rw")
If IsObject(File)
	FileOpened = 1
Else
{
	MsgBox Something went wrong`, shutting down the tool`.
	ExitApp
}

CurrentCoordinateIndex := -1
goto WelcomeScreen

; ######################################################################################################
; ########################################### WELCOME WINDOW ###########################################
; ######################################################################################################

WelcomeScreen:
AdvancedColour = 0

For ID, Value in VehicleNameArray
{
	VehicleList .= "|" . Value
}
VehicleList := SubStr(VehicleList, 2) ; Remove the first character because we don't want the "|" at the start.
outputdebug %VehicleList%


Gui 1: +LastFound
Gui, 1:Font, Q3 
gui, 1:Add, Text,,
gui, 1:Add, Text,xm+5 yp+5 section, Welcome to the GTA III Vehicle Challenge Creator!
gui, 1:Add, Text,xs, Please enter your settings below`:

gui, 1:Font, w700 Q3 ; Bold
gui, 1:Add, Text,, Course name`:
gui, 1:Font, w400 Q3 ; Normal
gui, 1:Add, Edit, vCourseName limit, 
gui, 1:Add, Text, h0 w0 Y+5,

gui, 1:Font, w700 Q3 ; Bold
gui, 1:Add, Text,, Map type`:
gui, 1:Font, w400 Q3 ; Normal
gui, 1:Add, Radio, vMapType section Checked1, Free Roam
gui, 1:Add, Radio, ys, Race
gui, 1:Add, Text, h0 w0 Y+7,

gui, 1:Font, w700 Q3 ; Bold
gui, 1:Add, Text,xs, Seconds added per checkpoint`:
gui, 1:Font, w400 Q3 ; Normal
gui, 1:Add, Edit, ReadOnly,
gui, 1:Add, UpDown, vTimeExtension Range1-99, 8
gui, 1:Add, Text, h0 w0 Y+5,

gui, 1:Font, w700 Q3 ; Bold
gui, 1:Add, Text, xs, Vehicle:
gui, 1:Font, w400 Q3 ; Normal
gui, 1:Add, DropDownList, vVehicleType Choose1, %VehicleList%
gui, 1:Add, Text, h0 w0 Y+5,

gui, 1:Font, w700 Q3 ; Bold
gui, 1:Add, Text, section, Vehicle colour:
gui, 1:Font, w400 Q3 ; Normal
gui, 1:Add, Checkbox, vUseAdvancedColour ys gAdvancedColour, Use advanced colour
gui, 1:Add, DropDownList,xs section vVehicleColour, Black||White|Blue|Red|Purple|Yellow|Silver|Orange|Green
gui, 1:Add, Edit,w30 vVehicleColourAdvanced1 +Number Limit2 ys gCheckValidColour,
gui, 1:Add, Edit,w30 vVehicleColourAdvanced2 +Number Limit2 ys gCheckValidColour,
GuiControl, 1:Hide, VehicleColourAdvanced1
GuiControl, 1:Hide, VehicleColourAdvanced2
gui, 1:Add, Text, h0 w0 Y+9,

gui, 1:Font, w700 Q3 ; Bold
gui, 1:Add, Text,xs section, Weather type`:
gui, 1:Font, w400 Q3 ; Normal
gui, 1:Add, DropDownList, vWeatherType, Sunny||Cloudy|Rainy|Foggy
gui, 1:Add, Text, h0 w0 Y+9,

gui, 1:Font, w700 Q3 ; Bold
gui, 1:Add, Text, xs section, Police settings`:
gui, 1:Font, w400 Q3 ; Normal
gui, 1:Add, DropDownList, vPolicePreset gPolicePresets AltSubmit, None||Easy|Medium|Challenging|Difficult|Hard|Very Hard|Extreme|Impossible|Dude`, nice
gui, 1:Add, Text,xs section, Police per checkpoint`:
gui, 1:Add, Slider, xs vPolicePerCP gPolicePerCP Range0-60 w120 Center Noticks AltSubmit, 0.0
gui, 1:Add, Text, x+0 vPolicePerCPTextControl w30, 0.0
gui, 1:Add, Text,xs section, Police per checkpoint cap`:
GuiControl, +Buddy2PolicePerCPTextControl, PolicePerCP
gui, 1:Add, Slider, xs vPolicePerCPCap gPolicePerCPCap Range0-6 w120 Center Noticks AltSubmit, 0
gui, 1:Add, Text, x+0 vPolicePerCPCapTextControl w30, 0
GuiControl, +Buddy2PolicePerCPCapTextControl, PolicePerCPCap
gui, 1:Add, Text, h0 w0 Y+5,

gui, 1:Add, Text,xm,
			( LTrim

				Confirm your settings when you are happy with them. 
				After doing so, you will have to use %SaveHotkey% to save 
				your current coordinates. The first time you do this, 
				your position, angle will be saved as the starting 
				point. The second time, the camera position will be
				saved as your position + %CameraAddedHeight%. After that, every time 
				you press %SaveHotkey% your position will be saved to create a 
				checkpoint there. 
				

			) 
gui, 1:Add, Button,xs section default, Confirm
gui, 1:Add, Button, ys, Close
gui, 1:Show
return


AdvancedColour:
if AdvancedColour = 0	
{
	GuiControl, 1:Hide, VehicleColour
	GuiControl, 1:Show, VehicleColourAdvanced1
	GuiControl, 1:Show, VehicleColourAdvanced2
	AdvancedColour = 1
}
else
{
	GuiControl, 1:Show, VehicleColour
	GuiControl, 1:Hide, VehicleColourAdvanced1
	GuiControl, 1:Hide, VehicleColourAdvanced2
	AdvancedColour = 0
}
return

CheckValidColour:
Gui, 1:Submit, NoHide
if (VehicleColourAdvanced1 > 94)
{
	MsgBox, Values over 94 are not supported by the game!
	GuiControl, , VehicleColourAdvanced1, 94
}
if (VehicleColourAdvanced2 > 94)
{
	MsgBox, Values over 94 are not supported by the game!
	GuiControl, , VehicleColourAdvanced2, 94
}
return

PolicePresets:
Gui, 1:Submit, NoHide
PolicePreset -= 1 ; Base index should be 0, not 1.
PolicePerCP := PolicePresetsPerCPArray[PolicePreset]
PolicePerCPCap := PolicePresetsPerCPCapArray[PolicePreset]
PolicePerCPFake := PolicePerCP*10
GuiControl, , PolicePerCP, %PolicePerCPFake%
GuiControl, , PolicePerCPTextControl, %PolicePerCP%
GuiControl, , PolicePerCPCap, %PolicePerCPCap%
GuiControl, , PolicePerCPCapTextControl, %PolicePerCPCap%
return

PolicePerCP:
if (A_GuiEvent = "Normal")
	return
SetFormat, Float, 0.1
PolicePerCP /= 10.0 ; Divide by 10.0 to get 0.0-6.0 instead of 0-60 since no float support in sliders.
SetFormat, Float, 0.2
GuiControl, , PolicePerCPTextControl, %PolicePerCP%
return

PolicePerCPCap:
GuiControl, , PolicePerCPCapTextControl, %PolicePerCPCap%
return

; Create a context menu if the user right clicks on the window.
GuiContextMenu:
Menu, OutputRightClick, Add, Restart Program, RestartSequence
Menu, OutputRightClick, Add, Exit, GuiClose
Menu, OutputRightClick, Show
return

; What happens if the user tries to close the window.
GuiClose:
GuiEscape:
ButtonClose:
ClosedBeforeConfirmation = 1
exitapp
return


ButtonConfirm:
Gui, 1:Submit

if (CourseName = "")
{
	Msgbox,  Please enter a course name.
	Gui, 1:Restore
	return
}
RestrictedCharsArray := [";","'",",",".","/","\","[","]","-","=","{","}","+","!","@","#","$","%","^","&","*","(",")","<",">","?","``","~","|","€",A_Space,":",""""]
For Key, Value in RestrictedCharsArray
{
	StringReplace, CourseName, CourseName, %Value%, _, All ; Replace all restricted characters in the course name with underscores so it won't break.
}

ThreadName := SubStr(CourseName, 1, ThreadNameLength) ; Get the first %ThreadNameLength% characters of CourseName.
outputdebug %CourseName% and %ThreadName%
;NumCheckpoints := ; We don't know yet!

TimeExtension *= 1000 ; Convert from sec to ms

For ID, Value in VehicleNameArray
{
	if (Value = VehicleType)
	{
		CarModel := ID
		break
	}
}

if (UseAdvancedColour = 1)
{
	if (VehicleColourAdvanced1 = "")
	{
		VehicleColourAdvanced1 := 0
	}
	if (VehicleColourAdvanced2 = "")
	{
		VehicleColourAdvanced2 := 0
	}
	CarCol := VehicleColourAdvanced1 . " " . VehicleColourAdvanced2
}
else
{
	CarCol := CarColsArray[VehicleColour]
}

WeatherType := WeatherArray[WeatherType]

if (MapType = 1)
{
	MapType := "free"
}
else if (MapType = 2)
{
	MapType := "race"
	MaxNumCheckpoints := 999
}

SetFormat, Float, 0.1
PolicePerCP /= 10.0 ; Divide by 10.0 to get 0.0-6.0 instead of 0-60 since no float support in sliders.
SetFormat, Float, 0.2

ReservedVar2 := "R"
ReservedVar3 := "R"
ReservedVar4 := "R"
ReservedVar5 := "R"
ReservedVar6 := "R"
ReservedVar7 := "R"

; PolicePerCPCap := ; Already set correctly in the menu, don't need to change anything here. 

SoundPlay, %StartGameInstructionSound%, wait
goto MainScript



; ######################################################################################################
; ############################################ MAIN SECTION ############################################
; ######################################################################################################

/*
Subheadings:

	MainScript
	SetFilesMain
	SetOriginalValues
*/

MainScript:
Hotkey, %SaveHotkey%, SaveCoordinates, Off

; Get the window class and name of the game from the array.
WindowClass := GameWindowClassArray[CurrentGame]
WindowName := GameWindowNameArray[CurrentGame]
; Wait until the game window is started. Check both the window class and window title to avoid false positives.
WinWait ahk_class %WindowClass%
WinGetTitle, CurrentWindowName
If (CurrentWindowName != WindowName)
	goto MainScript
; Get the Process Handle of the game for use in memory functions.
; If the process handle cannot be retrieved, try to restart the program
; with admin privileges to see if that fixes the problem.
; If it can still not be retrieved with admin privileges, the program
; cannot function properly so it will shut itself down.
WinGet, PID, PID
ErrorLevel := Memory(1, PID)
If ErrorLevel != 0
{
	If A_IsAdmin = 0
	{
		msgbox Error accessing the game. `nThe program will now try to restart with admin privileges.
		Run *RunAs "%A_ScriptFullPath%"
	}
	Else
	{
		msgbox Error accessing the game. `nThe program cannot continue operating.`n%Error%.
		Error := GetLastErrorMessage()
	}
	ExitConfirmed = 1
	ExitApp
}	

; Check if the game is started (which will set the ErrorLevel to !=0)
Process, Exist, %PID%
if ErrorLevel != 0
	VersionOffset := GameVersionCheck(CurrentGame) ; Check which version of the current game is used and which offset to use for memory addresses.
else 
	goto MainScript
GameRunningAddress := GameRunningAddressArray[CurrentGame]

VersionOffset += 0x10140 ; This will make 1.0/1.1 NoCD the standard version instead of the Steam version, meaning addresses are offset from 1.0/1.1 NoCD. (1.0 is offset 0, steam is offset 0x10140)

; 1.0 NoCD addresses:
if Memory(3, 0x005C1E70, 4) = 0x53E58955
{
	PlayerPointer := 0x009412F0
	CCameraStart := 0x006FACF8
	;CarPointer := 0x006FB49C
}


; 1.1 NoCD addresses:
else if Memory(3, 0x005C2130, 4) = 0x53E58955
{
	PlayerPointer := 0x009414A8
	CCameraStart := 0x006FACF8
	;CarPointer := 0x006FB49C
}

; Steam addresses:
Else if Memory(3, 0x005C6FD0, 4) = 0x53E58955
{
	PlayerPointer := 0x009515E8
	CCameraStart := 0x0070AE38
	;CarPointer := 0x0070B5DC
}

XOffset := 52
YOffset := 56
ZOffset := 60

PlayerHeadingOffset := 732

;OnMissionAddress := 0x0074B584+VersionOffset




; MAIN LOOP
While Memory(3, GameRunningAddress, 1) != "Fail"
{
	if (HotkeyInitialized != 1 AND Memory(3, PlayerPointer, 4) != 0) ; Player defined, i.e. not in the main menu.
		gosub InitializeHotkey
	sleep %RefreshRate%
}

goto MainScript


InitializeHotkey:
Hotkey, %SaveHotkey%, SaveCoordinates, On
SoundPlay, %IngameInstructionSound%, wait
HotkeyInitialized = 1
return

SaveCoordinates:
if (Memory(3, PlayerPointer, 4) = 0) ; Player not yet defined, i.e. in the main menu. Shouldn't be necessary with the new InitializeHotkey subroutine, but it doesnt hurt to be certain.
	return
gosub GetCoordinates
if CurrentCoordinateIndex = -1
{
	gosub GetHeading
	File.WriteLine(CurrentX . "," . CurrentY . "," . CurrentZ . "," . CurrentHeading)
	SoundPlay, %CameraInstructionSound%, wait
}
else if CurrentCoordinateIndex = 0
{
	gosub GetCamera
	File.WriteLine(CameraX . "," . CameraY . "," . CameraZ)
	SoundPlay, %FirstCheckpointInstructionSound%, wait
}
else
{
	File.WriteLine(CurrentX . "," . CurrentY . "," . CurrentZ)
	if CurrentCoordinateIndex < 5
		CurrentSound := Checkpoint%CurrentCoordinateIndex%CreatedSound
	else
		CurrentSound := CheckpointGenericCreatedSound
	SoundPlay, %CurrentSound%
}
CurrentCoordinateIndex += 1
outputdebug Coordinates Saved
if (CurrentCoordinateIndex > MaxNumCheckpoints)
{
	MsgBox You have reached the maximum number of checkpoints `(%MaxNumCheckpoints%`)`! `nClosing down the tool`.`.`.
	ExitApp
}

return

GetCoordinates:
PlayerXAddress := Memory(5, PlayerPointer, XOffset)
CurrentX := Memory(3, PlayerXAddress, 4, "Float")
CurrentX += 0.00
PlayerYAddress := Memory(5, PlayerPointer, YOffset)
CurrentY := Memory(3, PlayerYAddress, 4, "Float")
CurrentY += 0.00
PlayerZAddress := Memory(5, PlayerPointer, ZOffset)
CurrentZ := Memory(3, PlayerZAddress, 4, "Float")
CurrentZ += 0.00
if (CurrentZ = "Fail")
{
	MsgBox Something went wrong`, shutting down the tool`.
	ExitApp
}
return

GetHeading:
PlayerHeadingAddress := Memory(5, PlayerPointer, PlayerHeadingOffset)
CurrentHeading := Memory(3, PlayerHeadingAddress, 4, "Float")
CurrentHeading += 0.00
CurrentHeading := 180.0 / (4 * ATan(1)) * CurrentHeading ; Convert from rad to deg
If CurrentHeading < 0
	CurrentHeading := 360.0 + CurrentHeading  ; 0.0 to 360.0 instead of -180.0 to 180.0
return

GetCamera:
CameraXAddress := CCameraStart+XOffset
CameraX := Memory(3, CameraXAddress, 4, "Float")
CameraX += 0.00
CameraYAddress := CCameraStart+YOffset
CameraY := Memory(3, CameraYAddress, 4, "Float")
CameraY += 0.00
CameraZAddress := CCameraStart+ZOffset
CameraZ := Memory(3, CameraZAddress, 4, "Float")
CameraZ += %CameraAddedHeight%
return

; ######################################################################################################
; ########################################### RESTART/EXIT SEQUENCE ####################################
; ######################################################################################################

/*
Subheadings:

	RestartSequence
	ExitSequence
	3ButtonYes
	3ButtonNo/3GuiClose/3GuiEscape
*/

;Restart the program
RestartSequence:
reload
sleep 100
return


; What happens when the program is closed
ExitSequence:
if (FileOpened = 1 and ClosedBeforeConfirmation != 1)
{
	CheckpointCount := CurrentCoordinateIndex - 1
	if (CheckpointCount >= MinimumRequiredCheckpoints)
		gosub CompleteFileContents
	else if (SkipInvalidWarning != 1)
		MsgBox The Vehicle Challenge you have created is not valid! `nIt won`'t work!
	File.Close()
	FileOpened = 0
}
if A_IsCompiled
{
	FileDelete, %StartGameInstructionSound%
	FileDelete, %IngameInstructionSound%
	FileDelete, %CameraInstructionSound%
	FileDelete, %FirstCheckpointInstructionSound%
	FileDelete, %Checkpoint1CreatedSound%
	FileDelete, %Checkpoint2CreatedSound%
	FileDelete, %Checkpoint3CreatedSound%
	FileDelete, %Checkpoint4CreatedSound%
	FileDelete, %Checkpoint5CreatedSound%
	FileDelete, %CheckpointGenericCreatedSound%
}
sleep 100
Exitapp

CompleteFileContents:
File.Seek(0, 0) ; Sets the file pointer to the beginning of the file.
AllCoords := File.Read() ; Read all existing content
outputdebug %AllCoords%
File.Seek(0, 0) ; Sets the file pointer to the beginning of the file.
File.WriteLine( CourseName
	. "," . ThreadName
	. "," . CheckpointCount
	. "," . TimeExtension
	. "," . CarModel
	. "," . CarCol
	. "," . WeatherType
	. "," . MapType
	. "," . PolicePerCP
	. "," . ReservedVar2
	. "," . ReservedVar3
	. "," . ReservedVar4
	. "," . ReservedVar5
	. "," . ReservedVar6
	. "," . ReservedVar7
	. "," . PolicePerCPCap)

File.Write(AllCoords)
return

; ######################################################################################################
; ########################################### DEBUG STUFF ##############################################
; ######################################################################################################


DebugFunctions:
Hotkey, F7, DebugListvars, On
SkipOverwriteWarning = 1
SkipInvalidWarning = 1
return

DebugListvars:
Listvars
return
;*/
