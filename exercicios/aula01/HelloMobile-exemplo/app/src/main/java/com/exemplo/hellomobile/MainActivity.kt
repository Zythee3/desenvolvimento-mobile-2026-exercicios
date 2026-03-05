package com.exemplo.hellomobile

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Array de cores com nomes representativos
        val cores = arrayOf(
            Color.parseColor("#FFFFFF"),   // Branco
            Color.parseColor("#715b31"),   // Marrom claro
            Color.parseColor("#66c491"),   // Verde claro
            Color.parseColor("#574B60"),   // Deep Amethyst
            Color.parseColor("#3F334D"),   // Grayish violet
            Color.parseColor("#EDAFB8")    // Cherry blossom
        )

        var indice = 0

        // Pegar referências dos componentes do layout
        val rootLayout: LinearLayout = findViewById(R.id.rootLayout)
        val btnMudarCor: Button = findViewById(R.id.btnMudarCor)
        val btnReset: Button = findViewById(R.id.btnReset)

        // Botão para resetar para a cor padrão (Branco)
        btnReset.setOnClickListener {
            val colorFrom = (rootLayout.background as? ColorDrawable)?.color ?: Color.WHITE
            animateColorChange(rootLayout, colorFrom, Color.WHITE)
            indice = 0 // Reinicia o índice
        }

        // Lógica para alterar as cores com animação
        btnMudarCor.setOnClickListener {
            // 1. Pega a cor atual do fundo
            val colorFrom = (rootLayout.background as? ColorDrawable)?.color ?: Color.WHITE

            // 2. Pega a próxima cor do array
            val colorTo = cores[indice]

            // 3. Executa a animação
            animateColorChange(rootLayout, colorFrom, colorTo)

            // Atualiza o índice para a próxima cor
            indice = (indice + 1) % cores.size
        }
    }

    private fun animateColorChange(view: LinearLayout, colorFrom: Int, colorTo: Int) {
        val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), colorFrom, colorTo)
        colorAnimation.duration = 500
        colorAnimation.addUpdateListener { animator ->
            view.setBackgroundColor(animator.animatedValue as Int)
        }
        colorAnimation.start()
    }
}
