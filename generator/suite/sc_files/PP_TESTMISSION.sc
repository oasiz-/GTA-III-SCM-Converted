    // ----------------------------------------------------------------------------------------------
    // -------------------           MISSION GENERATE OUTOUT     ------------------------------------
    // ----------------------------------------------------------------------------------------------

// Dodo_City (Internally called Dodo_Ci) has the following parameters:
// Starting coordinate: 195.14 -468.12 26.50  Angle: 333.64
// We are using a car called 126 with carcol 3 3
// Weather is 0
// Camera is located at: 179.81 -493.96 42.32
//
// Coordinates for the mission are:
// 199.83 -460.21 26.49
// 252.48 -134.66 27.31
// 390.28 112.37 34.09
// 545.16 -245.48 6.46
// 344.09 -179.80 38.81
// 89.36 -384.21 84.73
// 98.34 -836.80 77.97
// 145.70 -1006.50 31.75
// 149.21 -1144.07 60.17
// 115.71 -1433.49 70.89
// -45.73 -1414.46 123.37
// 23.59 -1630.78 36.99
// 403.73 -1448.37 41.32
// 409.23 -1178.03 43.43
// 411.05 -943.52 26.70

// Mission start stuff

:MIS_Clinic
gosub @MISSION_START_Dodo_City
GOSUB @MISSION_CLEANUP_Dodo_City
end_thread

    // ----------------------------------------------------------------------------------------------
    // ----------------------R             MISSION START         ------------------------------------
    // ----------------------------------------------------------------------------------------------
    // ----------------------------------------------------------------------------------------------
    // ----------------------------------------------------------------------------------------------
    // ----------------------------------------------------------------------------------------------

:MISSION_START_Dodo_City
0004: $ONMISSION = 1 
    // ----------------------------------------------------------------------------------------------
    // -------------------R             INITIAL MISSION          ------------------------------------
    // ----------------------------------------------------------------------------------------------
01B4: set_player $PLAYER_CHAR controllable 0 
0055: put_player $PLAYER_CHAR at 825.9011 -1054.3267 14.4000
0171: set_player $PLAYER_CHAR z_angle_to 56.0434
01B6: set_weather WEATHER_SUNNY
00C0: set_current_time 4 20
0169: set_fade_color 1 1 1 
03CB: load_scene 807.0 -937.0 36.5625
0247: request_model 126
038B: load_all_models_now 
03AF: set_streaming 1 
03F7: load_island_data 1
043C: set_game_sounds_fade 0  
while fading
  wait 0 ms
end
00BA: print_big 'T4X4_1' time 10000 style 2  // Change this GXT entry to Dodo_City
00A5: create_car 126 at 816.288 -1050.0724 14.5562 store_to $CAR_CHALLENGE // 158.3151 angle
0229: set_car $CAR_CHALLENGE color_to 3 3
0169: set_fade_color 1 1 1
0239: actor $PLAYER_ACTOR run_to 812.0 -945.5
01D5: actor $PLAYER_ACTOR go_to_and_drive_car $CAR_CHALLENGE
wait 2000
fade 0 for 2500 ms
while fading
wait 0 ms
end
:Isplayerincar_Dodo_City
if
  80DE: not is_player_in_model $PLAYER_CHAR model 126
then
  if
    0119: car $CAR_CHALLENGE wrecked
  then
    goto @MISSION_Dodo_City_FAILED
  end
  wait 0 ms
  goto @Isplayerincar_Dodo_City
end
0055: put_player $PLAYER_CHAR at 195.14 -468.12 26.50
0175: set_car $CAR_CHALLENGE z_angle_to 333.64
wait 1000



0317: increment_mission_attempts 
03A4: name_thread 'Dodo_Ci'

    // ----------------------------------------------------------------------------------------------
    // -------------------S                  SET SHARED          ------------------------------------
    // ----------------------------------------------------------------------------------------------
    // ----------------------------------------------------------------------------------------------
    // -------------------                SET VARIABLES          ------------------------------------
    // ----------------------------------------------------------------------------------------------

0004: $COUNTER_4X4_PICKUPS = 0 
0004: $TIMER_4X4 = 0 
0004: $FLAG_INTRO = 0 
0004: $FLAG_TIMER = 0 
0004: $ON_PATRIOT_PLAYGROUND_MISSION = 1 
0004: $FLAG_INTRO_JUMP = 0
0004: $PATRIOT_PLAYGROUND_HELP_FINISHED = 0 
0004: $RECORD_TEMP = 0 
0004: $introticks = 75
0004: $blipcount = 0

0005: $police_per_cp =  0
    // ----------------------------------------------------------------------------------------------
    // -------------------R             COORDINATE INIT          ------------------------------------
    // ----------------------------------------------------------------------------------------------
0005: $X_1 = 199.83
0005: $Y_1 = -460.21
0005: $Z_1 = 26.49

0005: $X_2 = 252.48
0005: $Y_2 = -134.66
0005: $Z_2 = 27.31

0005: $X_3 = 390.28
0005: $Y_3 = 112.37
0005: $Z_3 = 34.09

0005: $X_4 = 545.16
0005: $Y_4 = -245.48
0005: $Z_4 = 6.46

0005: $X_5 = 344.09
0005: $Y_5 = -179.80
0005: $Z_5 = 38.81

0005: $X_6 = 89.36
0005: $Y_6 = -384.21
0005: $Z_6 = 84.73

0005: $X_7 = 98.34
0005: $Y_7 = -836.80
0005: $Z_7 = 77.97

0005: $X_8 = 145.70
0005: $Y_8 = -1006.50
0005: $Z_8 = 31.75

0005: $X_9 = 149.21
0005: $Y_9 = -1144.07
0005: $Z_9 = 60.17

0005: $X_10 = 115.71
0005: $Y_10 = -1433.49
0005: $Z_10 = 70.89

0005: $X_11 = -45.73
0005: $Y_11 = -1414.46
0005: $Z_11 = 123.37

0005: $X_12 = 23.59
0005: $Y_12 = -1630.78
0005: $Z_12 = 36.99

0005: $X_13 = 403.73
0005: $Y_13 = -1448.37
0005: $Z_13 = 41.32

0005: $X_14 = 409.23
0005: $Y_14 = -1178.03
0005: $Z_14 = 43.43

0005: $X_15 = 411.05
0005: $Y_15 = -943.52
0005: $Z_15 = 26.70

    // ----------------------------------------------------------------------------------------------
    // -------------------R                 BLIP INIT            ------------------------------------
    // ----------------------------------------------------------------------------------------------
018A: $FIRST_BLIP create_checkpoint_at $X_1 $Y_1 $Z_1
0167: $SECOND_BLIP create_marer_at $X_2 $Y_2 $Z_2 color 5 flag 2

    // ----------------------------------------------------------------------------------------------
    // -------------------R             MISSION SCRIPT           ------------------------------------
    // ----------------------------------------------------------------------------------------------
0110: clear_player $PLAYER_CHAR wanted_level  
if
 8119:   not car $CAR_CHALLENGE wrecked 
then
 020A: set_car $CAR_CHALLENGE door_status_to CARLOCK_LOCKED
end
01B4: set_player $PLAYER_CHAR controllable 0 
02A3: toggle_widescreen 1 




// - - - - MAIN LOOP - - - -
while 001A: 15 > $COUNTER_4X4_PICKUPS                      /////////// AMOUNT OF PICKUPS !!!
 wait 0 ms
if
  0119: car $CAR_CHALLENGE wrecked
then
  goto @MISSION_Dodo_City_FAILED
end
 if
     0038: $blipcount == 0
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_1 $Y_1 $Z_1
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_2 $Y_2 $Z_2
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_1 $Y_1 $Z_1 radius 7.5 7.5 7.5
     then
         014E: start_timer_at $TIMER_4X4 
         0004: $FLAG_TIMER = 1 
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_1 $Y_1 $Z_1
         0004: $blipcount = 1
         gosub @MISSION_Dodo_City_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_2 $Y_2 $Z_2
         0167: $SECOND_BLIP = create_marker_at $X_3 $Y_3 $Z_3 color 5 flag 2
     end
 end

 if
     0038: $blipcount == 1
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_2 $Y_2 $Z_2
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_3 $Y_3 $Z_3
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_2 $Y_2 $Z_2 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_2 $Y_2 $Z_2
         0008: $blipcount += 1
         gosub @MISSION_Dodo_City_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_3 $Y_3 $Z_3
         0167: $SECOND_BLIP = create_marker_at $X_4 $Y_4 $Z_4 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 2
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_3 $Y_3 $Z_3
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_4 $Y_4 $Z_4
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_3 $Y_3 $Z_3 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_3 $Y_3 $Z_3
         0008: $blipcount += 1
         gosub @MISSION_Dodo_City_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_4 $Y_4 $Z_4
         0167: $SECOND_BLIP = create_marker_at $X_5 $Y_5 $Z_5 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 3
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_4 $Y_4 $Z_4
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_5 $Y_5 $Z_5
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_4 $Y_4 $Z_4 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_4 $Y_4 $Z_4
         0008: $blipcount += 1
         gosub @MISSION_Dodo_City_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_5 $Y_5 $Z_5
         0167: $SECOND_BLIP = create_marker_at $X_6 $Y_6 $Z_6 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 4
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_5 $Y_5 $Z_5
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_6 $Y_6 $Z_6
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_5 $Y_5 $Z_5 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_5 $Y_5 $Z_5
         0008: $blipcount += 1
         gosub @MISSION_Dodo_City_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_6 $Y_6 $Z_6
         0167: $SECOND_BLIP = create_marker_at $X_7 $Y_7 $Z_7 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 5
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_6 $Y_6 $Z_6
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_7 $Y_7 $Z_7
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_6 $Y_6 $Z_6 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_6 $Y_6 $Z_6
         0008: $blipcount += 1
         gosub @MISSION_Dodo_City_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_7 $Y_7 $Z_7
         0167: $SECOND_BLIP = create_marker_at $X_8 $Y_8 $Z_8 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 6
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_7 $Y_7 $Z_7
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_8 $Y_8 $Z_8
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_7 $Y_7 $Z_7 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_7 $Y_7 $Z_7
         0008: $blipcount += 1
         gosub @MISSION_Dodo_City_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_8 $Y_8 $Z_8
         0167: $SECOND_BLIP = create_marker_at $X_9 $Y_9 $Z_9 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 7
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_8 $Y_8 $Z_8
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_9 $Y_9 $Z_9
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_8 $Y_8 $Z_8 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_8 $Y_8 $Z_8
         0008: $blipcount += 1
         gosub @MISSION_Dodo_City_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_9 $Y_9 $Z_9
         0167: $SECOND_BLIP = create_marker_at $X_10 $Y_10 $Z_10 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 8
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_9 $Y_9 $Z_9
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_10 $Y_10 $Z_10
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_9 $Y_9 $Z_9 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_9 $Y_9 $Z_9
         0008: $blipcount += 1
         gosub @MISSION_Dodo_City_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_10 $Y_10 $Z_10
         0167: $SECOND_BLIP = create_marker_at $X_11 $Y_11 $Z_11 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 9
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_10 $Y_10 $Z_10
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_11 $Y_11 $Z_11
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_10 $Y_10 $Z_10 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_10 $Y_10 $Z_10
         0008: $blipcount += 1
         gosub @MISSION_Dodo_City_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_11 $Y_11 $Z_11
         0167: $SECOND_BLIP = create_marker_at $X_12 $Y_12 $Z_12 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 10
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_11 $Y_11 $Z_11
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_12 $Y_12 $Z_12
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_11 $Y_11 $Z_11 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_11 $Y_11 $Z_11
         0008: $blipcount += 1
         gosub @MISSION_Dodo_City_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_12 $Y_12 $Z_12
         0167: $SECOND_BLIP = create_marker_at $X_13 $Y_13 $Z_13 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 11
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_12 $Y_12 $Z_12
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_13 $Y_13 $Z_13
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_12 $Y_12 $Z_12 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_12 $Y_12 $Z_12
         0008: $blipcount += 1
         gosub @MISSION_Dodo_City_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_13 $Y_13 $Z_13
         0167: $SECOND_BLIP = create_marker_at $X_14 $Y_14 $Z_14 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 12
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_13 $Y_13 $Z_13
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_14 $Y_14 $Z_14
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_13 $Y_13 $Z_13 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_13 $Y_13 $Z_13
         0008: $blipcount += 1
         gosub @MISSION_Dodo_City_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_14 $Y_14 $Z_14
         0167: $SECOND_BLIP = create_marker_at $X_15 $Y_15 $Z_15 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 13
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_14 $Y_14 $Z_14
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_15 $Y_15 $Z_15
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_14 $Y_14 $Z_14 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_14 $Y_14 $Z_14
         0008: $blipcount += 1
         gosub @MISSION_Dodo_City_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_15 $Y_15 $Z_15
         0167: $SECOND_BLIP = create_marker_at $X_16 $Y_16 $Z_16 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 14
 then
     024F: create_corona 5.0 CORONATYPE_HEX FLARETYPE_NONE with_color 0 200 0 at_point $X_15 $Y_15 $Z_15
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_15 $Y_15 $Z_15 radius 12.5 12.5 12.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_15 $Y_15 $Z_15
         0008: $blipcount += 1
         gosub @MISSION_Dodo_City_CHECKPOINT_PICKED_UP
     end
 end

    // ----------------------------------------------------------------------------------------------
    // -------------------S                INTRO START           ------------------------------------
    // ----------------------------------------------------------------------------------------------

 if
     0038:   $PATRIOT_PLAYGROUND_HELP_FINISHED == 0 
 then
     0004: $introskipz = 0
     01B4: set_player $PLAYER_CHAR controllable 0
     015F: set_camera_position 179.81 -493.96 42.32 0.0 rotation 0.0 0.0
     03CB: load_scene 195.14 -468.12 26.50
     0160: point_camera 195.14 -468.12 26.50 switchstyle JUMP_CUT
     016A: fade 1 for 1500 ms 
     while fading
         wait 0 ms   
         if and
               00E1: is_button_pressed PAD1 button CROSS
               0038: $introskipz == 0
         then
               0004: $introticks = 5
               0004: $introskipz = 1
         end
     end
     :INTROLOOP_Dodo_City
     if and
           00E1: is_button_pressed PAD1 button CROSS
           0038: $introskipz == 0
     then
           0004: $introticks = 5
           0004: $introskipz = 1
     end
     if
           0018: $introticks = 5
     then
           wait 5 ms
           000C: $introticks -= 1
           goto @INTROLOOP_Dodo_City
     end
 
     if
         8119:   not car $CAR_CHALLENGE wrecked 
     then
         020A: set_car $CAR_CHALLENGE door_status_to CARLOCK_UNLOCKED
     end

        016A: fade 0 for 1500 ms
     while fading
         wait 0 ms
     end
     02A3: toggle_widescreen 0
     02EB: restore_camera_jumpcut 
    wait 10 ms
     016A: fade 1 for 1500 ms
     while fading
         wait 0 ms
         01B4: set_player $PLAYER_CHAR controllable 1
     end
     00BE: clear_prints

        0004: $PATRIOT_PLAYGROUND_HELP_FINISHED = 1
 end
    // ----------------------------------------------------------------------------------------------
    // -------------------R    TIMER STARTED - FAIL CONDITION      ----------------------------------
    // ----------------------------------------------------------------------------------------------
 
 if
     0038:   $FLAG_TIMER == 1 
 then
     if
         001A:   1 > $TIMER_4X4
     then
         00BC: print_now 'TAXI2' time 3000 flag 1  // ~r~You're out of time!
         goto @MISSION_Dodo_City_FAILED
     end
 end
 if
     80DE:   not is_player_in_model $PLAYER_CHAR model 126
 then
     00BC: print_now 'T4X4_F' time 3000 flag 1  // ~r~You bailed! Too tough for you?!
     goto @MISSION_Dodo_City_FAILED
 end
end

    // ----------------------------------------------------------------------------------------------
    // -------------------R    TIMER STARTED - WIN CONDITION       ----------------------------------
    // ----------------------------------------------------------------------------------------------


if
 0038:   $COUNTER_4X4_PICKUPS == 15   // CP amount 
then
 goto @MISSION_Dodo_City_PASSED
end

    // ----------------------------------------------------------------------------------------------
    // -------------------R      CHECKPOINT PICK UP                ----------------------------------
    // ----------------------------------------------------------------------------------------------


:MISSION_Dodo_City_CHECKPOINT_PICKED_UP
0008: $COUNTER_4X4_PICKUPS += 1 
0008: $TIMER_4X4 += 15000
01E5: text_1number_highpriority 'T4X4_1B' $COUNTER_4X4_PICKUPS flag 30000 time 1  // ~1~ of many!
return


    // ----------------------------------------------------------------------------------------------
    // -------------------R       MISSION FAIL ROUTINE             ----------------------------------
    // ----------------------------------------------------------------------------------------------

:MISSION_Dodo_City_FAILED
00BA: print_big 'M_FAIL' time 2000 style 1  // MISSION FAILED!
0255: set_critical_mission_restart_at 825.9011 -1054.3267 14.4000 angle 56.0434
0322: kill_player $PLAYER_CHAR
wait 2000 ms
goto @MISSION_CLEANUP_Dodo_City
return

    // ----------------------------------------------------------------------------------------------
    // -------------------R    MISSION COMPLETE ROUTINE            ----------------------------------
    // ----------------------------------------------------------------------------------------------

:MISSION_Dodo_City_PASSED
0004: $COURSE_Dodo_City = $TIMER_4X4
014F: stop_timer $TIMER_4X4
01B4: set_player $PLAYER_CHAR controllable 0
016A: fade 0 for 1500 ms
while fading
   wait 0 ms
end
0110: clear_player $PLAYER_CHAR wanted_level 
0164: disable_marker $FIRST_BLIP
0164: disable_marker $SECOND_BLIP
02A3: toggle_widescreen 1
     015F: set_camera_position 179.81 -493.96 42.32 0.0 rotation 0.0 0.0
     03CB: load_scene 195.14 -468.12 26.50
     0160: point_camera 195.14 -468.12 26.50 switchstyle JUMP_CUT
016A: fade 1 for 1000 ms
while fading
   wait 0 ms
end
01E3: text_1number_styled 'M_PASS' number 20000 time 5000 style 1  // MISSION PASSED! $~1~
0394: play_music 1       
wait 4000
016A: fade 0 for 1000 ms
while fading
   wait 0 ms
end
012A: put_player $PLAYER_CHAR at 825.9011 -1054.3267 14.4000 and_remove_from_car
0171: set_player $PLAYER_CHAR z_angle_to 56.0434
02EB: restore_camera_jumpcut 
02A3: toggle_widescreen 0
00D8: mission_has_finished 
wait 1
016A: fade 1 for 1000 ms
while fading
   wait 0 ms
end 
wait 1000 ms
0004: $ONMISSION = 0 
0051: return
return

    // ----------------------------------------------------------------------------------------------
    // -------------------R    MISSION BAD ENDING ROUTINE          ----------------------------------
    // ----------------------------------------------------------------------------------------------

:MISSION_CLEANUP_Dodo_City
01B4: set_player $PLAYER_CHAR controllable 0
0164: disable_marker $FIRST_BLIP
0164: disable_marker $SECOND_BLIP
02EB: restore_camera_jumpcut 
02A3: toggle_widescreen 0  
014F: stop_timer $TIMER_4X4 
0004: $ONMISSION = 0 
mission_cleanup 
00D8: mission_has_finished
while fading
   wait 1000 ms
end 
0051: return 
