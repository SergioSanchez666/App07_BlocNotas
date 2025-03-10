package com.example.app07_blocnotas
//Miembros del equipo:
//Coronel Meza Sergio Daniel
//Sanchez Cruz Sergio Antonio

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
    /**
     * EditText donde el usuario ingresa las notas.
     */
    private lateinit var editTextNotas: EditText

    /**
     * Instancia de SharedPreferences para almacenar y recuperar las notas.
     */
    private lateinit var sharedPreferences: SharedPreferences

    /**
     * Método llamado al crear la actividad.
     * Inicializa la vista, recupera las notas guardadas y las muestra en el EditText.
     *
     * @param savedInstanceState Si la actividad se reinicializa después de haber sido cerrada previamente,
     * este Bundle contiene los datos que se proporcionaron más recientemente en onSaveInstanceState(Bundle).
     * Nota: De lo contrario, es nulo.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el layout de la actividad desde el archivo activity_main.xml.
        setContentView(R.layout.activity_main)

        // Inicializa el EditText para las notas.
        editTextNotas = findViewById(R.id.editTextNotas)

        // Obtiene una instancia de SharedPreferences con el nombre "notas" y modo privado.
        sharedPreferences = getSharedPreferences("notas", Context.MODE_PRIVATE)

        // Recupera las notas guardadas desde SharedPreferences. Si no existen, se usa una cadena vacía como valor predeterminado.
        val notasGuardadas = sharedPreferences.getString("notas", "")

        // Establece el texto del EditText con las notas guardadas.
        editTextNotas.setText(notasGuardadas)
    }

    /**
     * Método llamado cuando la actividad está a punto de pausarse (por ejemplo, cuando otra actividad pasa a primer plano).
     * Guarda las notas actuales en SharedPreferences para persistencia.
     */
    override fun onPause() {
        super.onPause()

        // Obtiene el texto actual del EditText.
        val notas = editTextNotas.text.toString()

        // Obtiene un editor para SharedPreferences.
        val editor = sharedPreferences.edit()

        // Guarda las notas en SharedPreferences con la clave "notas".
        editor.putString("notas", notas)

        // Aplica los cambios de forma asíncrona.
        editor.apply()
    }
}