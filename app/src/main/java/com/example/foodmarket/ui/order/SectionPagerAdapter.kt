package com.example.foodmarket.ui.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.foodmarket.model.response.transaction.Data
import com.example.foodmarket.ui.home.newtaste.HomeNewTasteFragment
import com.example.foodmarket.ui.home.popular.HomePopularFragment
import com.example.foodmarket.ui.home.recommended.HomeRecommendedFragment
import com.example.foodmarket.ui.order.inprogress.InProgressFragment
import com.example.foodmarket.ui.order.pastorders.PastOrdersFragment
import com.example.foodmarket.ui.profile.account.ProfileAccountFragment
import com.example.foodmarket.ui.profile.foodmarket.ProfileFoodMarketFragment

class SectionPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    var inProgressList: ArrayList<Data>? = ArrayList()
    var pastOrdersList: ArrayList<Data>? = ArrayList()


    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "In Progress"
            1 -> "Past Orders"
            else -> ""
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        var fragment : Fragment
        return when(position) {
            0 -> {
                fragment = InProgressFragment()
                val bundle = Bundle()
                bundle.putParcelableArrayList("data", inProgressList)
                fragment.arguments = bundle
                return fragment
            }
            1 -> {
                fragment = PastOrdersFragment()
                val bundle = Bundle()
                bundle.putParcelableArrayList("data", pastOrdersList)
                fragment.arguments = bundle
                return fragment
            }
            else -> {
                fragment = InProgressFragment()
                val bundle = Bundle()
                bundle.putParcelableArrayList("data", inProgressList)
                fragment.arguments = bundle
                return fragment
            }
        }
    }

    fun setData(inProgressListParams: ArrayList<Data>?, pastOrdersListParams: ArrayList<Data>?) {
        inProgressList = inProgressListParams
        pastOrdersList = pastOrdersListParams
    }

}