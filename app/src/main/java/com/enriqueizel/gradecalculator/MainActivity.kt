package com.enriqueizel.gradecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.enriqueizel.gradecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.btnCalculate.setOnClickListener {
      val note1 = binding.schoolGrade1.text.toString().toDouble()
      val note2 = binding.schoolGrade2.text.toString().toDouble()
      val note3 = binding.schoolGrade3.text.toString().toDouble()
      val note4 = binding.schoolGrade4.text.toString().toDouble()
      val absences = binding.absences.text.toString().toInt()
      val textResult = binding.textResult

      val meanNotes = (note1 + note2 + note3 + note4) / 4

      if (meanNotes >= 6 && absences <= 20) {
        textResult.setText("Aluno Aprovado\n Média $meanNotes")
        textResult.setTextColor(getColor(R.color.green))
        clearFields()
      } else {
        textResult.setText("Aluno Reprovado\n Média $meanNotes\n Faltas $absences ")
        textResult.setTextColor(getColor(R.color.red))
        clearFields()
      }
    }
  }

  fun clearFields(){
    with(binding) {
      schoolGrade1.setText("")
      schoolGrade2.setText("")
      schoolGrade3.setText("")
      schoolGrade4.setText("")
    }
  }
}