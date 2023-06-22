package com.test.fdj.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class BaseFragmentAdapter(
    fm: FragmentManager,
    var mNumOfTabs: Int,
    var listFragment: ArrayList<Fragment>,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fm, lifecycle) {

    var mPos = 0


    override fun getItemCount(): Int {
        return mNumOfTabs
    }

    override fun createFragment(position: Int): Fragment {
        mPos = position
        if (mPos > 0) mPos -= 1
        else mPos = position
        return listFragment[position % listFragment.size]
    }
}

