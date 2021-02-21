package com.example.mttp_projekt

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.*
import kotlinx.android.synthetic.main.activity_main.*

private var listOfSquares: List<Square> = mutableListOf(Square(),Square(),Square(),Square(),Square(),Square(),Square(),Square(),Square())
private var isTurnX: Boolean = true
private var isThereWinner = false
private var xNumberOfWins: Int = 0
private var oNumberOfWins: Int = 0

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        square0.setOnClickListener(this)
        square1.setOnClickListener(this)
        square2.setOnClickListener(this)
        square3.setOnClickListener(this)
        square4.setOnClickListener(this)
        square5.setOnClickListener(this)
        square6.setOnClickListener(this)
        square7.setOnClickListener(this)
        square8.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.square0 -> {
                if(!isThereWinner){
                    listOfSquares[0].enterSymbol(isTurnX)
                    square0.setImageResource(listOfSquares[0].getSquareImageResource())
                    displayWinner()
                    isTurnX = !isTurnX
                }
            }
            R.id.square1 -> {
                if(!isThereWinner){
                    listOfSquares[1].enterSymbol(isTurnX)
                    square1.setImageResource(listOfSquares[1].getSquareImageResource())
                    displayWinner()
                    isTurnX = !isTurnX
                }
            }
            R.id.square2 -> {
                if(!isThereWinner){
                    listOfSquares[2].enterSymbol(isTurnX)
                    square2.setImageResource(listOfSquares[2].getSquareImageResource())
                    displayWinner()
                    isTurnX = !isTurnX
                }
            }
            R.id.square3-> {
                if(!isThereWinner){
                    listOfSquares[3].enterSymbol(isTurnX)
                    square3.setImageResource(listOfSquares[3].getSquareImageResource())
                    displayWinner()
                    isTurnX = !isTurnX
                }
            }
            R.id.square4-> {
                if(!isThereWinner){
                    listOfSquares[4].enterSymbol(isTurnX)
                    square4.setImageResource(listOfSquares[4].getSquareImageResource())
                    displayWinner()
                    isTurnX = !isTurnX
                }
            }
            R.id.square5 -> {
                if(!isThereWinner){
                    listOfSquares[5].enterSymbol(isTurnX)
                    square5.setImageResource(listOfSquares[5].getSquareImageResource())
                    displayWinner()
                    isTurnX = !isTurnX
                }

            }
            R.id.square6 -> {
                if(!isThereWinner){
                    listOfSquares[6].enterSymbol(isTurnX)
                    square6.setImageResource(listOfSquares[6].getSquareImageResource())
                    displayWinner()
                    isTurnX = !isTurnX
                }

            }
            R.id.square7 -> {
                if(!isThereWinner){
                    listOfSquares[7].enterSymbol(isTurnX)
                    square7.setImageResource(listOfSquares[7].getSquareImageResource())
                    displayWinner()
                    isTurnX = !isTurnX
                }

            }
            R.id.square8 -> {
                if(!isThereWinner){
                    listOfSquares[8].enterSymbol(isTurnX)
                    square8.setImageResource(listOfSquares[8].getSquareImageResource())
                    displayWinner()
                    isTurnX = !isTurnX
                }
            }
        }
    }

    private fun checkWinner(): Int {
        if(listOfSquares[0].getSquareImageResource() == R.drawable.x && listOfSquares[1].getSquareImageResource() == R.drawable.x && listOfSquares[2].getSquareImageResource() == R.drawable.x
            || listOfSquares[3].getSquareImageResource() == R.drawable.x && listOfSquares[4].getSquareImageResource() == R.drawable.x && listOfSquares[5].getSquareImageResource() == R.drawable.x
            || listOfSquares[6].getSquareImageResource() == R.drawable.x && listOfSquares[7].getSquareImageResource() == R.drawable.x && listOfSquares[8].getSquareImageResource() == R.drawable.x
            || listOfSquares[0].getSquareImageResource() == R.drawable.x && listOfSquares[3].getSquareImageResource() == R.drawable.x && listOfSquares[6].getSquareImageResource() == R.drawable.x
            || listOfSquares[1].getSquareImageResource() == R.drawable.x && listOfSquares[4].getSquareImageResource() == R.drawable.x && listOfSquares[7].getSquareImageResource() == R.drawable.x
            || listOfSquares[2].getSquareImageResource() == R.drawable.x && listOfSquares[5].getSquareImageResource() == R.drawable.x && listOfSquares[8].getSquareImageResource() == R.drawable.x
            || listOfSquares[0].getSquareImageResource() == R.drawable.x && listOfSquares[4].getSquareImageResource() == R.drawable.x && listOfSquares[8].getSquareImageResource() == R.drawable.x
            || listOfSquares[2].getSquareImageResource() == R.drawable.x && listOfSquares[4].getSquareImageResource() == R.drawable.x && listOfSquares[6].getSquareImageResource() == R.drawable.x) {

                isThereWinner = true
                return Winner.X.ordinal
        } else if (listOfSquares[0].getSquareImageResource() == R.drawable.o && listOfSquares[1].getSquareImageResource() == R.drawable.o && listOfSquares[2].getSquareImageResource() == R.drawable.o
            || listOfSquares[3].getSquareImageResource() == R.drawable.o && listOfSquares[4].getSquareImageResource() == R.drawable.o && listOfSquares[5].getSquareImageResource() == R.drawable.o
            || listOfSquares[6].getSquareImageResource() == R.drawable.o && listOfSquares[7].getSquareImageResource() == R.drawable.o && listOfSquares[8].getSquareImageResource() == R.drawable.o
            || listOfSquares[0].getSquareImageResource() == R.drawable.o && listOfSquares[3].getSquareImageResource() == R.drawable.o && listOfSquares[6].getSquareImageResource() == R.drawable.o
            || listOfSquares[1].getSquareImageResource() == R.drawable.o && listOfSquares[4].getSquareImageResource() == R.drawable.o && listOfSquares[7].getSquareImageResource() == R.drawable.o
            || listOfSquares[2].getSquareImageResource() == R.drawable.o && listOfSquares[5].getSquareImageResource() == R.drawable.o && listOfSquares[8].getSquareImageResource() == R.drawable.o
            || listOfSquares[0].getSquareImageResource() == R.drawable.o && listOfSquares[4].getSquareImageResource() == R.drawable.o && listOfSquares[8].getSquareImageResource() == R.drawable.o
            || listOfSquares[2].getSquareImageResource() == R.drawable.o && listOfSquares[4].getSquareImageResource() == R.drawable.o && listOfSquares[6].getSquareImageResource() == R.drawable.o){

                isThereWinner = true
                return Winner.O.ordinal
        } else
            return Winner.NONE.ordinal
    }

    enum class Winner{
        X,
        O,
        NONE
    }

    private fun displayWinner(){
        val dialogBuilder = AlertDialog.Builder(this)

        dialogBuilder
            .setCancelable(false)
            .setPositiveButton("Play Again", DialogInterface.OnClickListener {
                    _, _ -> playAgain()
            })

        val alert = dialogBuilder.create()
        alert.setTitle("Winner")

        if(checkWinner() == Winner.X.ordinal){
            xNumberOfWins++
            alert.setMessage("Winner is X")
            alert.show()
        } else if (checkWinner() == Winner.O.ordinal){
            oNumberOfWins++
            alert.setMessage("Winner is O")
            alert.show()
        } else if(checkWinner() == Winner.NONE.ordinal){
            var counter = 0
            listOfSquares.forEach(){
                if(it.isEntered){
                    counter++
                }
            }
            if(counter == 9){
                alert.setMessage("Draw")
                alert.show()
            }
        }
    }

    private fun playAgain(){
        xWinNumber.text = xNumberOfWins.toString()
        oWinNumber.text = oNumberOfWins.toString()
        isThereWinner = false
        isTurnX = true;
        square0.setImageResource(0)
        square1.setImageResource(0)
        square2.setImageResource(0)
        square3.setImageResource(0)
        square4.setImageResource(0)
        square5.setImageResource(0)
        square6.setImageResource(0)
        square7.setImageResource(0)
        square8.setImageResource(0)
        listOfSquares.forEach(){
            it.resetImageReource()
            it.isEntered = false
        }
    }
}