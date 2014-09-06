    // ----------------------------------------------------------------------------------------------
    // -------------------           MISSION GENERATE OUTOUT     ------------------------------------
    // ----------------------------------------------------------------------------------------------

// test (Internally called test) has the following parameters:
// Starting coordinate: 925.21 -40.70 7.18  Angle: 182.38
// We are using a car called BANSHEE with carcol 0 0
// Weather is 0
// Camera is located at: 914.31 -92.19 25.79
//
// Coordinates for the mission are:
// 925.01 -86.05 5.09
// 923.67 -131.00 5.01
// 918.48 -218.16 8.86
// 907.64 -330.38 10.01
// 911.71 -419.05 14.66
// 1048.59 -462.18 14.66
// 976.43 -553.04 14.68
// 926.48 -568.89 14.68
// 919.79 -568.28 14.69
// 913.19 -567.72 14.68
// 906.06 -567.10 14.68
// 899.30 -566.66 14.69
// 893.95 -566.57 14.69
// 889.31 -566.55 14.68
// 884.50 -566.52 14.68
// 879.54 -566.48 14.69
// 874.46 -566.61 14.69
// 870.29 -566.86 14.69
// 867.11 -567.13 14.69
// 860.72 -568.07 14.69
// 857.47 -568.70 14.70
// 854.18 -569.40 14.69
// 850.91 -570.20 14.68
// 847.67 -571.08 14.68
// 844.49 -572.11 14.70
// 841.40 -573.34 14.71
// 831.89 -578.43 14.68
// 825.10 -584.51 14.77
// 823.81 -585.99 14.84
// 819.90 -591.53 15.05
// 818.31 -593.96 14.88
// 816.78 -596.42 14.75
// 815.78 -598.06 14.75
// 814.39 -600.53 14.77
// 813.15 -603.03 14.68
// 812.20 -605.60 14.64
// 810.29 -616.19 14.82
// 809.97 -618.93 14.77
// 809.70 -621.72 14.86
// 809.53 -624.53 14.85
// 810.31 -638.18 14.82
// 810.75 -641.22 14.79
// 811.22 -644.30 14.70
// 811.71 -647.43 14.69
// 812.17 -650.61 14.71
// 812.60 -653.83 14.71
// 813.00 -657.07 14.68
// 813.23 -659.25 14.65
// 813.47 -662.56 14.68
// 813.63 -664.79 14.71
// 813.82 -668.16 14.69
// 813.95 -672.65 14.65
// 813.97 -676.04 14.66
// 813.94 -679.43 14.68
// 813.91 -681.70 14.68
// 813.75 -685.11 14.68
// 813.55 -688.52 14.67
// 813.28 -691.93 14.70
// 813.08 -694.20 14.76
// 812.76 -697.61 14.82
// 812.54 -699.88 14.79
// 811.76 -709.06 14.88
// 811.50 -712.50 14.90
// 811.23 -715.93 14.77
// 810.68 -721.68 14.78
// 810.32 -725.14 14.86
// 810.08 -727.45 14.93
// 809.72 -730.91 14.98
// 809.38 -734.38 14.96
// 809.19 -736.70 14.94
// 808.96 -740.18 14.93
// 808.86 -743.64 14.94
// 808.92 -749.42 14.92
// 809.51 -762.26 14.92
// 809.62 -764.60 14.92
// 809.79 -769.31 14.92
// 809.72 -775.18 14.91
// 809.52 -778.70 14.92
// 809.26 -782.21 14.93
// 809.10 -799.81 14.92
// 809.12 -803.35 14.92
// 809.13 -806.91 14.93
// 809.14 -810.47 14.93
// 809.17 -814.03 14.94
// 809.20 -817.61 14.93
// 809.24 -821.18 14.93
//


// Mission start stuff

:MIS_test
gosub @MISSION_START_test
GOSUB @MISSION_CLEANUP_test
end_thread

    // ----------------------------------------------------------------------------------------------
    // ----------------------R             MISSION START         ------------------------------------
    // ----------------------------------------------------------------------------------------------
    // ----------------------------------------------------------------------------------------------
    // ----------------------------------------------------------------------------------------------
    // ----------------------------------------------------------------------------------------------

:MISSION_START_test
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
00BA: print_big 'T4X4_1' time 10000 style 2  // Change this GXT entry to test
00A5: create_car #BANSHEE at 816.288 -1050.0724 14.5562 store_to $CAR_CHALLENGE // 158.3151 angle
0229: set_car $CAR_CHALLENGE color_to 0 0
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
0055: put_player $PLAYER_CHAR at 925.21 -40.70 7.18
0171: set_player $PLAYER_CHAR z_angle_to 182.38
043C: set_game_sounds_fade 0
wait 1000



0317: increment_mission_attempts 
03A4: name_thread 'test'

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
0005: $X_1 = 925.01
0005: $Y_1 = -86.05
0005: $Z_1 = 5.09

0005: $X_2 = 923.67
0005: $Y_2 = -131.00
0005: $Z_2 = 5.01

0005: $X_3 = 918.48
0005: $Y_3 = -218.16
0005: $Z_3 = 8.86

0005: $X_4 = 907.64
0005: $Y_4 = -330.38
0005: $Z_4 = 10.01

0005: $X_5 = 911.71
0005: $Y_5 = -419.05
0005: $Z_5 = 14.66

0005: $X_6 = 1048.59
0005: $Y_6 = -462.18
0005: $Z_6 = 14.66

0005: $X_7 = 976.43
0005: $Y_7 = -553.04
0005: $Z_7 = 14.68

0005: $X_8 = 926.48
0005: $Y_8 = -568.89
0005: $Z_8 = 14.68

0005: $X_9 = 919.79
0005: $Y_9 = -568.28
0005: $Z_9 = 14.69

0005: $X_10 = 913.19
0005: $Y_10 = -567.72
0005: $Z_10 = 14.68

0005: $X_11 = 906.06
0005: $Y_11 = -567.10
0005: $Z_11 = 14.68

0005: $X_12 = 899.30
0005: $Y_12 = -566.66
0005: $Z_12 = 14.69

0005: $X_13 = 893.95
0005: $Y_13 = -566.57
0005: $Z_13 = 14.69

0005: $X_14 = 889.31
0005: $Y_14 = -566.55
0005: $Z_14 = 14.68

0005: $X_15 = 884.50
0005: $Y_15 = -566.52
0005: $Z_15 = 14.68

0005: $X_16 = 879.54
0005: $Y_16 = -566.48
0005: $Z_16 = 14.69

0005: $X_17 = 874.46
0005: $Y_17 = -566.61
0005: $Z_17 = 14.69

0005: $X_18 = 870.29
0005: $Y_18 = -566.86
0005: $Z_18 = 14.69

0005: $X_19 = 867.11
0005: $Y_19 = -567.13
0005: $Z_19 = 14.69

0005: $X_20 = 860.72
0005: $Y_20 = -568.07
0005: $Z_20 = 14.69

0005: $X_21 = 857.47
0005: $Y_21 = -568.70
0005: $Z_21 = 14.70

0005: $X_22 = 854.18
0005: $Y_22 = -569.40
0005: $Z_22 = 14.69

0005: $X_23 = 850.91
0005: $Y_23 = -570.20
0005: $Z_23 = 14.68

0005: $X_24 = 847.67
0005: $Y_24 = -571.08
0005: $Z_24 = 14.68

0005: $X_25 = 844.49
0005: $Y_25 = -572.11
0005: $Z_25 = 14.70

0005: $X_26 = 841.40
0005: $Y_26 = -573.34
0005: $Z_26 = 14.71

0005: $X_27 = 831.89
0005: $Y_27 = -578.43
0005: $Z_27 = 14.68

0005: $X_28 = 825.10
0005: $Y_28 = -584.51
0005: $Z_28 = 14.77

0005: $X_29 = 823.81
0005: $Y_29 = -585.99
0005: $Z_29 = 14.84

0005: $X_30 = 819.90
0005: $Y_30 = -591.53
0005: $Z_30 = 15.05

0005: $X_31 = 818.31
0005: $Y_31 = -593.96
0005: $Z_31 = 14.88

0005: $X_32 = 816.78
0005: $Y_32 = -596.42
0005: $Z_32 = 14.75

0005: $X_33 = 815.78
0005: $Y_33 = -598.06
0005: $Z_33 = 14.75

0005: $X_34 = 814.39
0005: $Y_34 = -600.53
0005: $Z_34 = 14.77

0005: $X_35 = 813.15
0005: $Y_35 = -603.03
0005: $Z_35 = 14.68

0005: $X_36 = 812.20
0005: $Y_36 = -605.60
0005: $Z_36 = 14.64

0005: $X_37 = 810.29
0005: $Y_37 = -616.19
0005: $Z_37 = 14.82

0005: $X_38 = 809.97
0005: $Y_38 = -618.93
0005: $Z_38 = 14.77

0005: $X_39 = 809.70
0005: $Y_39 = -621.72
0005: $Z_39 = 14.86

0005: $X_40 = 809.53
0005: $Y_40 = -624.53
0005: $Z_40 = 14.85

0005: $X_41 = 810.31
0005: $Y_41 = -638.18
0005: $Z_41 = 14.82

0005: $X_42 = 810.75
0005: $Y_42 = -641.22
0005: $Z_42 = 14.79

0005: $X_43 = 811.22
0005: $Y_43 = -644.30
0005: $Z_43 = 14.70

0005: $X_44 = 811.71
0005: $Y_44 = -647.43
0005: $Z_44 = 14.69

0005: $X_45 = 812.17
0005: $Y_45 = -650.61
0005: $Z_45 = 14.71

0005: $X_46 = 812.60
0005: $Y_46 = -653.83
0005: $Z_46 = 14.71

0005: $X_47 = 813.00
0005: $Y_47 = -657.07
0005: $Z_47 = 14.68

0005: $X_48 = 813.23
0005: $Y_48 = -659.25
0005: $Z_48 = 14.65

0005: $X_49 = 813.47
0005: $Y_49 = -662.56
0005: $Z_49 = 14.68

0005: $X_50 = 813.63
0005: $Y_50 = -664.79
0005: $Z_50 = 14.71

0005: $X_51 = 813.82
0005: $Y_51 = -668.16
0005: $Z_51 = 14.69

0005: $X_52 = 813.95
0005: $Y_52 = -672.65
0005: $Z_52 = 14.65

0005: $X_53 = 813.97
0005: $Y_53 = -676.04
0005: $Z_53 = 14.66

0005: $X_54 = 813.94
0005: $Y_54 = -679.43
0005: $Z_54 = 14.68

0005: $X_55 = 813.91
0005: $Y_55 = -681.70
0005: $Z_55 = 14.68

0005: $X_56 = 813.75
0005: $Y_56 = -685.11
0005: $Z_56 = 14.68

0005: $X_57 = 813.55
0005: $Y_57 = -688.52
0005: $Z_57 = 14.67

0005: $X_58 = 813.28
0005: $Y_58 = -691.93
0005: $Z_58 = 14.70

0005: $X_59 = 813.08
0005: $Y_59 = -694.20
0005: $Z_59 = 14.76

0005: $X_60 = 812.76
0005: $Y_60 = -697.61
0005: $Z_60 = 14.82

0005: $X_61 = 812.54
0005: $Y_61 = -699.88
0005: $Z_61 = 14.79

0005: $X_62 = 811.76
0005: $Y_62 = -709.06
0005: $Z_62 = 14.88

0005: $X_63 = 811.50
0005: $Y_63 = -712.50
0005: $Z_63 = 14.90

0005: $X_64 = 811.23
0005: $Y_64 = -715.93
0005: $Z_64 = 14.77

0005: $X_65 = 810.68
0005: $Y_65 = -721.68
0005: $Z_65 = 14.78

0005: $X_66 = 810.32
0005: $Y_66 = -725.14
0005: $Z_66 = 14.86

0005: $X_67 = 810.08
0005: $Y_67 = -727.45
0005: $Z_67 = 14.93

0005: $X_68 = 809.72
0005: $Y_68 = -730.91
0005: $Z_68 = 14.98

0005: $X_69 = 809.38
0005: $Y_69 = -734.38
0005: $Z_69 = 14.96

0005: $X_70 = 809.19
0005: $Y_70 = -736.70
0005: $Z_70 = 14.94

0005: $X_71 = 808.96
0005: $Y_71 = -740.18
0005: $Z_71 = 14.93

0005: $X_72 = 808.86
0005: $Y_72 = -743.64
0005: $Z_72 = 14.94

0005: $X_73 = 808.92
0005: $Y_73 = -749.42
0005: $Z_73 = 14.92

0005: $X_74 = 809.51
0005: $Y_74 = -762.26
0005: $Z_74 = 14.92

0005: $X_75 = 809.62
0005: $Y_75 = -764.60
0005: $Z_75 = 14.92

0005: $X_76 = 809.79
0005: $Y_76 = -769.31
0005: $Z_76 = 14.92

0005: $X_77 = 809.72
0005: $Y_77 = -775.18
0005: $Z_77 = 14.91

0005: $X_78 = 809.52
0005: $Y_78 = -778.70
0005: $Z_78 = 14.92

0005: $X_79 = 809.26
0005: $Y_79 = -782.21
0005: $Z_79 = 14.93

0005: $X_80 = 809.10
0005: $Y_80 = -799.81
0005: $Z_80 = 14.92

0005: $X_81 = 809.12
0005: $Y_81 = -803.35
0005: $Z_81 = 14.92

0005: $X_82 = 809.13
0005: $Y_82 = -806.91
0005: $Z_82 = 14.93

0005: $X_83 = 809.14
0005: $Y_83 = -810.47
0005: $Z_83 = 14.93

0005: $X_84 = 809.17
0005: $Y_84 = -814.03
0005: $Z_84 = 14.94

0005: $X_85 = 809.20
0005: $Y_85 = -817.61
0005: $Z_85 = 14.93

0005: $X_86 = 809.24
0005: $Y_86 = -821.18
0005: $Z_86 = 14.93

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
while 001A: 86 > $COUNTER_4X4_PICKUPS                      /////////// AMOUNT OF PICKUPS !!!
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
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
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
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
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
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
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
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
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
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
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
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
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
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
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
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
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
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
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
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
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
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
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
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
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
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
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
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_15 $Y_15 $Z_15
         0167: $SECOND_BLIP = create_marker_at $X_16 $Y_16 $Z_16 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 14
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_15 $Y_15 $Z_15
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_16 $Y_16 $Z_16
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_15 $Y_15 $Z_15 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_15 $Y_15 $Z_15
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_16 $Y_16 $Z_16
         0167: $SECOND_BLIP = create_marker_at $X_17 $Y_17 $Z_17 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 15
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_16 $Y_16 $Z_16
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_17 $Y_17 $Z_17
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_16 $Y_16 $Z_16 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_16 $Y_16 $Z_16
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_17 $Y_17 $Z_17
         0167: $SECOND_BLIP = create_marker_at $X_18 $Y_18 $Z_18 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 16
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_17 $Y_17 $Z_17
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_18 $Y_18 $Z_18
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_17 $Y_17 $Z_17 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_17 $Y_17 $Z_17
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_18 $Y_18 $Z_18
         0167: $SECOND_BLIP = create_marker_at $X_19 $Y_19 $Z_19 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 17
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_18 $Y_18 $Z_18
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_19 $Y_19 $Z_19
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_18 $Y_18 $Z_18 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_18 $Y_18 $Z_18
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_19 $Y_19 $Z_19
         0167: $SECOND_BLIP = create_marker_at $X_20 $Y_20 $Z_20 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 18
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_19 $Y_19 $Z_19
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_20 $Y_20 $Z_20
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_19 $Y_19 $Z_19 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_19 $Y_19 $Z_19
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_20 $Y_20 $Z_20
         0167: $SECOND_BLIP = create_marker_at $X_21 $Y_21 $Z_21 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 19
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_20 $Y_20 $Z_20
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_21 $Y_21 $Z_21
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_20 $Y_20 $Z_20 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_20 $Y_20 $Z_20
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_21 $Y_21 $Z_21
         0167: $SECOND_BLIP = create_marker_at $X_22 $Y_22 $Z_22 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 20
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_21 $Y_21 $Z_21
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_22 $Y_22 $Z_22
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_21 $Y_21 $Z_21 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_21 $Y_21 $Z_21
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_22 $Y_22 $Z_22
         0167: $SECOND_BLIP = create_marker_at $X_23 $Y_23 $Z_23 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 21
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_22 $Y_22 $Z_22
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_23 $Y_23 $Z_23
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_22 $Y_22 $Z_22 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_22 $Y_22 $Z_22
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_23 $Y_23 $Z_23
         0167: $SECOND_BLIP = create_marker_at $X_24 $Y_24 $Z_24 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 22
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_23 $Y_23 $Z_23
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_24 $Y_24 $Z_24
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_23 $Y_23 $Z_23 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_23 $Y_23 $Z_23
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_24 $Y_24 $Z_24
         0167: $SECOND_BLIP = create_marker_at $X_25 $Y_25 $Z_25 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 23
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_24 $Y_24 $Z_24
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_25 $Y_25 $Z_25
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_24 $Y_24 $Z_24 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_24 $Y_24 $Z_24
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_25 $Y_25 $Z_25
         0167: $SECOND_BLIP = create_marker_at $X_26 $Y_26 $Z_26 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 24
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_25 $Y_25 $Z_25
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_26 $Y_26 $Z_26
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_25 $Y_25 $Z_25 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_25 $Y_25 $Z_25
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_26 $Y_26 $Z_26
         0167: $SECOND_BLIP = create_marker_at $X_27 $Y_27 $Z_27 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 25
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_26 $Y_26 $Z_26
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_27 $Y_27 $Z_27
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_26 $Y_26 $Z_26 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_26 $Y_26 $Z_26
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_27 $Y_27 $Z_27
         0167: $SECOND_BLIP = create_marker_at $X_28 $Y_28 $Z_28 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 26
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_27 $Y_27 $Z_27
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_28 $Y_28 $Z_28
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_27 $Y_27 $Z_27 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_27 $Y_27 $Z_27
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_28 $Y_28 $Z_28
         0167: $SECOND_BLIP = create_marker_at $X_29 $Y_29 $Z_29 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 27
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_28 $Y_28 $Z_28
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_29 $Y_29 $Z_29
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_28 $Y_28 $Z_28 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_28 $Y_28 $Z_28
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_29 $Y_29 $Z_29
         0167: $SECOND_BLIP = create_marker_at $X_30 $Y_30 $Z_30 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 28
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_29 $Y_29 $Z_29
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_30 $Y_30 $Z_30
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_29 $Y_29 $Z_29 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_29 $Y_29 $Z_29
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_30 $Y_30 $Z_30
         0167: $SECOND_BLIP = create_marker_at $X_31 $Y_31 $Z_31 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 29
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_30 $Y_30 $Z_30
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_31 $Y_31 $Z_31
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_30 $Y_30 $Z_30 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_30 $Y_30 $Z_30
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_31 $Y_31 $Z_31
         0167: $SECOND_BLIP = create_marker_at $X_32 $Y_32 $Z_32 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 30
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_31 $Y_31 $Z_31
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_32 $Y_32 $Z_32
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_31 $Y_31 $Z_31 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_31 $Y_31 $Z_31
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_32 $Y_32 $Z_32
         0167: $SECOND_BLIP = create_marker_at $X_33 $Y_33 $Z_33 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 31
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_32 $Y_32 $Z_32
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_33 $Y_33 $Z_33
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_32 $Y_32 $Z_32 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_32 $Y_32 $Z_32
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_33 $Y_33 $Z_33
         0167: $SECOND_BLIP = create_marker_at $X_34 $Y_34 $Z_34 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 32
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_33 $Y_33 $Z_33
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_34 $Y_34 $Z_34
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_33 $Y_33 $Z_33 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_33 $Y_33 $Z_33
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_34 $Y_34 $Z_34
         0167: $SECOND_BLIP = create_marker_at $X_35 $Y_35 $Z_35 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 33
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_34 $Y_34 $Z_34
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_35 $Y_35 $Z_35
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_34 $Y_34 $Z_34 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_34 $Y_34 $Z_34
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_35 $Y_35 $Z_35
         0167: $SECOND_BLIP = create_marker_at $X_36 $Y_36 $Z_36 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 34
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_35 $Y_35 $Z_35
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_36 $Y_36 $Z_36
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_35 $Y_35 $Z_35 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_35 $Y_35 $Z_35
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_36 $Y_36 $Z_36
         0167: $SECOND_BLIP = create_marker_at $X_37 $Y_37 $Z_37 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 35
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_36 $Y_36 $Z_36
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_37 $Y_37 $Z_37
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_36 $Y_36 $Z_36 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_36 $Y_36 $Z_36
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_37 $Y_37 $Z_37
         0167: $SECOND_BLIP = create_marker_at $X_38 $Y_38 $Z_38 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 36
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_37 $Y_37 $Z_37
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_38 $Y_38 $Z_38
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_37 $Y_37 $Z_37 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_37 $Y_37 $Z_37
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_38 $Y_38 $Z_38
         0167: $SECOND_BLIP = create_marker_at $X_39 $Y_39 $Z_39 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 37
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_38 $Y_38 $Z_38
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_39 $Y_39 $Z_39
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_38 $Y_38 $Z_38 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_38 $Y_38 $Z_38
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_39 $Y_39 $Z_39
         0167: $SECOND_BLIP = create_marker_at $X_40 $Y_40 $Z_40 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 38
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_39 $Y_39 $Z_39
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_40 $Y_40 $Z_40
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_39 $Y_39 $Z_39 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_39 $Y_39 $Z_39
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_40 $Y_40 $Z_40
         0167: $SECOND_BLIP = create_marker_at $X_41 $Y_41 $Z_41 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 39
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_40 $Y_40 $Z_40
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_41 $Y_41 $Z_41
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_40 $Y_40 $Z_40 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_40 $Y_40 $Z_40
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_41 $Y_41 $Z_41
         0167: $SECOND_BLIP = create_marker_at $X_42 $Y_42 $Z_42 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 40
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_41 $Y_41 $Z_41
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_42 $Y_42 $Z_42
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_41 $Y_41 $Z_41 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_41 $Y_41 $Z_41
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_42 $Y_42 $Z_42
         0167: $SECOND_BLIP = create_marker_at $X_43 $Y_43 $Z_43 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 41
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_42 $Y_42 $Z_42
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_43 $Y_43 $Z_43
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_42 $Y_42 $Z_42 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_42 $Y_42 $Z_42
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_43 $Y_43 $Z_43
         0167: $SECOND_BLIP = create_marker_at $X_44 $Y_44 $Z_44 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 42
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_43 $Y_43 $Z_43
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_44 $Y_44 $Z_44
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_43 $Y_43 $Z_43 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_43 $Y_43 $Z_43
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_44 $Y_44 $Z_44
         0167: $SECOND_BLIP = create_marker_at $X_45 $Y_45 $Z_45 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 43
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_44 $Y_44 $Z_44
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_45 $Y_45 $Z_45
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_44 $Y_44 $Z_44 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_44 $Y_44 $Z_44
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_45 $Y_45 $Z_45
         0167: $SECOND_BLIP = create_marker_at $X_46 $Y_46 $Z_46 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 44
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_45 $Y_45 $Z_45
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_46 $Y_46 $Z_46
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_45 $Y_45 $Z_45 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_45 $Y_45 $Z_45
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_46 $Y_46 $Z_46
         0167: $SECOND_BLIP = create_marker_at $X_47 $Y_47 $Z_47 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 45
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_46 $Y_46 $Z_46
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_47 $Y_47 $Z_47
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_46 $Y_46 $Z_46 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_46 $Y_46 $Z_46
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_47 $Y_47 $Z_47
         0167: $SECOND_BLIP = create_marker_at $X_48 $Y_48 $Z_48 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 46
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_47 $Y_47 $Z_47
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_48 $Y_48 $Z_48
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_47 $Y_47 $Z_47 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_47 $Y_47 $Z_47
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_48 $Y_48 $Z_48
         0167: $SECOND_BLIP = create_marker_at $X_49 $Y_49 $Z_49 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 47
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_48 $Y_48 $Z_48
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_49 $Y_49 $Z_49
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_48 $Y_48 $Z_48 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_48 $Y_48 $Z_48
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_49 $Y_49 $Z_49
         0167: $SECOND_BLIP = create_marker_at $X_50 $Y_50 $Z_50 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 48
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_49 $Y_49 $Z_49
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_50 $Y_50 $Z_50
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_49 $Y_49 $Z_49 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_49 $Y_49 $Z_49
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_50 $Y_50 $Z_50
         0167: $SECOND_BLIP = create_marker_at $X_51 $Y_51 $Z_51 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 49
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_50 $Y_50 $Z_50
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_51 $Y_51 $Z_51
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_50 $Y_50 $Z_50 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_50 $Y_50 $Z_50
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_51 $Y_51 $Z_51
         0167: $SECOND_BLIP = create_marker_at $X_52 $Y_52 $Z_52 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 50
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_51 $Y_51 $Z_51
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_52 $Y_52 $Z_52
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_51 $Y_51 $Z_51 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_51 $Y_51 $Z_51
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_52 $Y_52 $Z_52
         0167: $SECOND_BLIP = create_marker_at $X_53 $Y_53 $Z_53 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 51
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_52 $Y_52 $Z_52
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_53 $Y_53 $Z_53
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_52 $Y_52 $Z_52 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_52 $Y_52 $Z_52
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_53 $Y_53 $Z_53
         0167: $SECOND_BLIP = create_marker_at $X_54 $Y_54 $Z_54 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 52
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_53 $Y_53 $Z_53
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_54 $Y_54 $Z_54
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_53 $Y_53 $Z_53 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_53 $Y_53 $Z_53
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_54 $Y_54 $Z_54
         0167: $SECOND_BLIP = create_marker_at $X_55 $Y_55 $Z_55 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 53
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_54 $Y_54 $Z_54
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_55 $Y_55 $Z_55
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_54 $Y_54 $Z_54 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_54 $Y_54 $Z_54
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_55 $Y_55 $Z_55
         0167: $SECOND_BLIP = create_marker_at $X_56 $Y_56 $Z_56 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 54
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_55 $Y_55 $Z_55
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_56 $Y_56 $Z_56
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_55 $Y_55 $Z_55 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_55 $Y_55 $Z_55
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_56 $Y_56 $Z_56
         0167: $SECOND_BLIP = create_marker_at $X_57 $Y_57 $Z_57 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 55
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_56 $Y_56 $Z_56
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_57 $Y_57 $Z_57
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_56 $Y_56 $Z_56 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_56 $Y_56 $Z_56
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_57 $Y_57 $Z_57
         0167: $SECOND_BLIP = create_marker_at $X_58 $Y_58 $Z_58 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 56
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_57 $Y_57 $Z_57
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_58 $Y_58 $Z_58
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_57 $Y_57 $Z_57 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_57 $Y_57 $Z_57
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_58 $Y_58 $Z_58
         0167: $SECOND_BLIP = create_marker_at $X_59 $Y_59 $Z_59 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 57
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_58 $Y_58 $Z_58
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_59 $Y_59 $Z_59
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_58 $Y_58 $Z_58 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_58 $Y_58 $Z_58
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_59 $Y_59 $Z_59
         0167: $SECOND_BLIP = create_marker_at $X_60 $Y_60 $Z_60 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 58
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_59 $Y_59 $Z_59
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_60 $Y_60 $Z_60
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_59 $Y_59 $Z_59 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_59 $Y_59 $Z_59
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_60 $Y_60 $Z_60
         0167: $SECOND_BLIP = create_marker_at $X_61 $Y_61 $Z_61 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 59
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_60 $Y_60 $Z_60
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_61 $Y_61 $Z_61
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_60 $Y_60 $Z_60 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_60 $Y_60 $Z_60
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_61 $Y_61 $Z_61
         0167: $SECOND_BLIP = create_marker_at $X_62 $Y_62 $Z_62 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 60
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_61 $Y_61 $Z_61
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_62 $Y_62 $Z_62
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_61 $Y_61 $Z_61 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_61 $Y_61 $Z_61
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_62 $Y_62 $Z_62
         0167: $SECOND_BLIP = create_marker_at $X_63 $Y_63 $Z_63 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 61
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_62 $Y_62 $Z_62
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_63 $Y_63 $Z_63
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_62 $Y_62 $Z_62 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_62 $Y_62 $Z_62
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_63 $Y_63 $Z_63
         0167: $SECOND_BLIP = create_marker_at $X_64 $Y_64 $Z_64 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 62
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_63 $Y_63 $Z_63
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_64 $Y_64 $Z_64
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_63 $Y_63 $Z_63 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_63 $Y_63 $Z_63
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_64 $Y_64 $Z_64
         0167: $SECOND_BLIP = create_marker_at $X_65 $Y_65 $Z_65 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 63
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_64 $Y_64 $Z_64
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_65 $Y_65 $Z_65
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_64 $Y_64 $Z_64 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_64 $Y_64 $Z_64
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_65 $Y_65 $Z_65
         0167: $SECOND_BLIP = create_marker_at $X_66 $Y_66 $Z_66 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 64
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_65 $Y_65 $Z_65
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_66 $Y_66 $Z_66
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_65 $Y_65 $Z_65 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_65 $Y_65 $Z_65
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_66 $Y_66 $Z_66
         0167: $SECOND_BLIP = create_marker_at $X_67 $Y_67 $Z_67 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 65
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_66 $Y_66 $Z_66
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_67 $Y_67 $Z_67
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_66 $Y_66 $Z_66 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_66 $Y_66 $Z_66
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_67 $Y_67 $Z_67
         0167: $SECOND_BLIP = create_marker_at $X_68 $Y_68 $Z_68 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 66
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_67 $Y_67 $Z_67
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_68 $Y_68 $Z_68
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_67 $Y_67 $Z_67 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_67 $Y_67 $Z_67
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_68 $Y_68 $Z_68
         0167: $SECOND_BLIP = create_marker_at $X_69 $Y_69 $Z_69 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 67
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_68 $Y_68 $Z_68
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_69 $Y_69 $Z_69
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_68 $Y_68 $Z_68 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_68 $Y_68 $Z_68
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_69 $Y_69 $Z_69
         0167: $SECOND_BLIP = create_marker_at $X_70 $Y_70 $Z_70 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 68
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_69 $Y_69 $Z_69
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_70 $Y_70 $Z_70
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_69 $Y_69 $Z_69 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_69 $Y_69 $Z_69
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_70 $Y_70 $Z_70
         0167: $SECOND_BLIP = create_marker_at $X_71 $Y_71 $Z_71 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 69
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_70 $Y_70 $Z_70
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_71 $Y_71 $Z_71
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_70 $Y_70 $Z_70 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_70 $Y_70 $Z_70
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_71 $Y_71 $Z_71
         0167: $SECOND_BLIP = create_marker_at $X_72 $Y_72 $Z_72 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 70
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_71 $Y_71 $Z_71
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_72 $Y_72 $Z_72
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_71 $Y_71 $Z_71 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_71 $Y_71 $Z_71
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_72 $Y_72 $Z_72
         0167: $SECOND_BLIP = create_marker_at $X_73 $Y_73 $Z_73 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 71
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_72 $Y_72 $Z_72
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_73 $Y_73 $Z_73
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_72 $Y_72 $Z_72 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_72 $Y_72 $Z_72
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_73 $Y_73 $Z_73
         0167: $SECOND_BLIP = create_marker_at $X_74 $Y_74 $Z_74 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 72
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_73 $Y_73 $Z_73
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_74 $Y_74 $Z_74
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_73 $Y_73 $Z_73 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_73 $Y_73 $Z_73
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_74 $Y_74 $Z_74
         0167: $SECOND_BLIP = create_marker_at $X_75 $Y_75 $Z_75 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 73
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_74 $Y_74 $Z_74
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_75 $Y_75 $Z_75
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_74 $Y_74 $Z_74 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_74 $Y_74 $Z_74
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_75 $Y_75 $Z_75
         0167: $SECOND_BLIP = create_marker_at $X_76 $Y_76 $Z_76 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 74
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_75 $Y_75 $Z_75
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_76 $Y_76 $Z_76
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_75 $Y_75 $Z_75 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_75 $Y_75 $Z_75
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_76 $Y_76 $Z_76
         0167: $SECOND_BLIP = create_marker_at $X_77 $Y_77 $Z_77 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 75
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_76 $Y_76 $Z_76
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_77 $Y_77 $Z_77
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_76 $Y_76 $Z_76 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_76 $Y_76 $Z_76
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_77 $Y_77 $Z_77
         0167: $SECOND_BLIP = create_marker_at $X_78 $Y_78 $Z_78 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 76
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_77 $Y_77 $Z_77
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_78 $Y_78 $Z_78
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_77 $Y_77 $Z_77 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_77 $Y_77 $Z_77
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_78 $Y_78 $Z_78
         0167: $SECOND_BLIP = create_marker_at $X_79 $Y_79 $Z_79 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 77
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_78 $Y_78 $Z_78
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_79 $Y_79 $Z_79
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_78 $Y_78 $Z_78 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_78 $Y_78 $Z_78
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_79 $Y_79 $Z_79
         0167: $SECOND_BLIP = create_marker_at $X_80 $Y_80 $Z_80 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 78
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_79 $Y_79 $Z_79
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_80 $Y_80 $Z_80
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_79 $Y_79 $Z_79 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_79 $Y_79 $Z_79
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_80 $Y_80 $Z_80
         0167: $SECOND_BLIP = create_marker_at $X_81 $Y_81 $Z_81 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 79
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_80 $Y_80 $Z_80
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_81 $Y_81 $Z_81
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_80 $Y_80 $Z_80 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_80 $Y_80 $Z_80
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_81 $Y_81 $Z_81
         0167: $SECOND_BLIP = create_marker_at $X_82 $Y_82 $Z_82 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 80
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_81 $Y_81 $Z_81
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_82 $Y_82 $Z_82
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_81 $Y_81 $Z_81 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_81 $Y_81 $Z_81
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_82 $Y_82 $Z_82
         0167: $SECOND_BLIP = create_marker_at $X_83 $Y_83 $Z_83 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 81
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_82 $Y_82 $Z_82
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_83 $Y_83 $Z_83
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_82 $Y_82 $Z_82 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_82 $Y_82 $Z_82
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_83 $Y_83 $Z_83
         0167: $SECOND_BLIP = create_marker_at $X_84 $Y_84 $Z_84 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 82
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_83 $Y_83 $Z_83
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_84 $Y_84 $Z_84
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_83 $Y_83 $Z_83 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_83 $Y_83 $Z_83
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_84 $Y_84 $Z_84
         0167: $SECOND_BLIP = create_marker_at $X_85 $Y_85 $Z_85 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 83
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_84 $Y_84 $Z_84
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_85 $Y_85 $Z_85
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_84 $Y_84 $Z_84 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_84 $Y_84 $Z_84
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_85 $Y_85 $Z_85
         0167: $SECOND_BLIP = create_marker_at $X_86 $Y_86 $Z_86 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 84
 then
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 100 100 200 at_point $X_85 $Y_85 $Z_85
     024F: create_corona 3.0 CORONATYPE_HEX FLARETYPE_NONE with_color 50 50 50 at_point $X_86 $Y_86 $Z_86
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_85 $Y_85 $Z_85 radius 7.5 7.5 7.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_85 $Y_85 $Z_85
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
         018A: $FIRST_BLIP = create_checkpoint_at $X_86 $Y_86 $Z_86
         0167: $SECOND_BLIP = create_marker_at $X_87 $Y_87 $Z_87 color 5 flag 2
     end
 end
 if
     0038: $blipcount == 85
 then
     024F: create_corona 5.0 CORONATYPE_HEX FLARETYPE_NONE with_color 0 200 0 at_point $X_86 $Y_86 $Z_86
     if
         00F7:   player $PLAYER_CHAR sphere 0 near_point_in_car $X_86 $Y_86 $Z_86 radius 12.5 12.5 12.5
     then
         0164: disable_marker $FIRST_BLIP
         0164: disable_marker $SECOND_BLIP
         018C: play_sound SOUND_PART_MISSION_COMPLETE at $X_86 $Y_86 $Z_86
         0008: $blipcount += 1
         gosub @MISSION_test_CHECKPOINT_PICKED_UP
     end
 end

    // ----------------------------------------------------------------------------------------------
    // -------------------R                INTRO START           ------------------------------------
    // ----------------------------------------------------------------------------------------------

 if
     0038:   $PATRIOT_PLAYGROUND_HELP_FINISHED == 0 
 then
     01B4: set_player $PLAYER_CHAR controllable 0
     015F: set_camera_position 914.31 -92.19 25.79 0.0 rotation 0.0 0.0
     03CB: load_scene 925.21 -40.70 7.18
     0160: point_camera 925.21 -40.70 7.18 switchstyle JUMP_CUT
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
         goto @MISSION_test_FAILED
     end
 end
 if
     80DE:   not is_player_in_model $PLAYER_CHAR model #BANSHEE
 then
     00BC: print_now 'T4X4_F' time 3000 flag 1  // ~r~You bailed! Too tough for you?!
     goto @MISSION_test_FAILED
 end
end

    // ----------------------------------------------------------------------------------------------
    // -------------------R    TIMER STARTED - WIN CONDITION       ----------------------------------
    // ----------------------------------------------------------------------------------------------


if
 0038:   $COUNTER_4X4_PICKUPS == 86   // CP amount 
then
 goto @MISSION_test_PASSED
end

    // ----------------------------------------------------------------------------------------------
    // -------------------R      CHECKPOINT PICK UP                ----------------------------------
    // ----------------------------------------------------------------------------------------------


:MISSION_test_CHECKPOINT_PICKED_UP
0008: $COUNTER_4X4_PICKUPS += 1 
0008: $TIMER_4X4 += 8000000
01E5: text_1number_highpriority 'T4X4_1B' $COUNTER_4X4_PICKUPS flag 30000 time 1  // ~1~ of many!
return


    // ----------------------------------------------------------------------------------------------
    // -------------------R       MISSION FAIL ROUTINE             ----------------------------------
    // ----------------------------------------------------------------------------------------------

:MISSION_test_FAILED
00BA: print_big 'M_FAIL' time 2000 style 1  // MISSION FAILED!
0255: set_critical_mission_restart_at 825.9011 -1054.3267 14.4000 angle 56.0434
0322: kill_player $PLAYER_CHAR
wait 2000 ms
goto @MISSION_CLEANUP_test
return

    // ----------------------------------------------------------------------------------------------
    // -------------------R    MISSION COMPLETE ROUTINE            ----------------------------------
    // ----------------------------------------------------------------------------------------------

:MISSION_test_PASSED
0004: $COURSE_test = $TIMER_4X4
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
     015F: set_camera_position 914.31 -92.19 25.79 0.0 rotation 0.0 0.0
     03CB: load_scene 925.21 -40.70 7.18
     0160: point_camera 925.21 -40.70 7.18 switchstyle JUMP_CUT
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

:MISSION_CLEANUP_test
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
