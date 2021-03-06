:GENSTUFF
0004: $SECOND_FLOOR_CARS_EXIST = 0 
0004: $THIRD_FLOOR_CARS_EXIST = 0
0004: $FOURTH_FLOOR_CARS_EXIST = 0 
0004: $FIFTH_FLOOR_CARS_EXIST = 0
 
0004: $NEED_TO_CLEAR_AREA_FLAG = 0 
0004: $HAS_PLAYER_BEEN_AT_FISH_BEFORE = 0 
0004: $HAS_PLAYER_BEEN_IN_TRAMP_TUNNEL_BEFORE = 0 
0004: $FLAG_SOUNDS_ADDED_REDLIGHT = 0
0004: $TRAMPS_BEEN_CREATED = 0
0004: $TRAMP_IS_DEAD = 0
0004: $CAMERA_AMMU1 = 0
0004: $CAMERA_AMMU2 = 0
0004: $FLAG_SOUNDS_ADDED_DOG = 0
0004: $FLAG_FAILED_LOVE1 = 0
0004: $FLAG_NEED_WALL_CHANGE_KM1 = 0
0004: $ON_ARMS_SHORTAGE_MISSION = 0
0004: $TRAMP1 = -1
0004: $TRAMP2 = -1
0004: $TRAMP3 = -1 
0004: $TRAMP4 = -1
// 0004: $TRAMP1_DEAD = 0 // NEVER USED
// 0004: $TRAMP2_DEAD = 0 // NEVER USED
// 0004: $TRAMP4_DEAD = 0 // NEVER USED 
// 0004: $TRAMP3_DEAD = 0 // NEVER USED
0004: $AMMU_SAMPLE = 0 
0004: $SPECIAL_AMMU_AUDIO = 0
0004: $AMMU_BLOKE_KILL_PLAYER = 0
03A4: thread 'GENSTUF' 
0111: set_deatharrest_state 0 (disabled)
create_thread @IND_AMMU 
create_thread @FISH_FACTORY_GEN 
create_thread @TRAMP_TUNNEL 
create_thread @IND_SOUND 
create_thread @COM_AMMU 
create_thread @COM_CAR_PARK 
create_thread @DOG_SOUND 
create_thread @COBBLERS 
end_thread

:COBBLERS
while true
	wait 1000 ms
	if 
		0038: $FLAG_STAUNTON_OPEN == 1
	then
		0215: destroy_pickup $INFO_PICKUP7A 
		0215: destroy_pickup $INFO_PICKUP8 
		0215: destroy_pickup $INFO_PICKUP9 
		0215: destroy_pickup $INFO_PICKUP3 
		0215: destroy_pickup $INFO_PICKUP4 
		0215: destroy_pickup $INFO_PICKUP5 
		0215: destroy_pickup $INFO_PICKUP1 
		end_thread
	end
end

:CHECK_INFO_PICKUP
while 8214: NOT pickup 0@ picked_up
	wait 500 ms
end
if
    0039:    1@ ==  1  
then
    03E5: text_box 'SPRAY'  // Drive your vehicle into the spray shop to lose your ~h~wanted level~w~, ~h~repair ~w~and ~h~respray ~w~your vehicle. Cost - ~h~$1000.
end
if
    0039:    1@ ==  2  
then
    03E5: text_box 'BOMB'  // Drive your vehicle into the bomb shop to attach a ~h~bomb~w~. Cost - ~h~$1000.
end
if
    0039:    1@ ==  3  
then
    03E5: text_box 'AMMU'  // Go inside Ammu-Nation to buy a weapon.
end
if
    0039:    1@ ==  4  
then
    03E5: text_box 'SAVE2'  // Any vehicle left in this garage will be stored when the game is saved.
end
if
    0039:    1@ ==  5  
then
    03E5: text_box 'SAVE1'  // Walk through the doorway to ~h~Save the game~w~. You cannot save during a mission.
end
if
    0039:    1@ ==  6  
then
    03E5: text_box 'CRUSH'  // Park in the marked area and exit your vehicle. The vehicle will then be crushed.
end
jump @CHECK_INFO_PICKUP

:CHECK_INFO_PICKUP_2
while 8214:   NOT   pickup  0@ picked_up
    wait  500 ms
end
if
    0039:    1@ ==  7  
then
    03E5: text_box 'BRIDGE1'  // When the Callahan Bridge is repaired you will be able to drive to Staunton Island.
end
if
    0039:    1@ ==  8  
then
    03E5: text_box 'TUNNEL'  // When the Porter Tunnel is opened you will be able to drive to Staunton Island.
end
if
    0039:    1@ ==  9  
then
    03E5: text_box 'TUBE1'  // When the subway opens you will be able to catch a train to Staunton Island.
end
if
	0039:    1@ ==  10  
then
	03E5: text_box 'L_TRN_2'  // You can ride the L-train around Portland. Press the~h~ ~k~~VEHICLE_ENTER_EXIT~ button~w~ to ~h~enter ~w~or ~h~exit~w~ a train.
end
if
	0039:    1@ ==  11  
then
	03E5: text_box 'S_TRN_1'  // You can take the subway trains across Liberty. Press the~h~ ~k~~VEHICLE_ENTER_EXIT~ button~w~ to ~h~enter ~w~or ~h~exit~w~ a train.
end
jump @CHECK_INFO_PICKUP_2


:IND_AMMU
03A4: name_thread 'I_AMMU'
while true
	wait 70 ms
	if
		0256:   player $PLAYER_CHAR defined
	then
		if
			0121:   player $PLAYER_CHAR in_zone 'LITTLEI'  // Saint Mark's
		then
			if
				0057:   player $PLAYER_CHAR 0 1066.563 -403.5 14.0 1072.75 -394.0 18.0
			then
				if
					0038: $CAMERA_AMMU1 == 0
				then
					01B4: set_player $PLAYER_CHAR frozen_state 0 (frozen)
					0169: set_fade_color 1 1 1 
					03AF: set_streaming 0 (disabled)
					023C: load_special_actor 4 'SAM' 
					043C: set_music_does_fade 0 
					016A: fade 0  500 ms
					while 823D:   not special_actor 4 loaded
						wait 0 ms
					end
					while fading
						wait 0 ms
					end
					03AF: set_streaming 1 (enabled)
					01BD: $CURRENT_TIME = current_time_in_ms 
					0084: $TIME_DIFFERENCE = $CURRENT_TIME 
					0060: $TIME_DIFFERENCE -= $TIME_SINCE_MURDERING_SHOPKEEPER1
					if 
						$TIME_DIFFERENCE > 60000
					then
						009A: create_char 21 model #SPECIAL04 at 1070.75 -396.9375 14.1875 store_to $AMMU_SHOP_BLOKE1
						0243: set_actor $AMMU_SHOP_BLOKE1 ped_stats_to 16 
						0173: set_actor $AMMU_SHOP_BLOKE1 z_angle_to 170.0 
						0350: unknown_actor $AMMU_SHOP_BLOKE1 not_scared_flag 1 
						01B2: give_actor $AMMU_SHOP_BLOKE1 weapon 4 ammo 999
						if
							0256:   player $PLAYER_CHAR defined 
						then
							022D: set_actor $AMMU_SHOP_BLOKE1 to_look_at_player $PLAYER_CHAR
						end
					end
					0296: unload_special_actor 4 
					015F: set_camera_position 1071.938 -402.75 17.0 0.0 0.0 0.0 
					0452: enable_player_control_camera
					if
						0256:   player $PLAYER_CHAR defined
					then
						0157: camera_on_player $PLAYER_CHAR 15 2 
						0395: clear_area 1 at 1067.875 -397.25 range 14.1875 1.0 
						0055: put_player $PLAYER_CHAR at 1067.875 -397.25 14.1875 
						0171: set_player $PLAYER_CHAR z_angle_to 200.0 
					end
					016A: fade 1  500 ms
					while fading
						wait 0 ms
					end
					if
						0256:   player $PLAYER_CHAR defined
					then
						01B4: set_player $PLAYER_CHAR frozen_state 1 (unfrozen)
					end
					if and
						8118:   not actor $AMMU_SHOP_BLOKE1 dead 
						0038:   $SPECIAL_AMMU_AUDIO == 0
					then
						if
							0038:   $AMMU_SAMPLE == 0
						then
							041C: make_actor $AMMU_SHOP_BLOKE1 say 103
						end
						if
							0038:   $AMMU_SAMPLE == 1
						then
							041C: make_actor $AMMU_SHOP_BLOKE1 say 104
						end
						if
							0038:   $AMMU_SAMPLE == 2
						then
							041C: make_actor $AMMU_SHOP_BLOKE1 say 105
						end
					end
					0004: $CAMERA_AMMU1 = 1
				else // camera_ammu1 = 1
					if and
						02DF:   player $PLAYER_CHAR agressive
						8118:   not actor $AMMU_SHOP_BLOKE1 dead 
						0038:   $AMMU_BLOKE_KILL_PLAYER == 0
					then
						if
							0256:   player $PLAYER_CHAR defined
						then
							01CA: actor $AMMU_SHOP_BLOKE1 kill_player $PLAYER_CHAR
						end
						0004: $AMMU_BLOKE_KILL_PLAYER = 1
					end
				end
			else // player not in area
				if
					0038: $CAMERA_AMMU1 == 1
				then
					01B4: set_player $PLAYER_CHAR frozen_state 0 (frozen)
					016A: fade 0  500 ms
					while fading
						wait 0 ms
					end
					if and
						0118:   actor $AMMU_SHOP_BLOKE1 dead 
						0018:   $TIME_DIFFERENCE > 60000
					then
						01BD: $TIME_SINCE_MURDERING_SHOPKEEPER1 = current_time_in_ms
					end
					009B: destroy_actor_instantly $AMMU_SHOP_BLOKE1 
					0395: clear_area 1 at 1063.25 -395.25 range 14.1875 1.0 
					if
						0256:   player $PLAYER_CHAR defined
					then
						0055: put_player $PLAYER_CHAR at 1063.25 -395.25 14.1875 
						0171: set_player $PLAYER_CHAR z_angle_to 90.0 
						02EB: restore_camera_with_jumpcut 
						03C8: rotate_player-180-degrees 
					end
					016A: fade 1  500 ms
					while fading
						wait 0 ms
					end
					043C: set_music_does_fade 1
					if
						0256:   player $PLAYER_CHAR defined
					then
						01B4: set_player $PLAYER_CHAR frozen_state 1 (unfrozen)
					end
					0008: $AMMU_SAMPLE += 1
					if
						0018: $AMMU_SAMPLE > 2
					then
						0018: $AMMU_SAMPLE = 0
					end
					0004: $AMMU_BLOKE_KILL_PLAYER = 0
					0004: $CAMERA_AMMU1 = 1
				end
			end // IS_PLAYER_IN_AREA_3D
		else // not in LITTLEI
			if
				0038: $CAMERA_AMMU1 == 1
			then
				if and
					0118:   actor $AMMU_SHOP_BLOKE1 dead 
					0018:   $TIME_DIFFERENCE > 60000
				then
					01BD: $TIME_SINCE_MURDERING_SHOPKEEPER1 = current_time_in_ms
				end
				02EB: restore_camera_with_jumpcut 
				03C8: rotate_player-180-degrees 
				009B: destroy_actor_instantly $AMMU_SHOP_BLOKE1 
				043C: set_music_does_fade 1 
				0004: $CAMERA_AMMU1 = 0
			end
		end // IF IS_PLAYER_IN_ZONE player LITTLEI
	end // IS_PLAYER_PLAYING
end //while


:FISH_FACTORY_GEN
03A4: name_thread 'FISHGEN'
while true
	wait 1000 ms
	if
		0256:   is_player $PLAYER_CHAR defined 
	then
		//FISH FACTORY SET UP
		if
			0038:   $FISH_FACTORY_DESTROYED == 0
		then
			if
				0121:   player $PLAYER_CHAR in_zone 'PORT_W'  // Callahan Point
			then
				//CREATES A GANG OF TRIADS DOWN AT THE FISH FACTORY
				if
					0038: $HAS_PLAYER_BEEN_AT_FISH_BEFORE == 0
				then
					0247: request_model #GANG03 
					0247: request_model #GANG04
					while true
						if or
							8248:   not model #GANG03 available 
							8248:   not model #GANG04 available 
						jf break
						wait 0 ms
					end
					009A: create_char 8 model #GANG03 at 997.0 -1112.0 -100.0 store_to $FISH_TRIAD1 
					01B2: give_actor $FISH_TRIAD1 weapon 2 ammo 100 
					011A: set_actor $FISH_TRIAD1 search_threat 1 

					009A: create_char 8 model #GANG04 at 964.0 -1095.0 -100.0 store_to $FISH_TRIAD2 
					01B2: give_actor $FISH_TRIAD2 weapon 2 ammo 100 
					011A: set_actor $FISH_TRIAD2 search_threat 1 

					009A: create_char 8 model #GANG03 at 982.0 -1085.0 -100.0 store_to $FISH_TRIAD3 
					01B2: give_actor $FISH_TRIAD3 weapon 2 ammo 100 
					011A: set_actor $FISH_TRIAD3 search_threat 1 

					009A: create_char 8 model #GANG04 at 953.0 -1122.0 -100.0 store_to $FISH_TRIAD4 
					01B2: give_actor $FISH_TRIAD4 weapon 2 ammo 100 
					011A: set_actor $FISH_TRIAD4 search_threat 1 

					009A: create_char 8 model #GANG03 at 1008.0 -1126.0 -100.0 store_to $FISH_TRIAD5 
					01B2: give_actor $FISH_TRIAD5 weapon 2 ammo 100 
					011A: set_actor $FISH_TRIAD5 search_threat 1 

					009A: create_char 8 model #GANG03 at 974.0 -1142.0 -100.0 store_to $FISH_TRIAD6 
					01B2: give_actor $FISH_TRIAD6 weapon 2 ammo 100 
					011A: set_actor $FISH_TRIAD6 search_threat 1 

					009C: char_wander_dir $FISH_TRIAD1 to 0 
					009C: char_wander_dir $FISH_TRIAD2 to 0 
					009C: char_wander_dir $FISH_TRIAD3 to 0 
					009C: char_wander_dir $FISH_TRIAD4 to 0 
					009C: char_wander_dir $FISH_TRIAD5 to 0 
					009C: char_wander_dir $FISH_TRIAD6 to 0 
					0004: $HAS_PLAYER_BEEN_AT_FISH_BEFORE = 1
				end
			else	//	Player not in PORT_W
				if
					0038:   $HAS_PLAYER_BEEN_AT_FISH_BEFORE == 1
				then
					01C2: remove_references_to_actor $FISH_TRIAD1 
					01C2: remove_references_to_actor $FISH_TRIAD2 
					01C2: remove_references_to_actor $FISH_TRIAD3 
					01C2: remove_references_to_actor $FISH_TRIAD4 
					01C2: remove_references_to_actor $FISH_TRIAD5 
					01C2: remove_references_to_actor $FISH_TRIAD6 
					if 
						0038: $ONMISSION == 0
					then
						0249: release_model #GANG03 
						0249: release_model #GANG04
						0004: $HAS_PLAYER_BEEN_AT_FISH_BEFORE = 0
					end
				end
			end // IS PLAYER IN ZONE
		else // fish_factory_destroyed
			if
				0038:   $HAS_PLAYER_BEEN_AT_FISH_BEFORE == 1
			then
				01C2: remove_references_to_actor $FISH_TRIAD1 
				01C2: remove_references_to_actor $FISH_TRIAD2 
				01C2: remove_references_to_actor $FISH_TRIAD3 
				01C2: remove_references_to_actor $FISH_TRIAD4 
				01C2: remove_references_to_actor $FISH_TRIAD5 
				01C2: remove_references_to_actor $FISH_TRIAD6 
				if 
					0038: $ONMISSION == 0
				then
					0249: release_model #GANG03 
					0249: release_model #GANG04
					0004: $HAS_PLAYER_BEEN_AT_FISH_BEFORE = 0
				end
			end
		end //fish_factory_destroyed
	end //IS_PLAYER_PLAYING
end //while

:TRAMP_TUNNEL
03A4: name_thread 'TRAMPS'
while true
	wait 1000 ms
	if
		0256:   player $PLAYER_CHAR defined
	then
		if
			0121:   player $PLAYER_CHAR in_zone 'LITTLEI'  // Saint Mark's
		then
			if
				0057:   player $PLAYER_CHAR 0 1325.0 -512.0 14.0 1315.0 -165.75 17.0
			then
				if
					0038: $HAS_PLAYER_BEEN_IN_TRAMP_TUNNEL_BEFORE == 0
				then
					0247: request_model #SCUM_MAN 
					0247: request_model #SCUM_WOM
					while true
						if or
							8248:   not model #SCUM_MAN available 
							8248:   not model #SCUM_WOM available 
						jf break
						wait 0 ms
					end
					009A: create_char 19 model #SCUM_MAN at 1320.375 -370.0 15.0 store_to $TRAMP1
					01B2: give_actor $TRAMP1 weapon 10 ammo 1 
					0243: set_actor $TRAMP1 ped_stats_to 14 
					011A: set_actor $TRAMP1 flags 1048576 
					011A: set_actor $TRAMP1 flags 33554432 

					009A: create_char 19 model #SCUM_WOM at 1317.0 -365.0 15.0 store_to $TRAMP2
					01B2: give_actor $TRAMP2 weapon 10 ammo 1 
					0173: set_actor $TRAMP2 z_angle_to 290.0 
					0243: set_actor $TRAMP2 ped_stats_to 14 
					011A: set_actor $TRAMP2 flags 1048576 
					011A: set_actor $TRAMP2 flags 33554432 

					009A: create_char 19 model #SCUM_WOM at 1322.375 -367.0 15.0 store_to $TRAMP3
					01B2: give_actor $TRAMP3 weapon 10 ammo 1 
					0173: set_actor $TRAMP3 z_angle_to 57.0 
					0243: set_actor $TRAMP3 ped_stats_to 14 
					011A: set_actor $TRAMP3 flags 1048576 
					011A: set_actor $TRAMP3 flags 33554432 

					009A: create_char 19 model #SCUM_MAN at 1320.0 -362.0 15.0 store_to $TRAMP4 
					01B2: give_actor $TRAMP4 weapon 10 ammo 1 
					0173: set_actor $TRAMP4 z_angle_to 180.0 
					0243: set_actor $TRAMP4 ped_stats_to 14 
					011A: set_actor $TRAMP4 flags 1048576 
					011A: set_actor $TRAMP4 flags 33554432 

					0249: mark_model_as_no_longer_needed #SCUM_MAN 
					0249: mark_model_as_no_longer_needed #SCUM_WOM 
					$TRAMPS_BEEN_CREATED = 1
					$HAS_PLAYER_BEEN_IN_TRAMP_TUNNEL_BEFORE = 1
				else
					if and
						0038:   $TRAMPS_BEEN_CREATED == 1
						0038:   $TRAMP_IS_DEAD == 0
					then
						if or
							0118:   actor $TRAMP1 dead
							0118:   actor $TRAMP2 dead
							0118:   actor $TRAMP3 dead
							0118:   actor $TRAMP4 dead
						then
							0006: 16@ = 0
							0004: $TRAMP_IS_DEAD = 1
						end
					end
				end
			end
		else // IF IS_PLAYER_IS_ZONE Player LITTLEI
			if
				0038:   $HAS_PLAYER_BEEN_IN_TRAMP_TUNNEL_BEFORE == 1
			then
				if
					0038:   $TRAMPS_BEEN_CREATED == 1
				then
					01C2: remove_references_to_actor $TRAMP1 // Like turning an actor into a random pedestrian 
					01C2: remove_references_to_actor $TRAMP2 // Like turning an actor into a random pedestrian 
					01C2: remove_references_to_actor $TRAMP3 // Like turning an actor into a random pedestrian 
					01C2: remove_references_to_actor $TRAMP4 // Like turning an actor into a random pedestrian 
					0004: $TRAMPS_BEEN_CREATED = 0
				end
				if
					0038:   $TRAMP_IS_DEAD == 1
				then
					if
						0019: 16@ > 1440000 // 24 minutes
					then
						0004: $TRAMP_IS_DEAD = 0
						0004: $HAS_PLAYER_BEEN_IN_TRAMP_TUNNEL_BEFORE = 0
					end
				else
					0004: $HAS_PLAYER_BEEN_IN_TRAMP_TUNNEL_BEFORE = 0
				end
			end
		end // IF IS_PLAYER_IS_ZONE Player LITTLEI
	end // player defined
end //while

:IND_SOUND
03A4: name_thread 'I_SOUND'
while true
	wait 1000 ms
	if
		0256:   player $PLAYER_CHAR defined
	then
		if
			0121:   player $PLAYER_CHAR in_zone 'REDLIGH'  // Red Light District
		then
			00BF: $CURRENT_TIME_HOURS = current_time_hours, $CURRENT_TIME_MINUTES = current_time_minutes 
			if or
				0028:   $CURRENT_TIME_HOURS >= 20  
				002A:   5 >= $CURRENT_TIME_HOURS
			then
				if
					0038:   $FLAG_SOUNDS_ADDED_REDLIGHT == 0 
				then
					018D: $SOUND_LOOP8 = create_sound 32 at 891.875 -416.875 16.0625 // Luigi's Club
					018D: $SOUND_LOOP9 = create_sound 30 at 924.1875 -464.25 16.0 // Sex Kitten Club
					018D: $SOUND_LOOP10 = create_sound 62 at 901.0625 -392.0 15.0 // XXX Cinema1
					018D: $SOUND_LOOP11 = create_sound 64 at 901.1875 -339.0 10.0 // XXX Cinema2
					018D: $SOUND_LOOP12 = create_sound 66 at 960.0625 -379.0 15.0 // XXX Cinema
					$FLAG_SOUNDS_ADDED_REDLIGHT = 1
				end
			else
				if
					0038:   $FLAG_SOUNDS_ADDED_REDLIGHT == 1
				then
					018E: stop_sound $SOUND_LOOP8 
					018E: stop_sound $SOUND_LOOP9 
					018E: stop_sound $SOUND_LOOP10 
					018E: stop_sound $SOUND_LOOP11 
					018E: stop_sound $SOUND_LOOP12
					$FLAG_SOUNDS_ADDED_REDLIGHT = 0
				end
			end
		end
	end
end //while

:DOG_SOUND
03A4: name_thread 'D_SOUND'
while true
	wait 1000 ms
	if
		0256:   player $PLAYER_CHAR defined
	then
		if
			0121:   player $PLAYER_CHAR in_zone 'PORT_I'  // Trenton
		then
			00BF: $CURRENT_TIME_HOURS = current_time_hours, $CURRENT_TIME_MINUTES = current_time_minutes 
			if or
				0028:   $CURRENT_TIME_HOURS >= 9  
				002A:   17 >= $CURRENT_TIME_HOURS
			then
				if
					0038:   $FLAG_SOUNDS_ADDED_DOG == 0 
				then
					018D: $SOUND_LOOP7 = create_sound 37 at 1210.875 -802.1875 15.0 
					$FLAG_SOUNDS_ADDED_DOG = 1
				end
			else
				if
					0038:   $FLAG_SOUNDS_ADDED_DOG == 1
				then
					018E: stop_sound $SOUND_LOOP7
					$FLAG_SOUNDS_ADDED_DOG = 0
				end
			end
		end
	end
end //while

:COM_AMMU
03A4: name_thread 'C_AMMU'
while true
	wait 70 ms
	if
		0256:   player $PLAYER_CHAR defined
	then
		if
			0121:   player $PLAYER_CHAR in_zone 'COM_EAS'  // Newport
		then
			if
				0057:   player $PLAYER_CHAR 0 353.25 -711.6875 24.0 339.75 -722.375 28.0
			then
				if
					0038: $CAMERA_AMMU2 == 0
				then
					01B4: set_player $PLAYER_CHAR frozen_state 0 (frozen)
					0169: set_fade_color 1 1 1 
					03AF: set_streaming 0 (disabled)
					023C: load_special_actor 4 'SAM' 
					043C: set_music_does_fade 0 
					016A: fade 0  500 ms
					while true
						if
							823D:   not special_actor 4 loaded
						jf break
						wait 0 ms
					end
					while fading
						wait 0 ms
					end
					03AF: set_streaming 1 (enabled)
					01BD: $CURRENT_TIME = current_time_in_ms 
					0084: $TIME_DIFFERENCE = $CURRENT_TIME 
					0060: $TIME_DIFFERENCE -= $TIME_SINCE_MURDERING_SHOPKEEPER1
					if 
						$TIME_DIFFERENCE > 60000
					then
						009A: create_char 21 model #SPECIAL04 at 350.1875 -719.875 25.375 store_to $AMMU_SHOP_BLOKE1
						0243: set_actor $AMMU_SHOP_BLOKE1 ped_stats_to 16 
						0173: set_actor $AMMU_SHOP_BLOKE1 z_angle_to 170.0 
						0350: unknown_actor $AMMU_SHOP_BLOKE1 not_scared_flag 1 
						01B2: give_actor $AMMU_SHOP_BLOKE1 weapon 4 ammo 999
						if
							0256:   player $PLAYER_CHAR defined 
						then
							022D: set_actor $AMMU_SHOP_BLOKE1 to_look_at_player $PLAYER_CHAR
						end
					end
					0296: unload_special_actor 4 
					015F: set_camera_position 341.6875 -720.625 28.0 0.0 0.0 0.0 
					0452: enable_player_control_camera
					if
						0256:   player $PLAYER_CHAR defined
					then
						0157: camera_on_player $PLAYER_CHAR 15 2 
						0395: clear_area 1 at 350.6875 -713.0625 range 26.375 1.0 
						0055: put_player $PLAYER_CHAR at 350.6875 -713.0625 25.375 
						0171: set_player $PLAYER_CHAR z_angle_to 108.0 
					end
					016A: fade 1  500 ms
					while fading
						wait 0 ms
					end
					if
						0256:   player $PLAYER_CHAR defined
					then
						01B4: set_player $PLAYER_CHAR frozen_state 1 (unfrozen)
					end
					if and
						8118:   not actor $AMMU_SHOP_BLOKE1 dead 
						0038:   $SPECIAL_AMMU_AUDIO == 0
					then
						if
							0038:   $AMMU_SAMPLE == 0
						then
							041C: make_actor $AMMU_SHOP_BLOKE1 say 103
						end
						if
							0038:   $AMMU_SAMPLE == 1
						then
							041C: make_actor $AMMU_SHOP_BLOKE1 say 104
						end
						if
							0038:   $AMMU_SAMPLE == 2
						then
							041C: make_actor $AMMU_SHOP_BLOKE1 say 105
						end
					end
					0004: $CAMERA_AMMU2 = 1
				else // camera_ammu1 = 1
					if and
						02DF:   player $PLAYER_CHAR agressive
						8118:   not actor $AMMU_SHOP_BLOKE1 dead 
						0038:   $AMMU_BLOKE_KILL_PLAYER == 0
					then
						if
							0256:   player $PLAYER_CHAR defined
						then
							01CA: actor $AMMU_SHOP_BLOKE1 kill_player $PLAYER_CHAR
						end
						0004: $AMMU_BLOKE_KILL_PLAYER = 1
					end
				end
			else // player not in area
				if
					0038:   $CAMERA_AMMU2 == 1
				then
					01B4: set_player $PLAYER_CHAR frozen_state 0 (frozen)
					016A: fade 0  500 ms
					while fading
						wait 0 ms
					end
					if and
						0118:   actor $AMMU_SHOP_BLOKE1 dead 
						0018:   $TIME_DIFFERENCE > 60000
					then
						01BD: $TIME_SINCE_MURDERING_SHOPKEEPER1 = current_time_in_ms
					end
					009B: destroy_actor_instantly $AMMU_SHOP_BLOKE1 
					0395: clear_area 1 at 352.0 -708.75 range 25.375 1.0 
					if
						0256:   player $PLAYER_CHAR defined
					then
						0055: put_player $PLAYER_CHAR at 352.0 -708.75 25.375
						0171: set_player $PLAYER_CHAR z_angle_to 0.0 
						02EB: restore_camera_with_jumpcut 
						03C8: rotate_player-180-degrees 
					end
					016A: fade 1  500 ms
					while fading
						wait 0 ms
					end
					043C: set_music_does_fade 1
					if
						0256:   player $PLAYER_CHAR defined
					then
						01B4: set_player $PLAYER_CHAR frozen_state 1 (unfrozen)
					end
					0008: $AMMU_SAMPLE += 1
					if
						0018: $AMMU_SAMPLE > 2
					then
						0018: $AMMU_SAMPLE = 0
					end
					0004: $AMMU_BLOKE_KILL_PLAYER = 0
					0004: $CAMERA_AMMU2 = 1
				end
			end // IS_PLAYER_IN_AREA_3D
		else // not in LITTLEI
			if
				0038:   $CAMERA_AMMU2 == 1
			then
				if and
					0118:   actor $AMMU_SHOP_BLOKE1 dead 
					0018:   $TIME_DIFFERENCE > 60000
				then
					01BD: $TIME_SINCE_MURDERING_SHOPKEEPER1 = current_time_in_ms
				end
				02EB: restore_camera_with_jumpcut 
				03C8: rotate_player-180-degrees 
				009B: destroy_actor_instantly $AMMU_SHOP_BLOKE1 
				043C: set_music_does_fade 1 
				0004: $CAMERA_AMMU2 = 0
			end
		end // IF IS_PLAYER_IN_ZONE player LITTLEI
	end // IS_PLAYER_PLAYING
end //while

:COM_CAR_PARK
03A4: name_thread 'C_CARP'
while true
	wait 250 ms
	if
		0256:   player $PLAYER_CHAR defined
	then
		if and
			03C6:   current_island == 2
			0121:   player $PLAYER_CHAR in_zone 'COM_EAS'  // Newport
		then
			if
				0057:   player $PLAYER_CHAR 0 266.8125 -610.875 25.0 306.25 -479.875 30.0 
			then
				01EB: set_car_density_to 0.0 
				if
					0038:   $SECOND_FLOOR_CARS_EXIST == 0
				then
					gosub @SECOND_FLOOR_OF_CARS
					0004: $SECOND_FLOOR_CARS_EXIST = 1
				end
				if
					0038:   $THIRD_FLOOR_CARS_EXIST == 1
				then
					03BA: clear_cars_from_cube 266.8125 -610.875 30.375 306.25 -479.875 34.8125 // 3RD FLOOR CLEAR
					0004: $THIRD_FLOOR_CARS_EXIST = 0
				end
				if
					0038:   $FOURTH_FLOOR_CARS_EXIST == 1
				then
					03BA: clear_cars_from_cube 306.25 -610.875 32.8125 346.75 -479.875 40.0  // 4TH FLOOR CLEAR
					0004: $FOURTH_FLOOR_CARS_EXIST = 0
				end
				if
					0038:   $FIFTH_FLOOR_CARS_EXIST == 1
				then
					03BA: clear_cars_from_cube 266.8125 -610.875 35.1875 306.25 -479.875 40.0  // 5TH FLOOR CLEAR
					0004: $FIFTH_FLOOR_CARS_EXIST = 0
				end
				0004: $NEED_TO_CLEAR_AREA_FLAG = 1
			end
			if and
				0018:   $NEED_TO_CLEAR_AREA_FLAG > 0
				0057:   player $PLAYER_CHAR 0 306.25 -610.875 28.0 346.75 -479.875 32.375 // 2ND FLOOR LOCATE
			then
				if
					0038:   $SECOND_FLOOR_CARS_EXIST == 0
				then
					gosub @SECOND_FLOOR_OF_CARS
					0004: $SECOND_FLOOR_CARS_EXIST = 1
				end
				if
					0038:   $THIRD_FLOOR_CARS_EXIST == 0
				then
					gosub @THIRD_FLOOR_OF_CARS
					0004: $THIRD_FLOOR_CARS_EXIST = 1
				end
				if
					0038:   $FOURTH_FLOOR_CARS_EXIST == 1
				then
					03BA: clear_cars_from_cube 306.25 -610.875 32.8125 346.75 -479.875 40.0  // 4TH FLOOR CLEAR
					0004: $FOURTH_FLOOR_CARS_EXIST = 0
				end
				if
					0038:   $FIFTH_FLOOR_CARS_EXIST == 1
				then
					03BA: clear_cars_from_cube 266.8125 -610.875 35.1875 306.25 -479.875 40.0  // 5TH FLOOR CLEAR
					0004: $FIFTH_FLOOR_CARS_EXIST = 0
				end
				0004: $NEED_TO_CLEAR_AREA_FLAG = 2
			end
			if and
				0018:   $NEED_TO_CLEAR_AREA_FLAG > 1
				0057:   player $PLAYER_CHAR 0 266.8125 -610.875 30.375 306.25 -479.875 34.8125 // 3RD FLOOR LOCATE
			then
				if
					0038:   $SECOND_FLOOR_CARS_EXIST == 0
				then
					gosub @SECOND_FLOOR_OF_CARS
					0004: $SECOND_FLOOR_CARS_EXIST = 1
				end
				if
					0038:   $THIRD_FLOOR_CARS_EXIST == 0
				then
					gosub @THIRD_FLOOR_OF_CARS
					0004: $THIRD_FLOOR_CARS_EXIST = 1
				end
				if
					0038:   $FOURTH_FLOOR_CARS_EXIST == 0
				then
					gosub @FOURTH_FLOOR_OF_CARS
					0004: $FOURTH_FLOOR_CARS_EXIST = 1
				end
				if
					0038:   $FIFTH_FLOOR_CARS_EXIST == 1
				then
					03BA: clear_cars_from_cube 266.8125 -610.875 35.1875 306.25 -479.875 40.0  // 5TH FLOOR CLEAR
					0004: $FIFTH_FLOOR_CARS_EXIST = 0
				end
				0004: $NEED_TO_CLEAR_AREA_FLAG = 3
			end
			if and
				0018:   $NEED_TO_CLEAR_AREA_FLAG > 2
				0057:   player $PLAYER_CHAR 0 306.25 -610.875 32.8125 346.75 -479.875 40.0  // 4TH FLOOR LOCATE
			then
				if
					0038:   $SECOND_FLOOR_CARS_EXIST == 1
				then
					03BA: clear_cars_from_cube 306.25 -610.875 28.0 346.75 -479.875 32.375  // 2ND FLOOR CLEAR
					0004: $SECOND_FLOOR_CARS_EXIST = 0
				end
				if
					0038:   $THIRD_FLOOR_CARS_EXIST == 0
				then
					gosub @THIRD_FLOOR_OF_CARS
					0004: $THIRD_FLOOR_CARS_EXIST = 1
				end
				if
					0038:   $FOURTH_FLOOR_CARS_EXIST == 0
				then
					gosub @FOURTH_FLOOR_OF_CARS
					0004: $FOURTH_FLOOR_CARS_EXIST = 1
				end
				if
					0038:   $FIFTH_FLOOR_CARS_EXIST == 0
				then
					gosub @FIFTH_FLOOR_OF_CARS
					0004: $FIFTH_FLOOR_CARS_EXIST = 1
				end
				0004: $NEED_TO_CLEAR_AREA_FLAG = 4
			end
			if and
				0018:   $NEED_TO_CLEAR_AREA_FLAG > 3
				0057:   player $PLAYER_CHAR 0 266.8125 -610.875 35.1875 306.25 -479.875 40.0  // 5TH FLOOR LOCATE
			then
				if
					0038:   $SECOND_FLOOR_CARS_EXIST == 1
				then
					03BA: clear_cars_from_cube 306.25 -610.875 28.0 346.75 -479.875 32.375  // 2ND FLOOR CLEAR
					0004: $SECOND_FLOOR_CARS_EXIST = 0
				end
				if
					0038:   $THIRD_FLOOR_CARS_EXIST == 1
				then
					03BA: clear_cars_from_cube 266.8125 -610.875 30.375 306.25 -479.875 34.8125 // 3RD FLOOR CLEAR
					0004: $THIRD_FLOOR_CARS_EXIST = 0
				end
				if
					0038:   $FOURTH_FLOOR_CARS_EXIST == 0
				then
					gosub @FOURTH_FLOOR_OF_CARS
					0004: $FOURTH_FLOOR_CARS_EXIST = 1
				end
				if
					0038:   $FIFTH_FLOOR_CARS_EXIST == 0
				then
					gosub @FIFTH_FLOOR_OF_CARS
					0004: $FIFTH_FLOOR_CARS_EXIST = 1
				end
				0004: $NEED_TO_CLEAR_AREA_FLAG = 5
			end
			if and
				0018:   $NEED_TO_CLEAR_AREA_FLAG > 0
				8057:   not player $PLAYER_CHAR 0 266.8125 -610.875 25.0 346.75 -479.875 40.0  // ENTIRE CARPARK LOCATE
			then
				01EB: set_car_density_to 1.0
				03BA: clear_cars_from_cube 306.25 -610.875 28.0 346.75 -479.875 32.375  // 2ND FLOOR CLEAR
				03BA: clear_cars_from_cube 266.8125 -610.875 30.375 306.25 -479.875 34.8125 // 3RD FLOOR CLEAR
				03BA: clear_cars_from_cube 306.25 -610.875 32.8125 346.75 -479.875 40.0  // 4TH FLOOR CLEAR
				03BA: clear_cars_from_cube 266.8125 -610.875 35.1875 306.25 -479.875 40.0  // 5TH FLOOR CLEAR
				0004: $SECOND_FLOOR_CARS_EXIST = 0
				0004: $THIRD_FLOOR_CARS_EXIST = 0
				0004: $FOURTH_FLOOR_CARS_EXIST = 0
				0004: $FIFTH_FLOOR_CARS_EXIST = 0
				0004: $NEED_TO_CLEAR_AREA_FLAG = 0
			end
		end // IF CURRENT_LEVEL == 2 and IS_PLAYER_IN_ZONE player COM_EAS
		if and
			0018:   $NEED_TO_CLEAR_AREA_FLAG > 0
			8057:   not player $PLAYER_CHAR 0 266.8125 -610.875 25.0 346.75 -479.875 40.0  // ENTIRE CARPARK LOCATE
		then
			01EB: set_car_density_to 1.0
			03BA: clear_cars_from_cube 306.25 -610.875 28.0 346.75 -479.875 32.375  // 2ND FLOOR CLEAR
			03BA: clear_cars_from_cube 266.8125 -610.875 30.375 306.25 -479.875 34.8125 // 3RD FLOOR CLEAR
			03BA: clear_cars_from_cube 306.25 -610.875 32.8125 346.75 -479.875 40.0  // 4TH FLOOR CLEAR
			03BA: clear_cars_from_cube 266.8125 -610.875 35.1875 306.25 -479.875 40.0  // 5TH FLOOR CLEAR
			0004: $SECOND_FLOOR_CARS_EXIST = 0
			0004: $THIRD_FLOOR_CARS_EXIST = 0
			0004: $FOURTH_FLOOR_CARS_EXIST = 0
			0004: $FIFTH_FLOOR_CARS_EXIST = 0
			0004: $NEED_TO_CLEAR_AREA_FLAG = 0
		end
	end //player defined
end //while

:SECOND_FLOOR_OF_CARS // 2ND FLOOR CARS
03C5: create_random_car_for_carpark 311.5 -510.25 28.0625 91.0 
03C5: create_random_car_for_carpark 323.5 -526.5 28.0625 270.3125 
03C5: create_random_car_for_carpark 342.625 -542.3125 28.0625 268.375 
03C5: create_random_car_for_carpark 311.4375 -554.375 28.0625 91.0625 
03C5: create_random_car_for_carpark 310.4375 -574.625 28.0625 269.4375 
03C5: create_random_car_for_carpark 342.6875 -590.4375 28.0625 268.4375 
return 

:THIRD_FLOOR_OF_CARS // 3RD FLOOR CARS
03C5: create_random_car_for_carpark 302.25 -580.5 30.5 270.3125 
03C5: create_random_car_for_carpark 289.5 -564.5625 30.5 88.0 
03C5: create_random_car_for_carpark 283.875 -548.375 30.5 92.5 
03C5: create_random_car_for_carpark 270.625 -528.4375 30.5 88.5625 
03C5: create_random_car_for_carpark 301.5 -484.75 30.375 271.625 
return 

:FOURTH_FLOOR_OF_CARS // 4TH FLOOR CARS
03C5: create_random_car_for_carpark 311.0625 -512.625 32.8125 91.125 
03C5: create_random_car_for_carpark 342.625 -536.25 32.8125 266.625 
03C5: create_random_car_for_carpark 311.4375 -564.125 32.8125 267.5 
03C5: create_random_car_for_carpark 330.5 -584.3125 32.8125 267.75 
03C5: create_random_car_for_carpark 342.875 -600.625 32.8125 87.25 
return 

:FIFTH_FLOOR_OF_CARS // 5TH FLOOR CARS
03C5: create_random_car_for_carpark 282.3125 -582.5 35.1875 267.0 
03C5: create_random_car_for_carpark 302.6875 -574.5 35.1875 271.0625 
03C5: create_random_car_for_carpark 270.9375 -530.4375 35.1875 88.3125 
03C5: create_random_car_for_carpark 303.1875 -510.5625 35.1875 88.625 
03C5: create_random_car_for_carpark 283.1875 -502.75 35.1875 89.4375 
03C5: create_random_car_for_carpark 302.375 -485.5 35.1875 266.0 
return
