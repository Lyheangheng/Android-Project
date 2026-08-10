package com.android.basic.android.util

import android.util.Patterns

object ValidEmail{

    fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}
