// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ***************************************4x4 by Far**************************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

:M00_PATRIOT
gosub @MISSION_START_4X4ONE
GOSUB @MISSION_CLEANUP_4X4ONE
end_thread

// ****************************************Mission Start************************************

:MISSION_START_4X4ONE
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
00A5: create_car #PATRIOT at 816.288 -1050.0724 14.5562 store_to $CAR_PATRIOT // 158.3151 angle
0229: set_car $CAR_PATRIOT color_to 33 51
fade 1 for 1000 ms
while fading
wait 0 ms
end
0169: set_fade_color 1 1 1
0239: actor $PLAYER_ACTOR run_to 812.0 -945.5
01B4: set_player $PLAYER_CHAR controllable 0
01D5: actor $PLAYER_ACTOR go_to_and_drive_car $CAR_PATRIOT
wait 3000
fade 0 for 1000 ms
while fading
wait 0 ms
end
0369: put_player $PLAYER_CHAR in_car $CAR_PATRIOT
wait 1000
043C: set_game_sounds_fade 0



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

0004: $RECORD_TEMP = 0 

// Set Coords

0005: $X_1 = 1391.688 
0005: $Y_1 = -135.0 
0005: $Z_1 = 54.75 

0005: $X_2 = 1428.688 
0005: $Y_2 = -350.5 
0005: $Z_2 = 39.8125 

0005: $X_3 = 1473.0 
0005: $Y_3 = -602.5 
0005: $Z_3 = 3.1875  

//Mission Script

0110: clear_player $PLAYER_CHAR wanted_level  
if
	8119:   not car $CAR_PATRIOT wrecked 
then
	020A: set_car $CAR_PATRIOT door_status_to CARLOCK_LOCKED
end
01B4: set_player $PLAYER_CHAR controllable 0 
02A3: toggle_widescreen 1 




018A: $BLIP_1 = create_checkpoint_at $X_1 $Y_1 $Z_1 
018A: $BLIP_2 = create_checkpoint_at $X_2 $Y_2 $Z_2 
018A: $BLIP_3 = create_checkpoint_at $X_3 $Y_3 $Z_3 





while 001A:   3 > $COUNTER_4X4_PICKUPS 
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




    // ----------------------------------------------------------------------------------------------
    // -------------------     INTRO THING FOR PATRIOT           ------------------------------------
    // ----------------------------------------------------------------------------------------------

	
	if
		0038:   $PATRIOT_PLAYGROUND_HELP_FINISHED == 0 
	then
		015F: set_camera_position 1458.0 -564.0 28.0 0.0 rotation 0.0 0.0 
		03CB: load_scene 1458.0 -564.0 28.0 
		0160: point_camera $X_3 $Y_3 $Z_3 switchstyle JUMP_CUT
		00BA: print_big 'T4X4_1' time 5000 style 2  // 'PATRIOT PLAYGROUND'
		016A: fade 1 for 1500 ms 
		while fading
			wait 0 ms	
		end
		wait 2000
		02A3: toggle_widescreen 0 
		01B4: set_player $PLAYER_CHAR controllable 1 
		if
			8119:   not car $CAR_PATRIOT wrecked 
		then
			020A: set_car $CAR_PATRIOT door_status_to CARLOCK_UNLOCKED
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
0008: $TIMER_4X4 += 20000 
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
//0004: $RECORD_TEMP = 300000 
//0060: $RECORD_TEMP -= $TIMER_4X4 
//0014: $RECORD_TEMP /= 1000 
//if or
//	0038:   $PATRIOT_PLAYGROUND_COMPLETED == 0
//	001C:   $PATRIOT_PLAYGROUND_BEST_TIME > $RECORD_TEMP
//then
//	0084: $PATRIOT_PLAYGROUND_BEST_TIME = $RECORD_TEMP 
//end
01E3: text_1number_styled 'M_PASS' number 20000 time 5000 style 1  // MISSION PASSED! $~1~
0394: play_music 1 
0110: clear_player $PLAYER_CHAR wanted_level 
//0109: player $PLAYER_CHAR money += 20000 
//03FD: save_offroad_time $PATRIOT_PLAYGROUND_BEST_TIME 
//if
//	0038:   $PATRIOT_PLAYGROUND_COMPLETED == 0
//then
	//0318: set_latest_mission_passed 'T4X4_1'  // 'PATRIOT PLAYGROUND'
//	0004: $PATRIOT_PLAYGROUND_COMPLETED = 1 
//	030C: progress_made = 1 
//end
//004F: create_thread @4x4_MISSION2_LOOP // Removed by R* 
//004F: create_thread @4x4_MISSION4_LOOP // Removed by R* 
return


    // ----------------------------------------------------------------------------------------------
    // -------------------     MISSION CLEANUP ROUTINE             ----------------------------------
    // ----------------------------------------------------------------------------------------------

:MISSION_CLEANUP_4X4ONE
0164: disable_marker $BLIP_1 
0164: disable_marker $BLIP_2 
0164: disable_marker $BLIP_3 

02EB: restore_camera_jumpcut 
02A3: toggle_widescreen 0 
01B4: set_player $PLAYER_CHAR controllable 1 
014F: stop_timer $TIMER_4X4 
0004: $ONMISSION = 0 
00D8: mission_has_finished 
0051: return 
