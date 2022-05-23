package com.omega.diceroller

import org.junit.Assert
import org.junit.Test

class DiceTest {

    @Test
    fun shouldThrowNullPointerExceptionWhenNotRolledFirst() {
        val dice = Dice(6)
        Assert.assertThrows(NullPointerException::class.java) {
            dice.getLastResult()
        }
    }

    @Test
    fun shouldReturnLastResult() {
        val dice = Dice(6)
        dice.roll()
        Assert.assertNotNull(dice.getLastResult())
    }
}