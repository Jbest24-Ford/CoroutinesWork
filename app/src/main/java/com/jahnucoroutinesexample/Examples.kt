package com.jahnucoroutinesexample

import android.provider.Settings
import androidx.annotation.MainThread
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow


fun basicObservable() {
    val observable = Observable.just(1, 2, 3)
    observable.subscribeOn(Schedulers.newThread())
        .filter { it % 2 == 0 }
        .subscribe {
            println("Observable returned $it on " + Thread.currentThread().name)
        }
}

fun basicCoroutine() {
    val f: Flow<Int> = flow {
        emit(1)
        emit(2)
        emit(3)
    }
    val job: Job = GlobalScope.launch {
        f.filter { it % 2 == 0 }
            .collect { println("Coroutine returned $it on " + Thread.currentThread().name) }
    }
}

fun retrofitWithCoroutines() {
    runBlocking {
        val result = CoroutinesRetrofitBuilder.getData()
        print(result)
    }
}

fun retrofitWithCoroutineswithFlow() {
//    val f: Flow<List<GithubData>> = flow {
//        val retrievedData = CoroutinesRetrofitBuilder.getData()
//        emit(retrievedData)
//    }
//    GlobalScope.launch {
//        println(f.collect())
//    }
}

fun retrofitWithCoroutinesWithLiveData() {

}

fun retrofitWithRx() {
    val cd = CompositeDisposable()
    val request = RetrofitBuilder.getRetrofitInstance()
    cd.add(request.getGithubData()
        .flatMapIterable { it }
        .subscribe { item ->
            println("${item.getCommitName()} with email ${item.getCommitEmail()} committed on ${item.getCommitDate()}")
        })
    cd.clear()
}

fun main() {
    /**
    GlobalScope.launch{
    delay(200)
    println("Coroutine launched on " + Thread.currentThread().name)
    }
     */
    //basicObservable()
    //basicCoroutine()
    retrofitWithCoroutines()
    //retrofitWithRx()
//    Thread.sleep(1000)
}