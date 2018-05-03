package com.loktra.krishna.view

import com.loktra.krishna.model.User

interface RepositoryMvpView : MvpView {

    fun showOwner(owner: User)

}
