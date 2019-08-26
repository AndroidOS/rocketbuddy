package com.casa.azul.rocketboy.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.casa.azul.rocketboy.model.Mission
import com.casa.azul.rocketboy.model.MissionApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

private const val TAG = "RocketViewModel"

class RocketViewModel(application: Application) : AndroidViewModel(application) {

    val missions by lazy { MutableLiveData<Mission>() }

    private val disposable = CompositeDisposable()
    private val api = MissionApiService()

    fun getMission() {
        Log.d(TAG, "getMission Started****************************************")
        disposable.add(
            api.getMission()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Mission>() {
                    override fun onSuccess(t: Mission) {
                        Log.d(TAG, "Mission object = $t")
                    }

                    override fun onError(e: Throwable) {
                        Log.d(TAG, "Error $e")
                    }

                })
        )
    }
}