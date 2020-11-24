package com.myogardener.worldroomdatabase6.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.myogardener.worldroomdatabase6.DB.WordViewModel
import com.myogardener.worldroomdatabase6.R
import kotlinx.android.synthetic.main.fragment_update.*

class UpdateFragment : Fragment() {
    private val args by navArgs<UpdateFragmentArgs>()
    lateinit var wordViewModel :WordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wordViewModel= ViewModelProviders.of(this).get(WordViewModel::class.java)

   edt_name_update.setText(args.word.name)

        floatingActionButton_update.setOnClickListener {


wordViewModel.updateItem(edt_name_update.text.toString(),args.word.name)

            findNavController().popBackStack()
        }
    }
}