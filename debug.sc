// -------------------------------------------------------
// ALL VARIABLES DEFINED BELOW UNLOCK FEATURES OF THE CODE
// -------------------------------------------------------
:DEBUG_VARIABLES
0004: $MASTERDEBUG                = 1 // Set to 1 to enable debug functions as defined in the STARTER thread.
0004: $DEBUGUNLOCKISLANDS	  = 0 // Unlock the other islands
0004: $DEBUGPACKAGESCOMPLETED	  = 0 // Set to 1 to activate all packages rewards
0004: $DEBUGPARAMEDICCOMPLETED	  = 0 // Set to 1 to trigger paramedic rewards
0004: $DEBUGVIGILANTECOMPLETED	  = 0 // Set to 1 to trigger vigilante rewards
0004: $DEBUGFIREFIGHTERCOMPLETED  = 0 // Set to 1 to trigger firefighter rewards
0004: $DEBUGIEGARAGESCOMPLETED    = 0 // Set to 1 to trigger import/export rewards
0004: $UNLOCKEXTRAS1		  = 0 // Set to 1 to enable the stuff that was commented out by R*
0004: $UNLOCKEXTRAS2		  = 0 // Set to 1 to enable custom extras
return

//#####################################################################################
//#####################################################################################
// END DEFINE DEBUG VARS / BEGIN TEMP THREAD INIT
//#####################################################################################
//#####################################################################################

:STARTER         //This thread is here to do stuff if $MASTERLCDEBUG is on
03A4: name_thread 'TMP_THR'
0111: set_deatharrest_state 0 (disabled)

wait 1000 ms
if
	0038:   $MASTERDEBUG == 1  
then
	0109: player $PLAYER_CHAR money += 10000000
	004F: create_thread @COORDS			// Enable if you need coordinates display in DEBUG mode
end
end_thread

//#####################################################################################
//#####################################################################################
// END TEMP THREAD INIT / BEGIN COORDINATES DISPLAY THREAD
//#####################################################################################
//#####################################################################################

:COORDS
03A4: name_thread 'PLR_POS'

while true
    wait 0 ms
    if 
        0256:   player $PLAYER_CHAR defined
    then
        0007: 4@ = 10.0  
        0007: 5@ = 10.0  
        0054: store_player $PLAYER_CHAR position_to 7@ 8@ 9@
	0170: 10@ = player $PLAYER_CHAR z_angle
	// For whatever reason the game only want to show the first two text boxes created, 
	// so we let X and Y be shown standard, and Z and Angle if the Look Behind key is held.
	if
		80E1:   NOT   key_pressed 0 19 // Look behind on foot, Sub-mission in vehicle.
	then
        	// X
       		0087: 2@ = 7@
        	gosub @COORDS_FRACT
        	gosub @COORDS_DRAW
        	// Y
        	0087: 2@ = 8@
        	gosub @COORDS_FRACT
        	gosub @COORDS_DRAW
        else
		// Z
        	0087: 2@ = 9@
        	gosub @COORDS_FRACT
        	gosub @COORDS_DRAW
        	// Angle
        	0087: 2@ = 10@
        	gosub @COORDS_FRACT
        	gosub @COORDS_DRAW
	end
        wait 250 ms
        03F0: text_draw_toggle  0
    end
end

:COORDS_FRACT
0092: 0@ = float_to_integer 2@    // Get the integer part
0093: 3@ = integer_to_float 0@    // By transforming back to float, fractional part disappears
0063: 2@ -= 3@                    // By subtracting integer part from original number, get only fractional part
0013: 2@ *=  100.0                // Round fractional part to two digits
0092: 1@ = float_to_integer 2@    // Convert fractional part to int
0095: make 1@ absolute_integer    // Fraction should be always positive
return

:COORDS_DRAW
gosub @COORDS_DRAW_SETUP
if
    0019:    1@ >  9
then
    045B: text_draw_2numbers  4@ 5@ 'POS1'  0@  1@  // ~1~.~1~
else
    045B: text_draw_2numbers  4@ 5@ 'POS2'  0@  1@  // ~1~.0~1~
end
000B: 5@ +=  15.0  
return

:COORDS_DRAW_SETUP
0340: set_text_draw_color  200  0  0  255
0341: set_text_draw_align_justify 1
03E4: set_text_draw_align_right  0
0343: set_text_linewidth  500.0
0348: set_text_draw_proportional  1
0342: set_text_draw_centered  0
0345: set_text_draw_in_box  0
033F: set_text_draw_letter_width_height 0.3 1.4 //0.5  1.8
return
