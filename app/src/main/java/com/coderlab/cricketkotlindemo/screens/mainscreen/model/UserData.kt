package com.coderlab.cricketkotlindemo.screens.mainscreen.model

import javax.inject.Inject

class UserData @Inject constructor(val username: String) {

    init {
        print(username)
    }
}