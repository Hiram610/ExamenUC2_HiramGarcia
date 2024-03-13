package mx.edu.potros.examenuc2_hiram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val button_detalles: Button = findViewById(R.id.btn_detalles)
        val button_globos: Button = findViewById(R.id.btn_globos)
        val button_peluches: Button = findViewById(R.id.btn_peluches)
        val button_regalos: Button = findViewById(R.id.btn_regalos)
        val button_tazas: Button = findViewById(R.id.btn_tazas)

        button_detalles.setOnClickListener {
            var intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("menuType", "detalles")
            startActivity(intent)
        }
        button_globos.setOnClickListener {
            var intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("menuType", "globos")
            startActivity(intent)
        }
        button_peluches.setOnClickListener {
            var intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("menuType", "peluches")
            startActivity(intent)
        }
        button_regalos.setOnClickListener {
            var intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("menuType", "regalos")
            startActivity(intent)
        }
        button_tazas.setOnClickListener {
            var intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("menuType", "tazas")
            startActivity(intent)
        }
    }
}