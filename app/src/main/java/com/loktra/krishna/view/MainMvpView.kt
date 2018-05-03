package com.loktra.krishna.view

import com.loktra.krishna.model.Commit
import com.loktra.krishna.model.Repository

interface MainMvpView : MvpView {

    fun showRepositories(repositories: List<Commit>)

    fun showMessage(stringId: Int)

    fun showProgressIndicator()
}
