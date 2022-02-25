package com.example.finalproject

import android.content.DialogInterface
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.room.Room
import com.example.finalproject.db.AppDatabase
import com.example.finalproject.entities.Transaction
import kotlinx.android.synthetic.main.activity_add_transaction.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddTransactionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_transaction)

        nameInput.addTextChangedListener{
            if(it!!.count()>0)
                amountLayout.error = null
        }

        addTransactionBtn.setOnClickListener {
            val label = nameInput.text.toString()
            val amount = amountInput.text.toString().toDoubleOrNull()
            val description = descriptionInput.text.toString()

            if (label.isEmpty())
                nameLayout.error = "Please add a label value"
            else if (amount == null)
                amountLayout.error = "Please add a valid amount"
            else {
                val transaction = Transaction(0, label, amount, description)
                insert(transaction)
                Toast.makeText(this, "Transaction added", Toast.LENGTH_SHORT).show()
            }
        }

        close.setOnClickListener{
            val builder: AlertDialog.Builder = AlertDialog.Builder(this).apply {
                setTitle(R.string.dialogTitle)
                setMessage(R.string.dialogMessage)
            }
            builder.setPositiveButton(R.string.positiveButton, this::positiveClick)
            builder.setNegativeButton(R.string.negativeButton, this::negativeClick)
            builder.show()
        }
    }

    fun positiveClick(dialog:DialogInterface, which: Int){
        finish()
        Toast.makeText(this, "Addition canceled", Toast.LENGTH_SHORT).show()
    }

    fun negativeClick(dialog:DialogInterface, which: Int){
        Toast.makeText(this, "Continue with the addition", Toast.LENGTH_SHORT).show()
    }


    private fun insert(transaction: Transaction){
        val db = Room.databaseBuilder(this,
            AppDatabase::class.java,
            "transactions").build()

        GlobalScope.launch {
            db.transactionDao().insertAll(transaction)
            finish()
        }
    }
}

