package mx.arr.androidexam

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_news_feed.*

class NewsFeed : AppCompatActivity(), ClickListener {

    //arreglo con noticias
    private lateinit var arrNoticias: Array<Noticia>

    // sharedPreferences
    private lateinit var prefs : SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_feed)

        //Configurar las prefs
        prefs = getSharedPreferences("Login", Context.MODE_PRIVATE)
        editor = prefs.edit()

        configurarRV()
    }

    //Finalizar sesion
    fun finalizarSesion(v : View){
        editor.clear()
        editor.commit()
        val intMain = Intent(this, MainActivity::class.java)
        startActivity(intMain)
        finish()
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
            Noticia("Tren Maya", "Excelsior", R.drawable.silueta__1_)
        )
    }

    override fun clicked(posicion: Int) {
        val noticia = arrNoticias[posicion]
        val url = Uri.parse(noticia.Fuente) // Link de la noticia
        val intNoticia = Intent(Intent.ACTION_VIEW, url)
        startActivity(intNoticia)
    }


}