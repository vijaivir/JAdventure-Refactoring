package com.jadventure.game.entities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void newRecruit() {
        Player player = Player.getInstance("recruit");
        int expected = 1;
        int actual = player.getArmour();
        assertEquals("Failure - new recruit not properly created", expected, actual);
    }

    @Test
    public void newSewerRat() {
        Player player = Player.getInstance("sewerrat");
        int expected = 0;
        int actual = player.getArmour();
        assertEquals("Failure - new sewer rat not properly created", expected, actual);
    }

    @Test
    public void oldPlayer() {
        Player player = Player.load("test");
        String expected = "test";
        String actual = player.getName();
        assertEquals("Failure - old player not properly loaded", expected, actual);
    }

    @Test
    public void playerTypeTest() {
        Player player = Player.load("sewer_rat_test");
        assertEquals("Failure - test player not properly loaded", "Sewer Rat", player.getCurrentCharacterType());
        player.trigger("kill", "Brotherhood Member");
        assertEquals("Failure - test player type did not change", "Syndicate Member", player.getCurrentCharacterType());
    }
}
