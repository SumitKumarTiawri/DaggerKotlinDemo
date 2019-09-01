package com.coderlab.cricketkotlindemo.realtimesearch.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coderlab.cricketkotlindemo.paging.rest.RetrofitClient
import com.coderlab.cricketkotlindemo.realtimesearch.model.SearchItem
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit


class RealtimeViewModel : ViewModel() {
    val searchData: MutableLiveData<List<SearchItem>> = MutableLiveData()
    private val subject: PublishSubject<String> = PublishSubject.create()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        val disposable = subject.debounce(300, TimeUnit.MILLISECONDS)
            .filter { value -> !value.isBlank() }
            .distinctUntilChanged()
            .switchMap { query ->
                RetrofitClient.instance.api.search(
                    "https://api.androidhive.info/json/contacts.php",
                    query
                ).onErrorResumeNext(Observable.empty())
            }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { items -> searchData.postValue(items) },
                { error ->
                    error?.printStackTrace()
                    error?.printStackTrace()
                })
        compositeDisposable.add(disposable)
    }

    fun query(text: String?) {
        text?.let { subject.onNext(it) }
    }

    fun stopAllTask() {
        compositeDisposable.clear()
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}