package com.loktra.krishna.presenter

import android.util.Log

import com.loktra.krishna.ArchiApplication
import com.loktra.krishna.R
import com.loktra.krishna.model.Commit
import com.loktra.krishna.model.GithubService
import com.loktra.krishna.model.Repository
import com.loktra.krishna.view.MainMvpView


import org.reactivestreams.Subscription

import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import retrofit2.HttpException

class MainPresenter : Presenter<MainMvpView> {

    private var mainMvpView: MainMvpView? = null
    private val subscription: Subscription? = null
    private var repositories: List<Commit>? = null

    override fun attachView(view: MainMvpView) {
        this.mainMvpView = view
    }

    override fun detachView() {
        this.mainMvpView = null
        //        if (subscription != null) subscription.cancel();
    }

    fun loadRepositories(ownerName: String, repoName: String) {
        val username = ownerName.trim { it <= ' ' }
        val repo = repoName.trim { it <= ' ' }

        if (username.isEmpty() || repo.isEmpty()) return

        mainMvpView!!.showProgressIndicator()
        //        if (subscription != null) subscription.cancel();
        val application = ArchiApplication[mainMvpView!!.getContext()]
        val githubService = application.githubService
        githubService!!.publicRepositories(username, repo)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(application.defaultSubscribeScheduler())
                .subscribe(object : Observer<List<Commit>> {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(repositories: List<Commit>) {
                        this@MainPresenter.repositories = repositories
                    }

                    override fun onError(error: Throwable) {
                        Log.e(TAG, "Error loading GitHub repos ", error)
                        if (isHttp404(error)) {
                            mainMvpView!!.showMessage(R.string.error_username_not_found)
                        } else {
                            mainMvpView!!.showMessage(R.string.error_loading_repos)
                        }
                    }

                    override fun onComplete() {
                        Log.i(TAG, "Repos loaded " + repositories!!)
                        if (!repositories!!.isEmpty()) {
                            mainMvpView!!.showRepositories(repositories!!)
                        } else {
                            mainMvpView!!.showMessage(R.string.text_empty_repos)
                        }
                    }
                })
    }

    companion object {

        var TAG = "MainPresenter"

        private fun isHttp404(error: Throwable): Boolean {
            return error is HttpException && error.code() == 404
        }
    }

}