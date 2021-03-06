package com.github.sikv.photos.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.sikv.photos.R
import com.github.sikv.photos.ui.navigation.Navigation
import com.github.sikv.photos.ui.navigation.NavigationDispatcher
import com.github.sikv.photos.ui.navigation.NavigationProvider

abstract class RootFragment : Fragment(), NavigationProvider {

    private var delayedFragment: Fragment? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_root, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            provideNavigation().addFragment(provideRootFragment(), withAnimation = false)

            delayedFragment?.let {
                provideNavigation().addFragment(it, withAnimation = false)
            }
        }
    }

    // TODO Used for 'Search' shortcut. Should be refactored.
    fun addFragmentDelayed(fragment: Fragment) {
        delayedFragment = fragment
    }

    override fun provideNavigation(): Navigation {
        return NavigationDispatcher(this, R.id.fragmentContainer)
    }

    abstract fun provideRootFragment(): Fragment
}