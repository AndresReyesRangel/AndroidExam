package mx.arr.androidexam

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_news_feed.*

class NewsFeed : AppCompatActivity(), ClickListener {

    private lateinit var arrNoticias: Array<Noticia>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_feed)

        configurarRV()
    }

    private fun configurarRV() {
        val layout = LinearLayoutManager(this)
        rvNoticias.layoutManager = layout

        arrNoticias = crearArrNoticias()
        val adaptador = Adaptador(arrNoticias)
        rvNoticias.adapter = adaptador

        adaptador.listener = this
    }

    private fun crearArrNoticias(): Array<Noticia> {
        return arrayOf(
            Noticia("Tren Maya", "Excelsior", 1)
        )
    }

    override fun clicked(posicion: Int) {
        val noticia = arrNoticias[posicion]
        val url = Uri.parse(noticia.Fuente) // Link de la noticia
        val intNoticia = Intent(Intent.ACTION_VIEW, url)
        startActivity(intNoticia)
    }


}