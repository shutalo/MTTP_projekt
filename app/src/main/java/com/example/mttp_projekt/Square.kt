package com.example.mttp_projekt

class Square {

    var isEntered: Boolean = false
    private var imageResource: Int = 0

    fun enterSymbol(type: Boolean){
        if(type && !isEntered){
            imageResource = R.drawable.x
            isEntered = true
        } else if(!type && !isEntered){
            imageResource = R.drawable.o
            isEntered = true
        }
    }

    fun getSquareImageResource(): Int{
        return imageResource
    }

    fun resetImageReource(){
        imageResource = 0
    }

}