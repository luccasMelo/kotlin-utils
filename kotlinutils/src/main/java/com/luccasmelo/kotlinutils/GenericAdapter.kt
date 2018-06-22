package com.luccasmelo.kotlinutils

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.MainThread
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import org.jetbrains.annotations.Nullable
import android.support.v7.widget.LinearLayoutManager




abstract class GenericAdapter<ITEM> constructor(protected var itemList: ArrayList<ITEM>,
                                                 private val layoutResId: Int, private val bindId: Int) : RecyclerView.Adapter<GenericAdapter.GenericViewHolder>() {


    override fun getItemCount() = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {

        val view = parent inflate layoutResId
        val viewHolder = GenericViewHolder(view)
        val itemView = viewHolder.itemView
        itemView.setOnClickListener {
            val adapterPosition = viewHolder.adapterPosition
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onItemClick(itemView, adapterPosition)
                onItemClick(viewHolder)
            }
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: GenericAdapter.GenericViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item!!, bindId)
    }


    @MainThread
    fun update(items: ArrayList<ITEM>) {
        val diffResult = DiffUtil.calculateDiff(DiffUtilCallback(itemList, items), false)
        this.itemList = items
        diffResult.dispatchUpdatesTo(this)
    }



    fun add(item: ITEM) {
        itemList.add(item)
        notifyItemInserted(itemList.size)
    }

    fun remove(position: Int) {
        itemList.removeAt(position)
        notifyItemRemoved(position)
    }


    protected open fun onViewRecycled(itemView: View) {
    }

    protected open fun onItemClick(itemView: View, position: Int) {
    }

    protected open fun onItemClick(viewHolder:GenericViewHolder) {
    }

    override fun onViewRecycled(holder: GenericViewHolder) {
        super.onViewRecycled(holder)
        this.onViewRecycled(holder.itemView)

    }

    class GenericViewHolder internal constructor(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(any: Any, id: Int) {
            binding.setVariable(id, any)
            binding.executePendingBindings()
        }
    }


}

internal class DiffUtilCallback<ITEM>(private val oldItems: MutableList<ITEM>,
                                      private val newItems: MutableList<ITEM>) : DiffUtil.Callback() {

    override fun getOldListSize() = oldItems.size

    override fun getNewListSize() = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldItems[oldItemPosition] == newItems[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldItems[oldItemPosition] == newItems[newItemPosition]

    @Nullable
    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {

        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}

infix fun ViewGroup.inflate(layoutResId: Int): ViewDataBinding =
        DataBindingUtil.inflate<ViewDataBinding>(
                LayoutInflater.from(this.context), layoutResId, this, false)


abstract class EndlessScrollListener : RecyclerView.OnScrollListener() {

    private var mPreviousTotal = 0

    private var mLoading = true

    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItemCount = recyclerView!!.childCount
        val totalItemCount = recyclerView.layoutManager.itemCount
        val firstVisibleItem = (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

        if (mLoading) {
            if (totalItemCount > mPreviousTotal) {
                mLoading = false
                mPreviousTotal = totalItemCount
            }
        }
        val visibleThreshold = 5
        if (!mLoading && totalItemCount - visibleItemCount <= firstVisibleItem + visibleThreshold) {
            onLoadMore()
            mLoading = true
        }
    }

    abstract fun onLoadMore()
}


