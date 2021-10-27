package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //prendiamo il testo che c'e nella textView
    private var numberInString=""
        get() =numberText?.text.toString()
        set(value){
            numberText?.text=value
            field=value
        }
    /////////////////////////////////////////

    private var currentNumber=0f
    private var oldNumber=0f
    private var operation : String=""
    private var previousOperation=""
    private var isNewOperation=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //stiamo facendo riferimento al file themes che si trova in values->themes->themes.xml
    fun onItemClick(view: View){

        if(isNewOperation){
            oldNumber=currentNumber
            numberInString=""
        }
        isNewOperation=false

        //come capire che pulsante stiamo cliccando
        //ora in base al pulsante clickatto emntreremo dentro diciamo il suo metodo
        when(view.id){
            R.id.button0->{
                setNumber(0)
            }
            R.id.button1->{
                setNumber(1)
            }
            R.id.button2->{
                setNumber(2)
            }
            R.id.button3->{
                setNumber(3)
            }
            R.id.button4->{
                setNumber(4)
            }
            R.id.button5->{
                setNumber(5)
            }
            R.id.button6->{
                setNumber(6)
            }
            R.id.button7->{
                setNumber(7)
            }
            R.id.button8->{
                setNumber(8)
            }
            R.id.button9->{
                setNumber(9)
            }
            ////////////////
            R.id.buttonC->{
                operation="c"
                total()
                previousOperation="c"
            }
            R.id.buttonPM->{
                operation="+/-"
                total()
                previousOperation="+/-"
            }
            R.id.buttonP->{
                operation="%"
                total()
                previousOperation="%"
            }
            R.id.buttonD->{
                operation="/"
                total()
                previousOperation="/"
            }
            R.id.buttonPer->{
                operation="*"
                total()
                previousOperation="*"
            }
            R.id.buttonMeno->{
                operation="-"
                total()
                previousOperation="-"
            }
            R.id.buttonPiu->{
                operation="+"
                total()
                previousOperation="+"
            }
            R.id.buttonpunto->{
                operation="."
                total()
                previousOperation="."
            }
            R.id.buttonUguale->{
                operation="="
                total()
                previousOperation="="
            }


        }

    }

    private fun setNumber(number:Int){
        if(numberInString=="0"){
            numberText.text=number.toString()
        }else{
            numberText.text=numberInString+number.toString()
        }
        currentNumber=numberInString.toFloat()
    }

    private fun makeOperation(operation:String){
       var finalResult=0f
        when(operation){
            "+"->{
                finalResult=oldNumber+currentNumber
            }
            "-"->{
                finalResult=oldNumber-currentNumber
            }
            "*"->{
                finalResult=oldNumber*currentNumber
            }
            "/"->{
                finalResult=oldNumber+currentNumber
            }
        }
        currentNumber=finalResult

        //mostriamo il risultato nella parte superiore
        numberInString =currentNumber.toString()

    }

    private fun total(){
        if(oldNumber!=0f && currentNumber!= 0f){
            makeOperation(previousOperation)
        }

    }

}