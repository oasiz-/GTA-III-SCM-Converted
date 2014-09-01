SCREEN _NEWIMAGE(500&, 240&, 13%)

DIM coords(3, 420) AS SINGLE
course_name$ = ""
threadname$ = ""
carname$ = ""
weather$ = ""
carcol$ = "33 51"
pickupamount% = 1
reward% = 8

police$ = ""
weight$ = ""
density$ = ""
pickuptype$ = ""
carhp$ = ""
minspeed$ = ""
riot$ = ""


DIM startcamera(3) AS SINGLE
DIM startlocation(4) AS SINGLE 'startangle = 4



PRINT ""
PRINT ""
OPEN "coords.txt" FOR INPUT AS #1 ' Coordinate opener
INPUT #1, course_name$
INPUT #1, threadname$
tempvar$ = ""
INPUT #1, tempvar$
pickupamount% = VAL(tempvar$)
INPUT #1, tempvar$
reward% = VAL(tempvar$)
INPUT #1, carname$
INPUT #1, carcol$
INPUT #1, weather$
INPUT #1, type$
INPUT #1, police$
INPUT #1, weight$
INPUT #1, density$
INPUT #1, pickuptype$
INPUT #1, carhp$
INPUT #1, minspeed$
INPUT #1, riot$
INPUT #1, tempvar$

_DISPLAY
_LIMIT 3
PRINT "READING FILE ..."
PRINT ""
PRINT "Course name: " + course_name$
PRINT "Thread name: " + threadname$
PRINT LTRIM$(STR$(pickupamount%)) + " checkpoints and using the car:" + carname$
GOSUB readcoords
CLOSE #1
GOSUB printfile

END





printfile:
IF type$ = "free" THEN
    OPEN "output.sc" FOR OUTPUT AS #1
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------           MISSION GENERATE OUTPUT     ------------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"

    PRINT #1, ""
    PRINT #1, "// " + course_name$ + " (Internally called " + threadname$ + ") has the following parameters:"
    PRINT #1, "// Starting coordinate: " + LTRIM$(STR$(startlocation(1))) + " " + LTRIM$(STR$(startlocation(2))) + " " + LTRIM$(STR$(startlocation(3))) + "  Angle: " + LTRIM$(STR$(startlocation(4)))
    PRINT #1, "// We are using a car called " + carname$ + " with carcol " + carcol$
    PRINT #1, "// Weather is " + weather$
    PRINT #1, "// Camera is located at: " + LTRIM$(STR$(startcamera(1))) + " " + LTRIM$(STR$(startcamera(2))) + " " + LTRIM$(STR$(startcamera(3)))
    PRINT #1, "//"
    PRINT #1, "// Coordinates for the mission are:"
    FOR i = 1 TO pickupamount%
        PRINT #1, "// " + LTRIM$(STR$(coords(1, i))) + " " + LTRIM$(STR$(coords(2, i))) + " " + LTRIM$(STR$(coords(3, i)))
    NEXT i
    PRINT #1, "//"
    PRINT #1, ""

    PRINT #1, ""
    PRINT #1, "// Mission start stuff"
    PRINT #1, ""
    PRINT #1, ":MIS_" + threadname$
    PRINT #1, "gosub @MISSION_START_" + course_name$
    PRINT #1, "GOSUB @MISSION_CLEANUP_" + course_name$
    PRINT #1, "end_thread"
    PRINT #1, ""
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // ----------------------              MISSION START         ------------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"

    PRINT #1, ""
    PRINT #1, ":MISSION_START_" + course_name$
    PRINT #1, "0004: $ONMISSION = 1 "
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------              INITIAL MISSION          ------------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "01B4: set_player $PLAYER_CHAR controllable 0 "
    PRINT #1, "0055: put_player $PLAYER_CHAR at 825.9011 -1054.3267 14.4000"
    PRINT #1, "0171: set_player $PLAYER_CHAR z_angle_to 56.0434"
    PRINT #1, "01B6: set_weather WEATHER_SUNNY"
    PRINT #1, "00C0: set_current_time 4 20"
    PRINT #1, "0169: set_fade_color 1 1 1 "
    PRINT #1, "03CB: load_scene 807.0 -937.0 36.5625"
    PRINT #1, "0247: request_model #" + carname$
    PRINT #1, "038B: load_all_models_now "
    PRINT #1, "03AF: set_streaming 1 "
    PRINT #1, "03F7: load_island_data 1"
    PRINT #1, "043C: set_game_sounds_fade 0  "
    PRINT #1, "wait 2000"
    PRINT #1, "00BA: print_big 'T4X4_1' time 10000 style 2  // Change this GXT entry to " + course_name$
    PRINT #1, "00A5: create_car #" + carname$ + " at 816.288 -1050.0724 14.5562 store_to $CAR_CHALLENGE // 158.3151 angle"
    PRINT #1, "0229: set_car $CAR_CHALLENGE color_to " + carcol$
    PRINT #1, "0169: set_fade_color 1 1 1"
    PRINT #1, "0239: actor $PLAYER_ACTOR run_to 812.0 -945.5"
    PRINT #1, "01D5: actor $PLAYER_ACTOR go_to_and_drive_car $CAR_CHALLENGE"
    PRINT #1, "wait 3000"
    PRINT #1, "fade 0 for 1000 ms"
    PRINT #1, "while fading"
    PRINT #1, "wait 0 ms"
    PRINT #1, "end"
    PRINT #1, "0369: put_player $PLAYER_CHAR in_car $CAR_CHALLENGE"
    PRINT #1, "wait 1000"
    PRINT #1, "0055: put_player $PLAYER_CHAR at " + LTRIM$(STR$(startlocation(1))) + " " + LTRIM$(STR$(startlocation(2))) + " " + LTRIM$(STR$(startlocation(3)))
    PRINT #1, "0171: set_player $PLAYER_CHAR z_angle_to " + LTRIM$(STR$(startlocation(4)))
    PRINT #1, "043C: set_game_sounds_fade 0"
    PRINT #1, "wait 1000"
    PRINT #1, ""
    PRINT #1, ""
    PRINT #1, ""
    PRINT #1, "0317: increment_mission_attempts "
    PRINT #1, "03A4: name_thread '" + threadname$ + "'"
    PRINT #1, ""
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------                SET VARIABLES          ------------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"

    PRINT #1, ""
    PRINT #1, "0004: $COUNTER_4X4_PICKUPS = 0 "
    PRINT #1, "0004: $TIMER_4X4 = 0 "
    PRINT #1, "0004: $FLAG_INTRO = 0 "
    PRINT #1, "0004: $FLAG_TIMER = 0 "
    PRINT #1, "0004: $ON_PATRIOT_PLAYGROUND_MISSION = 1 "
    PRINT #1, "0004: $FLAG_INTRO_JUMP = 0"
    PRINT #1, "0004: $PATRIOT_PLAYGROUND_HELP_FINISHED = 0 "
    PRINT #1, "0004: $RECORD_TEMP = 0 "
    PRINT #1, ""
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------                  BLIP INIT            ------------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    FOR i = 1 TO pickupamount%
        PRINT #1, "0004: $FLAG_BLIP_" + LTRIM$(STR$(i)) + " = 0"
    NEXT i
    PRINT #1, ""
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------              COORDINATE INIT          ------------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    FOR i = 1 TO pickupamount%
        PRINT #1, "0005: $X_" + LTRIM$(STR$(i)) + " = " + LTRIM$(STR$(coords(1, i)))
        PRINT #1, "0005: $Y_" + LTRIM$(STR$(i)) + " = " + LTRIM$(STR$(coords(2, i)))
        PRINT #1, "0005: $Z_" + LTRIM$(STR$(i)) + " = " + LTRIM$(STR$(coords(3, i)))
        PRINT #1, ""
    NEXT i

    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------              MISSION SCRIPT           ------------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"

    PRINT #1, "0110: clear_player $PLAYER_CHAR wanted_level  "
    PRINT #1, "if"
    PRINT #1, " 8119:   not car $CAR_CHALLENGE wrecked "
    PRINT #1, "then"
    PRINT #1, " 020A: set_car $CAR_CHALLENGE door_status_to CARLOCK_LOCKED"
    PRINT #1, "end"
    PRINT #1, "01B4: set_player $PLAYER_CHAR controllable 0 "
    PRINT #1, "02A3: toggle_widescreen 1 "
    PRINT #1, ""
    PRINT #1, ""
    FOR i = 1 TO pickupamount%
        PRINT #1, "018A: $BLIP_" + LTRIM$(STR$(i)) + " = create_checkpoint_at $X_" + LTRIM$(STR$(i)) + " $Y_" + LTRIM$(STR$(i)) + " $Z_" + LTRIM$(STR$(i))
    NEXT i
    PRINT #1, ""
    PRINT #1, ""
    PRINT #1, "// - - - - MAIN LOOP - - - -"
    PRINT #1, "while 001A: " + LTRIM$(STR$(pickupamount%)) + " > $COUNTER_4X4_PICKUPS                      /////////// AMOUNT OF PICKUPS !!!"
    PRINT #1, " wait 0 ms"
    PRINT #1, " if and"
    PRINT #1, "     0038:   $COUNTER_4X4_PICKUPS == 1 "
    PRINT #1, "     0038:   $FLAG_TIMER == 0 "
    PRINT #1, " then"
    PRINT #1, "     014E: start_timer_at $TIMER_4X4 "
    PRINT #1, "     0004: $FLAG_TIMER = 1 "
    PRINT #1, " end"
    PRINT #1, ""
    FOR i = 1 TO pickupamount%
        PRINT #1, " if"
        PRINT #1, "     0038: $FLAG_BLIP_" + LTRIM$(STR$(i)) + " == 0"
        PRINT #1, " then"
        PRINT #1, "     024F: create_corona 2.0 CORONATYPE_HEX FLARETYPE_NONE with_color 0 200 200 at_point $X_" + LTRIM$(STR$(i)) + " $Y_" + LTRIM$(STR$(i)) + " $Z_" + LTRIM$(STR$(i))
        PRINT #1, "     if"
        PRINT #1, "         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_" + LTRIM$(STR$(i)) + " $Y_" + LTRIM$(STR$(i)) + " $Z_" + LTRIM$(STR$(i)) + " radius 2.5 2.5 3.5 "
        PRINT #1, "     then"
        PRINT #1, "         0164: disable_marker $BLIP_" + LTRIM$(STR$(i))
        PRINT #1, "         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_" + LTRIM$(STR$(i)) + " $Y_" + LTRIM$(STR$(i)) + " $Z_" + LTRIM$(STR$(i))
        PRINT #1, "         0004: $FLAG_BLIP_" + LTRIM$(STR$(i)) + " = 1 "
        PRINT #1, "         gosub @MISSION_" + course_name$ + "_CHECKPOINT_PICKED_UP"
        PRINT #1, "     end"
        PRINT #1, " end"
    NEXT i
    PRINT #1, ""
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------                 INTRO START           ------------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, ""
    PRINT #1, " if"
    PRINT #1, "     0038:   $PATRIOT_PLAYGROUND_HELP_FINISHED == 0 "
    PRINT #1, " then"
    PRINT #1, "     01B4: set_player $PLAYER_CHAR controllable 0"
    PRINT #1, "     015F: set_camera_position " + LTRIM$(STR$(startcamera(1))) + " " + LTRIM$(STR$(startcamera(2))) + " " + LTRIM$(STR$(startcamera(3))) + " 0.0 rotation 0.0 0.0"
    PRINT #1, "     03CB: load_scene " + LTRIM$(STR$(startlocation(1))) + " " + LTRIM$(STR$(startlocation(2))) + " " + LTRIM$(STR$(startlocation(3)))
    PRINT #1, "     0160: point_camera " + LTRIM$(STR$(startlocation(1))) + " " + LTRIM$(STR$(startlocation(2))) + " " + LTRIM$(STR$(startlocation(3))) + " switchstyle JUMP_CUT"
    PRINT #1, "     016A: fade 1 for 1500 ms "
    PRINT #1, "     while fading"
    PRINT #1, "         wait 0 ms   "
    PRINT #1, "     end"
    PRINT #1, "     wait 2000        "
    PRINT #1, " "
    PRINT #1, "     if"
    PRINT #1, "         8119:   not car $CAR_CHALLENGE wrecked "
    PRINT #1, "     then"
    PRINT #1, "         020A: set_car $CAR_CHALLENGE door_status_to CARLOCK_UNLOCKED"
    PRINT #1, "     end"
    PRINT #1, ""
    PRINT #1, "        016A: fade 0 for 1500 ms"
    PRINT #1, "     while fading"
    PRINT #1, "         wait 0 ms"
    PRINT #1, "     end"
    PRINT #1, "        02A3: toggle_widescreen 0"
    PRINT #1, "     01B4: set_player $PLAYER_CHAR controllable 1"
    PRINT #1, "        02EB: restore_camera_jumpcut "
    PRINT #1, "             016A: fade 1 for 1500 ms"
    PRINT #1, "     while fading"
    PRINT #1, "         wait 0 ms"
    PRINT #1, "     end"
    PRINT #1, "     00BE: clear_prints"
    PRINT #1, ""
    PRINT #1, "        0004: $PATRIOT_PLAYGROUND_HELP_FINISHED = 1"
    PRINT #1, " end"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------     TIMER STARTED - FAIL CONDITION      ----------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, " "
    PRINT #1, " if"
    PRINT #1, "     0038:   $FLAG_TIMER == 1 "
    PRINT #1, " then"
    PRINT #1, "     if"
    PRINT #1, "         001A:   1 > $TIMER_4X4"
    PRINT #1, "     then"
    PRINT #1, "         00BC: print_now 'TAXI2' time 3000 flag 1  // ~r~You're out of time!"
    PRINT #1, "         goto @MISSION_" + course_name$ + "_FAILED"
    PRINT #1, "     end"
    PRINT #1, " end"
    PRINT #1, " if"
    PRINT #1, "     80DE:   not is_player_in_model $PLAYER_CHAR model #" + carname$
    PRINT #1, " then"
    PRINT #1, "     00BC: print_now 'T4X4_F' time 3000 flag 1  // ~r~You bailed! Too tough for you?!"
    PRINT #1, "     goto @MISSION_" + course_name$ + "_FAILED"
    PRINT #1, " end"
    PRINT #1, "end"
    PRINT #1, ""
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------     TIMER STARTED - WIN CONDITION       ----------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, ""
    PRINT #1, ""
    PRINT #1, "if"
    PRINT #1, " 0038:   $COUNTER_4X4_PICKUPS == " + LTRIM$(STR$(pickupamount%)) + "   // 12 !!!!"
    PRINT #1, "then"
    PRINT #1, " goto @MISSION_" + course_name$ + "_PASSED"
    PRINT #1, "end"
    PRINT #1, ""
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------       CHECKPOINT PICK UP                ----------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, ""
    PRINT #1, ""
    PRINT #1, ":MISSION_" + course_name$ + "_CHECKPOINT_PICKED_UP"
    PRINT #1, "0008: $COUNTER_4X4_PICKUPS += 1 "
    PRINT #1, "0008: $TIMER_4X4 += " + LTRIM$(STR$(reward%)) + "000"
    PRINT #1, "01E5: text_1number_highpriority 'T4X4_1B' $COUNTER_4X4_PICKUPS flag 30000 time 1  // ~1~ of many!"
    PRINT #1, "return"
    PRINT #1, ""
    PRINT #1, ""
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------        MISSION FAIL ROUTINE             ----------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, ""
    PRINT #1, ":MISSION_" + course_name$ + "_FAILED"
    PRINT #1, "00BA: print_big 'M_FAIL' time 2000 style 1  // MISSION FAILED!"
    PRINT #1, "0255: set_critical_mission_restart_at 825.9011 -1054.3267 14.4000 angle 56.0434"
    PRINT #1, "0322: kill_player $PLAYER_CHAR"
    PRINT #1, "wait 2000 ms"
    PRINT #1, "goto @MISSION_CLEANUP_" + course_name$
    PRINT #1, "return"
    PRINT #1, ""
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------     MISSION COMPLETE ROUTINE            ----------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, ""
    PRINT #1, ":MISSION_" + course_name$ + "_PASSED"
    PRINT #1, "0004: $COURSE_" + course_name$ + " = $TIMER_4X4"
    PRINT #1, "014F: stop_timer $TIMER_4X4"
    PRINT #1, "01B4: set_player $PLAYER_CHAR controllable 0"
    PRINT #1, "016A: fade 0 for 1500 ms"
    PRINT #1, "while fading"
    PRINT #1, "   wait 0 ms"
    PRINT #1, "end"
    PRINT #1, "0110: clear_player $PLAYER_CHAR wanted_level "
    FOR i = 1 TO pickupamount%
        PRINT #1, "0164: disable_marker $BLIP_" + LTRIM$(STR$(i))
    NEXT i
    PRINT #1, "02A3: toggle_widescreen 1"
    PRINT #1, "     015F: set_camera_position " + LTRIM$(STR$(startcamera(1))) + " " + LTRIM$(STR$(startcamera(2))) + " " + LTRIM$(STR$(startcamera(3))) + " 0.0 rotation 0.0 0.0"
    PRINT #1, "     03CB: load_scene " + LTRIM$(STR$(startlocation(1))) + " " + LTRIM$(STR$(startlocation(2))) + " " + LTRIM$(STR$(startlocation(3)))
    PRINT #1, "     0160: point_camera " + LTRIM$(STR$(startlocation(1))) + " " + LTRIM$(STR$(startlocation(2))) + " " + LTRIM$(STR$(startlocation(3))) + " switchstyle JUMP_CUT"
    PRINT #1, "016A: fade 1 for 1000 ms"
    PRINT #1, "while fading"
    PRINT #1, "   wait 0 ms"
    PRINT #1, "end"
    PRINT #1, "01E3: text_1number_styled 'M_PASS' number 20000 time 5000 style 1  // MISSION PASSED! $~1~"
    PRINT #1, "0394: play_music 1       "
    PRINT #1, "wait 4000"
    PRINT #1, "016A: fade 0 for 1000 ms"
    PRINT #1, "while fading"
    PRINT #1, "   wait 0 ms"
    PRINT #1, "end"
    PRINT #1, "012A: put_player $PLAYER_CHAR at 825.9011 -1054.3267 14.4000 and_remove_from_car"
    PRINT #1, "0171: set_player $PLAYER_CHAR z_angle_to 56.0434"
    PRINT #1, "02EB: restore_camera_jumpcut "
    PRINT #1, "02A3: toggle_widescreen 0"
    PRINT #1, "00D8: mission_has_finished "
    PRINT #1, "wait 1"
    PRINT #1, "016A: fade 1 for 1000 ms"
    PRINT #1, "while fading"
    PRINT #1, "   wait 0 ms"
    PRINT #1, "end "
    PRINT #1, "wait 1000 ms"
    PRINT #1, "0004: $ONMISSION = 0 "
    PRINT #1, "0051: return"
    PRINT #1, "return"
    PRINT #1, ""
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------     MISSION BAD ENDING ROUTINE          ----------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, ""
    PRINT #1, ":MISSION_CLEANUP_" + course_name$
    PRINT #1, "01B4: set_player $PLAYER_CHAR controllable 0"
    FOR i = 1 TO pickupamount%
        PRINT #1, "0164: disable_marker $BLIP_" + LTRIM$(STR$(i))
    NEXT i
    PRINT #1, "02EB: restore_camera_jumpcut "
    PRINT #1, "02A3: toggle_widescreen 0  "
    PRINT #1, "014F: stop_timer $TIMER_4X4 "
    PRINT #1, "0004: $ONMISSION = 0 "
    PRINT #1, "mission_cleanup "
    PRINT #1, "00D8: mission_has_finished"
    PRINT #1, "while fading"
    PRINT #1, "   wait 1000 ms"
    PRINT #1, "end "
    PRINT #1, "0051: return "
END IF
' ======================================================================== RACE
' ======================================================================== RACE
' ======================================================================== RACE
' ======================================================================== RACE
' ======================================================================== RACE
' ======================================================================== RACE
' ======================================================================== RACE
' ======================================================================== RACE
' ======================================================================== RACE
IF type$ = "race" THEN
    OPEN "output.sc" FOR OUTPUT AS #1
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------           MISSION GENERATE OUTOUT     ------------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"

    PRINT #1, ""
    PRINT #1, "// " + course_name$ + " (Internally called " + threadname$ + ") has the following parameters:"
    PRINT #1, "// Starting coordinate: " + LTRIM$(STR$(startlocation(1))) + " " + LTRIM$(STR$(startlocation(2))) + " " + LTRIM$(STR$(startlocation(3))) + "  Angle: " + LTRIM$(STR$(startlocation(4)))
    PRINT #1, "// We are using a car called " + carname$ + " with carcol " + carcol$
    PRINT #1, "// Weather is " + weather$
    PRINT #1, "// Camera is located at: " + LTRIM$(STR$(startcamera(1))) + " " + LTRIM$(STR$(startcamera(2))) + " " + LTRIM$(STR$(startcamera(3)))
    PRINT #1, "//"
    PRINT #1, "// Coordinates for the mission are:"
    FOR i = 1 TO pickupamount%
        PRINT #1, "// " + LTRIM$(STR$(coords(1, i))) + " " + LTRIM$(STR$(coords(2, i))) + " " + LTRIM$(STR$(coords(3, i)))
    NEXT i
    PRINT #1, "//"
    PRINT #1, ""

    PRINT #1, ""
    PRINT #1, "// Mission start stuff"
    PRINT #1, ""
    PRINT #1, ":MIS_" + threadname$
    PRINT #1, "gosub @MISSION_START_" + course_name$
    PRINT #1, "GOSUB @MISSION_CLEANUP_" + course_name$
    PRINT #1, "end_thread"
    PRINT #1, ""
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // ----------------------R             MISSION START         ------------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"

    PRINT #1, ""
    PRINT #1, ":MISSION_START_" + course_name$
    PRINT #1, "0004: $ONMISSION = 1 "
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------R             INITIAL MISSION          ------------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "01B4: set_player $PLAYER_CHAR controllable 0 "
    PRINT #1, "0055: put_player $PLAYER_CHAR at 825.9011 -1054.3267 14.4000"
    PRINT #1, "0171: set_player $PLAYER_CHAR z_angle_to 56.0434"
    PRINT #1, "01B6: set_weather WEATHER_SUNNY"
    PRINT #1, "00C0: set_current_time 4 20"
    PRINT #1, "0169: set_fade_color 1 1 1 "
    PRINT #1, "03CB: load_scene 807.0 -937.0 36.5625"
    PRINT #1, "0247: request_model #" + carname$
    PRINT #1, "038B: load_all_models_now "
    PRINT #1, "03AF: set_streaming 1 "
    PRINT #1, "03F7: load_island_data 1"
    PRINT #1, "043C: set_game_sounds_fade 0  "
    PRINT #1, "wait 2000"
    PRINT #1, "00BA: print_big 'T4X4_1' time 10000 style 2  // Change this GXT entry to " + course_name$
    PRINT #1, "00A5: create_car #" + carname$ + " at 816.288 -1050.0724 14.5562 store_to $CAR_CHALLENGE // 158.3151 angle"
    PRINT #1, "0229: set_car $CAR_CHALLENGE color_to " + carcol$
    PRINT #1, "0169: set_fade_color 1 1 1"
    PRINT #1, "0239: actor $PLAYER_ACTOR run_to 812.0 -945.5"
    PRINT #1, "01D5: actor $PLAYER_ACTOR go_to_and_drive_car $CAR_CHALLENGE"
    PRINT #1, "wait 3000"
    PRINT #1, "fade 0 for 1000 ms"
    PRINT #1, "while fading"
    PRINT #1, "wait 0 ms"
    PRINT #1, "end"
    PRINT #1, "0369: put_player $PLAYER_CHAR in_car $CAR_CHALLENGE"
    PRINT #1, "wait 1000"
    PRINT #1, "0055: put_player $PLAYER_CHAR at " + LTRIM$(STR$(startlocation(1))) + " " + LTRIM$(STR$(startlocation(2))) + " " + LTRIM$(STR$(startlocation(3)))
    PRINT #1, "0171: set_player $PLAYER_CHAR z_angle_to " + LTRIM$(STR$(startlocation(4)))
    PRINT #1, "043C: set_game_sounds_fade 0"
    PRINT #1, "wait 1000"
    PRINT #1, ""
    PRINT #1, ""
    PRINT #1, ""
    PRINT #1, "0317: increment_mission_attempts "
    PRINT #1, "03A4: name_thread '" + threadname$ + "'"
    PRINT #1, ""
    GOSUB shared_init
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------R               SET VARIABLES          ------------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"

    PRINT #1, ""
    PRINT #1, "0004: $COUNTER_4X4_PICKUPS = 0 "
    PRINT #1, "0004: $TIMER_4X4 = 0 "
    PRINT #1, "0004: $FLAG_INTRO = 0 "
    PRINT #1, "0004: $FLAG_TIMER = 0 "
    PRINT #1, "0004: $ON_PATRIOT_PLAYGROUND_MISSION = 1 "
    PRINT #1, "0004: $FLAG_INTRO_JUMP = 0"
    PRINT #1, "0004: $PATRIOT_PLAYGROUND_HELP_FINISHED = 0 "
    PRINT #1, "0004: $RECORD_TEMP = 0 "
    PRINT #1, "0004: $blipcount = 0 "
    PRINT #1, ""
    PRINT #1, ""
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------R             COORDINATE INIT          ------------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    FOR i = 1 TO pickupamount%
        PRINT #1, "0005: $X_" + LTRIM$(STR$(i)) + " = " + LTRIM$(STR$(coords(1, i)))
        PRINT #1, "0005: $Y_" + LTRIM$(STR$(i)) + " = " + LTRIM$(STR$(coords(2, i)))
        PRINT #1, "0005: $Z_" + LTRIM$(STR$(i)) + " = " + LTRIM$(STR$(coords(3, i)))
        PRINT #1, ""
    NEXT i
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------R                 BLIP INIT            ------------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "018A: $FIRST_BLIP create_checkpoint_at $X_1 $Y_1 $Z_1"
    PRINT #1, "0167: $SECOND_BLIP create_marer_at $X_2 $Y_2 $Z_2 color 5 flag 2"
    PRINT #1, ""
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------R             MISSION SCRIPT           ------------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"

    PRINT #1, "0110: clear_player $PLAYER_CHAR wanted_level  "
    PRINT #1, "if"
    PRINT #1, " 8119:   not car $CAR_CHALLENGE wrecked "
    PRINT #1, "then"
    PRINT #1, " 020A: set_car $CAR_CHALLENGE door_status_to CARLOCK_LOCKED"
    PRINT #1, "end"
    PRINT #1, "01B4: set_player $PLAYER_CHAR controllable 0 "
    PRINT #1, "02A3: toggle_widescreen 1 "
    PRINT #1, ""
    PRINT #1, ""
    PRINT #1, ""
    PRINT #1, ""
    PRINT #1, "// - - - - MAIN LOOP - - - -"
    PRINT #1, "while 001A: " + LTRIM$(STR$(pickupamount%)) + " > $COUNTER_4X4_PICKUPS                      /////////// AMOUNT OF PICKUPS !!!"
    PRINT #1, " wait 0 ms"
    PRINT #1, " if"
    PRINT #1, "     0038: $blipcount == 0"
    PRINT #1, " then"
    PRINT #1, "     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_1 $Y_1 $Z_1"
    PRINT #1, "     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_2 $Y_2 $Z_2"
    PRINT #1, "     if"
    PRINT #1, "         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_1 $Y_1 $Z_1 radius 7.5 7.5 7.5"
    PRINT #1, "     then"
    PRINT #1, "         014E: start_timer_at $TIMER_4X4 "
    PRINT #1, "         0004: $FLAG_TIMER = 1 "
    PRINT #1, "         0164: disable_marker $FIRST_BLIP"
    PRINT #1, "         0164: disable_marker $SECOND_BLIP"
    PRINT #1, "         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_1 $Y_1 $Z_1"
    PRINT #1, "         0004: $blipcount = 1"
    PRINT #1, "         gosub @MISSION_" + course_name$ + "_CHECKPOINT_PICKED_UP"
    PRINT #1, "         018A: $FIRST_BLIP = create_checkpoint_at $X_2 $Y_2 $Z_2"
    PRINT #1, "         0167: $SECOND_BLIP = create_marker_at $X_3 $Y_3 $Z_3 color 5 flag 2"
    PRINT #1, "     end"
    PRINT #1, " end"
    PRINT #1, ""

    FOR i = 2 TO (pickupamount% - 1)
        XYZ1$ = "$X_" + LTRIM$(STR$(i)) + " $Y_" + LTRIM$(STR$(i)) + " $Z_" + LTRIM$(STR$(i))
        XYZ2$ = "$X_" + LTRIM$(STR$(i + 1)) + " $Y_" + LTRIM$(STR$(i + 1)) + " $Z_" + LTRIM$(STR$(i + 1))
        XYZ3$ = "$X_" + LTRIM$(STR$(i + 2)) + " $Y_" + LTRIM$(STR$(i + 2)) + " $Z_" + LTRIM$(STR$(i + 2))

        PRINT #1, " if"
        PRINT #1, "     0038: $blipcount == " + LTRIM$(STR$(i - 1))
        PRINT #1, " then"
        PRINT #1, "     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point " + XYZ1$
        PRINT #1, "     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point " + XYZ2$
        PRINT #1, "     if"
        PRINT #1, "         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car " + XYZ1$ + " radius 7.5 7.5 7.5"
        PRINT #1, "     then"
        PRINT #1, "         0164: disable_marker $FIRST_BLIP"
        PRINT #1, "         0164: disable_marker $SECOND_BLIP"
        PRINT #1, "         018C: play_sound SOUND_PART_MISSION_COMPLETE at " + XYZ1$
        PRINT #1, "         0008: $blipcount += 1"
        PRINT #1, "         gosub @MISSION_" + course_name$ + "_CHECKPOINT_PICKED_UP"
        PRINT #1, "         018A: $FIRST_BLIP = create_checkpoint_at " + XYZ2$
        PRINT #1, "         0167: $SECOND_BLIP = create_marker_at " + XYZ3$ + " color 5 flag 2"
        PRINT #1, "     end"
        PRINT #1, " end"
    NEXT i

    'XYZ1$ = "$X_" + LTRIM$(STR$(pickupamount% - 1)) + " $Y_" + LTRIM$(STR$(pickupamount% - 1)) + " $Z_" + LTRIM$(STR$(pickupamount% - 1))
    'XYZ2$ = "$X_" + LTRIM$(STR$(pickupamount%)) + " $Y_" + LTRIM$(STR$(pickupamount%)) + " $Z_" + LTRIM$(STR$(pickupamount%))
    'PRINT #1, " if"
    'PRINT #1, "     0038: $blipcount == " + LTRIM$(STR$(pickupamount% - 1))
    'PRINT #1, " then"
    'PRINT #1, "     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point " + XYZ1$
    'PRINT #1, "     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point " + XYZ2$
    'PRINT #1, "     if"
    'PRINT #1, "         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car " + XYZ1$ + " radius 7.5 7.5 7.5"
    'PRINT #1, "     then"
    'PRINT #1, "         0164: disable_marker $FIRST_BLIP"
    'PRINT #1, "         0164: disable_marker $SECOND_BLIP"
    'PRINT #1, "         018C: play_sound SOUND_PART_MISSION_COMPLETE at " + XYZ1$
    'PRINT #1, "         0008: $blipcount += 1"
    'PRINT #1, "         gosub @MISSION_" + course_name$ + "_CHECKPOINT_PICKED_UP"
    'PRINT #1, "         018A: $FIRST_BLIP = create_checkpoint_at " + XYZ2$
    'PRINT #1, "     end"
    'PRINT #1, " end"

    XYZ1$ = "$X_" + LTRIM$(STR$(pickupamount%)) + " $Y_" + LTRIM$(STR$(pickupamount%)) + " $Z_" + LTRIM$(STR$(pickupamount%))
    PRINT #1, " if"
    PRINT #1, "     0038: $blipcount == " + LTRIM$(STR$(pickupamount% - 1))
    PRINT #1, " then"
    PRINT #1, "     024F: create_corona 5.0 CORONATYPE_HEX FLARETYPE_NONE with_color 0 200 0 at_point " + XYZ1$
    PRINT #1, "     if"
    PRINT #1, "         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car " + XYZ1$ + " radius 12.5 12.5 12.5"
    PRINT #1, "     then"
    PRINT #1, "         0164: disable_marker $FIRST_BLIP"
    PRINT #1, "         0164: disable_marker $SECOND_BLIP"
    PRINT #1, "         018C: play_sound SOUND_PART_MISSION_COMPLETE at " + XYZ1$
    PRINT #1, "         0008: $blipcount += 1"
    PRINT #1, "         gosub @MISSION_" + course_name$ + "_CHECKPOINT_PICKED_UP"
    PRINT #1, "     end"
    PRINT #1, " end"



    PRINT #1, ""
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------R                INTRO START           ------------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, ""
    PRINT #1, " if"
    PRINT #1, "     0038:   $PATRIOT_PLAYGROUND_HELP_FINISHED == 0 "
    PRINT #1, " then"
    PRINT #1, "     01B4: set_player $PLAYER_CHAR controllable 0"
    PRINT #1, "     015F: set_camera_position " + LTRIM$(STR$(startcamera(1))) + " " + LTRIM$(STR$(startcamera(2))) + " " + LTRIM$(STR$(startcamera(3))) + " 0.0 rotation 0.0 0.0"
    PRINT #1, "     03CB: load_scene " + LTRIM$(STR$(startlocation(1))) + " " + LTRIM$(STR$(startlocation(2))) + " " + LTRIM$(STR$(startlocation(3)))
    PRINT #1, "     0160: point_camera " + LTRIM$(STR$(startlocation(1))) + " " + LTRIM$(STR$(startlocation(2))) + " " + LTRIM$(STR$(startlocation(3))) + " switchstyle JUMP_CUT"
    PRINT #1, "     016A: fade 1 for 1500 ms "
    PRINT #1, "     while fading"
    PRINT #1, "         wait 0 ms   "
    PRINT #1, "     end"
    PRINT #1, "     wait 2000        "
    PRINT #1, " "
    PRINT #1, "     if"
    PRINT #1, "         8119:   not car $CAR_CHALLENGE wrecked "
    PRINT #1, "     then"
    PRINT #1, "         020A: set_car $CAR_CHALLENGE door_status_to CARLOCK_UNLOCKED"
    PRINT #1, "     end"
    PRINT #1, ""
    PRINT #1, "        016A: fade 0 for 1500 ms"
    PRINT #1, "     while fading"
    PRINT #1, "         wait 0 ms"
    PRINT #1, "     end"
    PRINT #1, "        02A3: toggle_widescreen 0"
    PRINT #1, "     01B4: set_player $PLAYER_CHAR controllable 1"
    PRINT #1, "        02EB: restore_camera_jumpcut "
    PRINT #1, "             016A: fade 1 for 1500 ms"
    PRINT #1, "     while fading"
    PRINT #1, "         wait 0 ms"
    PRINT #1, "     end"
    PRINT #1, "     00BE: clear_prints"
    PRINT #1, ""
    PRINT #1, "        0004: $PATRIOT_PLAYGROUND_HELP_FINISHED = 1"
    PRINT #1, " end"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------R    TIMER STARTED - FAIL CONDITION      ----------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, " "
    PRINT #1, " if"
    PRINT #1, "     0038:   $FLAG_TIMER == 1 "
    PRINT #1, " then"
    PRINT #1, "     if"
    PRINT #1, "         001A:   1 > $TIMER_4X4"
    PRINT #1, "     then"
    PRINT #1, "         00BC: print_now 'TAXI2' time 3000 flag 1  // ~r~You're out of time!"
    PRINT #1, "         goto @MISSION_" + course_name$ + "_FAILED"
    PRINT #1, "     end"
    PRINT #1, " end"
    PRINT #1, " if"
    PRINT #1, "     80DE:   not is_player_in_model $PLAYER_CHAR model #" + carname$
    PRINT #1, " then"
    PRINT #1, "     00BC: print_now 'T4X4_F' time 3000 flag 1  // ~r~You bailed! Too tough for you?!"
    PRINT #1, "     goto @MISSION_" + course_name$ + "_FAILED"
    PRINT #1, " end"
    PRINT #1, "end"
    PRINT #1, ""
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------R    TIMER STARTED - WIN CONDITION       ----------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, ""
    PRINT #1, ""
    PRINT #1, "if"
    PRINT #1, " 0038:   $COUNTER_4X4_PICKUPS == " + LTRIM$(STR$(pickupamount%)) + "   // CP amount "
    PRINT #1, "then"
    PRINT #1, " goto @MISSION_" + course_name$ + "_PASSED"
    PRINT #1, "end"
    PRINT #1, ""
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------R      CHECKPOINT PICK UP                ----------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, ""
    PRINT #1, ""
    PRINT #1, ":MISSION_" + course_name$ + "_CHECKPOINT_PICKED_UP"
    PRINT #1, "0008: $COUNTER_4X4_PICKUPS += 1 "
    PRINT #1, "0008: $TIMER_4X4 += " + LTRIM$(STR$(reward%)) + "000"
    PRINT #1, "01E5: text_1number_highpriority 'T4X4_1B' $COUNTER_4X4_PICKUPS flag 30000 time 1  // ~1~ of many!"
    PRINT #1, "return"
    PRINT #1, ""
    PRINT #1, ""
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------R       MISSION FAIL ROUTINE             ----------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, ""
    PRINT #1, ":MISSION_" + course_name$ + "_FAILED"
    PRINT #1, "00BA: print_big 'M_FAIL' time 2000 style 1  // MISSION FAILED!"
    PRINT #1, "0255: set_critical_mission_restart_at 825.9011 -1054.3267 14.4000 angle 56.0434"
    PRINT #1, "0322: kill_player $PLAYER_CHAR"
    PRINT #1, "wait 2000 ms"
    PRINT #1, "goto @MISSION_CLEANUP_" + course_name$
    PRINT #1, "return"
    PRINT #1, ""
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------R    MISSION COMPLETE ROUTINE            ----------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, ""
    PRINT #1, ":MISSION_" + course_name$ + "_PASSED"
    PRINT #1, "0004: $COURSE_" + course_name$ + " = $TIMER_4X4"
    PRINT #1, "014F: stop_timer $TIMER_4X4"
    PRINT #1, "01B4: set_player $PLAYER_CHAR controllable 0"
    PRINT #1, "016A: fade 0 for 1500 ms"
    PRINT #1, "while fading"
    PRINT #1, "   wait 0 ms"
    PRINT #1, "end"
    PRINT #1, "0110: clear_player $PLAYER_CHAR wanted_level "
    PRINT #1, "0164: disable_marker $FIRST_BLIP"
    PRINT #1, "0164: disable_marker $SECOND_BLIP"
    PRINT #1, "02A3: toggle_widescreen 1"
    PRINT #1, "     015F: set_camera_position " + LTRIM$(STR$(startcamera(1))) + " " + LTRIM$(STR$(startcamera(2))) + " " + LTRIM$(STR$(startcamera(3))) + " 0.0 rotation 0.0 0.0"
    PRINT #1, "     03CB: load_scene " + LTRIM$(STR$(startlocation(1))) + " " + LTRIM$(STR$(startlocation(2))) + " " + LTRIM$(STR$(startlocation(3)))
    PRINT #1, "     0160: point_camera " + LTRIM$(STR$(startlocation(1))) + " " + LTRIM$(STR$(startlocation(2))) + " " + LTRIM$(STR$(startlocation(3))) + " switchstyle JUMP_CUT"
    PRINT #1, "016A: fade 1 for 1000 ms"
    PRINT #1, "while fading"
    PRINT #1, "   wait 0 ms"
    PRINT #1, "end"
    PRINT #1, "01E3: text_1number_styled 'M_PASS' number 20000 time 5000 style 1  // MISSION PASSED! $~1~"
    PRINT #1, "0394: play_music 1       "
    PRINT #1, "wait 4000"
    PRINT #1, "016A: fade 0 for 1000 ms"
    PRINT #1, "while fading"
    PRINT #1, "   wait 0 ms"
    PRINT #1, "end"
    PRINT #1, "012A: put_player $PLAYER_CHAR at 825.9011 -1054.3267 14.4000 and_remove_from_car"
    PRINT #1, "0171: set_player $PLAYER_CHAR z_angle_to 56.0434"
    PRINT #1, "02EB: restore_camera_jumpcut "
    PRINT #1, "02A3: toggle_widescreen 0"
    PRINT #1, "00D8: mission_has_finished "
    PRINT #1, "wait 1"
    PRINT #1, "016A: fade 1 for 1000 ms"
    PRINT #1, "while fading"
    PRINT #1, "   wait 0 ms"
    PRINT #1, "end "
    PRINT #1, "wait 1000 ms"
    PRINT #1, "0004: $ONMISSION = 0 "
    PRINT #1, "0051: return"
    PRINT #1, "return"
    PRINT #1, ""
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, "    // -------------------R    MISSION BAD ENDING ROUTINE          ----------------------------------"
    PRINT #1, "    // ----------------------------------------------------------------------------------------------"
    PRINT #1, ""
    PRINT #1, ":MISSION_CLEANUP_" + course_name$
    PRINT #1, "01B4: set_player $PLAYER_CHAR controllable 0"
    PRINT #1, "0164: disable_marker $FIRST_BLIP"
    PRINT #1, "0164: disable_marker $SECOND_BLIP"
    PRINT #1, "02EB: restore_camera_jumpcut "
    PRINT #1, "02A3: toggle_widescreen 0  "
    PRINT #1, "014F: stop_timer $TIMER_4X4 "
    PRINT #1, "0004: $ONMISSION = 0 "
    PRINT #1, "mission_cleanup "
    PRINT #1, "00D8: mission_has_finished"
    PRINT #1, "while fading"
    PRINT #1, "   wait 1000 ms"
    PRINT #1, "end "
    PRINT #1, "0051: return "

END IF

CLOSE #1
RETURN




shared_init:
PRINT #1, "    // ----------------------------------------------------------------------------------------------"
PRINT #1, "    // -------------------S                  SET SHARED          ------------------------------------"
PRINT #1, "    // ----------------------------------------------------------------------------------------------"
IF police$ = "0" THEN PRINT #1, "0004: $polmulti = 0": maxwanted% = 0
IF police$ = "1" THEN PRINT #1, "0004: $polmulti = 0.3": maxwanted% = 2
IF police$ = "2" THEN PRINT #1, "0004: $polmulti = 0.4": maxwanted% = 3
IF police$ = "3" THEN PRINT #1, "0004: $polmulti = 0.7": maxwanted% = 4
IF police$ = "4" THEN PRINT #1, "0004: $polmulti = 1.4": maxwanted% = 5
IF police$ = "5" THEN PRINT #1, "0004: $polmulti = 1.3": maxwanted% = 6
IF police$ = "6" THEN PRINT #1, "0004: $polmulti = 1": maxwanted% = 3
IF police$ = "7" THEN PRINT #1, "0004: $polmulti = 3": maxwanted% = 4
IF police$ = "8" THEN PRINT #1, "0004: $polmulti = 4": maxwanted% = 5
IF police$ = "9" THEN PRINT #1, "0004: $polmulti = 5": maxwanted% = 6

RETURN





readcoords:
PRINT "Checkpoint stuff..."
INPUT #1, tempvar$
startlocation(1) = VAL(tempvar$)
INPUT #1, tempvar$
startlocation(2) = VAL(tempvar$)
INPUT #1, tempvar$
startlocation(3) = VAL(tempvar$)
INPUT #1, tempvar$
startlocation(4) = VAL(tempvar$)
LOCATE 1, 1: PRINT "START " + "X: " + LTRIM$(STR$(startlocation(1))) + " Y: " + LTRIM$(STR$(startlocation(2))) + " Z: " + LTRIM$(STR$(startlocation(3))) + " A: " + LTRIM$(STR$(startlocation(4)))
INPUT #1, tempvar$
startcamera(1) = VAL(tempvar$)
INPUT #1, tempvar$
startcamera(2) = VAL(tempvar$)
INPUT #1, tempvar$
startcamera(3) = VAL(tempvar$)




FOR i = 1 TO pickupamount%
    LOCATE 10, 1
    PRINT "Reading: " + LTRIM$(STR$(i)) + "/" + LTRIM$(STR$(pickupamount%))
    tempvar$ = ""
    INPUT #1, tempvar$
    coords(1, i) = VAL(tempvar$)
    LOCATE 11, 1: PRINT "                            "
    LOCATE 11, 1: PRINT "Checkpoint " + LTRIM$(STR$(i)) + " X: " + LTRIM$(STR$(coords(1, i)))
    INPUT #1, tempvar$
    coords(2, i) = VAL(tempvar$)
    LOCATE 12, 1: PRINT "                            "
    LOCATE 12, 1: PRINT "Checkpoint " + LTRIM$(STR$(i)) + " Y: " + LTRIM$(STR$(coords(2, i)))
    INPUT #1, tempvar$
    coords(3, i) = VAL(tempvar$)
    LOCATE 13, 1: PRINT "                            "
    LOCATE 13, 1: PRINT "Checkpoint " + LTRIM$(STR$(i)) + " Z: " + LTRIM$(STR$(coords(3, i)))
    _DISPLAY
NEXT i
RETURN


