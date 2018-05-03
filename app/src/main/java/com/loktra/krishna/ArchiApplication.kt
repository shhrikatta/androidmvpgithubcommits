package com.loktra.krishna

import android.app.Application
import android.content.Context
import com.loktra.krishna.dagger.AppComponent
import com.loktra.krishna.dagger.AppModule
import com.loktra.krishna.dagger.DaggerAppComponent

import com.loktra.krishna.model.GithubService

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class ArchiApplication : Application() {

    lateinit var archiComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        archiComponent = initDagger(this)

    }

    //For setting mocks during testing
    var githubService: GithubService? = null
        get() {
            if (field == null) {
                this.githubService = GithubService.Factory.create()
            }
            return field
        }
    private var defaultSubscribeScheduler: Scheduler? = null

    fun defaultSubscribeScheduler(): Scheduler {
        if (defaultSubscribeScheduler == null) {
            defaultSubscribeScheduler = Schedulers.io()
        }
        return defaultSubscribeScheduler as Scheduler
    }

    //User to change scheduler from tests
    fun setDefaultSubscribeScheduler(scheduler: Scheduler) {
        this.defaultSubscribeScheduler = scheduler
    }

    companion object {

        operator fun get(context: Context): ArchiApplication {
            return context.applicationContext as ArchiApplication
        }
    }

    private fun initDagger(app: ArchiApplication): AppComponent =
            DaggerAppComponent.builder()
                    .appModule(AppModule(app))
                    .build()
}
