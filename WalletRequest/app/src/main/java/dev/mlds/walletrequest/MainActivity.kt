package dev.mlds.walletrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import dev.mlds.walletrequest.Card
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var configuracao: ConfRetrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configuracao = ConfRetrofit()

        val servico = configuracao.service

        servico.getAll().enqueue(object : Callback<List<Card>> {
            override fun onResponse(call: Call<List<Card>>, response: Response<List<Card>>) {
                // 200, 201, 400, 404, 403, 401, 304
                Toast.makeText(this@MainActivity, "Sucesso", Toast.LENGTH_LONG).show()
                println("Sucesso")
            }

            override fun onFailure(call: Call<List<Card>>, t: Throwable) {
                // 500, 502, 501
                Toast.makeText(this@MainActivity, "Falha na conexao", Toast.LENGTH_LONG).show()
            }
        })

//        Thread {
//            try {
//                servico.getAll().execute()
//            } catch (e: Exception) {
//                Log.e("FATAL", e.message.orEmpty())
//            }
//        }
    }
}