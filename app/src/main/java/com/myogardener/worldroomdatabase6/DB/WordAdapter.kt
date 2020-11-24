package com.myogardener.worldroomdatabase6.DB

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myogardener.worldroomdatabase6.R
import kotlinx.android.synthetic.main.item_word.view.*

class WordAdapter: RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    private var mclickListener:Clicklistener ?=null
    private var wordList = emptyList<Word>()

    fun setOnclickListener(clicklistener: Clicklistener){
        this.mclickListener= clicklistener
    }

    inner class WordViewHolder (itemView: View): RecyclerView.ViewHolder(itemView),View.OnClickListener{

        lateinit var word: Word

        fun bind(word: Word){
            this.word= word
            itemView.item_word.text= word.name
        }
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            mclickListener?.onclick(word)
        }
    }
    fun updateData(wordList: List<Word>){
        this.wordList= wordList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_word,parent,false)
        return WordViewHolder(view)
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(wordList[position])
    }
    interface Clicklistener{
        fun onclick(word: Word)
    }
}