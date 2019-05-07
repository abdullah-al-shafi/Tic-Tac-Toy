package shafi.sbf.com.tictactoy

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    protected fun buClick(view: View) {
        val buSelected = view as Button
        var cellId = 0
        when(buSelected.id){
            R.id.bu1 -> cellId = 1
            R.id.bu2 -> cellId = 2
            R.id.bu3 -> cellId = 3
            R.id.bu4 -> cellId = 4
            R.id.bu5 -> cellId = 5
            R.id.bu6 -> cellId = 6
            R.id.bu7 -> cellId = 7
            R.id.bu8 -> cellId = 8
            R.id.bu9 -> cellId = 9
        }
     //   Toast.makeText(this,"ID: "+cellId, Toast.LENGTH_SHORT).show()
        PlayGame(cellId,buSelected)
    }

    var Player1 = ArrayList<Int>()
    var Player2 = ArrayList<Int>()
    var ActivPlayer = 1

    fun PlayGame(cellId:Int,buSelected:Button){

        if(ActivPlayer==1){
            buSelected.text="X"
            buSelected.setBackgroundColor(Color.GREEN)
            Player1.add(cellId)
            ActivPlayer=2
        }else{
            buSelected.text="O"
            buSelected.setBackgroundColor(Color.YELLOW)
            Player2.add(cellId)
            ActivPlayer=1
        }

        buSelected.isEnabled=false
        CheckWinner()
    }

    fun CheckWinner(){
        var winner = -1

        //Row 1
        if (Player1.contains(1) && Player1.contains(2) && Player1.contains(3)){
            winner = 1
        }
        if (Player2.contains(1) && Player2.contains(2) && Player2.contains(3)){
            winner = 2
        }
        //Row 2
        if (Player1.contains(4) && Player1.contains(5) && Player1.contains(6)){
            winner = 1
        }
        if (Player2.contains(4) && Player2.contains(5) && Player2.contains(6)){
            winner = 2
        }
        //Row 3
        if (Player1.contains(7) && Player1.contains(8) && Player1.contains(9)){
            winner = 1
        }
        if (Player2.contains(7) && Player2.contains(8) && Player2.contains(9)){
            winner = 2
        }

        //coulam 1
        if (Player1.contains(1) && Player1.contains(4) && Player1.contains(7)){
            winner = 1
        }
        if (Player2.contains(1) && Player2.contains(4) && Player2.contains(7)){
            winner = 2
        }
        //coulam 2
        if (Player1.contains(2) && Player1.contains(5) && Player1.contains(8)){
            winner = 1
        }
        if (Player2.contains(2) && Player2.contains(5) && Player2.contains(8)){
            winner = 2
        }
        //coulam 3
        if (Player1.contains(3) && Player1.contains(6) && Player1.contains(9)){
            winner = 1
        }
        if (Player2.contains(3) && Player2.contains(6) && Player2.contains(9)){
            winner = 2
        }

        if (winner != -1 ){
            if (winner==1){
                Toast.makeText(this,"Player1 is win the game",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Player2 is win the game",Toast.LENGTH_LONG).show()
            }
        }

    }
}
