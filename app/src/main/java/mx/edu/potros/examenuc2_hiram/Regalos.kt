package mx.edu.potros.examenuc2_hiram

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class Regalos : AppCompatActivity() {

    var adapter: DetallesAdapter? = null
    var detalles = ArrayList<Detalles>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalos)

        var opcion: String? = intent.getStringExtra("menuType")
        cargarRegalos(opcion)

        adapter = DetallesAdapter(this,detalles)

        var gridDetalles: GridView = findViewById(R.id.grid_regalos)

        gridDetalles.adapter = adapter

    }

    fun cargarRegalos(option: String?){
        when(option){
            "detalles"->{
                detalles.add(Detalles(R.drawable.cumplebotanas, "$ 280.00"))
                detalles.add(Detalles(R.drawable.cumplecheve,   "$ 320.00"))
                detalles.add(Detalles(R.drawable.cumpleescolar, "$ 330.00"))
                detalles.add(Detalles(R.drawable.cumplepaletas, "$ 190.00"))
                detalles.add(Detalles(R.drawable.cumplesnack,   "$ 150.00"))
                detalles.add(Detalles(R.drawable.cumplevinos,   "$ 370.00"))
            }
            "globos"->{
                detalles.add(Detalles(R.drawable.globoamor,    "$ 240.00"))
                detalles.add(Detalles(R.drawable.globocumple,  "$ 820.00"))
                detalles.add(Detalles(R.drawable.globofestejo, "$ 260.00"))
                detalles.add(Detalles(R.drawable.globonum,     "$ 760.00"))
                detalles.add(Detalles(R.drawable.globoregalo,  "$ 450.00"))
                detalles.add(Detalles(R.drawable.globos,       "$ 240.00"))
            }
            "peluches"->{
                detalles.add(Detalles(R.drawable.peluchemario,     "$ 320.00"))
                detalles.add(Detalles(R.drawable.pelucheminecraft, "$ 320.00"))
                detalles.add(Detalles(R.drawable.peluchepeppa,     "$ 290.00"))
                detalles.add(Detalles(R.drawable.peluches,         "$ 150.00"))
                detalles.add(Detalles(R.drawable.peluchesony,      "$ 330.00"))
                detalles.add(Detalles(R.drawable.peluchestich,     "$ 280.00"))
                detalles.add(Detalles(R.drawable.peluchevarios,    "$ 195.00"))
            }
            "regalos"->{
                detalles.add(Detalles(R.drawable.regaloazul,    "$ 80.00"))
                detalles.add(Detalles(R.drawable.regalobebe,    "$ 290.00"))
                detalles.add(Detalles(R.drawable.regalocajas,   "$ 140.00"))
                detalles.add(Detalles(R.drawable.regalocolores, "$ 85.00"))
                detalles.add(Detalles(R.drawable.regalos,       "$ 60.00"))
                detalles.add(Detalles(R.drawable.regalovarios,  "$ 75.00"))
            }
            "tazas"->{
                detalles.add(Detalles(R.drawable.tazaabuela, "$ 120.00"))
                detalles.add(Detalles(R.drawable.tazalove,   "$ 120.00"))
                detalles.add(Detalles(R.drawable.tazaquiero, "$ 260.00"))
                detalles.add(Detalles(R.drawable.tazas,      "$ 280.00"))
            }
        }
    }

    class DetallesAdapter: BaseAdapter{
        var detalles = ArrayList<Detalles>()
        var context: Context? = null

        constructor(context: Context, detalles:ArrayList<Detalles>):super(){
            this.detalles = detalles
            this.context = context
        }

        override fun getCount(): Int {
            return detalles.size
        }

        override fun getItem(position: Int): Any {
            return detalles[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var detalle = detalles[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.regalo, null)
            var image: ImageView = vista.findViewById(R.id.image_regalo)
            var precio: TextView = vista.findViewById(R.id.price_regalo)

            image.setImageResource(detalle.imagen)
            precio.setText(detalle.precio)

            image.setOnClickListener {
                val intento = Intent(context, DetalleRegalos::class.java)
                intento.putExtra("imagen", detalle.imagen)
                intento.putExtra("precio", detalle.precio)

                context!!.startActivity(intento)
            }

            return vista
        }
    }
}