package com.omega.diceroller

import org.junit.Assert
import org.junit.Test

class DiceThrowerTest {

    @Test
    fun shouldThrowRuntimeExceptionNErrorWhenDiceSizeDifferentFrom6() {
        Assert.assertThrows(RuntimeException::class.java) {
            DiceThrower(Dice(5))
        }
    }
}