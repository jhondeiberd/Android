package com.example.finalproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.widget.addTextChangedListener
import androidx.room.Room
import com.example.finalproject.db.AppDatabase
import com.example.finalproject.entities.Transaction
import kotlinx.android.synthetic.main.activity_detailed.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailedActivity : AppCompatActivity() {

    private lateinit var transaction: Transaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val transaction = intent.getSerializableExtra("transaction") as Transaction

        labelInput.setText(transaction.label)
        amountInput.setText(transaction.amount.toString())
        descriptionInput.setText(transaction.description)

        rootView.setOnClickListener{
            this.window.decorView.clearFocus()

            val click = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            click.hideSoftInputFromWindow(it.windowToken, 0)
        }

        labelInput.addTextChangedListener{
            updateTransactionBtn.visibility =  View.VISIBLE
            if(it!!.count()>0)
                labelLayout.error = null
        }

        amountInput.addTextChangedListener{
            updateTransactionBtn.visibility =  View.VISIBLE
            if(it!!.count()>0)
                amountLayout.error = null
        }

        descriptionInput.addTextChangedListener{
            updateTransactionBtn.visibility =  View.VISIBLE
            if(it!!.count()>0)
                amountLayout.error = null
        }

        updateTransactionBtn.setOnClickListener {
            updateTransactionBtn.visibility =  View.VISIBLE
            val label = labelInput.text.toString()
            val amount = amountInput.text.toString().toDoubleOrNull()
            val description = descriptionInput.text.toString()

            if (label.isEmpty())
                labelLayout.error = "Please add a label value"
            else if (amount == null)
                amountLayout.error = "Please add a valid amount"
            else {
                val transaction = Transaction(transaction.id, label, amount, description)
                update(transaction)
            }
        }

        close.setOnClickListener{
            finish()
        }

    }

    private fun update(transaction: Transaction){
        val db = Room.databaseBuilder(this,
            AppDatabase::class.java,
            "transactions").build()

        GlobalScope.launch {
            db.transactionDao().update(transaction)
            finish()
        }
    }
}