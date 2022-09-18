package com.example.odev1

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.odev1.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    private lateinit var counterTextView: TextView
    private var countValue = 0
    companion object {
        const val SCORE_KEY = "score_key"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.v("PATIKADEV","onAttach called.")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("PATIKADEV","onCreate called.")
    }

    /**
     * onCreateView de DataBinding tanımlandı.
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return fragmentHomeBinding.root
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.v("PATIKADEV","onCreateView called.")
        fragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)
        return fragmentHomeBinding.root
    }

    /**
     * Butonlara tıklandığında fonksiyonlara yönledirildi.
     *
     * @param view
     * @param savedInstanceState
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.v("PATIKADEV","onViewCreated called.")

        counterTextView = fragmentHomeBinding.counterText
        fragmentHomeBinding.apply {
            incrementButton.setOnClickListener{
                incrementCounter()
            }
            decrementButton.setOnClickListener {
                decrementCounter()
            }
        }
        displayCounter()
    }

    /**
     * savedInstanceState ile tutulan değer tekrar countValue ye eşitlendi.
     *
     * @param savedInstanceState
     */
    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.v("PATIKADEV","onViewStateRestored called.")

        if (savedInstanceState != null) {
            countValue = savedInstanceState.getInt(SCORE_KEY,0)
        }
        displayCounter()
    }

    override fun onStart() {
        super.onStart()
        Log.v("PATIKADEV","onStart called.")
    }

    override fun onResume() {
        super.onResume()
        Log.v("PATIKADEV","onResume called.")
    }

    override fun onPause() {
        super.onPause()
        Log.v("PATIKADEV","onPause called.")
    }

    override fun onStop() {
        super.onStop()
        Log.v("PATIKADEV","onStop called.")
    }

    /**
     * Program pause olduğunda CountValue yi Score Key olarak koruyoruz.
     *
     * @param outState
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.v("PATIKADEV","onSaveInstanceState called.")

        outState.putInt(SCORE_KEY,countValue)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.v("PATIKADEV","onDestroyView called.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("PATIKADEV","onDestroy called.")
    }

    override fun onDetach() {
        super.onDetach()
        Log.v("PATIKADEV","onDetach called.")
    }

    /**
     * countValue'yi bir arttırmak için kullanılır.
     *
     */
    private fun incrementCounter() {
        countValue+=1
        displayCounter()
    }

    /**
     * countValue'yi bir azaltmak için kullanılır.
     *
     */
    private fun decrementCounter() {
        countValue-=1
        displayCounter()
    }

    /**
     * counterTextView de countValue'yi göstermek için kullandık.
     *
     */
    private fun displayCounter() {
        counterTextView.text = countValue.toString()
    }
}