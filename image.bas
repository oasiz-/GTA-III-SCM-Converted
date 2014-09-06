i& = _LOADIMAGE("gta3.png", 32)
SCREEN i&
LOCATE 1, 1
flaggi = 0
x = 0
y = 0
PRINT "Press <space> for zone areas or wait 2s"
FOR i = 1 TO 120
    _DELAY 0.02
    q$ = INKEY$
    IF q$ = CHR$(27) THEN SYSTEM
    IF q$ = CHR$(32) THEN
        LOCATE 1, 1
        PRINT "Ok, zonerino it is ...                  "
        flaggi = 1
    END IF
NEXT i
IF flaggi = 0 THEN GOTO manual
LOCATE 1, 1
PRINT "                                "
LOCATE 1, 1
RESTORE Zones
FOR i = 1 TO 42

    text$ = ""
    READ text$
    READ dummy
    READ x1
    READ y1
    READ dummy
    READ x2
    READ y2
    READ dummy
    READ island
    map = 4096


    x1 = (x1 / 4) + 512
    x2 = (x2 / 4) + 512
    y1 = NOT (y1 / 4) - 512
    y2 = NOT (y2 / 4) - 512

    repick:
    colorz = RND(5) * 255
    colorz2 = RND(5) * 255
    colorz3 = RND(5) * 255
    IF colorz < 100 THEN GOTO repick
    IF colorz2 < 100 THEN GOTO repick
    IF colorz3 < 100 THEN GOTO repick
    IF text$ = "IND_ZON" THEN LINE (x1, y1)-(x2, y2), _RGBA(colorz, colorz2, colorz3, 255), B: flag = 1
    IF text$ = "COM_ZON" THEN LINE (x1, y1)-(x2, y2), _RGBA(colorz, colorz2, colorz3, 255), B: flag = 1
    IF text$ = "SUB_ZON" THEN LINE (x1, y1)-(x2, y2), _RGBA(colorz, colorz2, colorz3, 255), B: flag = 1
    IF flag = 0 THEN LINE (x1, y1)-(x2, y2), _RGBA(colorz, colorz2, colorz3, 128), BF
    IF flag = 0 THEN LINE (x1, y1)-(x2, y2), _RGBA(colorz, colorz2, colorz3, 255), B
    flag = 0
    IF island = 1 THEN text$ = "IND: " + text$
    IF island = 2 THEN text$ = "COM: " + text$
    IF island = 3 THEN text$ = "SUB: " + text$
    COLOR _RGBA(colorz, colorz2, colorz3, 255): PRINT text$
    lol:
    lol$ = INKEY$
    IF lol$ = CHR$(32) THEN GOTO buz ELSE GOTO lol
    IF lol$ = CHR$(27) THEN SYSTEM
    buz:

NEXT i

SLEEP
END


manual:
flaggi = 0
LOCATE 1, 1
PRINT "Press <space> to read from coord.txt or wait... "
FOR i = 1 TO 120
    _DELAY 0.02
    q$ = INKEY$
    IF q$ = CHR$(27) THEN SYSTEM
    IF q$ = CHR$(32) THEN
        LOCATE 1, 1
        PRINT "Ok, doing file input ...          "
        flaggi = 1
    END IF
NEXT i
IF flaggi = 0 THEN GOTO arrowz


fileread:
OPEN "coord.txt" FOR INPUT AS #2
i& = _LOADIMAGE("gta3.png", 32)
SCREEN i&
INPUT #2, x
INPUT #2, y

x1 = (x / 4) + 511
x2 = (x / 4) + 513
y1 = NOT (y / 4) - 511
y2 = NOT (y / 4) - 513
LINE (x1, y1)-(x2, y2), _RGBA(255, 100, 100, 128), BF
LINE (x1, y1)-(x2, y2), _RGBA(255, 100, 100, 255), B
LOCATE 1, 1
COLOR _RGBA(colorz, colorz2, colorz3, 255): PRINT STR$(x) + " " + STR$(y) + "  press <space> for re-read"
lol2:
lol$ = INKEY$
IF lol$ = CHR$(32) THEN GOTO buz2 ELSE GOTO lol2
IF lol$ = CHR$(27) THEN SYSTEM
buz2:
CLOSE #2
GOTO fileread
END



arrowz:
i& = _LOADIMAGE("gta3.png", 32)
arrows:

SCREEN i&

x1 = (x / 4) + 511
x2 = (x / 4) + 513
y1 = NOT (y / 4) - 511
y2 = NOT (y / 4) - 513
LINE (x1, y1)-(x2, y2), _RGBA(255, 100, 100, 128), BF
LINE (x1, y1)-(x2, y2), _RGBA(255, 100, 100, 255), B

LOCATE 1, 1
PRINT "                                       "
PRINT "                                       "
LOCATE 1, 1
PRINT "MARKER AT:  " + STR$(x) + " " + STR$(y)
PRINT "CURSOR AT:  " + STR$((mousex * 4) - 2048) + STR$(NOT (mousey * 4) - 2048)
_DISPLAY
lolza:
q$ = INKEY$
DO WHILE _MOUSEINPUT
    mousex = _MOUSEX + 1
    mousey = _MOUSEY + 1
    mleft = _MOUSEBUTTON(1)
    mrite = _MOUSEBUTTON(2)
LOOP
IF q$ = CHR$(27) THEN SYSTEM
IF mleft = -1 THEN x = (mousex * 4) - 2048
IF mleft = -1 THEN y = NOT (mousey * 4) - 2048
IF mrite = -1 THEN CLS: i& = _LOADIMAGE("gta3.png", 32): SCREEN i&: _DELAY 0.25
GOTO arrows




Zones:
DATA ROADBR1,1,617.442,-958.347,6.26083,1065.44,-908.347,206.261,1
DATA PORT_W,0,751.68,-1178.22,-13.8723,1065.68,-958.725,136.128,1
DATA FISHFAC,2,944.208,-1149.81,-9.72576,1016.14,-1076.01,40.2742,1
DATA PORT_S,0,1065.88,-1251.55,-13.5049,1501.88,-1069.93,136.495,1
DATA PORT_E,0,1363.68,-1069.65,-18.8643,1815.68,-613.646,131.136,1
DATA PORT_I,0,1065.88,-1069.85,1.49868,1363.38,-742.054,151.499,1
DATA CHINA,0,745.421,-908.289,-21.203,1065.42,-463.69,129.593,1
DATA REDLIGH,0,745.378,-463.616,-22.6676,1065.38,-282.616,147.332,1
DATA TOWERS,0,745.421,-282.4,-13.4117,1065.42,-78.7699,136.588,1
DATA LITTLEI,0,1065.9,-512.324,-14.296,1388.9,-78.324,135.704,1
DATA HARWOOD,0,745.979,-78.1778,-48.5832,1388.98,322.676,101.417,1
DATA EASTBAY,0,1389.37,-613.467,-29.883,1797.6,199.628,120.117,1
DATA S_VIEW,0,1066.1,-741.806,-34.2068,1363.6,-512.806,115.793,1
DATA COPS_1,2,1135.8,-695.021,6.9661,1182.36,-631.021,56.9661,1
DATA HOSPI_1,2,1136.09,-609.976,6.287,1182.09,-521.167,56.287,1
DATA IND_ZON,0,617.151,-1329.72,-117.535,1902.66,434.115,482.465,1
DATA ROADBR2,1,444.768,-958.298,30.7441,614.878,-908.298,180.744,2
DATA FILLIN1,2,1363.77,-613.339,-4.43849,1389.17,-512.539,70.4322,1
DATA CONSTRU,0,239.878,-411.617,7.62939e-005,614.322,-61.6167,163.819,2
DATA STADIUM,0,-225.764,-412.604,-9.53674e-005,116.236,160.496,120.271,2
DATA YAKUSA,0,199.766,-1672.42,-61.7588,577.766,-1059.93,432.688,2
DATA SHOPING,0,-224.438,-1672.05,-61.3183,199.562,-1004.45,432.352,2
DATA COM_EAS,0,200.107,-1059.19,-0.000144958,615.107,-412.193,198.864,2
DATA PARK,0,-121.567,-1003.07,-46.7463,199.271,-413.068,224.163,2
DATA UNIVERS,0,117.268,-411.622,0.000190735,239.268,-61.6218,166.36,2
DATA HOSPI_2,0,117.236,-61.1105,-17.071,615.236,268.889,83.754,2
DATA AIRPORT,0,-1632.97,-1344.71,-45.9404,-468.629,-268.443,254.696,3
DATA PROJECT,0,-811.835,-268.074,-45.8745,-371.041,92.7263,254.241,3
DATA SWANKS,0,-867.229,93.3882,-50.1134,-266.914,650.058,250.426,3
DATA SUB_IND,0,-1407.57,-267.966,-49.6792,-812.306,92.7559,250.437,3
DATA BIG_DAM,0,-1394.5,93.4441,-46.7412,-867.52,704.544,253.344,3
DATA MAIN_D1,2,1037.53,-907.274,0.0,1065.16,-637.689,30.0069,1
DATA MAIN_D2,2,966.079,-637.366,0.0,1064.83,-609.557,30.0789,1
DATA MAIN_D3,2,965.795,-608.99,0.0,995.306,-470.23,30.9302,1
DATA MAIN_D4,2,995.59,-511.092,0.0,1065.11,-470.23,30.0789,1
DATA MAIN_D5,2,1035.88,-463.56,0.0,1064.83,-282.86,30.3627,1
DATA MAIN_D6,2,1036.15,-281.96,0.0,1064.85,-179.224,30.6465,1
DATA SUB_ZON,0,-1644.64,-1351.38,-117.0,-266.895,1206.35,483.0,3
DATA COM_ZON,0,-265.479,-1719.97,-114.769,615.52,367.265,485.231,1
DATA SUB_ZO2,0,-265.444,161.113,-41.7094,-121.287,367.043,358.291,1
DATA SUB_ZO3,0,-265.434,79.0922,-45.8201,-226.334,161.064,354.18,1
DATA WEE_DAM,2,-1238.59,306.841,-0.48605,-910.445,504.646,39.514,3

