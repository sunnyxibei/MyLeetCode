package cn.com.timeriver.myleetcode

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import cn.com.timeriver.myleetcode.string.ValidPalindrome
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private val _VALID_PALINDROME = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        val recyclerView = find<RecyclerView>(R.id.list)

        val stringList = arrayListOf<String>()
        stringList.add("Valid Palindrome")
        recyclerView.layoutManager = LinearLayoutManager(this)
        val listAdapter = ListAdapter(stringList)
        recyclerView.adapter = listAdapter
        listAdapter.setOnItemClickListener { position -> handleClick(position) }
    }

    private fun handleClick(position: Int) {
        when (position) {
            _VALID_PALINDROME -> showValidPalindromeResult()
            else -> ""
        }
    }

    private fun showValidPalindromeResult() {
        val sample = "A man, a plan, a canal: Panama"
        toast("$sample is a valid palindrome : ${ValidPalindrome.checkValidPalindrome(sample)}")

    }
}

class ListAdapter(val data: ArrayList<String>) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context)
                .inflate(android.R.layout.simple_list_item_1, parent, false)
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = data[position]
        holder.itemView.setOnClickListener { mListener?.invoke(position) }
    }

    private var mListener: ((position: Int) -> Unit)? = null

    fun setOnItemClickListener(listener: ((position: Int) -> Unit)) {
        mListener = listener
    }
}

class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var textView: TextView = itemView!!.find(android.R.id.text1)

}
