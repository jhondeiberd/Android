package com.example.finalproject

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import androidx.room.Room
import com.example.finalproject.db.AppDatabase
import com.example.finalproject.entities.Transaction
import kotlinx.android.synthetic.main.activity_detailed.*
import kotlinx.android.synthetic.main.activity_detailed.amountInput
import kotlinx.android.synthetic.main.activity_detailed.amountLayout
import kotlinx.android.synthetic.main.activity_detailed.close
import kotlinx.android.synthetic.main.activity_detailed.descriptionInput
import kotlinx.android.synthetic.main.activity_detailed.nameInput
import kotlinx.android.synthetic.main.activity_detailed.nameLayout
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailedActivity : AppCompatActivity() {

    private lateinit var transaction: Transaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val transaction = intent.getSerializableExtra("transaction") as Transaction

        nameInput.setText(transaction.label)
        amountInput.setText(transaction.amount.toString())
        descriptionInput.setText(transaction.description)

        rootView.setOnClickListener{
            this.window.decorView.clearFocus()

            val click = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            click.hideSoftInputFromWindow(it.windowToken, 0)
        }

        nameInput.addTextChangedListener{
            updateTransactionBtn.visibility =  View.VISIBLE
            if(it!!.count()>0)
                nameLayout.error = null
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
            val label = nameInput.text.toString()
            val amount = amountInput.text.toString().toDoubleOrNull()
            val description = descriptionInput.text.toString()

            if (label.isEmpty())
                nameLayout.error = "Please add a label value"
            else if (amount == null)
                amountLayout.error = "Please add a valid amount"
            else {
                val transaction = Transaction(transaction.id, label, amount, description)
                update(transaction)
                Toast.makeText(this, "Transaction edited", Toast.LENGTH_SHORT).show()
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

    fun positiveClick(dialog: DialogInterface, which: Int){
        finish()
        Toast.makeText(this, "Upgrade canceled", Toast.LENGTH_SHORT).show()
    }

    fun negativeClick(dialog: DialogInterface, which: Int){
        Toast.makeText(this, "Continue with the update", Toast.LENGTH_SHORT).show()
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