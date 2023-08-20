package com.example.a360news.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.a360news.Fragments.AllNewsFragments
import com.example.a360news.Fragments.BusinessNewsFragment
import com.example.a360news.Fragments.EducationNewsFragment
import com.example.a360news.Fragments.EntertainmentNewsFragment
import com.example.a360news.Fragments.HealthNewsFragment
import com.example.a360news.Fragments.SportsNewsFragment
import com.example.a360news.Fragments.TechnologyNewsFragment

class TabviewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 7
    }

    /**
     * Return the Fragment associated with a specified position.
     */
    override fun getItem(position: Int): Fragment {
        var fragment:Fragment=AllNewsFragments()
       when(position){
           0->{
                fragment=AllNewsFragments()
           }
           1->{
               fragment=SportsNewsFragment()
           }
           2->{
                fragment=BusinessNewsFragment()
           }
           3->{
               fragment=EducationNewsFragment()
           }
           4->{
               fragment=EntertainmentNewsFragment()

           }
           5->{
               fragment=TechnologyNewsFragment()
           }
           6->{
               fragment=HealthNewsFragment()
           }

       }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title: String? = null
        if (position == 0) {
            title = "All"
        } else if (position == 1) {
            title = "Sports"
        } else if (position == 3) {
            title = "Education"
        } else if (position == 4) {
            title = "Entertainment"
        }else if (position == 2) {
            title = "Business"
        }else if (position == 5) {
            title = "Technology"
        }else if (position == 6) {
            title = "Politics"
        }
        return title
    }
}