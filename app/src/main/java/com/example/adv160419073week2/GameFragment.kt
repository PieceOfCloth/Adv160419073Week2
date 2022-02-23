package com.example.adv160419073week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_main.*

class GameFragment : Fragment() {
    val rand1 = (0..100).random()
    val rand2 = (0..100).random()
    val result = rand1 + rand2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"
        }
        txtNumber1.setText(rand1.toString())
        txtNumber2.setText(rand2.toString())

        btnSubmitAnswer.setOnClickListener {
            if(txtAnswer.text.toString() == result.toString()){
                txtResult1.setText("Benar")
            }else{
                val benar = txtAnswer.text.toString()
                val action = GameFragmentDirections.actionResultFragment(benar)
                Navigation.findNavController(it).navigate(action)
            }
        }

        /*btnBack.setOnClickListener {
            val action = GameFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }*/
    }
}