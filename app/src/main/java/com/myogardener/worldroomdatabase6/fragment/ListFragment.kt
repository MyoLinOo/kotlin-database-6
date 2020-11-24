package com.myogardener.worldroomdatabase6.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.myogardener.worldroomdatabase6.DB.Word
import com.myogardener.worldroomdatabase6.DB.WordAdapter
import com.myogardener.worldroomdatabase6.DB.WordViewModel
import com.myogardener.worldroomdatabase6.R
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment(),WordAdapter.Clicklistener {
    val wordAdapter = WordAdapter()
    lateinit var wordViewModel:WordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wordViewModel= ViewModelProviders.of(this).get(WordViewModel::class.java)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter =wordAdapter

        floatingActionButton_add.setOnClickListener{
            var action= ListFragmentDirections.actionListFragmentToAddFragment()
            findNavController().navigate(action)

        }
        floatingActionButton_delete.setOnClickListener {
            wordViewModel.deleteAll()
        }

        wordViewModel.allWord.observe(viewLifecycleOwner, Observer {
            wordAdapter.updateData(it)
        })
        wordAdapter.setOnclickListener(this)
    }

    override fun onclick(word: Word) {
        val builder = AlertDialog.Builder(context)
        builder.apply {
            setTitle("Delete item")
            setMessage("Are you sure to delete?")
            setIcon(android.R.drawable.ic_dialog_alert)


            setPositiveButton("Yes") { dialogInterface, i ->
                wordViewModel.deleteItem(word.name)
                Toast.makeText(context, "Delete successful", Toast.LENGTH_SHORT).show()
            }

            setNegativeButton("No") { dialogInterface, i ->
                Toast.makeText(context, "Delete cancel", Toast.LENGTH_SHORT).show()
            }

            setNeutralButton("Update") {dialogInterface,i->
                var action = ListFragmentDirections.actionListFragmentToUpdateFragment(word)
                findNavController().navigate(action)
//            dialogInterface, i ->
//                val updateBuilder = AlertDialog.Builder(context)
//                val dialogLayout = layoutInflater.inflate(
//                    R.layout.fragment_update, null
//                )
//                updateBuilder.apply {
//                    setTitle("Update Book")
//                    setView(dialogLayout)
//                    setPositiveButton("Ok") { dialogInterface, i ->
//                        //update လုပ်လိုက်တဲ့ Data တွေကို book_table က bookName ထဲကိုထည့်
//                        val updateText = dialogLayout.edtUpdateName.text.toString()
//                        bookViewModel.updateItem(updateText, book.bookName)
//                    }
//                }
//                val updateDialog: AlertDialog = updateBuilder.create()
//                updateDialog.show()
            }
        }.show()

    }
}