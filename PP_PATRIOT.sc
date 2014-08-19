// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ***************************************4x4 by Far**************************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

:M00_PATRIOT
gosub @MISSION_START_CLINIC_COURSE
GOSUB @MISSION_CLEANUP_4X4ONE
end_thread

// ****************************************Mission Start************************************

:MISSION_START_CLINIC_COURSE
0004: $ONMISSION = 1 
//initial stuff for the mission
 
0055: put_player $PLAYER_CHAR at 825.9011 -1054.3267 14.4000
0171: set_player $PLAYER_CHAR z_angle_to 56.0434
016E: override_next_restart at 825.9011 -1054.3267 14.4000 angle 56.0434
00C0: set_current_time 4 20
0169: set_fade_color 1 1 1 
//016A: fade 0 for 0 ms
03CB: load_scene 807.0 -937.0 36.5625
0247: request_model #PATRIOT
038B: load_all_models_now 
03AF: set_streaming 1 
03F7: load_island_data 1
043C: set_game_sounds_fade 0  
wait 2000 
00A5: create_car #PATRIOT at 816.288 -1050.0724 14.5562 store_to $CAR_CHALLENGE // 158.3151 angle
0229: set_car $CAR_CHALLENGE color_to 33 51
fade 1 for 1000 ms
while fading
wait 0 ms
end
0169: set_fade_color 1 1 1
0239: actor $PLAYER_ACTOR run_to 812.0 -945.5
01B4: set_player $PLAYER_CHAR controllable 0
01D5: actor $PLAYER_ACTOR go_to_and_drive_car $CAR_CHALLENGE
wait 3000
fade 0 for 1000 ms
while fading
wait 0 ms
end
0369: put_player $PLAYER_CHAR in_car $CAR_CHALLENGE
wait 1000
0055: put_player $PLAYER_CHAR at 1147.713 -545.3979 21.6366
0171: set_player $PLAYER_CHAR z_angle_to 152.5056
043C: set_game_sounds_fade 0
wait 1000



0317: increment_mission_attempts 
03A4: name_thread 'T4X4_1' 

//0001: wait 2500 ms        
// Set Variables

0004: $COUNTER_4X4_PICKUPS = 0 
0004: $TIMER_4X4 = 0 
0004: $FLAG_INTRO = 0 
0004: $FLAG_TIMER = 0 
0004: $ON_PATRIOT_PLAYGROUND_MISSION = 1 
0004: $FLAG_INTRO_JUMP = 0
0004: $PATRIOT_PLAYGROUND_HELP_FINISHED = 0 

0004: $FLAG_BLIP_1 = 0 
0004: $FLAG_BLIP_2 = 0 
0004: $FLAG_BLIP_3 = 0 
0004: $FLAG_BLIP_4 = 0
0004: $FLAG_BLIP_5 = 0
0004: $FLAG_BLIP_6 = 0
0004: $FLAG_BLIP_7 = 0
0004: $FLAG_BLIP_8 = 0
0004: $FLAG_BLIP_9 = 0
0004: $FLAG_BLIP_10 = 0
0004: $FLAG_BLIP_11 = 0
0004: $FLAG_BLIP_12 = 0

0004: $RECORD_TEMP = 0 

// Set Coords
//CLINIC COURSE
//X       Y       Z       ANGLE
//1147.713 -545.3979 21.6366 152.5056     // Start
//1120.4916 -512.0543 19.968 196.207      // Start camera

//1144.491 -591.7567 14.9616 180.3846     // Entrance 
//1165.5439 -633.5999 19.9459 92.189      // Grass plantage
//1160.9181 -679.646 17.2877 98.3647      // police side rail
//1138.048 -564.4852 18.2326 274.9096     // Grass hill, misty side
//1137.3625 -540.2901 19.4987 304.9959    // Grass hill, more
//1164.6238 -518.1641 21.0994 248.6794    // Stallion corner
//1183.4482 -646.0514 26.0638 1.2797      // Grass bump on the back
//1179.0785 -567.0985 27.3045 1.8328      // That damn ledge of hope

//1140.2371 -528.9567 21.1721 179.4683    // Clinic stairs
//1171.5259 -715.6229 15.2185 290.6114    // Grass in the back
//1254.5132 -631.0382 19.9624 310.5861    // Evil ramp
//1124.4554 -654.2805 14.8627 4.2634      // Road-policestation


0005: $X_1 = 1144.491 
0005: $Y_1 = -591.7567 
0005: $Z_1 = 14.9616 

0005: $X_2 = 1165.5439 
0005: $Y_2 = -633.5999 
0005: $Z_2 = 19.9459 

0005: $X_3 = 1160.9181 
0005: $Y_3 = -679.646 
0005: $Z_3 = 17.2877 

0005: $X_4 = 1138.048
0005: $Y_4 = -564.4852
0005: $Z_4 = 18.2326
 
0005: $X_5 = 1137.3625
0005: $Y_5 = -540.2901
0005: $Z_5 = 19.4987

0005: $X_6 = 1164.6238
0005: $Y_6 = -518.1641
0005: $Z_6 = 21.0994

0005: $X_7 = 1183.4482
0005: $Y_7 = -646.0514
0005: $Z_7 = 26.0638

0005: $X_8 = 1179.0785
0005: $Y_8 = -567.0985
0005: $Z_8 = 27.3045

0005: $X_9 = 1140.2371
0005: $Y_9 = -528.9567
0005: $Z_9 = 21.1721

0005: $X_10 = 1171.5259
0005: $Y_10 = -715.6229
0005: $Z_10 = 15.2185

0005: $X_11 = 1254.5132
0005: $Y_11 = -631.0382
0005: $Z_11 = 19.9624

0005: $X_12 = 1124.4554
0005: $Y_12 = -654.2805
0005: $Z_12 = 14.8627




//Mission Script

0110: clear_player $PLAYER_CHAR wanted_level  
if
	8119:   not car $CAR_CHALLENGE wrecked 
then
	020A: set_car $CAR_CHALLENGE door_status_to CARLOCK_LOCKED
end
01B4: set_player $PLAYER_CHAR controllable 0 
02A3: toggle_widescreen 1 




018A: $BLIP_1 = create_checkpoint_at $X_1 $Y_1 $Z_1 
018A: $BLIP_2 = create_checkpoint_at $X_2 $Y_2 $Z_2 
018A: $BLIP_3 = create_checkpoint_at $X_3 $Y_3 $Z_3 
018A: $BLIP_4 = create_checkpoint_at $X_4 $Y_4 $Z_4
018A: $BLIP_5 = create_checkpoint_at $X_5 $Y_5 $Z_5
018A: $BLIP_6 = create_checkpoint_at $X_6 $Y_6 $Z_6
018A: $BLIP_7 = create_checkpoint_at $X_7 $Y_7 $Z_7
018A: $BLIP_8 = create_checkpoint_at $X_8 $Y_8 $Z_8
018A: $BLIP_9 = create_checkpoint_at $X_9 $Y_9 $Z_9
018A: $BLIP_10 = create_checkpoint_at $X_10 $Y_10 $Z_10
018A: $BLIP_11 = create_checkpoint_at $X_11 $Y_11 $Z_11
018A: $BLIP_12 = create_checkpoint_at $X_12 $Y_12 $Z_12
                                                   



while 001A:   12 > $COUNTER_4X4_PICKUPS                      /////////// AMOUNT OF PICKUPS !!!
	wait 0 ms
	if and
		0038:   $COUNTER_4X4_PICKUPS == 1 
		0038:   $FLAG_TIMER == 0 
	then
		014E: start_timer_at $TIMER_4X4 
		0004: $FLAG_TIMER = 1 
	end
	if
		0038: $FLAG_BLIP_1 == 0
	then
		024F: create_corona 1.0 CORONATYPE_HEX FLARETYPE_NONE with_color 0 200 200 at_point $X_1 $Y_1 $Z_1
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_1 $Y_1 $Z_1 radius 2.5 2.5 3.5 
		then
			0164: disable_marker $BLIP_1 
			018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_1 $Y_1 $Z_1 
			0004: $FLAG_BLIP_1 = 1 
			gosub @MISSION_4X4ONE_CHECKPOINT_PICKED_UP
		end
	end
	
	if
		0038: $FLAG_BLIP_2 == 0
	then
		024F: create_corona 1.0 CORONATYPE_HEX FLARETYPE_NONE with_color 0 200 200 at_point $X_2 $Y_2 $Z_2
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_2 $Y_2 $Z_2 radius 2.5 2.5 3.5 
		then
			0164: disable_marker $BLIP_2 
			018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_2 $Y_2 $Z_2 
			0004: $FLAG_BLIP_2 = 1 
			gosub @MISSION_4X4ONE_CHECKPOINT_PICKED_UP
		end
	end
	
	if
		0038: $FLAG_BLIP_3 == 0
	then
		024F: create_corona 1.0 CORONATYPE_HEX FLARETYPE_NONE with_color 0 200 200 at_point $X_3 $Y_3 $Z_3
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_3 $Y_3 $Z_3 radius 2.5 2.5 3.5 
		then
			0164: disable_marker $BLIP_3 
			018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_3 $Y_3 $Z_3 
			0004: $FLAG_BLIP_3 = 1 
			gosub @MISSION_4X4ONE_CHECKPOINT_PICKED_UP
		end
		end
		
		if
		0038: $FLAG_BLIP_4 == 0
	then
		024F: create_corona 1.0 CORONATYPE_HEX FLARETYPE_NONE with_color 0 200 200 at_point $X_4 $Y_4 $Z_4
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_4 $Y_4 $Z_4 radius 2.5 2.5 3.5 
		then
			0164: disable_marker $BLIP_4 
			018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_4 $Y_4 $Z_4 
			0004: $FLAG_BLIP_4 = 1 
			gosub @MISSION_4X4ONE_CHECKPOINT_PICKED_UP
		end
		end
		if
		0038: $FLAG_BLIP_5 == 0
	then
		024F: create_corona 1.0 CORONATYPE_HEX FLARETYPE_NONE with_color 0 200 200 at_point $X_5 $Y_5 $Z_5
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_5 $Y_5 $Z_5 radius 2.5 2.5 3.5 
		then
			0164: disable_marker $BLIP_5 
			018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_5 $Y_5 $Z_5 
			0004: $FLAG_BLIP_5 = 1 
			gosub @MISSION_4X4ONE_CHECKPOINT_PICKED_UP
		end
		end
		if
		0038: $FLAG_BLIP_6 == 0
	then
		024F: create_corona 1.0 CORONATYPE_HEX FLARETYPE_NONE with_color 0 200 200 at_point $X_6 $Y_6 $Z_6
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_6 $Y_6 $Z_6 radius 2.5 2.5 3.5 
		then
			0164: disable_marker $BLIP_6 
			018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_6 $Y_6 $Z_6 
			0004: $FLAG_BLIP_6 = 1 
			gosub @MISSION_4X4ONE_CHECKPOINT_PICKED_UP
		end
		end
		if
		0038: $FLAG_BLIP_7 == 0
	then
		024F: create_corona 1.0 CORONATYPE_HEX FLARETYPE_NONE with_color 0 200 200 at_point $X_7 $Y_7 $Z_7
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_7 $Y_7 $Z_7 radius 2.5 2.5 3.5 
		then
			0164: disable_marker $BLIP_7 
			018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_7 $Y_7 $Z_7 
			0004: $FLAG_BLIP_7 = 1 
			gosub @MISSION_4X4ONE_CHECKPOINT_PICKED_UP
		end
		end
		if
		0038: $FLAG_BLIP_8 == 0
	then
		024F: create_corona 1.0 CORONATYPE_HEX FLARETYPE_NONE with_color 0 200 200 at_point $X_8 $Y_8 $Z_8
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_8 $Y_8 $Z_8 radius 2.5 2.5 3.5 
		then
			0164: disable_marker $BLIP_8 
			018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_8 $Y_8 $Z_8 
			0004: $FLAG_BLIP_8 = 1 
			gosub @MISSION_4X4ONE_CHECKPOINT_PICKED_UP
		end
		end
		if
		0038: $FLAG_BLIP_9 == 0
	then
		024F: create_corona 1.0 CORONATYPE_HEX FLARETYPE_NONE with_color 0 200 200 at_point $X_9 $Y_9 $Z_9
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_9 $Y_9 $Z_9 radius 2.5 2.5 3.5 
		then
			0164: disable_marker $BLIP_9 
			018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_9 $Y_9 $Z_9
			0004: $FLAG_BLIP_9 = 1 
			gosub @MISSION_4X4ONE_CHECKPOINT_PICKED_UP
		end
		end
		if
		0038: $FLAG_BLIP_10 == 0
	then
		024F: create_corona 1.0 CORONATYPE_HEX FLARETYPE_NONE with_color 0 200 200 at_point $X_10 $Y_10 $Z_10
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_10 $Y_10 $Z_10 radius 2.5 2.5 3.5 
		then
			0164: disable_marker $BLIP_10
			018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_10 $Y_10 $Z_10 
			0004: $FLAG_BLIP_10 = 1 
			gosub @MISSION_4X4ONE_CHECKPOINT_PICKED_UP
		end
		end
		if
		0038: $FLAG_BLIP_11 == 0
	then
		024F: create_corona 1.0 CORONATYPE_HEX FLARETYPE_NONE with_color 0 200 200 at_point $X_11 $Y_11 $Z_11
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_11 $Y_11 $Z_11 radius 2.5 2.5 3.5 
		then
			0164: disable_marker $BLIP_11 
			018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_11 $Y_11 $Z_11 
			0004: $FLAG_BLIP_11 = 1 
			gosub @MISSION_4X4ONE_CHECKPOINT_PICKED_UP
		end
		end
		if
		0038: $FLAG_BLIP_12 == 0
	then
		024F: create_corona 1.0 CORONATYPE_HEX FLARETYPE_NONE with_color 0 200 200 at_point $X_12 $Y_12 $Z_12
		if
			00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_12 $Y_12 $Z_12 radius 2.5 2.5 3.5 
		then
			0164: disable_marker $BLIP_12 
			018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_12 $Y_12 $Z_12 
			0004: $FLAG_BLIP_12 = 1 
			gosub @MISSION_4X4ONE_CHECKPOINT_PICKED_UP
		end
	end




    // ----------------------------------------------------------------------------------------------
    // -------------------     INTRO THING FOR PATRIOT           ------------------------------------
    // ----------------------------------------------------------------------------------------------

	
	if
		0038:   $PATRIOT_PLAYGROUND_HELP_FINISHED == 0 
	then
		015F: set_camera_position 1120.4916 -512.0543 30.968 0.0 rotation 0.0 0.0 
		03CB: load_scene 1458.0 -564.0 28.0 
		0160: point_camera 1147.713 -545.3979 21.6366 switchstyle JUMP_CUT
		00BA: print_big 'T4X4_1' time 5000 style 2  // 'PATRIOT PLAYGROUND'
		016A: fade 1 for 1500 ms 
		while fading
			wait 0 ms	
		end
		wait 2000
		02A3: toggle_widescreen 0 
		01B4: set_player $PLAYER_CHAR controllable 1 
		if
			8119:   not car $CAR_CHALLENGE wrecked 
		then
			020A: set_car $CAR_CHALLENGE door_status_to CARLOCK_UNLOCKED
		end

        016A: fade 0 for 1500 ms
		while fading
			wait 0 ms
		end
        02EB: restore_camera_jumpcut 
        		016A: fade 1 for 1500 ms
		while fading
			wait 0 ms
		end
		00BE: clear_prints
        0004: $PATRIOT_PLAYGROUND_HELP_FINISHED = 1
	end

	
    // ----------------------------------------------------------------------------------------------
    // -------------------     TIMER STARTED - FAIL CONDITIONS     ----------------------------------
    // ----------------------------------------------------------------------------------------------
	
	if
		0038:   $FLAG_TIMER == 1 
	then
		if
			001A:   1 > $TIMER_4X4
		then
			00BC: print_now 'TAXI2' time 3000 flag 1  // ~r~You're out of time!
			goto @MISSION_4X4ONE_FAILED
		end
	end
	if
		80DE:   not is_player_in_model $PLAYER_CHAR model #PATRIOT
	then
		00BC: print_now 'T4X4_F' time 3000 flag 1  // ~r~You bailed! Too tough for you?!
		goto @MISSION_4X4ONE_FAILED
	end
end

    // ----------------------------------------------------------------------------------------------
    // -------------------     TIMER STARTED - WIN CONDITIONS      ----------------------------------
    // ----------------------------------------------------------------------------------------------


if
	0038:   $COUNTER_4X4_PICKUPS == 3
then
	goto @MISSION_4X4ONE_PASSED
end

    // ----------------------------------------------------------------------------------------------
    // -------------------     CHECKPOINT PICKED UP                ----------------------------------
    // ----------------------------------------------------------------------------------------------


:MISSION_4X4ONE_CHECKPOINT_PICKED_UP
0008: $COUNTER_4X4_PICKUPS += 1 
0008: $TIMER_4X4 += 8000 
01E5: text_1number_highpriority 'T4X4_1B' $COUNTER_4X4_PICKUPS flag 3000 time 1  // ~1~ of many!
return

    // ----------------------------------------------------------------------------------------------
    // -------------------     MISSION FAILED ROUTINRE             ----------------------------------
    // ----------------------------------------------------------------------------------------------

:MISSION_4X4ONE_FAILED
00BA: print_big 'M_FAIL' time 2000 style 1  // MISSION FAILED!
return

    // ----------------------------------------------------------------------------------------------
    // -------------------     MISSION COMPLETE ROUTINE            ----------------------------------
    // ----------------------------------------------------------------------------------------------

:MISSION_4X4ONE_PASSED

01E3: text_1number_styled 'M_PASS' number 20000 time 5000 style 1  // MISSION PASSED! $~1~
0394: play_music 1 
0110: clear_player $PLAYER_CHAR wanted_level 

return


    // ----------------------------------------------------------------------------------------------
    // -------------------     MISSION CLEANUP ROUTINE             ----------------------------------
    // ----------------------------------------------------------------------------------------------

:MISSION_CLEANUP_4X4ONE
0164: disable_marker $BLIP_1 
0164: disable_marker $BLIP_2 
0164: disable_marker $BLIP_4
0164: disable_marker $BLIP_5
0164: disable_marker $BLIP_6
0164: disable_marker $BLIP_7
0164: disable_marker $BLIP_8
0164: disable_marker $BLIP_9
0164: disable_marker $BLIP_10
0164: disable_marker $BLIP_11
0164: disable_marker $BLIP_12
 

02EB: restore_camera_jumpcut 
02A3: toggle_widescreen 0 
01B4: set_player $PLAYER_CHAR controllable 1 
014F: stop_timer $TIMER_4X4 
0004: $ONMISSION = 0 
00D8: mission_has_finished 
0051: return 
