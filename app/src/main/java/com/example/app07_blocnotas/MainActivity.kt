package com.example.app07_blocnotas

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app07_blocnotas.ui.theme.App07_BlocNotasTheme

class MainActivity : ComponentActivity() {
    private lateinit var editTextNotas: EditText
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNotas = findViewById(R.id.editTextNotas)
        sharedPreferences = getSharedPreferences("notas", Context.MODE_PRIVATE)

        val notasGuardadas = sharedPreferences.getString("notas", "")
        editTextNotas.setText(notasGuardadas)
    }

    override fun onPause() {
        super.onPause()
        val notas = editTextNotas.text.toString()
        val editor = sharedPreferences.edit()

        editor.putString("notas", notas)
        editor.apply()
    }
}