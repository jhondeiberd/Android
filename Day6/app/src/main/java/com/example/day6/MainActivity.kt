package com.example.day6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.day6.entities.Nature
import com.example.day6.recyclerview.NatureAdapter

class MainActivity : AppCompatActivity() {

    private val natureAdapter = NatureAdapter()

    private val launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        this::resultFromNextActivity
    )

    private fun resultFromNextActivity(result: ActivityResult) {
        if (result.resultCode == RESULT_OK) {
            val intent = result.data
            if (intent?.hasExtra(CreateActivity.EXTRA_TITLE_KEY) == true &&
                intent.hasExtra(CreateActivity.EXTRA_IMAGE_KEY)
            ){
                val title : String = intent.getStringExtra(CreateActivity.EXTRA_TITLE_KEY) ?: ""
                val imageID = intent.getIntExtra(CreateActivity.EXTRA_IMAGE_KEY, -1)
                val nature = Nature(imageID, title)
                natureAdapter.addData(nature)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = listOf<Nature>(
            Nature(this, R.drawable.nature1, R.string.nature1),
            Nature(this, R.drawable.nature2, R.string.nature2),
            Nature(this, R.drawable.nature3, R.string.nature3),
            Nature(R.drawable.nature2, resources.getString(R.string.nature1))
        )

        val recyclerView = findViewById<RecyclerView>(R.id.main_recyclerView)
        recyclerView.adapter = natureAdapter
        recyclerView.setHasFixedSize(true) //Performance: If RecyclerView height and width doesn't change

        //Add Data
        natureAdapter.changeData(data)

        val createButton = findViewById<Button>(R.id.main_create)
        createButton.setOnClickListener {
            val intent = Intent(this, CreateActivity::class.java)
            launcher.launch(intent)
        }

    }
}