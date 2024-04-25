package com.example.practico2ingredientes.ui.secondPage

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practico2ingredientes.R
import com.example.practico2ingredientes.databinding.ActivitySegundaPaginaBinding
import com.example.practico2ingredientes.model.Receta
import com.example.practico2ingredientes.ui.adapters.OnRecetasClickListener
import com.example.practico2ingredientes.ui.adapters.RecetaAdapter
import com.example.practico2ingredientes.ui.main.MainViewModel
import com.example.practico2ingredientes.ui.thirdPage.ThirdPageActivity

class SegundaPaginaActivity : AppCompatActivity() , OnRecetasClickListener{
    private lateinit var binding: ActivitySegundaPaginaBinding
    private val model: MainViewModel by viewModels()



    // Ingredientes
    private var pollo: String = "1"
    private var estadoPollo: Boolean = false
    private var arroz: String = "2"
    private var estadoArroz: Boolean = false
    private var tomate: String = "3"
    private var estadoTomate: Boolean = false
    private var platano: String = "4"
    private var estadoPlatano: Boolean = false
    private var carne: String = "5"
    private var estadoCarne: Boolean = false
    private var zanahoria: String = "6"
    private var estadoZanahoria: Boolean = false
    private var espinaca: String = "7"
    private var estadoEspinaca: Boolean = false
    private var queso: String = "8"
    private var estadoQueso: Boolean = false
    private var pasta: String = "9"
    private var estadoPasta: Boolean = false
    private var harina: String = "0"
    private var estadoHarina: Boolean = false
    val listaRecetasCargadas: MutableList<Receta> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySegundaPaginaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val listaRecibida = intent.getStringExtra("LISTA_EXTRA")
        setupRecyclerView(listaRecibida)
    }

    private fun setupRecyclerView(listaRecibida: String?) {

        if (listaRecibida != null) {
            for (id in 0 until listaRecibida.length) {
                val elemento = listaRecibida[id].toString()
                if (elemento == pollo) {
                    estadoPollo = true
                }
                if (elemento == arroz) {
                    estadoArroz = true
                }
                if (elemento == tomate) {
                    estadoTomate = true
                }
                if (elemento == platano) {
                    estadoPlatano = true
                }
                if (elemento == carne) {
                    estadoCarne = true
                }
                if (elemento == zanahoria) {
                    estadoZanahoria = true
                }
                if (elemento == espinaca) {
                    estadoEspinaca = true
                }
                if (elemento == queso) {
                    estadoQueso = true
                }
                if (elemento == pasta) {
                    estadoPasta = true
                }
                if (elemento == harina) {
                    estadoHarina = true
                }
            }
        }

        //aca agrego las recetas si todu está listo
        when {
            estadoArroz -> {listaRecetasCargadas.add(Receta(1, "Solo arroz", "Ingredientes:\n" +
                    "\n" +
                    "1 taza de arroz\n" +
                    "2 tazas de agua\n" +
                    "Sal al gusto\n" +
                    "\n"+
                    "Instrucciones:\n" +
                    "\n" +
                    "Enjuaga el arroz bajo agua fría para quitar el exceso de almidón.\n" +
                    "En una olla, hierve las 2 tazas de agua.\n" +
                    "Agrega el arroz y la sal al agua hirviendo.\n" +
                    "Reduce el fuego a bajo, tapa la olla y cocina por 18-20 minutos.\n" +
                    "Una vez cocido, apaga el fuego y deja reposar el arroz tapado por unos minutos.\n" +
                    "Fluff el arroz con un tenedor antes de servir."))}
            }
        when {
            estadoArroz &&  estadoCarne -> {listaRecetasCargadas.add(Receta(2, "Arroz con Carne", "Ingredientes:\n" +
                    "\n" +
                    "1 taza de arroz\n" +
                    "200g de carne (res, pollo o cerdo), cortada en trozos pequeños\n" +
                    "Sal al gusto\n" +
                    "Pimienta al gusto\n" +
                    "Salsa de soja (opcional)\n" +
                    "Aceite de oliva o vegetal\n" +
                    "\n"+
                    "Instrucciones:\n" +
                    "\n" +
                    "En una olla mediana, calienta un poco de aceite a fuego medio-alto.\n" +
                    "Agrega la carne y dórala por todos lados.\n" +
                    "Cuando la carne esté dorada, añade el arroz y mezcla bien.\n" +
                    "Agrega sal y pimienta al gusto. Si lo deseas, puedes agregar un poco de salsa de soja para darle sabor adicional.\n" +
                    "Vierte 2 tazas de agua caliente sobre la mezcla.\n" +
                    "Reduce el fuego a bajo, tapa la olla y cocina durante 18-20 minutos, o hasta que el arroz esté cocido y el agua se haya absorbido por completo.\n" +
                    "Una vez listo, retira del fuego y deja reposar por unos minutos antes de servir."))}
        }
        when{
            estadoArroz &&  estadoPollo -> listaRecetasCargadas.add(Receta(3, "Arroz con Pollo", "Ingredientes:\n" +
                    "\n" +
                    "1 taza de arroz\n" +
                    "2 pechugas de pollo, cortadas en trozos pequeños\n" +
                    "Sal al gusto\n" +
                    "Pimienta al gusto\n" +
                    "Ajo en polvo (opcional)\n" +
                    "2 tazas de caldo de pollo o agua\n" +
                    "Aceite de oliva o vegetal\n" +
                    "\n"+
                    "Instrucciones:\n" +
                    "\n" +
                    "En una olla grande, calienta un poco de aceite a fuego medio-alto.\n" +
                    "Agrega los trozos de pollo y cocínalos hasta que estén dorados por todos lados.\n" +
                    "Una vez dorado el pollo, añade el arroz y mézclalo bien con el pollo.\n" +
                    "Condimenta con sal, pimienta y ajo en polvo al gusto.\n" +
                    "Vierte el caldo de pollo o agua sobre la mezcla y lleva a ebullición.\n" +
                    "Reduce el fuego a bajo, tapa la olla y cocina durante 18-20 minutos, o hasta que el arroz esté cocido y el líquido se haya absorbido por completo.\n" +
                    "Una vez cocido, retira del fuego y deja reposar por unos minutos antes de servir."))
        }
        when{
            estadoPollo &&  estadoArroz && estadoTomate -> listaRecetasCargadas.add(Receta(4, "Pollo al Tomate con Arroz", "Ingredientes:\n" +
                    "\n" +
                    "4 piezas de pollo (muslos, pechugas, etc.)\n" +
                    "1 taza de arroz\n" +
                    "2 tomates medianos, cortados en rodajas\n" +
                    "Sal al gusto\n" +
                    "Pimienta al gusto\n" +
                    "Ajo en polvo al gusto\n" +
                    "2 tazas de caldo de pollo o agua\n" +
                    "Aceite de oliva\n" +
                    "Perejil fresco picado (opcional, para decorar)\n" +
                    "\n"+
                    "Instrucciones:\n" +
                    "\n" +
                    "Precalienta el horno a 200°C (390°F).\n" +
                    "En una bandeja para hornear, coloca las piezas de pollo y las rodajas de tomate.\n" +
                    "Espolvorea sal, pimienta y ajo en polvo sobre el pollo y los tomates. Rocía un poco de aceite de oliva sobre ellos.\n" +
                    "Hornea en el horno precalentado durante 25-30 minutos o hasta que el pollo esté bien cocido y dorado.\n" +
                    "Mientras tanto, enjuaga el arroz bajo agua fría y escúrrelo.\n" +
                    "En una olla, agrega el arroz y el caldo de pollo o agua. Condimenta con sal al gusto.\n" +
                    "Lleva el arroz a ebullición, luego reduce el fuego a bajo, tapa la olla y cocina durante 18-20 minutos, o hasta que el arroz esté cocido y el líquido se haya absorbido por completo.\n" +
                    "Una vez listo el pollo, sirve acompañado del arroz cocido y los tomates horneados.\n" +
                    "Decora con perejil fresco picado, si lo deseas, y ¡disfruta tu deliciosa comida!"))
        }
        when{
            estadoPlatano &&  estadoQueso -> listaRecetasCargadas.add(Receta(5, "Platanos con Queso Derretido", "Ingredientes:\n" +
                    "\n" +
                    "Plátanos maduros\n" +
                    "Queso mozzarella o queso blanco, cortado en rodajas o rallado\n" +
                    "Miel o azúcar (opcional, para servir)\n" +
                    "\n"+
                    "Instrucciones:\n" +
                    "\n" +
                    "Precalienta el horno a 200°C (390°F).\n" +
                    "Pelar los plátanos y cortarlos en rodajas de aproximadamente 1 cm de grosor.\n" +
                    "Coloca las rodajas de plátano en una bandeja para hornear.\n" +
                    "Coloca una rodaja de queso sobre cada rodaja de plátano.\n" +
                    "Hornea en el horno precalentado durante 5-7 minutos, o hasta que el queso esté derretido y burbujeante.\n" +
                    "Retira del horno y sirve los plátanos con queso derretido caliente.\n" +
                    "Si lo deseas, puedes rociar un poco de miel o espolvorear azúcar sobre los plátanos antes de servir para un toque dulce adicional."))
        }
        when{
            estadoPollo &&  estadoEspinaca && estadoZanahoria -> listaRecetasCargadas.add(Receta(6, "Ensalada de Pollo, Espinacas y Zanahoria", "Ingredientes:\n" +
                    "\n" +
                    "2 pechugas de pollo cocidas y desmenuzadas\n" +
                    "2 tazas de espinacas frescas\n" +
                    "1 zanahoria grande, rallada\n" +
                    "1/4 de taza de nueces picadas (opcional)\n" +
                    "Vinagreta de tu elección (puedes usar vinagreta balsámica, de miel y mostaza, o cualquier otra que prefieras)\n" +
                    "Sal y pimienta al gusto\n" +
                    "\n"+
                    "Instrucciones:\n" +
                    "\n" +
                    "En un tazón grande, combina las espinacas, la zanahoria rallada y las nueces picadas.\n" +
                    "Agrega las pechugas de pollo desmenuzadas y mezcla bien.\n" +
                    "Adereza la ensalada con la vinagreta de tu elección. Añade sal y pimienta al gusto y mezcla nuevamente para asegurarte de que todos los ingredientes estén bien cubiertos.\n" +
                    "Sirve la ensalada en platos individuales y disfruta de esta deliciosa y nutritiva combinación."))
        }
        when{
            estadoPasta &&  estadoCarne && estadoTomate -> listaRecetasCargadas.add(Receta(7, "Pasta Boloñesa", "Ingredientes:\n" +
                    "\n" +
                    "250g de pasta (spaghetti, penne, etc.)\n" +
                    "300g de carne molida (res o cerdo)\n" +
                    "1 lata de tomate triturado (400g)\n" +
                    "Sal al gusto\n" +
                    "Pimienta al gusto\n" +
                    "Orégano al gusto\n" +
                    "\n"+
                    "Instrucciones:\n" +
                    "\n" +
                    "En una sartén grande, calienta un poco de aceite de oliva a fuego medio.\n" +
                    "Agrega la cebolla y el ajo picados y cocina hasta que estén dorados y fragantes.\n" +
                    "Añade la carne molida y cocina hasta que esté bien dorada y cocida.\n" +
                    "Agrega la zanahoria rallada y cocina por unos minutos más.\n" +
                    "Vierte el tomate triturado en la sartén y mezcla bien con la carne y las verduras.\n" +
                    "Condimenta con sal, pimienta y orégano al gusto. Deja cocinar a fuego lento durante unos 15-20 minutos para que los sabores se mezclen bien.\n" +
                    "Mientras tanto, cocina la pasta en una olla grande con agua hirviendo y sal, según las instrucciones del paquete.\n" +
                    "Una vez que la pasta esté cocida al dente, escúrrela y mézclala con la salsa boloñesa.\n" +
                    "Sirve caliente y, si lo deseas, espolvorea un poco de queso parmesano rallado encima."))
        }
        when{
            estadoPollo &&  estadoHarina -> listaRecetasCargadas.add(Receta(8, "Empanada de Pollo", "Ingredientes:\n" +
                    "\n" +
                    "Masa de empanadas (comprada o casera)\n" +
                    "Pollo cocido y desmenuzado\n" +
                    "Cebolla picada\n" +
                    "Pimiento picado\n" +
                    "Aceitunas picadas (opcional)\n" +
                    "Comino\n" +
                    "Pimentón\n" +
                    "Sal y pimienta\n" +
                    "Huevo batido (para pincelar)\n" +
                    "\n"+
                    "Instrucciones:\n" +
                    "\n" +
                    "Precalienta el horno a 180°C.\n" +
                    "En una sartén, saltea la cebolla y el pimiento hasta que estén dorados.\n" +
                    "Agrega el pollo desmenuzado a la sartén y condimenta con comino, pimentón, sal y pimienta al gusto. Cocina por unos minutos más.\n" +
                    "Extiende la masa de empanadas y corta círculos del tamaño deseado.\n" +
                    "Coloca una porción de relleno de pollo en el centro de cada círculo de masa.\n" +
                    "Dobla la masa sobre el relleno y presiona los bordes con un tenedor para sellar las empanadas.\n" +
                    "Coloca las empanadas en una bandeja para hornear, previamente engrasada o cubierta con papel pergamino.\n" +
                    "Pincela cada empanada con huevo batido.\n" +
                    "Hornea en el horno precalentado durante 20-25 minutos o hasta que estén doradas y crujientes.\n" +
                    "¡Sirve y disfruta tus empanadas de pollo!"))
        }
        when{
            estadoHarina &&  estadoCarne -> listaRecetasCargadas.add(Receta(9, "Empanada de Carne", "Ingredientes:\n" +
                    "\n" +
                    "Masa de empanadas (comprada o casera)\n" +
                    "Carne molida\n" +
                    "Cebolla picada\n" +
                    "Ajo picado\n" +
                    "Comino\n" +
                    "Pimentón\n" +
                    "Sal y pimienta\n" +
                    "Huevo batido (para pincelar)\n" +
                    "\n"+
                    "Instrucciones:\n" +
                    "\n" +
                    "Precalienta el horno a 180°C.\n" +
                    "En una sartén, cocina la cebolla y el ajo hasta que estén dorados.\n" +
                    "Agrega la carne molida a la sartén y condimenta con comino, pimentón, sal y pimienta al gusto. Cocina hasta que la carne esté completamente cocida.\n" +
                    "Extiende la masa de empanadas y corta círculos del tamaño deseado.\n" +
                    "Coloca una porción de relleno de carne en el centro de cada círculo de masa.\n" +
                    "Dobla la masa sobre el relleno y presiona los bordes con un tenedor para sellar las empanadas.\n" +
                    "Coloca las empanadas en una bandeja para hornear, previamente engrasada o cubierta con papel pergamino.\n" +
                    "Pincela cada empanada con huevo batido.\n" +
                    "Hornea en el horno precalentado durante 20-25 minutos o hasta que estén doradas y crujientes.\n" +
                    "¡Listo! Disfruta tus deliciosas empanadas de carne."))
        }
        when{
            estadoHarina &&  estadoQueso -> listaRecetasCargadas.add(Receta(10, "Empanada de Queso", "Ingredientes:\n" +
                    "\n" +
                    "Masa de empanadas (comprada o casera)\n" +
                    "Queso rallado (puedes usar el que prefieras, como mozzarella, cheddar, o cualquier otro queso que se derrita bien)\n" +
                    "\n"+
                    "Instrucciones:\n" +
                    "\n" +
                    "Precalienta el horno a 180°C.\n" +
                    "Extiende la masa de empanadas y corta círculos del tamaño deseado.\n" +
                    "Coloca una porción de queso rallado en el centro de cada círculo de masa.\n" +
                    "Dobla la masa sobre el queso y presiona los bordes con un tenedor para sellar las empanadas.\n" +
                    "Opcionalmente, puedes pincelar cada empanada con huevo batido para que adquieran un color dorado al hornear.\n" +
                    "Coloca las empanadas en una bandeja para hornear, previamente engrasada o cubierta con papel pergamino.\n" +
                    "Hornea en el horno precalentado durante 20-25 minutos o hasta que estén doradas y crujientes.\n" +
                    "¡Listo! Ahora puedes disfrutar de unas deliciosas empanadas de queso."))
        }
        when{
            estadoEspinaca &&  estadoPlatano && estadoZanahoria -> listaRecetasCargadas.add(Receta(11, "Sopa de Verduras", "Ingredientes:\n" +
                    "\n" +
                    "Espinacas frescas\n" +
                    "Zanahorias\n" +
                    "Plátanos maduros\n" +
                    "Agua o caldo de verduras\n" +
                    "Sal y pimienta al gusto\n" +
                    "\n"+
                    "Instrucciones:\n" +
                    "\n" +
                    "Lava y corta las espinacas en trozos pequeños.\n" +
                    "Pela y corta las zanahorias y los plátanos en rodajas.\n" +
                    "En una olla grande, lleva a ebullición el agua o el caldo de verduras.\n" +
                    "Agrega las espinacas, las zanahorias y los plátanos a la olla.\n" +
                    "Cocina a fuego medio hasta que las verduras estén tiernas, aproximadamente de 15 a 20 minutos.\n" +
                    "Condimenta con sal y pimienta al gusto.\n" +
                    "Una vez cocidas las verduras, retira la olla del fuego.\n" +
                    "Con una licuadora de inmersión, mezcla las verduras hasta obtener una consistencia suave.\n" +
                    "Prueba y ajusta la sazón según sea necesario.\n" +
                    "Sirve caliente y disfruta de esta reconfortante sopa de espinacas, zanahoria y plátano."))
        }
        when{
            estadoEspinaca &&  estadoHarina && estadoQueso -> listaRecetasCargadas.add(Receta(12, "Tortillas de Queso/Espinaca", "Ingredientes:\n" +
                    "\n" +
                    "Queso rallado (puedes usar queso mozzarella, cheddar u otro de tu preferencia)\n" +
                    "Espinacas frescas o congeladas\n" +
                    "Huevos\n" +
                    "Sal y pimienta al gusto\n" +
                    "\n"+
                    "Instrucciones:\n" +
                    "\n" +
                    "En un tazón, bate los huevos y sazona con sal y pimienta al gusto.\n" +
                    "Agrega las espinacas picadas (si son frescas, córtalas finamente; si son congeladas, descongélalas y escúrrelas bien).\n" +
                    "Incorpora el queso rallado a la mezcla de huevo y espinacas. Mezcla bien.\n" +
                    "Calienta una sartén antiadherente a fuego medio y añade un poco de aceite o mantequilla.\n" +
                    "Vierte una porción de la mezcla en la sartén caliente, extendiéndola uniformemente para formar una tortilla.\n" +
                    "Cocina la tortilla durante unos minutos por cada lado, hasta que esté dorada y firme.\n" +
                    "Repite el proceso con el resto de la mezcla.\n" +
                    "Sirve caliente y disfruta de tus deliciosas tortillas de queso y espinacas. Puedes acompañarlas con salsa o guarniciones adicionales si lo deseas."))
        }
        when{
            estadoPlatano &&  estadoZanahoria -> listaRecetasCargadas.add(Receta(13, "Crema Zanahoria y Platano", "Ingredientes:\n" +
                    "\n" +
                    "Zanahorias\n" +
                    "Plátanos maduros\n" +
                    "Caldo de verduras o agua\n" +
                    "Sal y pimienta al gusto\n" +
                    "Opcional: crema o leche de coco para dar cremosidad (si deseas una versión más cremosa)\n" +
                    "\n"+
                    "Instrucciones:\n" +
                    "\n" +
                    "Pela y corta las zanahorias y los plátanos en trozos.\n" +
                    "En una olla grande, lleva a ebullición el caldo de verduras o el agua.\n" +
                    "Agrega las zanahorias y los plátanos a la olla.\n" +
                    "Cocina a fuego medio hasta que las zanahorias y los plátanos estén tiernos, aproximadamente de 15 a 20 minutos.\n" +
                    "Retira la olla del fuego y deja que la mezcla se enfríe un poco.\n" +
                    "Con una licuadora de inmersión o una licuadora de vaso, mezcla los ingredientes hasta obtener una crema suave y homogénea.\n" +
                    "Si lo deseas, puedes agregar crema o leche de coco para darle cremosidad a la sopa.\n" +
                    "Condimenta con sal y pimienta al gusto, y ajusta la consistencia agregando más caldo si es necesario.\n" +
                    "Vuelve a calentar la crema antes de servir.\n" +
                    "Sirve caliente y disfruta de esta reconfortante crema de zanahoria y plátano. Puedes decorar con hojas de cilantro o un chorrito de crema antes de servir, si lo deseas."))
        }
        when{
            estadoTomate &&  estadoHarina && estadoQueso && estadoCarne -> listaRecetasCargadas.add(Receta(14, "Pizza sencilla", "Ingredientes:\n" +
                    "\n" +
                    "Masa de pizza (puedes comprarla prehecha o prepararla en casa con harina)\n" +
                    "Salsa de tomate (puedes utilizar salsa de tomate casera o comprada)\n" +
                    "Queso rallado (como mozzarella, cheddar u otro de tu elección)\n" +
                    "Carne (puedes usar jamón, pepperoni, salchicha, o cualquier carne que prefieras)\n" +
                    "\n"+
                    "Instrucciones:\n" +
                    "\n" +
                    "Precalienta el horno a la temperatura recomendada para la masa de pizza (generalmente alrededor de 200-220°C).\n" +
                    "Extiende la masa de pizza sobre una bandeja para hornear previamente engrasada o cubierta con papel pergamino.\n" +
                    "Unta una capa uniforme de salsa de tomate sobre la masa, dejando un borde alrededor.\n" +
                    "Espolvorea generosamente el queso rallado sobre la salsa de tomate.\n" +
                    "Distribuye la carne elegida sobre la pizza, asegurándote de cubrirla de manera uniforme.\n" +
                    "Hornea la pizza en el horno precalentado según las instrucciones de la masa, generalmente de 12 a 15 minutos o hasta que la masa esté dorada y el queso esté burbujeante y dorado.\n" +
                    "Retira la pizza del horno y deja que se enfríe ligeramente antes de cortarla en porciones.\n" +
                    "¡Sirve caliente y disfruta de tu deliciosa pizza casera con carne, queso y tomate!"))
        }
        when{
            estadoPollo &&  estadoEspinaca -> listaRecetasCargadas.add(Receta(15, "Pollo al Pesto", "Ingredientes:\n" +
                    "\n" +
                    "Pechugas de pollo\n" +
                    "Pesto (puedes usar pesto comercial o prepararlo casero con albahaca fresca, piñones, queso parmesano, ajo, aceite de oliva, sal y pimienta)\n" +
                    "Sal y pimienta al gusto\n" +
                    "Aceite de oliva\n" +
                    "\n"+
                    "Instrucciones:\n" +
                    "\n" +
                    "Precalienta el horno a 200°C.\n" +
                    "Sazona las pechugas de pollo con sal y pimienta al gusto.\n" +
                    "Calienta una sartén a fuego medio-alto con un poco de aceite de oliva.\n" +
                    "Sella las pechugas de pollo en la sartén caliente, cocinándolas por ambos lados hasta que estén doradas.\n" +
                    "Transfiere las pechugas de pollo a una bandeja para hornear.\n" +
                    "Cubre las pechugas con una capa generosa de pesto, asegurándote de cubrirlas completamente.\n" +
                    "Hornea en el horno precalentado durante aproximadamente 15-20 minutos, o hasta que el pollo esté completamente cocido y el pesto esté burbujeante.\n" +
                    "Retira del horno y deja reposar unos minutos antes de servir.\n" +
                    "Sirve el pollo al pesto caliente, acompañado de tus guarniciones favoritas, como arroz, pasta o verduras al vapor.\n" +
                    "¡Disfruta de esta deliciosa y fácil receta de pollo al pesto!"))
        }
        when{
            estadoEspinaca &&  estadoZanahoria && estadoTomate -> listaRecetasCargadas.add(Receta(16, "Ensalada Simple", "Ingredientes:\n" +
                    "\n" +
                    "Tomates maduros\n" +
                    "Zanahorias\n" +
                    "Hojas de espinacas frescas\n" +
                    "Vinagreta (puedes usar vinagre balsámico, aceite de oliva, mostaza, sal y pimienta para hacer una simple vinagreta)\n" +
                    "Opcional: queso feta desmenuzado, nueces picadas, aceitunas, etc., para agregar más sabor y textura\n" +
                    "\n"+
                    "Instrucciones:\n" +
                    "\n" +
                    "Lava y corta los tomates en rodajas o trozos.\n" +
                    "Pela y ralla las zanahorias.\n" +
                    "Lava y seca las hojas de espinacas.\n" +
                    "En un tazón grande para ensaladas, combina los tomates, las zanahorias y las espinacas.\n" +
                    "Prepara la vinagreta mezclando el vinagre balsámico, el aceite de oliva, la mostaza, la sal y la pimienta en un frasco con tapa, y agitando bien para combinar.\n" +
                    "Vierte la vinagreta sobre la ensalada y mezcla suavemente para cubrir todos los ingredientes.\n" +
                    "Si lo deseas, añade ingredientes adicionales como queso feta desmenuzado, nueces picadas o aceitunas.\n" +
                    "Sirve la ensalada de tomate, zanahoria y espinacas en platos individuales y disfruta como acompañamiento fresco y saludable para tus comidas principales.\n" +
                    "¡Disfruta de esta ensalada simple y deliciosa!"))
        }
        when{
            estadoCarne -> listaRecetasCargadas.add(Receta(17, "Carne Asada", "Ingredientes:\n" +
                    "\n" +
                    "Carne para asar (puedes usar un corte como filete, chuletón, costillas, etc.)\n" +
                    "Sal gruesa o sal de mar\n" +
                    "Pimienta negra molida\n" +
                    "Aceite de oliva (opcional)\n" +
                    "\n"+
                    "Instrucciones:\n" +
                    "\n" +
                    "Saca la carne del refrigerador y déjala reposar a temperatura ambiente durante unos 30 minutos antes de cocinarla.\n" +
                    "Precalienta tu parrilla o asador a fuego medio-alto.\n" +
                    "Si lo deseas, puedes frotar la carne con un poco de aceite de oliva para ayudar a que se adhieran mejor las especias.\n" +
                    "Espolvorea generosamente la carne con sal gruesa y pimienta negra molida en ambos lados, presionando ligeramente para que se adhieran.\n" +
                    "Coloca la carne en la parrilla caliente y cocínala según el grosor y el punto de cocción deseado. Cocina cada lado durante unos 4-6 minutos para obtener una carne jugosa y ligeramente dorada por fuera.\n" +
                    "Utiliza unas pinzas para darle la vuelta a la carne con cuidado y evita pincharla con un tenedor para mantener los jugos en su interior.\n" +
                    "Una vez que la carne esté cocida a tu gusto, retírala de la parrilla y déjala reposar durante unos minutos antes de cortarla.\n" +
                    "Corta la carne en rodajas finas contra la veta y sírvela caliente.\n" +
                    "¡Disfruta de esta carne asada jugosa y llena de sabor como plato principal en tu próxima comida!"))
        }
        when{
            estadoPasta &&  estadoQueso -> listaRecetasCargadas.add(Receta(18, "Pasta con Queso", "Ingredientes:\n" +
                    "\n" +
                    "Pasta (puedes usar tu tipo de pasta favorita, como espaguetis, penne, farfalle, etc.)\n" +
                    "Queso rallado (como queso parmesano, queso cheddar, queso mozzarella, o una mezcla de varios quesos)\n" +
                    "Sal al gusto\n" +
                    "\n"+
                    "Instrucciones:\n" +
                    "\n" +
                    "Cocina la pasta en una olla grande con agua hirviendo y sal, siguiendo las instrucciones del paquete para el tiempo de cocción, hasta que esté al dente.\n" +
                    "Escurre la pasta cocida y reserva aproximadamente 1/2 taza del agua de cocción de la pasta.\n" +
                    "Devuelve la pasta a la olla caliente y agrega un poco del agua de cocción reservada.\n" +
                    "Agrega el queso rallado a la pasta caliente y mezcla bien hasta que el queso se derrita y la pasta esté cubierta de manera uniforme.\n" +
                    "Continúa añadiendo más agua de cocción si es necesario para obtener una salsa cremosa y suave.\n" +
                    "Prueba la pasta y ajusta la sazón con sal al gusto si es necesario.\n" +
                    "Sirve la pasta con queso caliente en platos individuales y, si lo deseas, espolvorea un poco más de queso rallado por encima.\n" +
                    "¡Disfruta de esta deliciosa y reconfortante pasta con queso como plato principal o acompañamiento!"))
        }
        when{
            estadoPollo &&  estadoCarne && estadoTomate && estadoHarina -> listaRecetasCargadas.add(Receta(19, "Arepas de Carne y Pollo", "Ingredientes:\n" +
                    "\n" +
                    "Harina de maíz precocida para hacer arepas\n" +
                    "Carne de pollo cocida y desmenuzada\n" +
                    "Carne de res cocida y desmenuzada (opcional)\n" +
                    "Tomate picado\n" +
                    "Sal al gusto\n" +
                    "Aceite para cocinar\n" +
                    "\n"+
                    "Instrucciones:\n" +
                    "\n" +
                    "Prepara la masa para las arepas siguiendo las instrucciones del paquete de harina de maíz precocida. Generalmente, mezcla la harina con agua y sal hasta obtener una masa suave y maleable.\n" +
                    "Divide la masa en porciones y forma cada porción en una bola. Luego, aplana cada bola para formar una arepa delgada y redonda.\n" +
                    "Calienta una sartén antiadherente a fuego medio-alto y agrega un poco de aceite.\n" +
                    "Cocina las arepas en la sartén caliente, unos 5 minutos por cada lado, o hasta que estén doradas y cocidas por dentro.\n" +
                    "Mientras las arepas se cocinan, prepara el relleno. En una sartén, saltea la carne de pollo y de res (si la estás usando) con el tomate picado hasta que estén bien cocidos y sazonados al gusto.\n" +
                    "Una vez cocidas las arepas, córtalas por la mitad y rellénalas con la mezcla de carne y tomate.\n" +
                    "Sirve las arepas calientes y disfruta de este delicioso plato típico venezolano."))
        }
        when{
             estadoPasta -> listaRecetasCargadas.add(Receta(20, "Sola Pasta", "Ingredientes:\n" +
                     "\n" +
                     "Espaguetis\n" +
                     "Agua\n" +
                     "Sal\n" +
                     "\n"+
                     "Instrucciones:\n" +
                     "\n" +
                     "En una olla grande, lleva a ebullición una cantidad suficiente de agua. Añade sal al agua al gusto.\n" +
                     "Agrega los espaguetis a la olla de agua hirviendo.\n" +
                     "Cocina los espaguetis siguiendo las instrucciones del paquete o hasta que estén al dente, es decir, cocidos pero aún firmes al morder.\n" +
                     "Una vez cocidos, escurre los espaguetis en un colador.\n" +
                     "Sirve los espaguetis calientes en platos individuales.\n" +
                     "Si lo deseas, puedes añadir un poco de aceite de oliva o mantequilla derretida por encima para darle un poco de sabor y evitar que se peguen."))
        }
        when{
            estadoPollo -> listaRecetasCargadas.add(Receta(21, "Pollo Hervido", "Ingredientes:\n" +
                    "\n" +
                    "Pechugas de pollo (o cualquier otra parte de pollo que prefieras)\n" +
                    "Agua\n" +
                    "Sal al gusto\n" +
                    "\n"+
                    "Instrucciones:\n" +
                    "\n" +
                    "Lava las pechugas de pollo (o la parte de pollo que estés usando) bajo agua fría para limpiarlas.\n" +
                    "En una olla grande, vierte suficiente agua para cubrir completamente el pollo.\n" +
                    "Agrega sal al agua al gusto.\n" +
                    "Coloca las pechugas de pollo en la olla con agua salada.\n" +
                    "Lleva el agua a ebullición a fuego medio-alto.\n" +
                    "Una vez que el agua comience a hervir, reduce el fuego a medio-bajo para mantener un hervor suave.\n" +
                    "Cocina el pollo durante aproximadamente 20-25 minutos, o hasta que esté completamente cocido y tierno.\n" +
                    "Retira las pechugas de pollo de la olla y déjalas reposar unos minutos antes de cortarlas o desmenuzarlas según tu preferencia.\n" +
                    "Sirve el pollo hervido caliente como plato principal o úsalo como base para otras recetas como ensaladas, sopas, tacos, etc."))
        }
        when{
            estadoTomate -> listaRecetasCargadas.add(Receta(22, "Tomate y Sal", "Tomate y sal jajaj picalo y te lo comes"))
        }
        when{
            estadoQueso -> listaRecetasCargadas.add(Receta(23, "Queso frito", "Ingredientes:\n" +
                    "\n" +
                    "Queso firme adecuado para freír (como queso panela, queso blanco, halloumi, etc.)\n" +
                    "Aceite para freír\n" +
                    "\n"+
                    "Instrucciones:\n" +
                    "\n" +
                    "Corta el queso en rodajas o trozos del tamaño deseado.\n" +
                    "Calienta una sartén o una parrilla a fuego medio-alto.\n" +
                    "Agrega un poco de aceite a la sartén y deja que se caliente.\n" +
                    "Cuando el aceite esté caliente, coloca las rodajas o trozos de queso en la sartén.\n" +
                    "Fríe el queso durante unos 2-3 minutos por cada lado, o hasta que estén dorados y crujientes por fuera y ligeramente derretidos por dentro.\n" +
                    "Una vez listo, retira el queso frito de la sartén y colócalo sobre papel absorbente para eliminar el exceso de aceite.\n" +
                    "Sirve el queso frito caliente como aperitivo, acompañamiento o como desees."))
        }
        when{
            estadoPlatano -> listaRecetasCargadas.add(Receta(24, "Platano Frito", "Ingredientes:\n" +
                    "\n" +
                    "Plátanos maduros (preferiblemente que estén bien maduros)\n" +
                    "Aceite para freír\n" +
                    "\n"+
                    "Instrucciones:\n" +
                    "\n" +
                    "Pelar los plátanos y cortarlos en rodajas diagonales o en rodajas gruesas, según tu preferencia.\n" +
                    "Calentar suficiente aceite en una sartén grande a fuego medio-alto. El aceite debe ser lo suficientemente profundo para cubrir las rodajas de plátano.\n" +
                    "Una vez que el aceite esté caliente, añadir las rodajas de plátano en una capa uniforme en la sartén, sin amontonarlas.\n" +
                    "Freír los plátanos durante 2-3 minutos por cada lado, o hasta que estén dorados y crujientes por fuera.\n" +
                    "Usar una espumadera o una pinza para darles la vuelta con cuidado.\n" +
                    "Una vez dorados, retirar los plátanos de la sartén y colocarlos sobre papel absorbente para eliminar el exceso de aceite.\n" +
                    "Repetir el proceso con el resto de las rodajas de plátano, si es necesario, asegurándote de mantener el aceite caliente.\n" +
                    "Servir los plátanos fritos calientes como acompañamiento de tus platos favoritos, o disfrutarlos solos como un delicioso bocadillo."))
        }
        when{
            estadoEspinaca -> listaRecetasCargadas.add(Receta(25, "Seleccione otro ingrediente", "No hay recetas solo con espinaca"))
        }
        when{
            estadoZanahoria -> listaRecetasCargadas.add(Receta(26, "Seleccione otro ingrediente", "No hay recetas solo con zanahoria"))
        }
        when{
            estadoPasta -> listaRecetasCargadas.add(Receta(27, "Seleccione otro ingrediente", "No hay recetas solo con pasta"))
        }

        binding.lstRecetas.apply {
            adapter = RecetaAdapter(listaRecetasCargadas,
                this@SegundaPaginaActivity
            )
           layoutManager = LinearLayoutManager(this@SegundaPaginaActivity)
        }
    }

    override fun onRecetasClick(receta: Receta) {
        val intent = Intent(this, ThirdPageActivity::class.java)
        intent.putExtra("texto", receta.texto)
        startActivity(intent)
    }
}