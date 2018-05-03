package com.loktra.krishna

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.loktra.krishna.model.Commit
import com.squareup.picasso.Picasso

import java.util.Collections

class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder> {

    private var repositories: List<Commit>? = null
    private var callback: Callback? = null
    private var mContext: Context? = null

    constructor() {
        this.repositories = emptyList()
    }

    constructor(repositories: List<Commit>) {
        this.repositories = repositories
    }

    fun setRepositories(repositories: List<Commit>, context: Context) {
        this.repositories = repositories
        this.mContext = context
    }

    fun setCallback(callback: Callback) {
        this.callback = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_repo, parent, false)
        val viewHolder = RepositoryViewHolder(itemView)
        /*
        viewHolder.contentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback != null) {
                    callback.onItemClick(viewHolder.repository);
                }
            }
        });
*/
        return viewHolder
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val commit = repositories!![position]

        holder.autornameTextView.text = commit.commit.author.name
        holder.commitVersionTextView.text = commit.sha
        holder.commitMessageTextView.text = commit.commit.message
        Picasso.with(mContext).load(commit.author.avatarUrl).into(holder.mCircleImageView)
    }

    override fun getItemCount(): Int {
        return repositories!!.size
    }

    class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var contentLayout: View
        var autornameTextView: TextView
        var commitVersionTextView: TextView
        var commitMessageTextView: TextView
        var mCircleImageView: CircleImageView

        init {
            contentLayout = itemView.findViewById(R.id.layout_content)
            autornameTextView = itemView.findViewById(R.id.autor_name)
            commitVersionTextView = itemView.findViewById(R.id.commit_version)
            commitMessageTextView = itemView.findViewById(R.id.commit_message)
            mCircleImageView = itemView.findViewById(R.id.profileImageView)
        }
    }

    interface Callback//        void onItemClick(Commit repository);
}
