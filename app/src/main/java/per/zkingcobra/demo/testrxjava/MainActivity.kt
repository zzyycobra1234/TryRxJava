package per.zkingcobra.demo.testrxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.subjects.PublishSubject

class MainActivity : AppCompatActivity() {


    val subject= PublishSubject.create<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
