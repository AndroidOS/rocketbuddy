package com.casa.azul.rocketboy.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.casa.azul.rocketboy.model.Mission
import com.casa.azul.rocketboy.model.Mission1
import com.casa.azul.rocketboy.model.MissionApiService
import com.casa.azul.rocketboy.model.MissionDatabase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

private const val TAG = "RocketViewModel"

class RocketViewModel(application: Application) : BaseViewModel(application) {

    val missions by lazy { MutableLiveData<List<Mission>>() }
    val loading = MutableLiveData<Boolean>()

    private val disposable = CompositeDisposable()
    private val api = MissionApiService()

    fun getDetailMission(i: Int): Mission {

        return missions.value!![i]
    }

    fun getMission() {
        loading.value = true
        Log.d(TAG, "getMission Started")
        disposable.add(
            api.getMission()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Mission>>() {
                    override fun onSuccess(t: List<Mission>) {
                        storeMissionsLocally(t)
                        missions.value = t
                        loading.value = false
                    }

                    override fun onError(e: Throwable) {
                        Log.d(TAG, "Error $e")
                    }

                })
        )
    }

    private fun storeMissionsLocally(missionList: List<Mission>) {
        launch {
            val dao = MissionDatabase(getApplication()).missionDao()
            val list = createMission1List(missionList)
            dao.deleteAllMissions()
            val result = dao.insertAll(*list.toTypedArray())
            var i = 0
            while (i < list.size) {
                list[i].uuid = result[i].toInt()
                ++i
            }
            //fetchFromDatabase()
        }
    }

    private fun createMission1List(missionList: List<Mission>): List<Mission1> {
        var list = mutableListOf<Mission1>()
        for (q in missionList) {
            list.add(Mission1(q.mission_name, q.launch_date_unix.toString()))
        }
        return list
    }
}