package mx.arr.androidexam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.renglon_noticia.view.*

// Administra la info. que se muestra en el Recycler View
class Adaptador (private val arrDatos: Array<Noticia>) :
    RecyclerView.Adapter<Adaptador.VistaRenglon>(){

    //Avisar los eventos en el Recycler View
    var listener: ClickListener? = null

    //Crear un renglon
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaRenglon {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.renglon_noticia, parent, false)
        return VistaRenglon(vista)
    }

    //Pide los datos de un renglon
    override fun onBindViewHolder(holder: VistaRenglon, position: Int) {
        val noticia = arrDatos[position]
        holder.set(noticia)

        //Programa el listener
        holder.vistaRenglonNoticia.setOnClickListener{
            listener?.clicked(position)
        }
    }

    //Número de renglones a desplegar
    override fun getItemCount(): Int {
        return arrDatos.size
    }

    //Poblando la tarjeta con sus respectivos componentes
    class VistaRenglon(val vistaRenglonNoticia: View ) :
        RecyclerView.ViewHolder(vistaRenglonNoticia) {
        fun set(noticia: Noticia){
            vistaRenglonNoticia.tvTitulo.text = noticia.Titulo
            vistaRenglonNoticia.tvFuente.text = noticia.Fuente
            vistaRenglonNoticia.imgNoticia.setImageResource(noticia.Imagen)
        }
    }




}