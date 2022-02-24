package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        labelInput.addTextChangedListener{
            if(it!!.count()>0)
                labelLayout.error = null
        }

        labelInput.addTextChangedListener{
            if(it!!.count()>0)
                amountLayout.error = null
        }

        addTransactionBtn.setOnClickListener {
            val label = labelInput.text.toString()
            val amount = amountInput.text.toString().toDoubleOrNull()
            val description = descriptionInput.text.toString()

            if (label.isEmpty())
                labelLayout.error = "Please add a label value"
            else if (amount == null)
                amountLayout.error = "Please add a valid amount"
            else {
                val transaction = Transaction(0, label, amount, description)
                insert(transaction)
            }
        }

        close.setOnClickListener{
            finish()
        }

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