    // ----------------------------------------------------------------------------------------------
    // -------------------           MISSION GENERATE OUTOUT     ------------------------------------
    // ----------------------------------------------------------------------------------------------

// Clinic_course (Internally called clinic) has the following parameters:
// Starting coordinate: 994.1072 -80.4221 4.2526  Angle: 97.7364
// We are using a car called BANSHEE with carcol 33 51
// Weather is WEATHER_SUNNY
// Camera is located at: 917.9661 -79.6807 7.1198
//
// Coordinates for the mission are:
// 919.5564 -85.7166 -1.5846
// 816.4901 -253.3982 3.3959
// 816.1395 -506.6298 14.5003
// 816.3753 -844.1661 14.5818
// 1008.518 -1030.675 14.3494
// 1326.133 -960.9858 14.3492
// 1352.698 -807.5165 14.4008
// 1200.289 -581.8907 19.3994
// 1195.296 -209.9652 24.2503
// 1370.524 -282.8221 49.4027
// 1387.014 -493.0442 48.7843
// 1422.405 -626.1753 11.7669
//


// Mission start stuff

:MIS_clinic
gosub @MISSION_START_Clinic_course
GOSUB @MISSION_CLEANUP_Clinic_course
end_thread

    // ----------------------------------------------------------------------------------------------
    // ----------------------R             MISSION START         ------------------------------------
    // ----------------------------------------------------------------------------------------------
    // ----------------------------------------------------------------------------------------------
    // ----------------------------------------------------------------------------------------------
    // ----------------------------------------------------------------------------------------------

:MISSION_START_Clinic_course
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
0247: request_model #BANSHEE
038B: load_all_models_now 
03AF: set_streaming 1 
03F7: load_island_data 1
043C: set_game_sounds_fade 0  
wait 2000
00BA: print_big 'T4X4_1' time 10000 style 2  // Change this GXT entry to Clinic_course
00A5: create_car #BANSHEE at 816.288 -1050.0724 14.5562 store_to $CAR_CHALLENGE // 158.3151 angle
0229: set_car $CAR_CHALLENGE color_to 33 51
0169: set_fade_color 1 1 1
0239: actor $PLAYER_ACTOR run_to 812.0 -945.5
01D5: actor $PLAYER_ACTOR go_to_and_drive_car $CAR_CHALLENGE
wait 3000
fade 0 for 1000 ms
while fading
wait 0 ms
end
0369: put_player $PLAYER_CHAR in_car $CAR_CHALLENGE
wait 1000
0055: put_player $PLAYER_CHAR at 994.1072 -80.4221 4.2526
0171: set_player $PLAYER_CHAR z_angle_to 97.7364
043C: set_game_sounds_fade 0
wait 1000



0317: increment_mission_attempts 
03A4: name_thread 'clinic'

    // ----------------------------------------------------------------------------------------------
    // -------------------S                  SET SHARED          ------------------------------------
    // ----------------------------------------------------------------------------------------------
0005: $police_per_cp =  0
    // ----------------------------------------------------------------------------------------------
    // -------------------R               SET VARIABLES          ------------------------------------
    // ----------------------------------------------------------------------------------------------

0004: $COUNTER_4X4_PICKUPS = 0 
0004: $TIMER_4X4 = 0 
0004: $FLAG_INTRO = 0 
0004: $FLAG_TIMER = 0 
0004: $ON_PATRIOT_PLAYGROUND_MISSION = 1 
0004: $FLAG_INTRO_JUMP = 0
0004: $PATRIOT_PLAYGROUND_HELP_FINISHED = 0 
0004: $RECORD_TEMP = 0 
0004: $blipcount = 0 


    // ----------------------------------------------------------------------------------------------
    // -------------------R             COORDINATE INIT          ------------------------------------
    // ----------------------------------------------------------------------------------------------
0005: $X_1 = 919.5564
0005: $Y_1 = -85.7166
0005: $Z_1 = -1.5846

0005: $X_2 = 816.4901
0005: $Y_2 = -253.3982
0005: $Z_2 = 3.3959

0005: $X_3 = 816.1395
0005: $Y_3 = -506.6298
0005: $Z_3 = 14.5003

0005: $X_4 = 816.3753
0005: $Y_4 = -844.1661
0005: $Z_4 = 14.5818

0005: $X_5 = 1008.518
0005: $Y_5 = -1030.675
0005: $Z_5 = 14.3494

0005: $X_6 = 1326.133
0005: $Y_6 = -960.9858
0005: $Z_6 = 14.3492

0005: $X_7 = 1352.698
0005: $Y_7 = -807.5165
0005: $Z_7 = 14.4008

0005: $X_8 = 1200.289
0005: $Y_8 = -581.8907
0005: $Z_8 = 19.3994

0005: $X_9 = 1195.296
0005: $Y_9 = -209.9652
0005: $Z_9 = 24.2503

0005: $X_10 = 1370.524
0005: $Y_10 = -282.8221
0005: $Z_10 = 49.4027

0005: $X_11 = 1387.014
0005: $Y_11 = -493.0442
0005: $Z_11 = 48.7843

0005: $X_12 = 1422.405
0005: $Y_12 = -626.1753
0005: $Z_12 = 11.7669

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
while 001A: 12 > $COUNTER_4X4_PICKUPS                      /////////// AMOUNT OF PICKUPS !!!
 wait 0 ms
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
         gosub @MISSION_Clinic_course_CHECKPOINT_PICKED_UP
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
         gosub @MISSION_Clinic_course_CHECKPOINT_PICKED_UP
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
         gosub @MISSION_Clinic_course_CHECKPOINT_PICKED_UP
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
         gosub @MISSION_Clinic_course_CHECKPOINT_PICKED_UP
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
         gosub @MISSION_Clinic_course_CHECKPOINT_PICKED_UP
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
         gosub @MISSION_Clinic_course_CHECKPOINT_PICKED_UP
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
         gosub @MISSION_Clinic_course_CHECKPOINT_PICKED_UP
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
         gosub @MISSION_Clinic_course_CHECKPOINT_PICKED_UP
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
         gosub @MISSION_Clinic_course_CHECKPOINT_PICKED_UP
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
         gosub @MISSION_Clinic_course_CHECKPOINT_PICKED_UP
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
         gosub @MISSION_Clinic_course_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_12 $Y_12 $Z_12
         0167: $SECOND_BLIP = create_marker_at $X_13 $Y_13 $Z_13 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 11
 then
     024F: create_corona 5.0 CORONATYPE_HEX FLARETYPE_NONE with_color 0 200 0 at_point $X_12 $Y_12 $Z_12
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_12 $Y_12 $Z_12 radius 12.5 12.5 12.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_12 $Y_12 $Z_12
         0008: $blipcount += 1
         gosub @MISSION_Clinic_course_CHECKPOINT_PICKED_UP
     end
 end

    // ----------------------------------------------------------------------------------------------
    // -------------------R                INTRO START           ------------------------------------
    // ----------------------------------------------------------------------------------------------

 if
     0038:   $PATRIOT_PLAYGROUND_HELP_FINISHED == 0 
 then
     01B4: set_player $PLAYER_CHAR controllable 0
     015F: set_camera_position 917.9661 -79.6807 7.1198 0.0 rotation 0.0 0.0
     03CB: load_scene 994.1072 -80.4221 4.2526
     0160: point_camera 994.1072 -80.4221 4.2526 switchstyle JUMP_CUT
     016A: fade 1 for 1500 ms 
     while fading
         wait 0 ms   
     end
     wait 2000        
 
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
     01B4: set_player $PLAYER_CHAR controllable 1
        02EB: restore_camera_jumpcut 
             016A: fade 1 for 1500 ms
     while fading
         wait 0 ms
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
         goto @MISSION_Clinic_course_FAILED
     end
 end
 if
     80DE:   not is_player_in_model $PLAYER_CHAR model #BANSHEE
 then
     00BC: print_now 'T4X4_F' time 3000 flag 1  // ~r~You bailed! Too tough for you?!
     goto @MISSION_Clinic_course_FAILED
 end
end

    // ----------------------------------------------------------------------------------------------
    // -------------------R    TIMER STARTED - WIN CONDITION       ----------------------------------
    // ----------------------------------------------------------------------------------------------


if
 0038:   $COUNTER_4X4_PICKUPS == 12   // CP amount 
then
 goto @MISSION_Clinic_course_PASSED
end

    // ----------------------------------------------------------------------------------------------
    // -------------------R      CHECKPOINT PICK UP                ----------------------------------
    // ----------------------------------------------------------------------------------------------


:MISSION_Clinic_course_CHECKPOINT_PICKED_UP
0008: $COUNTER_4X4_PICKUPS += 1 
0008: $TIMER_4X4 += 20000
01E5: text_1number_highpriority 'T4X4_1B' $COUNTER_4X4_PICKUPS flag 30000 time 1  // ~1~ of many!
return


    // ----------------------------------------------------------------------------------------------
    // -------------------R       MISSION FAIL ROUTINE             ----------------------------------
    // ----------------------------------------------------------------------------------------------

:MISSION_Clinic_course_FAILED
00BA: print_big 'M_FAIL' time 2000 style 1  // MISSION FAILED!
0255: set_critical_mission_restart_at 825.9011 -1054.3267 14.4000 angle 56.0434
0322: kill_player $PLAYER_CHAR
wait 2000 ms
goto @MISSION_CLEANUP_Clinic_course
return

    // ----------------------------------------------------------------------------------------------
    // -------------------R    MISSION COMPLETE ROUTINE            ----------------------------------
    // ----------------------------------------------------------------------------------------------

:MISSION_Clinic_course_PASSED
0004: $COURSE_Clinic_course = $TIMER_4X4
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
     015F: set_camera_position 917.9661 -79.6807 7.1198 0.0 rotation 0.0 0.0
     03CB: load_scene 994.1072 -80.4221 4.2526
     0160: point_camera 994.1072 -80.4221 4.2526 switchstyle JUMP_CUT
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

:MISSION_CLEANUP_Clinic_course
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
