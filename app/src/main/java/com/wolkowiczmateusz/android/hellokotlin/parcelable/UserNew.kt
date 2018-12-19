package com.wolkowiczmateusz.android.hellokotlin.parcelable

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// won't work under android 4.4
@Parcelize
data class UserNew(val name: String,
                   val username: String) : Parcelable