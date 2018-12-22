package com.wolkowiczmateusz.android.hellokotlin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

sealed class ScreenState {
    class Error : ScreenState()
    class Loading : ScreenState()
    data class Data(val someData: SomeData) : ScreenState()
}

// just to check if it's working
sealed class ScreenStateParceled {
    class Error : ScreenStateParceled()
    class Loading : ScreenStateParceled()
    data class Data(val someData: SomeData) : ScreenStateParceled()
    @Parcelize
    data class Data2(val someData: SomeData) : ScreenStateParceled(), Parcelable
}

// Error and Loading have no data to handle so it could be singleton like below
sealed class ScreenStateSingleton {
    object Error : ScreenStateSingleton()
    object Loading : ScreenStateSingleton()
    data class Data(val someData: SomeData) : ScreenStateSingleton()
}

//in view
fun setScreenState(screenState: ScreenStateSingleton) {
    when (screenState) {
        is ScreenStateSingleton.Error -> { /* set error state in the view */
        }
        is ScreenStateSingleton.Loading -> { /* set loading state in the view */
        }
        is ScreenStateSingleton.Data -> {
            /* hide loading or error states in the view and display data*/
            //sometextView.text = screenState.someData.name
        }
    }
}

class SomeData
