package per.zkingcobra.demo.testrxjava.createOperator

import android.annotation.SuppressLint
import android.util.Log
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import kotlinx.android.synthetic.main.fragment_create_operator.*
import per.zkingcobra.demo.testrxjava.R
import per.zkingcobra.demo.testrxjava.base.BaseFragment
import java.util.concurrent.TimeUnit

class CreateOperatorFragment : BaseFragment() {

    val o: String? = null
    var intervalObservable: Disposable? = null
    override fun layoutId(): Int = R.layout.fragment_create_operator

    @SuppressLint("SetTextI18n")
    override fun initData() {

        just.clicks().doOnNext {

            Observable.just("我是操作符 Just").doOnNext {
                showContent.text = "${showContent.text}\t$it"
            }.subscribe()

        }.subscribe()



        fromArray.clicks().doOnNext {
            Observable.fromArray(1, 2, 3, 4, 5, 6, 7, 8, 9).doOnNext {
                showContent.text = "${showContent.text}\n$it"
            }.subscribe()
        }.subscribe()



        fromIterable.clicks().doOnNext {
            Observable.fromIterable(arrayListOf(11, 12, 13, 14, 15, 16)).doOnNext {
                showContent.text = "${showContent.text}\n$it ~"
            }.subscribe()
        }.subscribe()



        range.clicks().doOnNext {
            Observable.range(100, 5).doOnNext {
                showContent.text = "${showContent.text}\n$it *"
            }.subscribe()
        }.subscribe()


        // TODO 为什么是6
        interval.clicks().doOnNext {

            intervalObservable = Observable.interval(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
//                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext {
                    Log.e("TAG", "当前线程 " + Thread.currentThread())

                    if (it > 5)
                        intervalObservable!!.dispose()
                    showContent.text = "${showContent.text}\n$it ="

                }.subscribe()


        }.subscribe()



        intervalRange.clicks().doOnNext {

            intervalObservable = Observable.intervalRange(1, 5, 1, 1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext {
                    showContent.text = "${showContent.text}\n$it +"
                }.subscribe()


        }.subscribe()



        clear.clicks().doOnNext { showContent.text = "" }.subscribe()
    }

    companion object {

        fun newInstance(): CreateOperatorFragment {
            return CreateOperatorFragment()
        }
    }
}