package per.zkingcobra.demo.testrxjava

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

object UIUtils {

    /**
     * The `fragment` is added to the container view with id `frameId`. The operation is
     * performed by the `fragmentManager`.
     */
    fun addFragmentToActivity(fragmentManager: FragmentManager, fragment: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.add(android.R.id.content, fragment)
        transaction.commit()
    }

    fun replaceFragmentToFragment(fragmentManager: FragmentManager, fragment: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(android.R.id.content, fragment)
        transaction.commit()
    }

    fun removeFragment(fragmentManager: FragmentManager) {
        val size = fragmentManager.fragments.size
        if (size > 0) fragmentManager.beginTransaction().remove(fragmentManager.fragments[size - 1])
    }
}
