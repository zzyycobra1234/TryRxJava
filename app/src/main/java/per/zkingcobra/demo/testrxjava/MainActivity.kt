package per.zkingcobra.demo.testrxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import per.zkingcobra.demo.testrxjava.R.layout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)


        Log.e("TAG", "supportFragmentManager.fragments " + supportFragmentManager.fragments.size)

        var mainFragment = supportFragmentManager.findFragmentById(android.R.id.content)

        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance()
            UIUtils.addFragmentToActivity(supportFragmentManager, mainFragment)
        }

        Log.e("TAG", "supportFragmentManager.fragments " + supportFragmentManager.fragments.size)
    }

    override fun onBackPressed() {

        val size = supportFragmentManager.fragments.size
        val transaction = supportFragmentManager.beginTransaction()
        if (size > 1) {
            transaction.remove(supportFragmentManager.fragments[size - 1])
            transaction.commit()
        } else super.onBackPressed()
    }
}
