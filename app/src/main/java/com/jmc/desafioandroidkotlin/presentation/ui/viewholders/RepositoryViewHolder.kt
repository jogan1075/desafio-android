package com.jmc.desafioandroidkotlin.presentation.ui.viewholders

import android.view.View
import com.jmc.desafioandroidkotlin.presentation.model.RepositoryItem
import com.jmc.desafioandroidkotlin.presentation.ui.adapters.PagedRepositoryAdapter
import com.jmc.desafioandroidkotlin.utils.onClickOnce

import kotlinx.android.synthetic.main.item_repository.view.*

open class RepositoryViewHolder(
    itemView: View,
    private val callback: PagedRepositoryAdapter.AdapterCallback
) : BaseViewHolder<RepositoryItem>(itemView) {
    override fun bindView(item: RepositoryItem) {
        with(itemView) {
            tViewRepositoryName.text = item.name
            tViewRepositoryDescription.text = item.description
            tViewRepositoryUserName.text = item.userLogin
            tViewRepositoryForkCount.text = item.forksCount
            tViewRepositoryStarCount.text = item.stargazersCount
            tViewRepositoryIssueCount.text = item.openIssuesCount

            callback.loadImage(item.userAvatarUrl, iViewRepositoryUserAvatar)

            onClickOnce { callback.onRepositoryClicked(item) }

            iViewRepositoryUserAvatar.onClickOnce { callback.onUserClicked(item) }
        }
    }
}