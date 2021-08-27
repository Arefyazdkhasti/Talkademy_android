package com.example.talkademy_phase4.phase11

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.talkademy_phase4.databinding.ActivityProgressBinding
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit


private const val TAG = "progress"

@SuppressLint("SetTextI18n")
class ProgressActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProgressBinding

    private lateinit var disposable: Disposable

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // observable
        val animalsObservable: Observable<Int> =
            getProgressObservable()


        // observer
        val animalsObserver: Observer<Int> = getProgressObserver()

        binding.startBtn.setOnClickListener {
            setTimer()

            // observer subscribing to observable
            animalsObservable.concatMap { s ->
                Observable.just(s).delay(10, TimeUnit.SECONDS)
            }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(animalsObserver)
        }

    }

    private fun getProgressObserver(): Observer<Int> {
        return object : Observer<Int> {
            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
                disposable = d
            }

            override fun onNext(t: Int) {
                println("Name: $t")
                setProgressPercentage(t)
                if (t != 100)
                    setTimer()
                else
                    binding.timer.text = "Finished!"
            }

            override fun onError(e: Throwable) {
                println("onError: " + e.message)
            }

            override fun onComplete() {
                println("All items are emitted!")
            }


        }
    }


    private fun getProgressObservable(): Observable<Int> {
        return Observable.just(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)
    }

    private fun setProgressPercentage(pr: Int) {
        binding.progressBar.progress = pr
        binding.progressText.text = "$pr/100"
    }

    private fun setTimer() {
        object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.timer.text = ((millisUntilFinished / 1000) % 60).toString()
            }

            // When the task is over it will print 00:00:00 there
            override fun onFinish() {
                binding.timer.text = "10"
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}