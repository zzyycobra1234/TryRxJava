package per.zkingcobra.demo.testrxjava.createOperator

import android.util.Log
import per.zkingcobra.demo.testrxjava.MainFragment
import per.zkingcobra.demo.testrxjava.R
import per.zkingcobra.demo.testrxjava.base.BaseFragment

class CreateOperatorFragment : BaseFragment() {


    override fun layoutId(): Int = R.layout.fragment_create_operator



    override fun initData() {

    }

    companion object {

        fun newInstance(): CreateOperatorFragment {
            return CreateOperatorFragment()
        }
    }

}