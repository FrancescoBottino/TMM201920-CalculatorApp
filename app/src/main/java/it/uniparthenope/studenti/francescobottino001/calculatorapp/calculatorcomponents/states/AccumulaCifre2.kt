package it.uniparthenope.studenti.francescobottino001.calculatorapp.calculatorcomponents.states

import it.uniparthenope.studenti.francescobottino001.calculatorapp.Calculator
import it.uniparthenope.studenti.francescobottino001.calculatorapp.calculatorcomponents.CalculatorState
import it.uniparthenope.studenti.francescobottino001.calculatorapp.calculatorcomponents.CalculatorStates

class AccumulaCifre2(private val calculator: Calculator) : CalculatorState(calculator) {
    override fun gestisci_operatore(valore: String): Boolean {
        calculator.cambiaStato(CalculatorStates.FINALE)
        return false
    }

    override fun gestisci_funzione(valore: String): Boolean {
        when(valore) {
            "AC" -> calculator.clear()
            "+/-" -> calculator.sign()
            "." -> if (!calculator.num_1.contains('.')) calculator.num_1 += '.'
            "%" -> calculator.percent()
            else -> {}
        }
        return true
    }

    override fun gestisci_numero(valore: String): Boolean {
        if(calculator.num_1 != "" && calculator.num_1 != "0")
            calculator.num_1 += valore
        else
            calculator.num_1 = valore
        return true
    }

    override fun gestisci_uguale(valore: String): Boolean {
        calculator.cambiaStato(CalculatorStates.FINALE)
        return false
    }

}
