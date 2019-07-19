package per.zkingcobra.demo.testrxjava

import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.fragment_main.*
import per.zkingcobra.demo.testrxjava.base.BaseFragment
import per.zkingcobra.demo.testrxjava.createOperator.CreateOperatorFragment

class MainFragment : BaseFragment() {

    override fun layoutId(): Int = R.layout.fragment_main

    override fun initData() {


        createOperatorButton.clicks().doOnNext {
            UIUtils.addFragmentToActivity(
                activity!!.supportFragmentManager,
                CreateOperatorFragment.newInstance()
            )
        }.subscribe()





    }

    companion object {

        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
}