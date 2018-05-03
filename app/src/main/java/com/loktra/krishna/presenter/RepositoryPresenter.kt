package com.loktra.krishna.presenter

import android.util.Log

import com.loktra.krishna.ArchiApplication
import com.loktra.krishna.model.GithubService
import com.loktra.krishna.view.RepositoryMvpView

import org.reactivestreams.Subscription

import io.reactivex.android.schedulers.AndroidSchedulers

class RepositoryPresenter : Presenter<RepositoryMvpView> {

    private var repositoryMvpView: RepositoryMvpView? = null
    private val subscription: Subscription? = null

    override fun attachView(view: RepositoryMvpView) {
        this.repositoryMvpView = view
    }

    override fun detachView() {
        this.repositoryMvpView = null
        //        if (subscription != null) subscription.cancel();
    }

    fun loadOwner(userUrl: String) {
        val application = ArchiApplication.get(repositoryMvpView!!.getContext())
        val githubService = application.githubService
        githubService!!.userFromUrl(userUrl)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(application.defaultSubscribeScheduler())
                .subscribe { user ->
                    Log.i(TAG, "Full user data loaded $user")
                    repositoryMvpView!!.showOwner(user)
                }
    }

    companion object {

        private val TAG = "RepositoryPresenter"
    }
}
