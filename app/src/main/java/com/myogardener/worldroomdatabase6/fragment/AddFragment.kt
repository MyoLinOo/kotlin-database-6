package com.myogardener.worldroomdatabase6.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.myogardener.worldroomdatabase6.DB.Word
import com.myogardener.worldroomdatabase6.DB.WordAdapter
import com.myogardener.worldroomdatabase6.DB.WordViewModel
import com.myogardener.worldroomdatabase6.R
import kotlinx.android.synthetic.main.fragment_add.*

class AddFragment : Fragment() {
lateinit var wordViewModel: WordViewModel
val wordAdapter = WordAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)

        floatingActionButton_send.setOnClickListener {
           var word= Word(edt_name.text.toString())

        wordViewModel.insert(word)
            findNavController().popBackStack()
        }

    }
}